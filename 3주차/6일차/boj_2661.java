package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int start = 1;
    static int end = 3;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        back("");



    }

    private static void back(String s) {
        if(s.length() == n)
            System.out.println(s);
        for(int i=start;i<=end;i++){
            if(check(s+i))
                back(s+i);
        }
    }

    private static boolean check(String s) {
        for(int i=1;i<=s.length()/2;i++){
            //절반만 체크
            String front = s.substring(s.length()-i*2, s.length()-i);
            String back = s.substring(s.length() - i, s.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}
