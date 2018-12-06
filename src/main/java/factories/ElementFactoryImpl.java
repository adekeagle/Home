package factories;

import models.Element;
import models.Home;
import models.Position;
import models.Size;
import models.properties.ElementProperty;

import java.util.*;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Element createElement(String line, String separator) {
        // create one element by line

        String[] values = line.split(separator);

        Map<ElementProperty, String> el = new EnumMap<>(ElementProperty.class);

        el.put(ElementProperty.ELEMENT_NAME, values[0]);
        el.put(ElementProperty.POSITION_X, values[1]);
        el.put(ElementProperty.POSITION_Y, values[2]);
        el.put(ElementProperty.POSITION_Z, values[3]);
        el.put(ElementProperty.WEIGHT, values[3]);
        el.put(ElementProperty.LENGTH, values[4]);
        el.put(ElementProperty.WIDTH, values[5]);
        el.put(ElementProperty.HEIGHT, values[6]);


        return new Element(el.get(ElementProperty.ELEMENT_NAME), new Position(Float.valueOf(el.get(ElementProperty.POSITION_X)),
                Float.valueOf(el.get(ElementProperty.POSITION_Y)), Float.valueOf(el.get(ElementProperty.POSITION_Z))),
                Float.valueOf(el.get(ElementProperty.WEIGHT)), new Size(Float.valueOf(el.get(ElementProperty.LENGTH)),
                Float.valueOf(el.get(ElementProperty.WIDTH)), Float.valueOf(el.get(ElementProperty.HEIGHT))));
    }
}
