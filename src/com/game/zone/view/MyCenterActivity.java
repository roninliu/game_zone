package com.game.zone.view;

import com.game.zone.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class MyCenterActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_center_layout);
		
		
		final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout linlayout = (LinearLayout)findViewById(R.id.my_center_container);
		
		LinearLayout my_center_home = (LinearLayout) inflater.inflate(R.layout.my_center_home_layout, null);
		linlayout.addView(my_center_home);
	}
}
