package com.example.androidpatternlockv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PatternLockViewListener {

    PatternLockView patternLockView;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);
        patternLockView.addPatternLockListener(this);

    }

    @Override
    public void onStarted() {
        points=0;
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

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()<2)
        {
            Toast.makeText(this, "Pattern is too short!", Toast.LENGTH_SHORT).show();
            return;
        }

//        if(PatternLockUtils.patternToString(patternLockView, pattern).length()!=3 && PatternLockUtils.patternToString(patternLockView, pattern).length()!=4)
//        {
//            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
//            return;
//        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("0")) {
            points+=2;
        }

        if(StartsInCorner(ptrn)==true)
        {
            points+=2;
        }
        if(PatternLockUtils.patternToString(patternLockView, pattern).length()<8){
            points+=2;
            if(PatternLockUtils.patternToString(patternLockView, pattern).length()<4){
                points +=2;
            }
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()==7) {
            if(ChechForM(ptrn)==true){
                points+=2;
            }
            else if(ChechForC(ptrn)==true)
            {
                points+=2;
            }
            else if(ChechForN(ptrn)==true){
                points+=2;
            }
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()==9) {
            if(ChechForS(ptrn)==true){
                points+=2;
            }
            else if(ChechForZ(ptrn)==true){
                points+=2;
            }
        }

        if(PatternLockUtils.patternToString(patternLockView, pattern).length()==5) {
            if(ChechForL(ptrn)==true){
                points+=2;
            }
        }

        if (points <= 1)
        {
            patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
            Toast.makeText(this, "STRONG PASSWORD", Toast.LENGTH_SHORT).show();

        }

        else if (points <= 3)
        {
            patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
            Toast.makeText(this, "GOOD PASSWORD", Toast.LENGTH_SHORT).show();

        }
        else
        {
            patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
            Toast.makeText(this, "WEAK PASSWORD", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onCleared() {
        points = 0;
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

    public boolean ChechForC(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("2103678"))
        {
            letter = true;
        }
        return letter;
    }

    public boolean ChechForN(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("6304852"))
        {
            letter = true;
        }
        return letter;
    }

    public boolean ChechForS(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("210345876"))
        {
            letter = true;
        }
        return letter;
    }

    public boolean ChechForZ(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("012543678"))
        {
            letter = true;
        }
        return letter;
    }

    public boolean ChechForL(String ptrn){
        boolean letter = false;
        if(ptrn.equalsIgnoreCase("03678"))
        {
            letter = true;
        }
        return letter;
    }
}
