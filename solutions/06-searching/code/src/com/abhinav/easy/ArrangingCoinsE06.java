public class ArrangingCoinsE06 {
  public static int arrangeCoins(int n) {
    int start = 1;
    int end = 2;
    int middle = 0;
    int possibleNumber = 2; 
    int largestOfSmaller = 1;
    int prevPossibleNumber = 1;
    while (possibleNumber < n){
      if (possibleNumber < prevPossibleNumber){
        break;
      } else {
        prevPossibleNumber = possibleNumber;
      }
      start = end + 1;
      end *= 2;
      possibleNumber = end * (end + 1) / 2;
    }

    long differentPossibleNumber;
    while (start <= end){
      middle = start + (end - start) / 2;
      differentPossibleNumber = (long) middle * (middle + 1) / 2;
      if (differentPossibleNumber == n){
        return middle;
      } else if (differentPossibleNumber < n){
        largestOfSmaller = middle;
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    if (largestOfSmaller == 1){
      return start - 1 ;
    } else {
      return largestOfSmaller;
    }
  }

  public static void main(String[] args) {
    System.out.println(arrangeCoins(5));
  }
}
