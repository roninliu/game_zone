package com.game.zone;

import com.game.zone.view.HotGameActivity;
import com.game.zone.view.NewListActivity;

import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends ActivityGroup {
	
	private static final String TAB_TAG_NEW_LIST = "tab_tag_new_list";
	private static final String TAB_TAG_HOT_GAME = "tab_tag_hot_game";
	private static final String TAB_TAG_MY_CENTER = "tab_tag_my_center";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header_layout);
		
		View newListTab = (View) LayoutInflater.from(this).inflate(R.layout.tab_btn_layout, null);
		TextView newListText = (TextView) newListTab.findViewById(R.id.tab_text);
		ImageView newListIcon = (ImageView) newListTab.findViewById(R.id.tab_icon);
		
		newListText.setText(R.string.new_list_txt);
		newListIcon.setBackgroundResource(R.drawable.ic_launcher);
		
		
		View hotGameTab = (View) LayoutInflater.from(this).inflate(R.layout.tab_btn_layout, null);
		TextView hotGameText = (TextView) hotGameTab.findViewById(R.id.tab_text);
		ImageView hotGameIcon = (ImageView) hotGameTab.findViewById(R.id.tab_icon);
		
		hotGameText.setText(R.string.hot_game_txt);
		hotGameIcon.setBackgroundResource(R.drawable.ic_launcher);
		
		
		View myCenterTab = (View) LayoutInflater.from(this).inflate(R.layout.tab_btn_layout, null);
		TextView myCenterText = (TextView) myCenterTab.findViewById(R.id.tab_text);
		ImageView myCenterIcon = (ImageView) myCenterTab.findViewById(R.id.tab_icon);
		
		myCenterText.setText(R.string.my_center_txt);
		myCenterIcon.setBackgroundResource(R.drawable.ic_launcher);
		
		
		TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
		tabHost.setup(this.getLocalActivityManager());
		
		tabHost.addTab(tabHost.newTabSpec(TAB_TAG_NEW_LIST).setIndicator(newListTab).setContent(new Intent(this,NewListActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_TAG_HOT_GAME).setIndicator(hotGameTab).setContent(new Intent(this,HotGameActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_TAG_MY_CENTER).setIndicator(myCenterTab).setContent(R.id.tab3));

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
