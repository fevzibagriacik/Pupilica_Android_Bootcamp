package com.fevzibagriacik.workmanagerusage

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context:Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result { //it runs the background
        val sum = 10 + 20
        Log.e("Background Result", sum.toString())
        return Result.success()
    }
}