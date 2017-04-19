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
public class Mutiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number : ");
        int number = sc.nextInt();
        for (int i = 1; i <= 25; i++) {
            System.out.println(number+" x "+i+" = "+(number*i));
        }
        
    }
}
