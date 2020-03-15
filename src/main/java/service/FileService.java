package service;

import java.util.Set;

public interface FileService {
    Set<String> readWordsFromFile(String path);
}
