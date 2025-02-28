import java.util.ArrayList;

public class JumpGameM07 {
    public static boolean canJump(int[] nums) {
      //edge cases
      if (nums.length == 1) {
        return true;
      } else if(nums[0] == 0) {
        return false;
      }
      //store the indices of all zeroes except if it is present at the last index
      ArrayList<Integer> indexOfZeroes = new ArrayList<>(1);
      for (int i = 0; i < nums.length-1; i++){
        if (nums[i] == 0){
          indexOfZeroes.add(i);
        }
      }
      //if there's no zero, no need to think
      if (indexOfZeroes.isEmpty()) {
        return true;
      }
      //for every zero check if there is a way to get over it
      for (int j = 0; j<indexOfZeroes.size(); j++){
        int indCurZero = indexOfZeroes.get(j);
        for (int i=0; i<=indCurZero; i++){
          if (nums[i] > indCurZero - i){
            break;
          } else if (i == indCurZero - 1){
            return false;
          }
        }
      }
      return true;
    }
  public static void main(String[] args) {
    int[] arr = {2, 0, 0};
    System.out.println(canJump(arr));
  }
}
