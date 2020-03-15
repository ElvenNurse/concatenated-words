package service;

import java.util.Map;
import java.util.Set;

public interface WordService {
    Map<String, Integer> findConcatenatedWords(Set<String> words);

    Map.Entry<String, Integer> findLongestConcatenatedWord(Map<String, Integer> words);

    Map.Entry<String, Integer> findSecondLongestConcatenatedWord(Map<String, Integer> words);
}
