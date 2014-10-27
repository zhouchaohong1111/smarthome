package com.chaohong.smart.home.data;

import android.util.Log;

/**
 * 入口图标数据体
 * @author zhouchaohong
 *
 */
public class Entrance {
	public static String TAG = "Entrance";
	
	public static class Type {
		public static final int UNKNOWN = 0;	//未知
		public static final int LOCATION = 1;	//位置控制
		public static final int DEVICE = 2;		//设备控制
		public static final int FUNCTION = 3;	//功能控制
		public static final int SCENE = 4;		//场景控制
	}
	private int nameId; 	//图标名字id
	private int drawableId; //图标图片id
	private int type;		//入口类别
	private int locationType;	//位置的类别
	private int deviceType;		//设备的类别
	private int functionType;	//功能的类别
	private int sceneType;		//场景的类别

	
	public Entrance(int nameId, int drawableId, int type) {
		super();
		this.nameId = nameId;
		this.drawableId = drawableId;
		this.type = type;
	}
	
	public Entrance(int nameId, int drawableId, int type, int locationType) {
		super();
		this.nameId = nameId;
		this.drawableId = drawableId;
		this.type = type;
		this.locationType = locationType;
	}
	
	public Entrance(int nameId, int drawableId, int type, int locationType, int deviceType, int functionType, int sceneType) {
		super();
		this.nameId = nameId;
		this.drawableId = drawableId;
		this.type = type;
		this.locationType = locationType;
		this.deviceType = deviceType;
		this.functionType = functionType;
		this.sceneType = sceneType;
	}
	
	public int getNameId() {
		return nameId;
	}

	public int getDrawableId() {
		return drawableId;
	}
	
	public int getType() {
		return type;
	}
	
	public int getSubType() {
		switch (type) {
		case Type.LOCATION:
			return locationType;
		case Type.DEVICE:
			return sceneType;
		case Type.FUNCTION:
			return deviceType;
		default:
			Log.v(TAG, "Unknown Type:" + type);
			break;
		}
		return Type.UNKNOWN;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public int getFunctionType() {
		return functionType;
	}

	public void setFunctionType(int functionType) {
		this.functionType = functionType;
	}


	public int getSceneType() {
		return sceneType;
	}

	public void setSceneType(int sceneType) {
		this.sceneType = sceneType;
	}

}
