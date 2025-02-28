package abhinav.medium;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public static int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      int[] output = {-1, -1};
      return output;
    }
    //binary search for target
    int initial = binarySearch(nums, 0, nums.length-1, target);
    int[] output = {initial, initial};
    if (initial != -1 && nums.length > 1) {
      //now do it to the left until you can't find more of the same target
      int testLeft = binarySearch(nums, 0, initial-1, target); 
      while (testLeft != -1){
        output[0] = testLeft;
        testLeft = binarySearch(nums, 0, testLeft-1, target); 
      }
      //binary search to the right of the initial index
      int testRight = binarySearch(nums, initial+1, nums.length-1, target); 
      //keep doing it will you can't find more of the same
      while (testRight != -1){
        output[1] = testRight;
        testRight = binarySearch(nums, testRight+1, nums.length-1, target); 
      }
    }
    //reutrn the starting and ending posiiton of target value
    return output;
  }
  public static int binarySearch(int[] arr, int start, int end, int query){
    int avgIndex = (start+end)/2+1;
    while (end > -1 && start > -1 && start < arr.length && end < arr.length) {
      if (start == end) {
        if (arr[start] == query){
          return start;
        } else {
          break;
        }
      } else if (arr[avgIndex] == query){
        return avgIndex;
      } else if (arr[avgIndex] < query){
        start = avgIndex;
      } else {
        end = avgIndex-1;
      }
      avgIndex = (start+end)/2+1;
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] input = {5, 7, 7, 8, 8,10};
    System.out.println(Arrays.toString(searchRange(input, 8)));
  }
}
