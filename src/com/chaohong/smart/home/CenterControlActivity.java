package com.chaohong.smart.home;

import java.util.ArrayList;
import java.util.List;

import com.chaohong.smart.home.data.Entrance;

public class CenterControlActivity extends InnerGridViewActivity {

	@Override
	public List<Entrance> getEntrances() {
		int entraceType = Entrance.Type.DEVICE;
		List<Entrance> entrances = new ArrayList<Entrance>();
		entrances.add(new Entrance(R.string.lights, R.drawable.device_light, entraceType));
		entrances.add(new Entrance(R.string.socket, R.drawable.device_socket, entraceType));
		entrances.add(new Entrance(R.string.curtain, R.drawable.device_curtain, entraceType));
		entrances.add(new Entrance(R.string.air_conditioners, R.drawable.device_air_conditioner, entraceType));
		entrances.add(new Entrance(R.string.tvs, R.drawable.device_tv, entraceType));
		entrances.add(new Entrance(R.string.fridges, R.drawable.device_fridge, entraceType));
		entrances.add(new Entrance(R.string.washer, R.drawable.device_washer, entraceType));
		return entrances;
		
/*		int entraceType = Entrance.Type.SCENCE;
		List<Entrance> entrances = new ArrayList<Entrance>();
		entrances.add(new Entrance(R.string.meeting, R.drawable.scene_meeting, entraceType));
		entrances.add(new Entrance(R.string.cinema, R.drawable.scene_cinema, entraceType));
		entrances.add(new Entrance(R.string.disco, R.drawable.scene_disco, entraceType));
		entrances.add(new Entrance(R.string.sleep, R.drawable.scene_sleep,entraceType));
		return entrances;*/
		
	}


}
