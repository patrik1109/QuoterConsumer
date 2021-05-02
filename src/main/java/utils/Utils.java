package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<File> listFilesForFolder(final File folder) {
        List files = new ArrayList();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
               files.add(fileEntry);
            }
        }
        return  files;
    }
}
