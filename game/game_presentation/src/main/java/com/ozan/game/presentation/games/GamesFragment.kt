package com.ozan.game.presentation.games

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozan.core.model.DataHolder
import com.ozan.core.navigation.controller.DefaultNavigationController
import com.ozan.core.presentation.base.BaseFragment
import com.ozan.core.presentation.delegate.viewBinding
import com.ozan.core.presentation.extensions.setup
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.core.presentation.recyclerview.RecyclerViewAdapter
import com.ozan.game.presentation.R
import com.ozan.game.presentation.databinding.FragmentGamesBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference
import javax.inject.Inject

@AndroidEntryPoint
class GamesFragment : BaseFragment() {

    private val binding: FragmentGamesBinding by viewBinding()
    private val viewModel: GamesViewModel by lazy {
        ViewModelProvider(this).get(GamesViewModel::class.java)
    }
    private lateinit var navigationController: DefaultNavigationController

    @Inject
    protected lateinit var gamesAdapter: RecyclerViewAdapter

    override fun getLayoutRes(): Int = R.layout.fragment_games

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
        this.navigationController = DefaultNavigationController(WeakReference(activity))
    }

    override fun initView() {
        super.initView()

        binding.recyclerView.apply {
            setup(context = context, adapter = gamesAdapter)
            addOnScrollListener(recyclerViewOnScrollListener)
        }

        gamesAdapter.itemClickListener = { _: View, item: DisplayItem ->
            navigationController.navigateToGameDetailFragment(
                R.id.frameLayout,
                (item as GameViewEntity).id!!
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.gamesLiveData.observe(viewLifecycleOwner, {
            binding.swipeToRefreshLayout.isRefreshing = it is DataHolder.Loading
            when (it) {
                is DataHolder.Success -> gamesAdapter.addItems(it.data)
                is DataHolder.Fail -> onError(it.e)
                else -> return@observe
            }
        })

        if (savedInstanceState == null) {
            viewModel.getGamesByPagination()
        }
    }
}