package com.ozan.game.presentation.gamedetail

import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import com.ozan.core.model.DataHolder
import com.ozan.core.navigation.features.GameDetailFragment.BUNDLE_GAME_ID
import com.ozan.core.presentation.base.BaseFragment
import com.ozan.core.presentation.extensions.formatDate
import com.ozan.core.presentation.extensions.loadImage
import com.ozan.game.presentation.R
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameDetailFragment : BaseFragment<GameDetailViewModel>() {

    private var gameId: Int? = null

    override fun getLayoutRes(): Int = R.layout.fragment_game_detail

    override fun getModelClass() = GameDetailViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameId = it.getInt(BUNDLE_GAME_ID)
            viewModel.fetchGameDetail(gameId!!)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.gameDetailLiveData.observe(this, Observer {
            when (it) {
                is DataHolder.Success -> setData((it.data as GameDetailViewEntity))
                is DataHolder.Fail -> onError(it.e)
            }
        })
    }

    private fun setData(gameDetail: GameDetailViewEntity) {
        imageView.loadImage(gameDetail.backgroundImage!!)
        titleTextView.text = gameDetail.name
        releaseDateTextView.text = gameDetail.release.formatDate()
        ratingTextView.text = gameDetail.rating.toString()
        descriptionTextView.text =
            HtmlCompat.fromHtml(gameDetail.description!!, HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
}