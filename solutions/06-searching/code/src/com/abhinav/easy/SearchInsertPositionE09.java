public class SearchInsertPositionE09 {
  public static int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int middle;
    while (start <= end){
      middle = start + (end - start) / 2;
      if (nums[middle] == target){
        return middle;
      } else if (nums[middle] < target){
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    int[] arr = {1,7,12,1000};
    System.out.println(searchInsert(arr, 999));
  }
}
