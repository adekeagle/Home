package factories;

import models.Element;
import models.Room;
import models.properties.RoomProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RoomFactoryImpl implements RoomFactory {
    ElementFactory elementFactory = new ElementFactoryImpl();

    @Override
    public Room createRoom(List<String> lines, String separator) {
        // create room using element Factory to create each element

        List<Element> elements = new ArrayList<>();

        Map<RoomProperty, String> rum = new EnumMap<>(RoomProperty.class);

        String[] values = lines.get(0).split(separator);

        rum.put(RoomProperty.ROOM_NAME, values[0]);
        rum.put(RoomProperty.ROOM_COLOR_HEX, values[1]);
        rum.put(RoomProperty.AREA, values[2]);
        rum.put(RoomProperty.HEIGHT, values[3]);
        rum.put(RoomProperty.COUNT_ELEMENTS, values[4]);

        for(int i = 1; i < Integer.valueOf(rum.get(RoomProperty.COUNT_ELEMENTS)); i++) {
            elements.add(elementFactory.createElement(lines.get(i), "%"));
        }

        return new Room(rum.get(RoomProperty.ROOM_NAME), rum.get(RoomProperty.ROOM_COLOR_HEX), Float.valueOf(rum.get(RoomProperty.AREA)), Float.valueOf(rum.get(RoomProperty.HEIGHT)), elements);

    }
}
