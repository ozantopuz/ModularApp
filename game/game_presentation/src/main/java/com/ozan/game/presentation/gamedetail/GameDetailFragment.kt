package com.ozan.game.presentation.gamedetail

import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import com.ozan.core.model.DataHolder
import com.ozan.core.navigation.features.GameDetailFragment.BUNDLE_GAME_ID
import com.ozan.core.presentation.base.BaseFragment
import com.ozan.core.presentation.delegate.viewBinding
import com.ozan.core.presentation.extensions.formatDate
import com.ozan.core.presentation.extensions.loadImage
import com.ozan.game.presentation.R
import com.ozan.game.presentation.databinding.FragmentGameDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailFragment : BaseFragment() {

    private val binding: FragmentGameDetailBinding by viewBinding()
    private val viewModel: GameDetailViewModel by lazy {
        ViewModelProvider(this).get(GameDetailViewModel::class.java)
    }

    private var gameId: Int? = null

    override fun getLayoutRes(): Int = R.layout.fragment_game_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameId = it.getInt(BUNDLE_GAME_ID)
            viewModel.fetchGameDetail(gameId!!)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.gameDetailLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is DataHolder.Success -> setData((it.data as GameDetailViewEntity))
                is DataHolder.Fail -> onError(it.e)
                else -> return@observe
            }
        })
    }

    private fun setData(gameDetail: GameDetailViewEntity) {
        with(binding) {
            imageView.loadImage(gameDetail.backgroundImage!!)
            titleTextView.text = gameDetail.name
            releaseDateTextView.text = gameDetail.release.formatDate()
            ratingTextView.text = gameDetail.rating.toString()
            descriptionTextView.text =
                HtmlCompat.fromHtml(gameDetail.description!!, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }
}