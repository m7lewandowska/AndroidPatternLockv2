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

//        if(PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("0125")) {
//
//            patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
//            Toast.makeText(this, "Pattern is correct!", Toast.LENGTH_SHORT).show();
//        }
//
//        else {
//            patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
//            Toast.makeText(this, "Pattern is not correct!", Toast.LENGTH_SHORT).show();
//        }
        String ptrn = PatternLockUtils.patternToString(patternLockView, pattern);
        int points = 0;

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()<2)
        {
            Toast.makeText(this, "Pattern is too short!", Toast.LENGTH_SHORT).show();
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()!=3 && PatternLockUtils.patternToString(patternLockView, pattern).length()!=4)
        {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("0")) {
            points++;
        }

        if(StartsInCorner(ptrn)==true)
        {
            points++;
        }
        if(PatternLockUtils.patternToString(patternLockView, pattern).length()<8){
            points++;
            if(PatternLockUtils.patternToString(patternLockView, pattern).length()<4){
                points +=2;
            }
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()==7) {


        }


        // M PATTERN
        else if(PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("6304258")) {
//
            patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
            Toast.makeText(this, "Pattern is correct!", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onCleared() {

    }

    public boolean StartsInCorner(String ptrn){
        boolean startsInCorner = false;

        if (ptrn.equalsIgnoreCase("0") || ptrn.equalsIgnoreCase("2") ||
                ptrn.equalsIgnoreCase("6") || ptrn.equalsIgnoreCase("8")
            ) startsInCorner = true;

        return startsInCorner;
    }

    public boolean ChechForM(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("6304258"))
        {
            letter = true;
        }
        return letter;
    }
}
