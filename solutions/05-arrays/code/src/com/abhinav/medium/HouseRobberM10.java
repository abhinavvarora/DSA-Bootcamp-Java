import java.util.ArrayList;
import java.util.Collections;

public class HouseRobberM10 {
  public static int rob(int[] nums) {
    ArrayList<Integer> arrSums = new ArrayList<>(3); //to keep all the sums
    ArrayList<Boolean> arrCondition = new ArrayList<>(3); //to store whether to add or not to add current element
    ArrayList<Boolean> arrSkipped = new ArrayList<>(3); //to store whether the sum has just skipped an element in the immediate past or not

    //edge cases
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1){
      return nums[0];
    }

    //initializing the arrays for the first two indices
    arrSums.add(nums[0]); 
    arrCondition.add(true); 
    arrSkipped.add(false);
    arrSums.add(nums[1]);
    arrCondition.add(false);
    arrSkipped.add(false);

    //traverse the given array from the third index onwards
    for (int i = 2; i<nums.length; i++){
      //for every number, add it to the sums that have their corresponding arrCondition as true and make copies of sums that haven't skipped the previous number
      for (int j = 0; j<arrCondition.size(); j++){
        //make a copy of all the previous sums that haven't skipped the previous number and make the copy skip the current one.
        if (!arrSkipped.get(j)){
          arrSums.add(arrSums.get(j));
          arrCondition.add(false);
          arrSkipped.add(true);
        } 
        if (arrCondition.get(j)) {
          arrSums.set(j, arrSums.get(j) + nums[i]);
          arrCondition.set(j, false);
          arrSkipped.set(j, false);
        } else {
          arrCondition.set(j, true);
        }
      }
    }
    //return the max of all sums taken
    return Collections.max(arrSums);
  }
  public static void main(String[] args) {
    int[] nums = {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
    System.out.println(rob(nums));
  }
}
