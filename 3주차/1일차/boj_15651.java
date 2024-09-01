package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] res;
    static int[] arr;
    static int[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        res = new int[m];
        visited = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        //중복조합
        comb( arr[0], 0);
        bw.write(sb.toString());
        bw.close();

    }

    private static void comb(int start, int depth) {
        if(depth == res.length){
            for(int i=0;i<res.length;i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<arr.length;i++){
            res[depth] = arr[i];
            comb(start + 1, depth + 1);
        }
    }
}
