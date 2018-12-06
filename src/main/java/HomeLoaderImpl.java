import factories.HomeFactory;
import factories.HomeFactoryImpl;
import models.Home;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeLoaderImpl implements HomeLoader {
    HomeFactory homeFactory = new HomeFactoryImpl();

    @Override
    public Home loadHome(String fileName, String separator) {
        //load file and use home factory to create home
        HomeFactory homeFactoryLoad = new HomeFactoryImpl();
        List<String> lista = new ArrayList<>();

        BufferedReader bf = null;

        try{
            String strCurrentLine;
            bf = new BufferedReader(new FileReader(fileName));

            while ((strCurrentLine = bf.readLine()) != null) {
//                System.out.println(strCurrentLine);
                lista.add(strCurrentLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return homeFactoryLoad.createHome(lista, "%");
    }
}
