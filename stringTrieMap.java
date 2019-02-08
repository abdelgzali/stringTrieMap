import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Daily Java Challenge from HackerRank
public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] matches = new int[queries.length];
        if(strings.length == 0 || queries.length == 0) {
            return matches;
        }

        String letterChain = "", trieChain = "";
        int chainLength = letterChain.length();
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            letterChain+= strings[i] + ";";
        }  
        for (int i = 0; i < letterChain.length() - 1; i++) {
            System.out.println(trieChain);
            if (letterChain.charAt(i) == ';') {
                trieChain = "";
                i++;
            }
            trieChain += letterChain.charAt(i);
            if (hm.containsKey(trieChain)) {
                hm.put(trieChain, hm.get(trieChain) + 1);
            } else {
                hm.put(trieChain, 1);
            }
            
        }
        for(int i = 0; i < queries.length; i++) {
            System.out.println("queries: " + queries[i]);
            if (hm.containsKey(queries[i])) {
                matches[i] = hm.get(queries[i]);
            } else {
                matches[i] = 0;
            }
        }
        return matches;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
