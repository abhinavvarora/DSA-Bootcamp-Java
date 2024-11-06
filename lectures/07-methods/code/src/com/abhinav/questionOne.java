package com.abhinav;
import java.util.Scanner;
//prime number

public class questionOne {
  public static void main(String args[]){
    Scanner in = new Scanner (System.in);
    // System.out.println("Input the number you want verified to be prime or not: ");
    // int userInput = in.nextInt();
    // System.out.println(isPrime(userInput));

    //pritn all 3 digit armstrong numbers
    // threeDigArm();

    //loop to find all 3 digit armstrong numbers
    for (int i = 100; i < 1000; i++){
      if (armstrongOfThree(i)){
        System.out.println(i);
      }
    }
  }

  //print all 3 digit armstrong numbers
  static void threeDigArm(){
    int sumOfDigitsToThree;
    int n2;
    int n;
    for (int i = 100; i < 1000; i++){
      n2 = i;
      sumOfDigitsToThree = 0;
      while (true){
        n = n2%10;
        sumOfDigitsToThree += Math.pow(n,3);
        n2 /= 10;
        if (n2 == 0){
          break;
        }
      }
      if (sumOfDigitsToThree == i){
        System.out.println(i);
      }
    }
  }

  static boolean armstrongOfThree(int n){
    int a = n;
    int sum = 0;
    while (a > 0){
      int rem = a%10;
      sum += Math.pow(rem, 3);
      a/=10;
    }
    return (sum == n);
  }

  static boolean isPrime(int n){
    if (n <= 1){
      return false;
    }
    int c = 2;
    while (c*c <= n){
      if (n%c==0){
        return false;
      }
      c++;
    }
    return true;
  }
}