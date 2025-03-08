public class SmallestLetterGreaterThanTargetE07 {
  public static char nextGreatestLetter(char[] letters, char target){
    int start = 0;
    int end = letters.length - 1;
    int middle;
    char smallestOfLarger = letters[0];
    boolean largerExists = false;

    while (start <= end){
      middle = start + (end - start) / 2;
      if (letters[middle] == target){
        start = middle + 1;
      } else if (letters[middle] < target){
        start = middle + 1;
      } else {
        largerExists = true;
        smallestOfLarger = letters[middle];
        end = middle - 1;
      }
    }
    return largerExists? smallestOfLarger : letters[0];
  }

  public static void main(String[] args) {
    char[] arr = {'a', 'b', 'c', 'd', 'e'};
    System.out.println(nextGreatestLetter(arr, 'e'));
  }
}
