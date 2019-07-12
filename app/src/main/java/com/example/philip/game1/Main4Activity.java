package com.example.philip.game1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.evedevelopers.mof.R;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;



public class Main4Activity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    int n,i,c,sel,temp,ar[],d;
    long millis,millip;
    ConstraintLayout base;
    CountDownTimer tt,te;
    TextView score,time;
    Vibrator vibe;
    Vector ars ;
    public void gameover(){
        Intent i = new Intent(Main4Activity.this,Main2Activity.class);
        i.putExtra("level",4);
        i.putExtra("score",c);
        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
        startActivity(i);
    }
    public  void check(){
        SharedPreferences sound = getSharedPreferences("sound", AppCompatActivity.MODE_PRIVATE);
        if(sound.getInt("s",1) == 1) {
            vibe.vibrate(15);
        }
        if(sel!=ar[i]) {
            gameover();

        }else if(i==n){
            c++;
            //String nums = String.format("%d",c);
            score.setText("SCORE: "+String.valueOf(c));
            if(n==15){
                gameover();
            }
            new_button();
            i=0;


        }
        else {
            i++;
        }
    }
    public void new_button(){
        n++;
        int cc;
        Random rand = new Random();
        Random color = new Random();
        int co =  color.nextInt(4);
        switch (co){
            case 0:cc = R.drawable.color4;
                if(Build.VERSION.SDK_INT>=21) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(getResources().getColor(R.color.color4));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.color4));
                    base.setBackground(getResources().getDrawable(R.color.color4));
                }break;
            case 1:cc = R.drawable.color1;
                if(Build.VERSION.SDK_INT>=21) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(getResources().getColor(R.color.color1));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.color1));
                    base.setBackground(getResources().getDrawable(R.color.color1));
                }break;
            case 2:cc = R.drawable.color2;
                if(Build.VERSION.SDK_INT>=21) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(getResources().getColor(R.color.color2));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.color2));
                    base.setBackground(getResources().getDrawable(R.color.color2));
                }break;
            case 3:cc = R.drawable.color3;if(Build.VERSION.SDK_INT>=21) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.color3));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.color3));
                base.setBackground(getResources().getDrawable(R.color.color3));
            }break;
           // case 4:cc = R.drawable.color5;break;
            default:cc = R.drawable.bgroup;break;
        }
        temp=0;
        if(ars.size()!=0) {
            temp = (int) ars.get(rand.nextInt(ars.size()));
            ar[n]=temp;
        }
        boolean k = ars.removeElement(temp);


        switch (temp){
            case 1: b1.setVisibility(View.VISIBLE);b1.setBackgroundResource(cc);break;
            case 2: b2.setVisibility(View.VISIBLE);b2.setBackgroundResource(cc);break;
            case 3: b3.setVisibility(View.VISIBLE);b3.setBackgroundResource(cc);break;
            case 4: b4.setVisibility(View.VISIBLE);b4.setBackgroundResource(cc);break;
            case 5: b5.setVisibility(View.VISIBLE);b5.setBackgroundResource(cc);break;
            case 6: b6.setVisibility(View.VISIBLE);b6.setBackgroundResource(cc);break;
            case 7: b7.setVisibility(View.VISIBLE);b7.setBackgroundResource(cc);break;
            case 8: b8.setVisibility(View.VISIBLE);b8.setBackgroundResource(cc);break;
            case 9: b9.setVisibility(View.VISIBLE);b9.setBackgroundResource(cc);break;
            case 10: b10.setVisibility(View.VISIBLE);b10.setBackgroundResource(cc);break;
            case 11: b11.setVisibility(View.VISIBLE);b11.setBackgroundResource(cc);break;
            case 12: b12.setVisibility(View.VISIBLE);b12.setBackgroundResource(cc);break;
            case 13: b13.setVisibility(View.VISIBLE);b13.setBackgroundResource(cc);break;
            case 14: b14.setVisibility(View.VISIBLE);b14.setBackgroundResource(cc);break;
            case 15: b15.setVisibility(View.VISIBLE);b15.setBackgroundResource(cc);break;

        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        base = findViewById(R.id.base);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        i=0;n=0;c=0;millip=90000;millis=90000;
        SharedPreferences level = getSharedPreferences("level", AppCompatActivity.MODE_PRIVATE);
        SharedPreferences.Editor editl = level.edit();
        editl.putInt("level",16);
        editl.apply();
        final SharedPreferences res = getSharedPreferences("resume", AppCompatActivity.MODE_PRIVATE);
        final SharedPreferences.Editor edit = res.edit();
        ar = new int[16];
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        ars =new Vector(16,1);
        for(int j=0;j<15;j++){
            ars.addElement(j+1);
        }
        Arrays.fill(ar,0);
        score = findViewById(R.id.score);
        b0 = findViewById(R.id.button);
        b1 = findViewById(R.id.button1);
        b1.setVisibility(View.INVISIBLE);
        b2 = findViewById(R.id.button2);
        b2.setVisibility(View.INVISIBLE);
        b3 = findViewById(R.id.button3);
        b3.setVisibility(View.INVISIBLE);
        b4 = findViewById(R.id.button4);
        b4.setVisibility(View.INVISIBLE);
        b5 = findViewById(R.id.button5);
        b5.setVisibility(View.INVISIBLE);
        b6 = findViewById(R.id.button6);
        b6.setVisibility(View.INVISIBLE);
        b7 = findViewById(R.id.button7);
        b7.setVisibility(View.INVISIBLE);
        b8 = findViewById(R.id.button8);
        b8.setVisibility(View.INVISIBLE);
        b9 = findViewById(R.id.button9);
        b9.setVisibility(View.INVISIBLE);
        b10 = findViewById(R.id.button10);
        b10.setVisibility(View.INVISIBLE);
        b11 = findViewById(R.id.button11);
        b11.setVisibility(View.INVISIBLE);
        b12 = findViewById(R.id.button12);
        b12.setVisibility(View.INVISIBLE);
        b13 = findViewById(R.id.button13);
        b13.setVisibility(View.INVISIBLE);
        b14 = findViewById(R.id.button14);
        b14.setVisibility(View.INVISIBLE);
        b15 = findViewById(R.id.button15);
        b15.setVisibility(View.INVISIBLE);
        time  = findViewById(R.id.time);
        d=1;
        tt = new CountDownTimer(millip,1000){
            public void onTick(long milli){
                millis-=1000;
                String sec;
                if((milli/1000)%60<10){
                    sec = "0"+String.valueOf((milli/1000)%60);
                }else {
                    sec = String.valueOf((milli/1000)%60);
                }
                time.setText("0"+String.valueOf(milli/60000)+":"+sec);
            }
            public void onFinish() {
                gameover();
            }
        };
        te = new CountDownTimer(millip,1000){
            public void onTick(long milli){
                millis-=1000;
                String sec;
                if((milli/1000)%60<10){
                    sec = "0"+String.valueOf((milli/1000)%60);
                }else {
                    sec = String.valueOf((milli/1000)%60);
                }
                time.setText("0"+String.valueOf(milli/60000)+":"+sec);
            }
            public void onFinish() {
                gameover();
            }
        };
        //Toast.makeText(MainActivity.this, n + "," + nex, Toast.LENGTH_SHORT).show();
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 0;
                if(n==0){
                    tt.start();
                    edit.putInt("res",0);
                    edit.commit();
                }
                check();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 1;
                check();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 2;
                check();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 3;
                check();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 3;
                check();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 4;
                check();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 5;
                check();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 6;
                check();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 7;
                check();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 8;
                check();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 9;
                check();
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 10;
                check();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 11;
                check();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 12;
                check();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 13;
                check();
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 14;
                check();
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel = 15;
                check();
            }
        });

    }
    @Override
    public void onPause(){
        super.onPause();
        tt.cancel();
        te.cancel();
        // k=0;
        millip=millis;
        //Toast.makeText(MainActivity.this,String.valueOf(millis),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
        builder.setTitle("Quit Game!");
        builder.setMessage("All your current progress will be lost. Are you sure!!!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences home = getSharedPreferences("home", AppCompatActivity.MODE_PRIVATE);
        SharedPreferences.Editor hh = home.edit();
        if(home.getInt("home",0)==1){
            hh.putInt("home",0);
            hh.commit();
            finish();
        }
        if(Build.VERSION.SDK_INT>=21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
            base.setBackground(getResources().getDrawable(R.color.black));
        }
        SharedPreferences res = getSharedPreferences("resume", AppCompatActivity.MODE_PRIVATE);
        int re = res.getInt("res",0);
        if(re == 1) {
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            b3.setVisibility(View.INVISIBLE);
            b4.setVisibility(View.INVISIBLE);
            b5.setVisibility(View.INVISIBLE);
            b6.setVisibility(View.INVISIBLE);
            b7.setVisibility(View.INVISIBLE);
            b8.setVisibility(View.INVISIBLE);
            b9.setVisibility(View.INVISIBLE);
            b10.setVisibility(View.INVISIBLE);
            b11.setVisibility(View.INVISIBLE);
            b12.setVisibility(View.INVISIBLE);
            b13.setVisibility(View.INVISIBLE);
            b14.setVisibility(View.INVISIBLE);
            b15.setVisibility(View.INVISIBLE);

            i = 0;
            n = 0;
            c = 0;
            ar = new int[16];
            score.setText("SCORE: " + String.valueOf(c));
            Arrays.fill(ar, 0);
            vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            ars = new Vector(16, 1);
            for (int j = 0; j < 15; j++) {
                ars.addElement(j + 1);
                //for(int j=0;j<24;j++){
                //    ars.addElement(j+1);
            }
            tt.cancel();
            time.setText("01:30");
            d=0;
            millip=90000;
            millis=90000;
           /* new CountDownTimer(120000,1000){
                public void onTick(long mill){
                    time.setText(String.valueOf(mill/60000)+":"+String.valueOf((mill/1000)));
                }
                public void onFinish() {
                    Intent over = new Intent(MainActivity.this, Main2Activity.class);
                    over.putExtra("score",c);
                    startActivity(over);
                }
            }.start();*/
        }else {
            if(n!=0){
                te = new CountDownTimer(millip,1000){
                    public void onTick(long milli){
                        millis-=1000;
                        String sec;
                        if((milli/1000)%60<10){
                            sec = "0"+String.valueOf((milli/1000)%60);
                        }else {
                            sec = String.valueOf((milli/1000)%60);
                        }
                        time.setText("0"+String.valueOf(milli/60000)+":"+sec);
                    }
                    public void onFinish() {
                        gameover();
                    }
                }.start();
            }
        }

    }
}

