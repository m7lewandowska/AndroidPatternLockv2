package com.example.androidpatternlockv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PatternLockViewListener {

    PatternLockView patternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);

        patternLockView.addPatternLockListener(this);
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onProgress(List<PatternLockView.Dot> progressPattern) {

    }

    @Override
    public void onComplete(List<PatternLockView.Dot> pattern) {

        if(PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("0125"));

        patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
        Toast.makeText(this, "Pattern is correct!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCleared() {

    }
}
