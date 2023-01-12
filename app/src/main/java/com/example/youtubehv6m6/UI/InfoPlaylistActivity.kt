package com.example.youtubehv6m6.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.youtubehv6m6.R
import com.example.youtubehv6m6.databinding.ActivityInfoPlaylistBinding

class InfoPlaylistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPlaylistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getSerializableExtra(PlaylistActivity.KEY_FOR_ID) as String
        Toast.makeText(this , id , Toast.LENGTH_SHORT).show()
    }
}