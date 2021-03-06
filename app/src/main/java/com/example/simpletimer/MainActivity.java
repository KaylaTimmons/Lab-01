package com.example.simpletimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.button);

        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));
    }

    @Override
    public void onClick(View v) {
        if(!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
            String startString = this.getResources().getString(R.string.startLabel);
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("Reset");
            startB.setText(getText(R.string.resetLabel));
        }

    }

    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            onFinish():
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));

        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain: " + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));

        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));

        }
    }
}