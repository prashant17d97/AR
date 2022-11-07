package com.example.beta

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.beta.databinding.ActivityMainBinding
import com.google.ar.sceneform.rendering.ModelRenderable


class MainActivity : AppCompatActivity() {
    private var andRenderer: ModelRenderable? = null
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ModelRenderable.builder()
            .setSource(this, R.raw.model)
            .build()
            .thenAccept { renderer: ModelRenderable ->
                andRenderer = renderer
            }
            .exceptionally { throwable: Throwable? ->
                Log.e(TAG, "Unable to load Render.", throwable)
                null
            }
    }
}