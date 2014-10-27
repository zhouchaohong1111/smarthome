package com.chaohong.smart.home.data;

import java.util.ArrayList;
import java.util.List;

import com.chaohong.smart.home.R;

import android.util.SparseArray;

/**
 * 所有设备的数据，供展示用，后续换成从数据库处理
 * @author zhouchaohong
 *
 */
public class AllDevices {
	private static List<Device> sDevices = null;
	
	private static SparseArray<List<Device>> sLocationDevices = null;
	
	public static synchronized List<Device> getDevices() {
		if( sDevices == null) {
			sDevices = new ArrayList<Device>();
			sDevices.add(new Device("灯带", R.drawable.device_light, Device.DeviceType.LIGHT, Device.LocationType.HOSTROOM,Device.Status.ON));
			sDevices.add(new Device("顶灯", R.drawable.device_light, Device.DeviceType.LIGHT, Device.LocationType.HOSTROOM,Device.Status.ON));
			sDevices.add(new Device("筒灯", R.drawable.device_light,Device.DeviceType.LIGHT, Device.LocationType.HOSTROOM,Device.Status.ON));
			sDevices.add(new Device("电视插座", R.drawable.device_socket, Device.DeviceType.SOCKET, Device.LocationType.HOSTROOM,Device.Status.OFF));
			sDevices.add(new Device("茶具插座", R.drawable.device_socket, Device.DeviceType.SOCKET, Device.LocationType.HOSTROOM,Device.Status.ON));
			sDevices.add(new Device("冰箱", R.drawable.device_fridge, Device.DeviceType.FRIDGE, Device.LocationType.HOSTROOM,Device.Status.ON));
			sDevices.add(new Device("窗帘", R.drawable.device_curtain, Device.DeviceType.CURTAIN, Device.LocationType.HOSTROOM,Device.Status.OFF));
		} 
		return sDevices;
	}
	
	
	
	public static synchronized List<Device> getdDevicesByLocation(int locationType) {
		getDevices();
		if(sLocationDevices == null) {
			sLocationDevices = new SparseArray<List<Device>>();
		}
		List<Device> devices = sLocationDevices.get(locationType);
		if( devices == null) {
			devices = new ArrayList<Device>();
			for(Device d:sDevices) {
				if(d.getLocationType() == locationType ) {
					devices.add(d);
				}
			}
			sLocationDevices.put(locationType, devices);
		}
		return devices;
 	}
}
