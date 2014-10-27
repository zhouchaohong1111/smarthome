package com.chaohong.smart.home;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.chaohong.smart.home.data.Entrance;

public class SceneControlActivity extends InnerGridViewActivity {

	@Override
	public List<Entrance> getEntrances() {
		
		int entraceType = Entrance.Type.SCENE;
		List<Entrance> entrances = new ArrayList<Entrance>();
		entrances.add(new Entrance(R.string.meeting, R.drawable.scene_meeting, entraceType));
		entrances.add(new Entrance(R.string.cinema, R.drawable.scene_cinema, entraceType));
		entrances.add(new Entrance(R.string.disco, R.drawable.scene_disco, entraceType));
		entrances.add(new Entrance(R.string.sleep, R.drawable.scene_sleep,entraceType));
		return entrances;
		
	}
	
	public static void setMargins (View v, int l, int t, int r, int b) {
	    if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
	        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
	        p.setMargins(l, t, r, b);
	        v.requestLayout();
	    }
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView titleView = (TextView) findViewById(R.id.title);
		titleView.setText(R.string.scene);
		titleView.setVisibility(View.VISIBLE);
		GridView gridView = (GridView) findViewById(R.id.icons);
		setMargins(gridView, 0, 0, 0, 0);
		
	}

}
