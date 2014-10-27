package com.chaohong.smart.home;

import java.util.List;

import com.chaohong.smart.home.data.Entrance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class InnerIconsAdapter extends ArrayAdapter<Entrance> {

	private LayoutInflater mInflater = null; 
	public InnerIconsAdapter(Context context, int resource,
			int textViewResourceId, List<Entrance> objects) {
		super(context, resource, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image, null);
			holder = new ViewHolder();
//			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Entrance entrance = (Entrance) getItem(position);
//		holder.icon.setImageResource(entrance.getDrawableId());
		holder.name.setText(entrance.getNameId());
		
		Drawable icon = getContext().getResources().getDrawable(entrance.getDrawableId());
		icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
		holder.name.setCompoundDrawables(null, icon, null, null);
		holder.name.setCompoundDrawablePadding(5);
		
		return convertView;
	}
	
	static class ViewHolder {
//		ImageView icon;
		TextView name;
	}

}
