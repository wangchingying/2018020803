package com.cyw.a2018020803;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JobScheduler jobScheduler;
    JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName(getPackageName(),
                        MyJobService.class.getName()) );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//>=android 7
            jobInfo = builder.setMinimumLatency(900000).build();//我測試只能run第一個15分,後面就沒了,有問題
        } else {//<Android 7
            jobInfo = builder.setPeriodic(3000).build();//7以下可以每三秒啟動一次
        }
    }
    public void click1(View v)
    {
        Log.d("JOB","click");
        jobScheduler.schedule(jobInfo);

    }
    public void click2(View v)
    {
        jobScheduler.cancel(1);
    }
}
