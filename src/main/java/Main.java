import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import model.Quote;
import netscape.javascript.JSObject;
import utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        File readFile = new File("d:\\tmp");


        while (true) {
            Thread.sleep(1000);
            List<File> fileList = Utils.listFilesForFolder(readFile);
            if (fileList.size() != 0) {
                for (File file : fileList) {
                    FileInputStream fis = new FileInputStream(file);
                    String name = file.getName();
                    File writeFile = new File("d:\\json\\" + name);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Object object = ois.readObject();

                    FileOutputStream fos = new FileOutputStream(writeFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);


                    if (object instanceof Quote) {
                        System.out.println(((Quote) object).getText());
                        Quote quote = ((Quote) object);
                        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                        String json = ow.writeValueAsString(quote);
                        oos.writeObject(json);
                        oos.close();
                    }
                    ois.close();
                }
            }

        }
    }



}
