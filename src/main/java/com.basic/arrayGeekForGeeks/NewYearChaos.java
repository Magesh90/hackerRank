package com.basic.arrayGeekForGeeks;

import java.util.*;


public class NewYearChaos {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int minimumBribes = 0;
        //[1,2,3,4,5] [2,1,5,3,4]-3 [2,5,1,3,4]-4 {1, 2, 5, 3, 7, 8, 6, 4}
        for (int i = 0; i < q.length; i++) {
            int bribedCount = q[i] - (i + 1);
            if (bribedCount <= 2) {
                if (bribedCount > 0)
                    minimumBribes += bribedCount;
            } else {
                System.out.println("Too chaotic");
                System.exit(0);
            }
        }
        System.out.println(minimumBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

        }*/

        //int[] inputArray = {2, 1, 5, 3, 4};
        //int[] inputArray = {2, 5, 1, 3, 4};
        //int[] inputArray = {5,1,2,3,7,8,6,4};
        int[] inputArray = {1, 2, 5, 3, 7, 8, 6, 4};
       // minimumBribes(inputArray);

        scanner.close();

        HashMap<String,String> test = new HashMap<>();
        System.out.println(test.getOrDefault("key","defaultValue"));

        LinkedHashMap<String,String> test1 = new LinkedHashMap<>();
        System.out.println(test1.getOrDefault("key","defaultValue"));


        Hashtable<String,String> table = new Hashtable<>();
        System.out.println(table.getOrDefault("key","defaultValue"));

        Properties properties=new Properties();
    }
}

