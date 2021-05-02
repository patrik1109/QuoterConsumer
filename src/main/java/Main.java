import lombok.SneakyThrows;
import model.Quote;
import service.FilesIOService;
import service.FilesIOServiceImpl;
import java.io.*;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        File readFile = new File("d:\\tmp");
        FilesIOService service  = new FilesIOServiceImpl();

            while (true){
                Thread.sleep(1000);
                List<File> fileList = service.listFilesForFolder(readFile);
                    for (File file : fileList) {
                        Quote quote = service.readQuoteFromFile(file);
                        //service.writeQuoteJSONtoFile(file.getName(),quote);
                        new Thread(() -> service.writeQuoteJSONtoFile(file.getName(),quote)).start();
                    }
            }
    }
}
