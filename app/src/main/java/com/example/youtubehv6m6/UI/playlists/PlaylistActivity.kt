package com.example.youtubehv6m6.UI.playlists

import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubehv6m6.core.ui.BaseActivity
import com.example.youtubehv6m6.core.network.Connection
import com.example.youtubehv6m6.databinding.ActivityPlaylistBinding
import com.example.youtubehv6m6.data.model.Items

class PlaylistActivity : BaseActivity<MainViewModel, ActivityPlaylistBinding>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    private fun clickListener(id : String) {
        Intent(this , InfoPlaylistActivity::class.java).apply {
            putExtra(KEY_FOR_ID ,id)
            startActivity(this)
        }
    }

    override fun initViewModel() {
        viewModel.playlist().observe(this) {
            if (it != null) {
                adapter = PlaylistAdapter(it.items as ArrayList<Items> , this ::clickListener)
            }
            binding.rvPlaylist.adapter = adapter
        }
    }

    override fun checkInternet() {
        Connection((getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedInternet.constInternet.isVisible = !it
                binding.rvPlaylist.isVisible  = it
                if (it == true) {
                    initViewModel()
                }
            }

    }

    companion object {
        val KEY_FOR_ID = "HELLO"
    }


}