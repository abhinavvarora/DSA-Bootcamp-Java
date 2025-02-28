import java.util.Arrays;

public class SortColors09 {

  public static void sortColors(int[] nums) {
    int[] arrColorNum = {0, 0, 0};
    //count number of zeroes, ones and twos then put them in an array
    for (int colorNo: nums){
      if (colorNo == 0) {
        arrColorNum[0]++;
      } else if (colorNo == 1){
        arrColorNum[1]++;
      } else {
        arrColorNum[2]++;
      }
    }
    //for every element of that array, loop that element number of times and set the value of nums' elements to that value
    int index = 0;
    for (int color = 0; color<3; color++){
      for (int i = 0; i<arrColorNum[color]; i++){
        nums[index] = color;
        index++;
      }
    }
  }
  public static void main(String[] args) {
    int[] nums = {2,0,2,2,1,0};
    sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}