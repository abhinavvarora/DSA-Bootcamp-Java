import java.util.Scanner;
public class Q13PythagoreanTriplet {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Input three numbers separated by a space");
    int num1 = in.nextInt();
    int num2 = in.nextInt();
    int num3 = in.nextInt();
    while (!(num1>0 && num2>0 && num3>0)){
      System.out.println("Please ensure all 3 numbers you input are positive. It has to be that way else it's not even up for discussion on whether it's a pythagorean triplet.");
      num1 = in.nextInt();
      num2 = in.nextInt();
      num3 = in.nextInt();
    }
    int[] largestFirst = largestOfThree(num1, num2, num3);
    System.out.println(isHypoteneuse(largestFirst[0], largestFirst[1], largestFirst[2])? "Yes, given triplet is pythagorean": "No, given triplet is not pythagorean");
  }
  static boolean isHypoteneuse(int a, int b, int c){
    return Math.pow(a,2) == Math.pow(b, 2) + Math.pow(c, 2);
  }

  static int[] largestOfThree(int a, int b, int c){
    if (a>b && a>c){
      int[] arr = {a, b, c};
      return arr;
    } else if (b>c){
      int[] arr = {b, a, c};
      return arr;
    } else {
      int[] arr = {c, a, b};
      return arr;
    }
  }
}