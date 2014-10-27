package com.chaohong.smart.home;

import java.util.List;
import com.chaohong.smart.home.InnerIconsAdapter.ViewHolder;
import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Entrance;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class DeviceDetailAdapter extends ArrayAdapter<Device>{
	

	private LayoutInflater mInflater = null; 
	
	public DeviceDetailAdapter(Context context, int textViewResourceId,
			List<Device> objects) {
		super(context, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
	}

	
	
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.device_status, null);
			holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.device_icon);
			holder.name = (TextView) convertView.findViewById(R.id.device_name);
//			holder.checkbox = (CheckBox) convertView.findViewById(R.id.device_status);
			holder.aswitch = (Switch) convertView.findViewById(R.id.device_status);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Device device = (Device) getItem(position);
		if(device == null) {
			Log.v(this.getClass().getName(),"device == null");
		}
		
		holder.name.setText(device.getName());
		
		Drawable icon = getContext().getResources().getDrawable(device.getDrawableId());
		double limit = 0.3;
		int width =  (int) (icon.getMinimumWidth() * limit);
		int height = (int) (icon.getMinimumHeight() * limit);
		icon.setBounds(0, 0, width, height);
		holder.icon.setImageDrawable(icon);
		
		/*
		holder.name.setCompoundDrawables(icon, null, null, null);
		holder.name.setCompoundDrawablePadding(80);*/
		
		if( holder.checkbox != null) {
			holder.checkbox.setChecked(device.getStatus() != Device.Status.OFF);
			holder.checkbox.setClickable(true); //暂时不允许修改
		}
	
		if( holder.aswitch != null) {
			holder.aswitch.setChecked(device.getStatus() != Device.Status.OFF);
			holder.aswitch.setClickable(true);
		}
		
		return convertView;
	}
	
	static class ViewHolder {
		ImageView icon;
		TextView name;
		CheckBox checkbox;
		Switch aswitch;
	}
}
