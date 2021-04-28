package com.dkokaia.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private  Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r= new Random();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                makeTextInvisible();
                playChosen(1);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                makeTextInvisible();
                playChosen(2);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                makeTextInvisible();
                playChosen(3);
            }
        });

    }

    private void makeTextInvisible(){
        findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageView).setVisibility(View.VISIBLE);
        findViewById(R.id.imageView2).setVisibility(View.VISIBLE);
    }

    /*
        1 - rock
        2- paper
        3- scissor
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void playChosen(int i){

        int comp = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        ImageView compImage = (ImageView) findViewById(R.id.imageView);

        if(comp==1){
            compImage.setImageResource(R.drawable.rock);
        }else  if(comp ==2 ){
            compImage.setImageResource(R.drawable.paper);
        }else {
            compImage.setImageResource(R.drawable.scissor);
        }

        ImageView playerImage = (ImageView) findViewById(R.id.imageView2);
        if(i==1){
            playerImage.setImageResource(R.drawable.rock);
        }else  if(i ==2 ){
            playerImage.setImageResource(R.drawable.paper);
        }else {
            playerImage.setImageResource(R.drawable.scissor);
        }


        if(i==comp){
            draw();
        }else{
            Boolean compWon = false;
            if(comp==1 && i ==3){
                compWon = true;
            }else if(comp==2 && i==1){
                compWon = true;
            }else if(comp==3 && i==2){
                compWon = true;
            }

            if(compWon){
                wonPlayer();
            }else{
                wonComp();
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private void draw(){
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTextColor(getResources().getColor(R.color.yellow));
        txt = (TextView) findViewById(R.id.textView4);
        txt.setTextColor(getResources().getColor(R.color.yellow));

    }
    @SuppressLint("ResourceAsColor")
    private void wonPlayer(){
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTextColor(getResources().getColor(R.color.green));
        String val = (String) txt.getText();
        int i=Integer.parseInt(val);
        i+=1;
        val = Integer.toString(i);
        txt.setText(val);

        txt = (TextView) findViewById(R.id.textView4);
        txt.setTextColor(getResources().getColor(R.color.red));

    }
    @SuppressLint("ResourceAsColor")
    private void wonComp(){
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTextColor(getResources().getColor(R.color.red));


        txt = (TextView) findViewById(R.id.textView4);
        txt.setTextColor(getResources().getColor(R.color.green));
        String val = (String) txt.getText();
        int i=Integer.parseInt(val);
        i+=1;
        val = Integer.toString(i);
        txt.setText(val);

    }


}