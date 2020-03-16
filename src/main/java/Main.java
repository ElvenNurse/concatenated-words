import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import service.FileService;
import service.FileServiceImpl;
import service.WordService;
import service.WordServiceImpl;

public class Main {
    public static void main(String[] args) {
        String filePath;
        if (args.length > 0) {
            filePath = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please provide path to input file:");
            filePath = scanner.nextLine();
        }

        FileService fileService = new FileServiceImpl();
        Set<String> words = fileService.readWordsFromFile(filePath);

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
