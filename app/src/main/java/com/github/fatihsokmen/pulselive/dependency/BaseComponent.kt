package com.github.fatihsokmen.pulselive.dependency


import android.app.Application
import android.content.Context
import com.github.fatihsokmen.pulselive.dependency.scheduler.Scheduler


import dagger.BindsInstance
import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface BaseComponent {

    fun applicationContext(): Context

    fun scheduler(): Scheduler

    fun okHttpClient(): OkHttpClient

    fun retrofit(): Retrofit

    interface Builder<C : BaseComponent, B : Builder<C, B>> {

        @BindsInstance
        fun application(application: Application): B

        fun build(): C
    }
}
