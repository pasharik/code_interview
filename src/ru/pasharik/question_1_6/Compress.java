package ru.pasharik.question_1_6;

public class Compress {
    private static String doCompress(String str) {
        StringBuilder sb = new StringBuilder();
        char oldChar = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (oldChar != ch) {
                sb.append(oldChar);
                sb.append(count);
                if (sb.length() > str.length()) return str;
                count = 0;
            }
            count++;
            oldChar = ch;
        }
        sb.append(oldChar);
        sb.append(count);

        return sb.length() > str.length() ? str : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                doCompress("aaaabbbcc"));
//                doCompress("abcdefgh"));
    }
}
