import java.util.Map;
import java.util.Set;
import service.FileService;
import service.FileServiceImpl;
import service.WordService;
import service.WordServiceImpl;

public class Main {
    private static final String FILE_PATH = "src/main/resources/wordsforproblem.txt";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        Set<String> words = fileService.readWordsFromFile(FILE_PATH);

        WordService wordService = new WordServiceImpl();
        Map<String, Integer> concatenatedWords = wordService.findConcatenatedWords(words);

        System.out.print("Longest Word is: ");
        System.out.println(wordService.findLongestConcatenatedWord(concatenatedWords));
        System.out.print("Second Longest Word is: ");
        System.out.println(wordService.findSecondLongestConcatenatedWord(concatenatedWords));
        System.out.print("Total concatenated words: ");
        System.out.println(concatenatedWords.size());
    }
}
