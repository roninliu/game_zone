package com.game.zone.view;

import com.game.zone.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HotGameActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hot_game_layout);
		
		final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout linlayout = (LinearLayout)findViewById(R.id.app_list_content);
		
		
		for(int i=0;i<5;i++){
			RelativeLayout app_item_layout = (RelativeLayout) inflater.inflate(R.layout.app_list_layout, null);
			
			linlayout.addView(app_item_layout);
		}
	}
}
