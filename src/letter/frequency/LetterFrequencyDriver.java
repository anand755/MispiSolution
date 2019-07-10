package letter.frequency;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class LetterFrequencyDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String sentence = scanner.nextLine();

        LetterSequence letterSequence = new LetterSequence(sentence);
        Map<Character, Integer> frequencyMap = letterSequence.computeFrequency();

        letterSequence.DisplayLetterFrequency(frequencyMap);

    }
}
