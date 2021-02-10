package PhysEdFormGen.src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Formatter {

    private static Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static Scanner input = new Scanner(System.in);

    //Returns letters definition
    public static String[] wordBankInput() {

        //Array to store letters
        String[] wordBank = new String[26];
        //Letters
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for(int i = 0; i<wordBank.length; i++) {
            System.out.println("Enter letter " + alphabet[i] + "'s definition");
            wordBank[i] = input.nextLine();
        }

        return wordBank;
    }

    public static String wordFormatter(String[] wordBank, int numOfWords) {
        String finalMessage = "";

        String[] words = new String[numOfWords]; //Makes a string array of the words

        for(int i = 0; i<numOfWords; i++) {
            int num = i + 1;
            System.out.println("Enter word number " + num);
            words[i] = input.nextLine().toLowerCase();
        }
        input.close();

        //Format Words
        List<Character> listAlphabet = Arrays.asList(alphabet);
        finalMessage += words[0] + " : ";

        for (int i = 0; i<words[0].length(); i++) {
            if(listAlphabet.indexOf(words[0].charAt(i)) != -1) {
                int alphNumber = listAlphabet.indexOf(words[0].charAt(i));
                finalMessage += wordBank[alphNumber] + " ";
            }
        }
        finalMessage += '\n';

        for(int i = 1; i<words.length; i++) {
            finalMessage += words[i] + " : ";

            for (int k = 0; k<words[0].length(); k++) {
                if(listAlphabet.contains(words[0].charAt(i))) {
                    int alphNumber = listAlphabet.indexOf(words[0].charAt(k));
                    finalMessage += wordBank[alphNumber] + " ";
                }
            }
            finalMessage += '\n';
        }

        input.close();

        return finalMessage;
    }

    public static String wordFormatter(String[] wordBank, String[] words) {
        String finalMessage = "";

        //Format Words
        List<Character> listAlphabet = Arrays.asList(alphabet);
        finalMessage += words[0] + " : ";

        for (int i = 0; i<words[0].length(); i++) {
            if(listAlphabet.indexOf(words[0].charAt(i)) != -1) {
                int alphNumber = listAlphabet.indexOf(words[0].charAt(i));
                finalMessage += wordBank[alphNumber] + " ";
            }
        }
        finalMessage += '\n';

        for(int i = 1; i<words.length; i++) {
            finalMessage += words[i] + " : ";

            for (int k = 0; k<words[i].length(); k++) {
                if(listAlphabet.contains(words[i].charAt(k))) {
                    int alphNumber = listAlphabet.indexOf(words[i].charAt(k));
                    finalMessage += wordBank[alphNumber] + " ";
                }
            }
            finalMessage += '\n';
        }

        input.close();

        return finalMessage;
    }
}
