package com.github.fatihsokmen.pulselive.articles


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.fatihsokmen.pulselive.R

class ArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
