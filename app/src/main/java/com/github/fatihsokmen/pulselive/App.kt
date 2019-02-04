package com.github.fatihsokmen.pulselive


import android.support.multidex.MultiDexApplication
import com.github.fatihsokmen.pulselive.dependency.AppComponent
import com.github.fatihsokmen.pulselive.dependency.BaseComponent
import com.github.fatihsokmen.pulselive.dependency.DaggerAppComponent

class App : MultiDexApplication() {

    lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        (baseComponent as AppComponent).inject(this)
    }
}