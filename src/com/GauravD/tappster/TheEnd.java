package com.GauravD.tappster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TheEnd extends Activity {

	TextView win_txt,p1,p2;
	Button retry;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_the_end);
		
		win_txt=(TextView) findViewById(R.id.winner_name);
	    win_txt.setText(getIntent().getStringExtra("win"));
	    
	    p1=(TextView) findViewById(R.id.P1);
	    p1.setText(getIntent().getStringExtra("count"));
	    
	    p2=(TextView) findViewById(R.id.P2);
	    p2.setText(getIntent().getStringExtra("count1"));	    
	    
	    retry=(Button) findViewById(R.id.retry);
	    
	    retry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent Rematch=new Intent("com.GauravD.tappster.MENU");
				startActivity(Rematch);
			}
		});
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}


	
}
