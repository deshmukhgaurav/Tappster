package com.GauravD.tappster;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class NewGame extends Activity {
	int count,count1,time;
	String winner,timer1,t2,np1,np2;
	ImageButton tap, dtap;
	TextView disp,disp2;
	TextView mTextField;
	CountDownTimer t;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_game);
        mTextField= (TextView) findViewById(R.id.timer);
        String temp="15";
        timer1=getIntent().getStringExtra("t1");
        np1=getIntent().getStringExtra("np1");
        np2=getIntent().getStringExtra("np2");
        //Log.v("EditText value=", mtimer.getText().toString());
        Log.v("value i get=", timer1);
        if(timer1.equals(temp))
        	{
        	Log.e("IN if", timer1);
        	time=15000;
        	}
        else
        {
        time=Integer.parseInt(timer1);
        time=time*1000;
        }
        t = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("STOP!");
                if(count==count1)
                	winner="DRAW!!";
                else if(count>count1)
                	winner=np1;
                	//winner="Player 1";
                else
                	winner=np2;
                	//winner="Player 2";
              String c=np1+": "+count;
              String c1=np2+": "+count1;
                //String c="Player 1: "+count;
                //String c1="Player 2: "+count1;
                Intent openGame = new Intent ("com.GauravD.tappster.THEEND");
                openGame.putExtra("win",winner);
                openGame.putExtra("count", c);
                openGame.putExtra("count1", c1);
				startActivity(openGame);
            }
            
         }.start();
        count = 0;
        count1 = 0;
        tap= (ImageButton) findViewById(R.id.but2);
        //tap.setText(np1);
        dtap= (ImageButton) findViewById(R.id.but1);
        //dtap.setText(np2);
        disp= (TextView) findViewById(R.id.text1);
        disp2=(TextView) findViewById(R.id.text2);
        tap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count+=1;
				disp2.setText(np1+":" +count);
			}
		});
        dtap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count1+=1;
				disp.setText(np2+":" +count1);
			}
		});
    } 
    	protected void onPause() {
    		// TODO Auto-generated method stub
    		super.onPause();
    		t.cancel();
    		finish();    		
    	}

}
