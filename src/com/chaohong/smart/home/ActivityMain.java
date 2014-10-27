package com.chaohong.smart.home;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class ActivityMain extends TabActivity {
	private TabSpec tabSpec;
	private TabHost tabHost;
	private Intent intent;
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	private GestureDetector gestureDetector;
	View.OnTouchListener gestureListener;

	int currentView = 0;
	private static int maxTabIndex = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		this.initTableHost();

		gestureDetector = new GestureDetector(new MyGestureDetector());
		gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (gestureDetector.onTouchEvent(event)) {
					return true;
				}
				return false;
			}
		};

	}

	/**
	 * tablehost�ĳ�ʼ�����������
	 */
	private void initTableHost() {
		tabHost = super.getTabHost();
		// 位置控制
		intent = new Intent(ActivityMain.this, LocationControlActivity.class);
		tabSpec = tabHost
				.newTabSpec(getString(R.string.location_control))
				.setIndicator(getString(R.string.location_control),
						getResources().getDrawable(R.drawable.logo))
				.setContent(intent);
		tabHost.addTab(tabSpec);
		// 中心控制
		intent = new Intent(ActivityMain.this, CenterControlActivity.class);
		tabSpec = tabHost
				.newTabSpec(getString(R.string.centrol_control))
				.setIndicator(getString(R.string.centrol_control),
						getResources().getDrawable(R.drawable.logo))
				.setContent(intent);
		tabHost.addTab(tabSpec);
		// 功能控制
		intent = new Intent(ActivityMain.this, FunctionControlActivity.class);
		tabSpec = tabHost
				.newTabSpec(getString(R.string.function_control))
				.setIndicator(getString(R.string.function_control),
						getResources().getDrawable(R.drawable.logo))
				.setContent(intent);
		tabHost.addTab(tabSpec);
		
		// 默认 位置控制
		tabHost.setCurrentTab(0);
		
		setTabTextAttributes();
	}
	
	private void setTabTextAttributes() {
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++)
		{
			TextView textView = (TextView)tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
			textView.setTextSize(16);
			textView.setGravity(Gravity.CENTER);
			textView.getLayoutParams().height = LayoutParams.MATCH_PARENT;
			textView.getLayoutParams().width = LayoutParams.MATCH_PARENT;
		}
	}

	// 滑动手势
	class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			TabHost tabHost = getTabHost();
			try {
				if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
					return false;
				// right to left swipe
				if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					Log.i("test", "right");
					if (currentView == maxTabIndex) {
						currentView = 0;
					} else {
						currentView++;
					}
					tabHost.setCurrentTab(currentView);
				} else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					Log.i("test", "left");
					if (currentView == 0) {
						currentView = maxTabIndex;
					} else {
						currentView--;
					}
					tabHost.setCurrentTab(currentView);
				}
			} catch (Exception e) {
			}
			return false;
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			event.setAction(MotionEvent.ACTION_CANCEL);
		}
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
