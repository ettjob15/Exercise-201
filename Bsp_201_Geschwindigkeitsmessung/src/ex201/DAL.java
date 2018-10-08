package ex201;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DAL {
    
    void save(ArrayList<Measurement> liste, File f) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(liste);
        oos.flush();
        oos.close();
    }
    
    ArrayList<Measurement> load(File f) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        ArrayList<Measurement> liste = (ArrayList<Measurement>) ois.readObject();
        ois.close();
        return liste;
    }
    
}