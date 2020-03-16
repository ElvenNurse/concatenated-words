package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public Set<String> readWordsFromFile(String path) {
        Set<String> words;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            words = reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException("There are troubles with provided file!", e);
        }
        return words;
    }
}
