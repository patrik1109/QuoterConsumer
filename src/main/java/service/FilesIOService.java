package service;

import model.Quote;

import java.io.File;
import java.util.List;

public interface FilesIOService {
    public Quote readQuoteFromFile(File file);
    public  List<File> listFilesForFolder(final File folder);
    public boolean writeQuoteJSONtoFile(String fileName,Quote quote);
}
