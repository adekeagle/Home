import factories.HomeFactory;
import factories.HomeFactoryImpl;
import models.Home;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomeLoaderImpl implements HomeLoader {
    HomeFactory homeFactory = new HomeFactoryImpl();

    @Override
    public Home loadHome(String fileName, String separator) {
        //load file and use home factory to create home

        return null;
    }
}
