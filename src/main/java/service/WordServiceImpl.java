package service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class WordServiceImpl implements WordService {
    @Override
    public Map<String, Integer> findConcatenatedWords(Set<String> words) {
        Map<String, Integer> concatenatedWords = new HashMap<>();
        for (String word : words) {
            if (isConcatenated(word, words, 0)) {
                concatenatedWords.put(word, word.length());
            }
        }
        return concatenatedWords;
    }

    @Override
    public Map.Entry<String, Integer> findLongestConcatenatedWord(Map<String, Integer> words) {
        return words.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Map.Entry<String, Integer> findSecondLongestConcatenatedWord(
            Map<String, Integer> words) {
        return words.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isConcatenated(String word, Set<String> words, int wordsCount) {
        for (int i = 0; i < word.length(); i++) {
            if (words.contains(word.substring(0, i + 1))) {
                wordsCount++;
                if (word.length() == i + 1 && wordsCount > 1) {
                    return true;
                }
                if (isConcatenated(word.substring(i + 1), words, wordsCount)) {
                    return true;
                } else {
                    wordsCount--;
                }
            }
        }
        return false;
    }
}
