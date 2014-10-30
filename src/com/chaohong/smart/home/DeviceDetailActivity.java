package com.chaohong.smart.home;

import java.util.List;

import com.chaohong.common.HostActivity;
import com.chaohong.smart.home.data.AllDevices;
import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Entrance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 智能设备详情控制
 * @author zhouchaohong
 *
 */
public class DeviceDetailActivity extends HostActivity {

	private ListView mListView = null;
	private List<Device> mDevices = null;
	private int mEntranceType = 0;
	private int mSubType = 0;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*		Intent i = getIntent();
		mEntranceType = i.getIntExtra("entrance_type",0);
		mSubType = i.getIntExtra("sub_type", 0);*/
		mEntranceType = Entrance.Type.LOCATION;
		mSubType = Device.LocationType.HOSTROOM;
		initViews();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	private void initViews() {
		setContentView(R.layout.inner_activity);
		mListView=(ListView) findViewById(R.id.icons); 
		if( mEntranceType == Entrance.Type.LOCATION) {
			mDevices = AllDevices.getdDevicesByLocation(mSubType);
			if( mDevices != null) {
				mListView.setAdapter(new DeviceDetailAdapter(this, 0,mDevices));
			}
		}
		
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getBaseContext(), R.string.not_support_modify, Toast.LENGTH_SHORT).show();
			}
		});

		
	}
	
}
