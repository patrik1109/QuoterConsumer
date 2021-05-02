package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Data;
import model.Quote;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class FilesIOServiceImpl implements FilesIOService{
    @Override
    public Quote readQuoteFromFile( File file) {
        FileInputStream fis = null;
        Quote quote = null;
        try {
            fis = new FileInputStream(file);
            String name = file.getName();
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
                if (object instanceof Quote) {
                    quote = ((Quote) object);
                }
                else {
                    System.out.println("wrong format class");
                }
                fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return quote;
    }

    public  List<File> listFilesForFolder(final File folder) {
        List files = new ArrayList();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry);
            }
        }
        files.removeAll(Arrays.asList("",null));
        return  files;
    }

    @Override
    public boolean writeQuoteJSONtoFile(String fileName,Quote quote){
        File writeFile = new File("d:\\json\\" + fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(writeFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(quote);
            oos.writeObject(json);
            oos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
