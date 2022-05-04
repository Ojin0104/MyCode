package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek9251LCS {
     public static void main(String args[]) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
         char[] A=(br.readLine()).toCharArray();
         char[] B=(br.readLine()).toCharArray();
          int[][] len=new int[A.length+1][B.length+1];
          
         for(int i=1;i<=A.length;i++) {
        	 for(int j=1;j<=B.length;j++) {
        		 if(A[i-1]==B[j-1]) {
        			 len[i][j]=len[i-1][j-1]+1;
        		 }else {
        			 len[i][j]=Math.max(len[i-1][j], len[i][j-1]);
        		 }
        	 }
         }
        
         System.out.println(len[A.length][B.length]);
     }
}
