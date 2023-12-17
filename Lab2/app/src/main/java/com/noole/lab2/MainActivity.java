package com.noole.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCounter=0;
    long pressStart = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 1; i<= 10; i++){
            Button button = new Button(this);
            String formatted = getString(R.string.nupp,i);
            button.setText(formatted);
            //button.setText(R.string.nupp +i);
            button.setBackgroundColor(Color.rgb(0,i*20,255));
            layout.addView(button);
        }
        //setContentView(layout);

 */
        setContentView(R.layout.activity_main);

        Button buttonClicker = findViewById(R.id.btnClicker);
        //lihtsalt vajutad nupule
        buttonClicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter++;
                buttonClicker.setText("I was " + clickCounter + " clicked");
            }
        });
/*
        //hoiad nuppu korra alla ja siis vabastad selle
        buttonClicker.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clickCounter--;
                buttonClicker.setText("I was " + clickCounter + " clicked");
                return false;
            }
        });
        */

        Button resetButton = findViewById(R.id.btnReset);
        resetButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    pressStart = System.currentTimeMillis();
                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    long duration = System.currentTimeMillis() - pressStart;
                    TextView text =findViewById(R.id.textView);
                    text.setText("button was pressed for " + duration + "ms");
                    LinearLayout vertical = findViewById(R.id.vertical_layout);
                    TextView txtDuration = new TextView(getApplicationContext());
                    txtDuration.setText("button was pressed for " + duration + "ms");
                    vertical.addView(txtDuration);
                }
                return false;
            }
        });
    }

    public void resetButton(View view) {
        clickCounter = 0;
        Button button = findViewById(R.id.btnClicker);
        button.setText("I was " + clickCounter + " clicked");
    }
}