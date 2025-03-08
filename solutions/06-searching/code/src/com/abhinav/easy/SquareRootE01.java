public class SquareRootE01 {
  public static void main(String[] args){
    //Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well. You must not use any built-in exponent function or operator.
    int num = 5;

    //edge cases
    if (num == 0) {
      System.out.println(0);
    } 

    //binary search for squares of numbers and their closeness to the given number. The closest one less than given number is the answer.
    int start, end, middle, closestLower;
    start = 0;
    end = num;
    closestLower = 1;
    while (start < end){
      middle = start + (end - start)/2;
      long sq = (long) middle * middle;
      if (sq == num){
        System.out.println(middle);
        break;
      } else if (sq < num){
        closestLower = Math.max(closestLower, middle);
        start = middle + 1;
      } else {
        end = middle;
      }
    }
    System.out.println(closestLower);
  }
}