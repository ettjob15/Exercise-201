package ex201;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        } else {
            String filename = f.getAbsolutePath();
            if (filename.endsWith(".ser")) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String getDescription() {
        return ".ser";
    }

}
