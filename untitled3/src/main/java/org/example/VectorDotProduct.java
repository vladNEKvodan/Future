package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VectorDotProduct
{
    public static void main(String[] args) throws IOException {
        String S = "";
        String str;
        int niz = 0;
        int high = 0;
        int high_niz = 0;
        int probels = 0;
        int znaki_prep = 0;
        int celie = 0;
        int floatish = 0;

        try (BufferedReader ab = new BufferedReader(new FileReader("C:/Users/01/IdeaProjects/untitled3/src/main/java/input.txt"))){
            while ((str = ab.readLine()) != null){
                S += str;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Датасет: " + S);
        var SSplit = String.valueOf(S.split(" ").length);
        System.out.println("Всего слов в датасете: " + SSplit);

        char[] c = S.toCharArray();
        for (int count = 0; count < c.length; count++) {
            if(Character.isLowerCase(c[count]))niz++;
        }
        System.out.println("Маленьких букв: " + niz);
        for (int count = 0; count < c.length; count++) {
            if (Character.isUpperCase(c[count])) high++;
            }
        System.out.println("Заглавных букв: " + high);
        high_niz = high + niz;
        System.out.println("Сумма маленьких и заглавных букв: " + high_niz);

        for (int count = 0; count < c.length; count++) {
            if (Character.isWhitespace(c[count])) probels++;
        }
        System.out.println("Количество пробелов: " + probels);

        for (int count = 0; count < c.length; count++) {
            if (Character.isDigit(c[count])) celie++;
        }
        System.out.println("Количество целых чисел: " + celie);


        char[]b = {',', '.', '!', '?'};
        for(int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case ',', '.', '!', '?':
                    znaki_prep++;
                    break;
            }
        }
        StringBuilder text = new StringBuilder(S);
        text.delete(7,11);
        text.delete(16, 24);
        text.delete(30, 34);
        text.delete(46, 50);
        text.delete(55, 60);
        System.out.println("Знаков препинания в сумме: " + znaki_prep);
        System.out.println("Текст с удаленными знаками препинания: " + text);

        FileWriter save = new FileWriter("Results.txt");
        save.write("Всего слов в датасете: " + SSplit + " " + "Маленьких букв: " + niz + " " + "Заглавных букв: " + high + " " + "Сумма маленьких и заглавных букв: " + high_niz + " " + "Количество пробелов: " + probels + " " + "Количество целых чисел: " + celie + " "
        + "Текст с удаленными знаками препинания: " +text);
        save.close();
        System.out.println("Сохранено");
        }
    }
