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
        Assert.assertEquals(4, concatenatedWords.size());
    }

    @Test
    public void findLongestConcatenatedWord_lettersOnly() {
        Map<String, Integer> concatenatedWords = new HashMap<>();
        concatenatedWords.put("abcdefghi", 9);
        concatenatedWords.put("abcdefg", 7);
        concatenatedWords.put("abcde", 5);
        concatenatedWords.put("abc", 3);
        concatenatedWords.put("a", 1);

        Assert.assertEquals(Map.entry("abcdefghi", 9),
                wordService.findLongestConcatenatedWord(concatenatedWords));
    }

    @Test
    public void findLongestConcatenatedWord_digitsOnly() {
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
    public void findSecondLongestConcatenatedWord_lettersOnly() {
        Map<String, Integer> concatenatedWords = new HashMap<>();
        concatenatedWords.put("abcdefghi", 9);
        concatenatedWords.put("abcdefg", 7);
        concatenatedWords.put("abcde", 5);
        concatenatedWords.put("abc", 3);
        concatenatedWords.put("a", 1);

        Assert.assertEquals(Map.entry("abcdefg", 7),
                wordService.findSecondLongestConcatenatedWord(concatenatedWords));
    }

    @Test
    public void findSecondLongestConcatenatedWord_digitsOnly() {
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
