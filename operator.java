/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Java_Practice.Java_Practice;

import java.util.Scanner;

/**
 *
 * @author Pletaria
 */
public class operator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("input number01 : ");
            int num1 = sc.nextInt();
            System.out.print("input number02 : ");
            int num2 = sc.nextInt();
            System.out.print("input operator 1 = +, 2 = -, 3 = *, 4 = /  : ");
            int operator = sc.nextInt();
            switch (operator) {
                case 1:
                    System.out.println("result : " + num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("result : " + num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("result : " + num1 + " x " + num2 + " = " + (num1 * num2));
                    break;
                case 4:
                    System.out.println("result : " + num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
                default:
                    System.out.println("wrong operator !!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
        
            

    }

}
