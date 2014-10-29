package com.chaohong.smart.home.data;


/**
 * 智能设备基本数据体
 * @author zhouchaohong
 *
 */
public class Device {


	public static class Status {
		public static final int OFF = 0;
		public static final int ON = 1;
	}
	
	public static class LocationType {
		public static final int UNKNOWN = 0;			//未知
		public static final int MAINBEDROOM = 1;		//主卧
		public static final int HOSTROOM = 2;			//客厅
		public static final int KITCHEN = 3;			//厨房
		public static final int WASHROOM = 4;			//洗手间
		public static final int DINNINGROOM = 5;		//餐厅
		public static final int STUDYROOM = 6;			//书房
	}
	
	public static class DeviceType {
		public static final int UNKNOWN = 0;			//未知
		public static final int LIGHT = 1;				//灯具
		public static final int AIR_CONDITIONERS = 2;	//空调
		public static final int TV = 3;					//电视
		public static final int FRIDGE = 4;				//冰箱
		public static final int WASHER = 5;				//洗衣机
		public static final int CURTAIN = 6;			//窗帘
		public static final int SOCKET = 7;				//插座
	}
	
	public static class FuntionType {
		public static final int UNKNOWN = 0;			//未知
		public static final int SCENE = 1;				//场景
		public static final int TIMER = 2;				//定时
		public static final int MONITOR = 3;			//监控
		public static final int SYNCHRONIZE = 4;		//同步
		public static final int SETTINGS = 5;			//设置
		public static final int CHECK_UPDATE = 6;		//检查更新
		public static final int FEEDBACK = 7;		//用户反馈

	}
	
	
	public static class SceneType {
		public static final int UNKNOWN = 0;			//未知
		public static final int DINNER = 1;				//晚餐
		public static final int MEET = 2;				//会客
		public static final int CINEMA = 3;				//影院
		public static final int DISCO = 4;				//迪斯科
	}
	
	private String name; 	//设备名字
	private int drawableId; 	//设备图片
	private int deviceType; 		//设备类型
	private int locationType; 		//设备位置
	private int status;		//设备状态
	
	

	public Device(String name, int drawableId, int deviceType, int locationType, int status) {
		super();
		this.name = name;
		this.drawableId = drawableId;
		this.deviceType = deviceType;
		this.setLocationType(locationType);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}
	

}
