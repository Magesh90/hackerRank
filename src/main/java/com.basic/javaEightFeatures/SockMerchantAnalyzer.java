package com.basic.javaEightFeatures;

import com.sun.corba.se.spi.monitoring.MonitoredObjectFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SockMerchantAnalyzer {

    public static void main(String[] args) {
        //System.out.print(sockMerchant(0, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
        String[] names = {"Kumar", "Logeshwari", "Magesh", "Malathi", "Nivaan"};
        System.out.println(binarySearch(names, "Malathi"));
        System.out.println(pageCount(7, 2));
    }

    static int sockMerchant(int n, int[] ar) {
        //[[2,1,3,2,1] 2
        int pairs = 0;
        //Set pairHolder = new HashSet();
        Map pairHolder = new HashMap<Integer, Integer>();
        for (int i = 0; i < ar.length; i++) {
            int tempCheck = ar[i];
            if (pairHolder.containsKey(tempCheck)) {
                int sockUnderCheck = (int) pairHolder.get(tempCheck);
                pairHolder.put(tempCheck, sockUnderCheck++); //10-2
                if (((int) pairHolder.get(tempCheck)) % 2 == 0) {
                    pairs++;
                }
            } else
                pairHolder.put(tempCheck, 1); //10-1
        }
        return pairs;
    }

    static int binarySearch(String[] names, String name) {
        boolean found = false;
        int position = 100;
        int left = 0;
        int right = names.length - 1;
        if (left > right) {
            return position;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (names[mid].equals(name)) {
                found = true;
                position = mid;
                return position;
            } else if (names[mid].compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return position;
    }


    static int pageCount(int n, int p) {
        int fromLastPage;
        int fromFrontPage;

        if (p == n) { //6
            return 0;
        } else if (p == 1) { //1
            return 0;
        } else {
            if (n % 2 == 0) {
                fromLastPage = (n - p + 1) / 2; //5 2/2 4- 3/2 //3 4/2 //2
                fromFrontPage = (p / 2) ;
            } else {
                fromLastPage = (n - p) / 2; //5 2/2 4- 3/2 //3 4/2 //2
                fromFrontPage = (p / 2);
            }
        }

        if (fromFrontPage > fromLastPage)
            return fromLastPage;
        else
            return fromFrontPage;
    }
}
