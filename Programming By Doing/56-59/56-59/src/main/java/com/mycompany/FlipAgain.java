/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlipAgain {

    public static void main(String[] args) {

 // 3.) Yes the program still works because it goes through the loop and
 //     before it ends y is given a value so the while condiiton can be met.
        
        Scanner keyboard = new Scanner(System.in);
        Random rng = new Random();

        String again;

        do {
            int flip = rng.nextInt(2);
            String coin;

            if (flip == 1) {
                coin = "HEADS";
            } else {
                coin = "TAILS";
            }

            System.out.println("You flip a coin and it is... " + coin);

            System.out.print("Would you like to flip again (y/n)? ");
            again = keyboard.next();
        } while (again.equals("y"));
    }
}
