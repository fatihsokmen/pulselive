package com.github.fatihsokmen.pulselive.dependency.scheduler

interface Scheduler {

    fun io(): io.reactivex.Scheduler

    fun main(): io.reactivex.Scheduler
}