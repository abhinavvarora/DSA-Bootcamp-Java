import java.util.Arrays;

public class RotateArrayM08 {
  public static void rotate(int[] nums, int k) {
    //take a remainder of k with the length of array
    k = k % nums.length;
    //make a temp array where you keep k number of elements
    int temp[] = new int[k];
    int count = 0;
    for (int i = nums.length-k; i < nums.length; i++){
      temp[count] = nums[i];
      count++;
    }
    //for loop to move every element in the list except the last k elements forward by k steps
    for (int i = nums.length - k - 1; i > -1; i--){
      nums[i+k] = nums[i];
    }
    //for the first k elements, replace them with the temp values
    for (int i = 0; i < k; i++){
      nums[i] = temp[i];
    }
  }
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7};
    rotate(arr, 3);
    System.out.println(Arrays.toString(arr));
  }
}
