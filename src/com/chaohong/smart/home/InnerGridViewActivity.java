package com.chaohong.smart.home;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.chaohong.common.HostActivity;
import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Entrance;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UpdateConfig;

public abstract class InnerGridViewActivity extends HostActivity implements GridView.OnItemClickListener {
	public static String TAG = "InnerGridViewActivity";
	private GridView mGridView = null;
	private List<Entrance> mEntrances = null;
	
	public abstract List<Entrance> getEntrances();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UpdateConfig.setDebug(true);
		initViews();
	}
	
	private void initViews() {
		setContentView(R.layout.inner_gridview_activity);
		mGridView=(GridView) findViewById(R.id.icons); 
		mEntrances = getEntrances();
		if( mEntrances != null) {
			mGridView.setAdapter(new InnerIconsAdapter(this, R.layout.image, 0, mEntrances));
		}

		mGridView.setOnItemClickListener(this);
	}
	


	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		
		if( position >=0 && position < mEntrances.size()) {
			Entrance entrance = mEntrances.get(position);
			if( entrance.getType() == Entrance.Type.LOCATION 
					&& entrance.getLocationType() == Device.LocationType.HOSTROOM) {
				Intent i = new Intent(getBaseContext(), DeviceDetailActivity.class);
				i.putExtra("entrance_type", entrance.getType());
				i.putExtra("sub_type", entrance.getSubType());
				startActivity(i);
			} else if( entrance.getType() == Entrance.Type.FUNCTION ) {
				switch (entrance.getFunctionType()) {
				case Device.FuntionType.SCENE:
					Intent i = new Intent(getBaseContext(), SceneControlActivity.class);
					startActivity(i);
					break;
				case  Device.FuntionType.CHECK_UPDATE:
					UmengUpdateAgent.forceUpdate(getApplicationContext()); //检查更新
					break;
				case Device.FuntionType.FEEDBACK:
					FeedbackAgent agent = new FeedbackAgent(this);
					agent.startFeedbackActivity();
					break;
				default:
					break;
				}
			} else {
				Toast.makeText(this, R.string.function_not_implemented, Toast.LENGTH_SHORT).show();
			}
		}
	}
}
