package factories;

import models.Home;
import models.Room;
import models.properties.HomeProperty;
import models.properties.RoomProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class HomeFactoryImpl implements HomeFactory {
    RoomFactory roomFactory = new RoomFactoryImpl();

    @Override
    public Home createHome(List<String> lines, String separator) {
        //create home using roomFactory

        Map<HomeProperty, String> h1 = new EnumMap<>(HomeProperty.class);
        List<Room> r1 = new ArrayList<>();

        String[] home = lines.get(0).split(separator);

        h1.put(HomeProperty.HOME_NAME, home[0]);
        h1.put(HomeProperty.ADDRESS, home[1]);
        h1.put(HomeProperty.HOMEMADE_COUNT, home[2]);
        h1.put(HomeProperty.ROOMS_COUNT, home[3]);

        r1.add(roomFactory.createRoom(lines.subList(1, Integer.valueOf(h1.get(HomeProperty.ROOMS_COUNT))+1),separator));

        return new Home(h1.get(HomeProperty.HOME_NAME), h1.get(HomeProperty.ADDRESS), Integer.valueOf(h1.get(HomeProperty.HOMEMADE_COUNT)), r1);
    }
}