package com.GauravD.tappster;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;


public class WelcomeScreen extends Activity {

	MediaPlayer sound;

	@Override
	protected void onCreate(Bundle page1) {
		// TODO Auto-generated method stub
		super.onCreate(page1);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_welcome_screen);
		MediaPlayer sound = MediaPlayer.create(WelcomeScreen.this,R.raw.tomjerry);
		sound.start();
		Thread delay = new Thread(){
			public void run(){
				try{
					sleep(1000);
				}
				catch(InterruptedException e){
					 e.printStackTrace();
				}finally{
					Intent openGame = new Intent ("com.GauravD.tappster.MENU");
					startActivity(openGame);
				}
			}
		};
		delay.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//sound.pause();
		finish();
	}
	
}
