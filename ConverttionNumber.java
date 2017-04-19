/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Java_Practice.Java_Practice;

import java.util.Scanner;

/**
 *
 * @author PMSEITOKAI
 */
public class ConverttionNumber {
    public static void main(String[] args) {
            int number = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please type a number between 0 and 999 OR type 0 to exit:  ");
            number = scanner.nextInt();
            while(number!=0){
                if(number>=0 && number<=999){
                    if(number==0){
                        System.out.print("NUMBER AFTER CONVERSION:\tZERO");
                    } else {
                        System.out.print("NUMBER AFTER CONVERSION:\t");
                        numberToWord(((number / 100) % 10), " ");
                        numberToWord((number % 100), " ");
                    }

                } else{
                    System.out.print("INVALID NUMBER !!! PLEASE TRY AGAIN ...");
                }
                System.out.print("\nPlease type a number between 0 and 999 OR type 0 to exit:  ");
                number = scanner.nextInt();
            }
        }

        public static void numberToWord(int num, String val) {
            String ones[] = {" ZERO", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE"};
           
            String tens[] = {" ZERO", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE"};
            if (num > 19) {
                System.out.print(tens[num / 10] + " " + ones[num % 10]);
            } else {
                System.out.print(ones[num]);
            }
            if (num > 0) {
                System.out.print(val);
            }
        }
    }

