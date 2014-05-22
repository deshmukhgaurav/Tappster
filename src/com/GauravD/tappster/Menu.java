package com.GauravD.tappster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends Activity {
	
	Menu myGame;
	Button new_game; 
	public String timer,n1,n2;
	EditText mtimer,np1,np2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_menu);
		
        final String temp="Name of player 1";
        final String temp1="Name of player 2";
		new_game= (Button)findViewById(R.id.new_g);
		new_game.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mtimer=(EditText) findViewById(R.id.editText1);
		        timer=mtimer.getText().toString();
		        np1=(EditText) findViewById(R.id.np1);
		        n1=np1.getText().toString();
		        if(n1.equals(temp))
		        {
		        	n1="PLayer 1";
		        }
		        np2=(EditText) findViewById(R.id.np2);
		        n2=np2.getText().toString();
		        if(n2.equals(temp1))
		        {
		        	n2="Player 2";
		        }
		        Intent openGame = new Intent ("com.GauravD.tappster.NEWGAME");
				Log.v("value i get in menu=", timer);
				openGame.putExtra("t1",timer);
				openGame.putExtra("np1",n1);
				openGame.putExtra("np2",n2);
				startActivity(openGame);
			}
		});
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
			
}
