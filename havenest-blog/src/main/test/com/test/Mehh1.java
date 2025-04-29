package com.test;

public class Mehh1 {
    public static void main(String[] args) {
       int a = 380;
        System.out.println(a / 10);
        System.out.println(a % 10);
    }
    public static String toLowerCase(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] >= 'A' && charArr[i] <= 'Z'){
                charArr[i] += 32;
            }
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}
