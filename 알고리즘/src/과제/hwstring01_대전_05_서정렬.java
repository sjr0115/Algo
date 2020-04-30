package 과제;

import java.io.*;
import java.util.LinkedList;

public class hwstring01_대전_05_서정렬 {
   static LinkedList<Integer> list;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String T = br.readLine();
      String P = br.readLine();
      list = new LinkedList<>();
      KMP(T, P);
      StringBuilder sb = new StringBuilder();
      System.out.println(list.size());
      for (Integer i : list) {
         sb.append(i + " ");
      }
      System.out.println(sb);
   }

   private static void KMP(String origin, String pattern) {
      int[] pi = getPi(pattern);
      int j = 0;
      for (int i = 0; i < origin.length(); i++) {
         while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
            j = pi[j - 1];
         }
         if(origin.charAt(i) == pattern.charAt(j)) {
            if(j == pattern.length() - 1) {
               list.add(i - pattern.length() + 2);
               j = pi[j];
            } else {
               j++;
            }
         }
      }
   }

   private static int[] getPi(String pattern) {
      int[] pi = new int[pattern.length()];
      int j = 0;
      for (int i = 1; i < pattern.length(); i++) {
         while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
            j = pi[j - 1];
         }
         if(pattern.charAt(i) == pattern.charAt(j)) {
            pi[i] = ++j;
         }
      }
      return pi;
   }

}