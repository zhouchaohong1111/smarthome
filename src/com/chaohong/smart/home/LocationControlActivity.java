package com.chaohong.smart.home;

import java.util.ArrayList;
import java.util.List;

import com.chaohong.smart.home.data.Device;
import com.chaohong.smart.home.data.Entrance;

public class LocationControlActivity extends InnerGridViewActivity {

	@Override
	public List<Entrance> getEntrances() {
		
		int entraceType = Entrance.Type.LOCATION;
		List<Entrance> entrances = new ArrayList<Entrance>();
		entrances.add(new Entrance(R.string.hostroom, R.drawable.hostroom, entraceType, Device.LocationType.HOSTROOM));
		entrances.add(new Entrance(R.string.dinningroom, R.drawable.dinningroom, entraceType, Device.LocationType.DINNINGROOM));
		entrances.add(new Entrance(R.string.kitchen, R.drawable.kitchen,entraceType, Device.LocationType.KITCHEN));
		entrances.add(new Entrance(R.string.studyroom, R.drawable.studyroom, entraceType, Device.LocationType.STUDYROOM));
		entrances.add(new Entrance(R.string.mainbedroom, R.drawable.bedroom, entraceType, Device.LocationType.MAINBEDROOM));
		entrances.add(new Entrance(R.string.washroom, R.drawable.washroom, entraceType, Device.LocationType.WASHROOM));
		return entrances;
	}

}
