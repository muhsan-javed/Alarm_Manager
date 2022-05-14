package com.muhsanapps.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.muhsanapps.alarmmanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    static final int ALARM_REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        binding.btnSet.setOnClickListener(view -> {

            int time =Integer.parseInt(binding.edTimeTaker.getText().toString());

            long triggerTime = System.currentTimeMillis()+(time* 1000L);

            Intent iBroadCast = new Intent(MainActivity.this, MyReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ_CODE, iBroadCast, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime, pendingIntent);
        });


    }
}