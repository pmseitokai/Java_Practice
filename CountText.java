/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Java_Practice.Java_Practice;;

import java.util.Scanner;

/**
 *
 * @author PMSEITOKAI
 */
public class CountText {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text = sc.nextLine();
        String vowels = "aeiouAEIOU";

        //System.out.println(text);
        int vowelCount = 0;
        int consCount = 0;
        int nuberic = 0;
        int space = 0;
        int other = 0;

        int i;
        int textlength = text.length();

        for (i = 0; i < textlength; i++) {

            char currentChar = text.charAt(i);
            if (vowels.indexOf(currentChar) >= 0) {
                vowelCount++;
            } else if (Character.isLetter(currentChar)) {
                consCount++;
            } else if (Character.isWhitespace(text.charAt(i))) {
                space++;
            } else if (Character.isDigit(text.charAt(i))) {
                nuberic++;
            } else {
                other++;
            }

        }

        String spaceTostar = text.replaceAll(" ", "*");

        
        
        int count = 0;
        String sb = "";
        for (char aToA : spaceTostar.toCharArray()) {
            char t = Character.toUpperCase(aToA);
            if (t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U') {
                sb = sb + t;
                count++;
            } else {
                sb = sb + aToA;
            }
        }

        System.out.println("Vowel : " + vowelCount);
        System.out.println("Consonant : " + consCount);
        System.out.println("Numburic : " + nuberic);
        System.out.println("space : " + space);
        System.out.println("Other : " + other);
        System.out.println("===================================");
        
        System.out.println("Your new text : " + sb.toString());

    }

}
