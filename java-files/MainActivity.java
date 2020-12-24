package com.example.myflipflop;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    private int camel,lion,fox,coala,monkey, wolf,code;
    private int clicked = 0;
    private boolean turnOver = false;
    private int lastClicked = -1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUp();
        final List<Integer> images = new ArrayList<>(Arrays.asList(coala, lion, monkey, fox, wolf, camel, coala, lion, monkey, fox, wolf, camel));
        final List<Button> buttons = new ArrayList<>(Arrays.asList(
                button1, button2, button3, button4,
                button5, button6, button7, button8,
                button9, button10, button11, button12));
        Collections.shuffle(images);
        for (int i = 0; i <= 11; i++) {
            buttons.get(i).setText("cardBack");
            buttons.get(i).setTextSize(0.0F);
            final int finalI = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (buttons.get(finalI).getText() == "cardBack" && !turnOver){
                        buttons.get(finalI).setBackgroundResource(images.get(finalI));
                        buttons.get(finalI).setText(images.get(finalI));
                        if (clicked == 0){
                            lastClicked = finalI;
                        }
                        clicked++;
                    }
                    else if (buttons.get(finalI).getText() != "cardBack" ){
                        buttons.get(finalI).setBackgroundResource(code);
                        buttons.get(finalI).setText("cardBack");
                        clicked--;
                    }
                    if (clicked == 2) {
                        turnOver = true;
                        if (buttons.get(finalI).getText() == buttons.get(lastClicked).getText()) {
                            buttons.get(finalI).setEnabled(false);
                            buttons.get(lastClicked).setEnabled(false);
                            turnOver = false;
                            clicked = 0;
                        }
                    }else if (clicked == 0){
                        turnOver = false;
                    }
                }
            });
        }

    }
    private void SetUp() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);

        code = R.drawable.code;
        coala = R.drawable.coala;
        lion =  R.drawable.lion;
        monkey = R.drawable.monkey;
        fox = R.drawable.fox;
        camel = R.drawable.camel;
        wolf = R.drawable.wolf;
    }
}