package com.cyw.a2018020803;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//起一個service, 改成繼承JobSerivce, 執行抽象方法, 在manifest裡面要增加一行權限
//Android 7之後Jobscheduler只能每15分鐘跑一次
public class MyJobService extends JobService {
    public MyJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("JOB", "This is onStartJob");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
