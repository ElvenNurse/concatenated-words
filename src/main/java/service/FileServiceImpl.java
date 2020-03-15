package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public Set<String> readWordsFromFile(String path) {
        Set<String> words = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            words = reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
