import java.util.Arrays;
public class arrayShuffle_05 {
  public static void main(String[] args) {
    int[] nums = {2,5,1,3,4,7};
    int n = 3;
    int numberOfLoops = 2 * n;
    int[] shuffledArray = new int[numberOfLoops];
    int firstPointer = 0;
    int secondPointer = n;
    for (int i = 0; i < numberOfLoops; i+=2) {
      shuffledArray[i] = nums[firstPointer];
      shuffledArray[i+1] = nums[secondPointer];
      firstPointer++;
      secondPointer++;
    }
    System.out.println(Arrays.toString(shuffledArray));
  }
}
