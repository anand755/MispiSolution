package letter.frequency;

import java.util.*;

public class LetterSequence {
    private String sentence;

    public LetterSequence() {
    }

    public LetterSequence(String sentence) {
        this.sentence = sentence;
    }


    public Map<Character, Integer> computeFrequency() {

        String trimmedSentence = sentence.replaceAll(" ", "");
        Map<Character, Integer> initialMap = new HashMap<>();
        for (char c : trimmedSentence.toCharArray()) {

            if (initialMap.get(c) != null)
                initialMap.put(c, initialMap.get(c) + 1);
            else
                initialMap.put(c, 1);
        }

        //Character[] charArray = new Character[8];
        Map<Character, Integer> sortedFrequencyMap = new TreeMap<>(initialMap);

        //Collections.sort(frequecyMap.);

        return sortedFrequencyMap;
    }


    public void DisplayLetterFrequency(Map<Character, Integer> frequencyMap) {

        for (Map.Entry entry : frequencyMap.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < Integer.valueOf(entry.getValue().toString()); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
