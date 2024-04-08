import java.util.Scanner;

public class Anagrams {
    private static int printCount = 0;

    public static void main(String[] args) {

        // Get number
        int n = Integer.parseInt(args[0]);

        // Get word
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci parola: ");
        String word = scanner.next().toLowerCase();

        // Generate and print anagrams
        char[] chars = word.toCharArray();
        printCount = n;
        generateAnagrams(chars, chars.length);
    }

    private static void generateAnagrams(char[] chars, int n) {
        if (printCount < 1) {
            return;
        } else {
            System.out.printf("%d: ", printCount);
            printPermutation(chars);
            printCount--;
        }

        for (int i = 0; i < n; i++) {
            generateAnagrams(chars, n - 1);

            if (n % 2 == 0) {
                swap(chars, i, n - 1);
            } else {
                swap(chars, 0, n - 1);
            }
        }
    }

    private static void printPermutation(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        String s = sb.toString();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        System.out.println(s);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}



/*
public class Anagrams {
    public static void main(String[] args) {

        //get number
        int n = Integer.parseInt(args[0]);

        //get word
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci parola: ");
        String w = scanner.next().toLowerCase();

        String[] anagrams = getAnagrams(w, w.length());

        int i = 0;
        for (String s : anagrams) {
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            System.out.printf("%d: %s%n", i, s);
            if (i >= n) {
                break;
            }
            i++;
        }
    }

    private static String[] getAnagrams(String w, int n) {
        //base case
        if (w.length() < 2) {
            String[] temp = new String[1];
            temp[0] = w;
            return temp;
        }

        String[] substringCollection = getAnagrams(w.substring(1, n), n - 1);
        String[] anagrams = new String[n * substringCollection.length];
        String letter = w.substring(0, 1);

        for (int i = 0; i < substringCollection.length; i++) {
            for (int j = 0; j < n; j++) {
                String subAnagram = substringCollection[i];
                String leftSub = subAnagram.substring(0, j);
                String rightSub = subAnagram.substring(j);
                anagrams[n * i + j] = leftSub + letter + rightSub;
            }
        }

        return anagrams;
    }
}
*/
