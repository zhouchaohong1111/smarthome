package com.chaohong.smart.home;

import java.util.List;

import com.chaohong.smart.home.data.Entrance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public abstract class InnerActivity extends Activity {
	
	private ListView mListView = null;
	private List<Entrance> mEntrances = null;
	
	public abstract List<Entrance> getEntrances();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
		

	}
	
	private void initViews() {
		setContentView(R.layout.inner_activity);
		mListView=(ListView) findViewById(R.id.icons); 
		mEntrances = getEntrances();
		if( mEntrances != null) {
			mListView.setAdapter(new InnerIconsAdapter(this, R.layout.image, 0, mEntrances));
		}
	}
}
