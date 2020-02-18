package com.ozan.game.presentation.games

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozan.core.model.DataHolder
import com.ozan.core.navigation.controller.DefaultNavigationController
import com.ozan.core.presentation.base.BaseFragment
import com.ozan.core.presentation.extensions.setup
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.core.presentation.recyclerview.RecyclerViewAdapter
import com.ozan.game.presentation.R
import kotlinx.android.synthetic.main.fragment_games.*
import java.lang.ref.WeakReference
import javax.inject.Inject

class GamesFragment : BaseFragment<GamesViewModel>() {

    private lateinit var navigationController: DefaultNavigationController

    @Inject
    protected lateinit var gamesAdapter: RecyclerViewAdapter

    override fun getLayoutRes(): Int =
        R.layout.fragment_games

    override fun getModelClass() = GamesViewModel::class.java

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = recyclerView.childCount
            val totalItemCount = recyclerView.layoutManager?.itemCount ?: 0
            val firstVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findFirstVisibleItemPosition()

            if (viewModel.gamesLiveData.value !is DataHolder.Loading) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 5
                    && firstVisibleItemPosition >= 0) {
                    viewModel.getGamesByPagination()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.navigationController = DefaultNavigationController(WeakReference(activity!!))
    }

    override fun initView() {
        super.initView()

        recyclerView.apply {
            setup(context = context!!, adapter = gamesAdapter)
            addOnScrollListener(recyclerViewOnScrollListener)
        }

        gamesAdapter.itemClickListener = { _: View, item: DisplayItem ->
            navigationController.navigateToGameDetailFragment(
                R.id.frameLayout,
                (item as GameViewEntity).id!!
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.gamesLiveData.observe(this, Observer {
            swipeToRefreshLayout.isRefreshing = it is DataHolder.Loading
            when (it) {
                is DataHolder.Success -> gamesAdapter.addItems(it.data)
                is DataHolder.Fail -> onError(it.e)
            }
        })

        if (savedInstanceState == null) {
            viewModel.getGamesByPagination()
        }
    }
}