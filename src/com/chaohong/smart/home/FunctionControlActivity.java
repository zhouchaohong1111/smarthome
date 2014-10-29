package com.chaohong.smart.home;

import java.util.ArrayList;
import java.util.List;

import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Device.DeviceType;
import com.chaohong.smart.home.data.Entrance;

public class FunctionControlActivity extends InnerGridViewActivity {

	@Override
	public List<Entrance> getEntrances() {

		int entraceType = Entrance.Type.FUNCTION;
		List<Entrance> entrances = new ArrayList<Entrance>();
		int functionType = Device.FuntionType.SCENE;
		entrances.add(new Entrance(R.string.scene, R.drawable.function_scene, entraceType,0,0, functionType,0));
		entrances.add(new Entrance(R.string.timer, R.drawable.function_timer, entraceType));
		entrances.add(new Entrance(R.string.monitor, R.drawable.function_monitor, entraceType));
		entrances.add(new Entrance(R.string.synchronize, R.drawable.function_synchronize, entraceType));
		entrances.add(new Entrance(R.string.settings, R.drawable.function_settings, entraceType));
		entrances.add(new Entrance(R.string.check_update, R.drawable.function_check_update, entraceType));
		return entrances;
	}

}
