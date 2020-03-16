package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class WordServiceImplTest {
    private WordService wordService = new WordServiceImpl();

    @Test
    public void findConcatenatedWords() {
        Set<String> words = new HashSet<>();
        words.add("a");
        words.add("b");
        words.add("ab");
        words.add("cat");
        words.add("dog");
        words.add("catdog");
        words.add("dogcat");
        words.add("adogbcat");
        Map<String, Integer> concatenatedWords = wordService.findConcatenatedWords(words);
        Assert.assertTrue(concatenatedWords.containsKey("ab"));
        Assert.assertTrue(concatenatedWords.containsKey("catdog"));
        Assert.assertTrue(concatenatedWords.containsKey("dogcat"));
        Assert.assertTrue(concatenatedWords.containsKey("adogbcat"));
        Assert.assertFalse(concatenatedWords.containsKey("a"));
        Assert.assertFalse(concatenatedWords.containsKey("b"));
        Assert.assertFalse(concatenatedWords.containsKey("cat"));
        Assert.assertFalse(concatenatedWords.containsKey("dog"));
    }

    @Test
    public void findLongestConcatenatedWord() {
        Map<String, Integer> concatenatedWords = new HashMap<>();
        concatenatedWords.put("123456789", 9);
        concatenatedWords.put("1234567", 7);
        concatenatedWords.put("12345", 5);
        concatenatedWords.put("123", 3);
        concatenatedWords.put("1", 1);

        Assert.assertEquals(Map.entry("123456789", 9),
                wordService.findLongestConcatenatedWord(concatenatedWords));
    }

    @Test
    public void findSecondLongestConcatenatedWord() {
        Map<String, Integer> concatenatedWords = new HashMap<>();
        concatenatedWords.put("123456789", 9);
        concatenatedWords.put("1234567", 7);
        concatenatedWords.put("12345", 5);
        concatenatedWords.put("123", 3);
        concatenatedWords.put("1", 1);

        Assert.assertEquals(Map.entry("1234567", 7),
                wordService.findSecondLongestConcatenatedWord(concatenatedWords));
    }
}