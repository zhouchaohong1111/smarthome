package com.chaohong.smart.home;

import java.util.ArrayList;
import java.util.List;

import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Entrance;

public class FunctionControlActivity extends InnerGridViewActivity {

	@Override
	public List<Entrance> getEntrances() {

		int entraceType = Entrance.Type.FUNCTION;
		List<Entrance> entrances = new ArrayList<Entrance>();
		entrances.add(new Entrance(R.string.scene, R.drawable.function_scene, entraceType,0,0, Device.FuntionType.SCENE,0));
		entrances.add(new Entrance(R.string.timer, R.drawable.function_timer, entraceType,0,0,Device.FuntionType.TIMER,0));
		entrances.add(new Entrance(R.string.monitor, R.drawable.function_monitor, entraceType,0,0,Device.FuntionType.MONITOR,0));
		entrances.add(new Entrance(R.string.synchronize, R.drawable.function_synchronize, entraceType,0,0,Device.FuntionType.SYNCHRONIZE,0));
		entrances.add(new Entrance(R.string.settings, R.drawable.function_settings, entraceType,0,0,Device.FuntionType.SETTINGS,0));
		entrances.add(new Entrance(R.string.check_update, R.drawable.function_check_update, entraceType,0,0,Device.FuntionType.CHECK_UPDATE,0));
		entrances.add(new Entrance(R.string.feedback, R.drawable.function_feedback, entraceType,0,0,Device.FuntionType.FEEDBACK,0));
		return entrances;
	}

}
