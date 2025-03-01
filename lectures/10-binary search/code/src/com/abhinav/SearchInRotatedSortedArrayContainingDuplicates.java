import java.util.Arrays;

public class SearchInRotatedSortedArrayContainingDuplicates {
  public static int findPivot(int[] arr){
    int start, end, middle;
    start = 0;
    end = arr.length;

    //if pivot doesn't exist, the array isn't rotated in the first place.
    if (!(arr[end-1] < arr[start]) && arr[end-1] != arr[start]){ 
      return -1;
    }

    while (true){
      middle = start + (end-start)/2;

      //check if start is pivot
      if (arr[start] > arr[start + 1]){
        return start;
      }

      //check if end is pivot
      if (arr[end-1]<arr[end-2]){
        return end-2;
      }

      //check if start is equal to end
      if (arr[start] == arr[end-1]){
        start++;
        end--;
      }

      //ignore elements from start or end to middle if they are duplicates
      if (arr[start] == arr[middle]){
        start = middle + 1;
      } else if (arr[end-1] == arr[middle]){
        end = middle;
      }

      //find element where previous element is bigger than itself. That previous element is the pivot
      if (arr[middle]<arr[middle-1]){
        return middle-1;
      } else if (arr[end-1] < arr[middle]){
        start = middle + 1;
      } else {
        end = middle;
      }
    }
  }

  public static int binarySearch(int target, int[] nums, int start, int end){
    //standard binary search
    int middle;
    while (start != end){
      middle = start + (end-start)/2;
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        end = middle;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

  public static int[] duplicateBinarySearch(int target, int[] nums, int start, int end){
    //returns the first and last index of element. If there is only 1 element matching target in the array, then returns array containing the same index twice.
    int preliminary = binarySearch(target, nums, start, end);
    int[] result = {-1, -1};

    //if target isn't found
    if (preliminary == - 1){
      return result;
    } else if (preliminary == 0 || preliminary == nums.length - 1){ 
      //if target is found as the first or last element, due to the nature of binary search, there can be no other index that holds it as well
      result[0] = result[1] = preliminary;
    } else {
      //keep checking to the left with binary search until no element matches target anymore
      int left, right;
      left = preliminary;
      while (left != -1){
        result[0] = left;
        left = binarySearch(target, nums, start, result[0]);
      }
      
      //keep checking to the right with binary search until no element matches target anymore
      right = preliminary;
      while (right != -1){
        result[1] = right;
        right = binarySearch(target, nums, result[1] + 1, end);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int target = 7;
    int[] arr = {7,7,7,8,3,4,4,5,6};

    boolean targetFound = false;
    //basic edge case check
    if (arr.length == 0){
      System.out.println(-1);
      targetFound = true;
    } else if (arr.length == 1) {
      targetFound = true;
      if (arr[0] == target){
        System.out.println(0);
      } else {
        System.out.println(-1);
      }
    }

    //if above edge cases weren't tripped, continue
    if (!targetFound) {
      int pivot = findPivot(arr);

      //if there is no pivot, then do a simple duplicateBinarySearch
      if (pivot == -1){
        System.out.println(Arrays.toString(duplicateBinarySearch(target, arr, 0, arr.length)));
      } else { 
        //if there is a pivot, then find if element is equal to first element
        if (target == arr[0]){
          //check if target is also equal to the last element
          if (target == arr[arr.length - 1]){
            int[] indicesToLeftOfPivot = duplicateBinarySearch(target, arr, 0, pivot + 1);
            int[] indicesToRightOfPivot = duplicateBinarySearch(target, arr, pivot + 1, arr.length);
            int[] answer = {indicesToRightOfPivot[0], indicesToLeftOfPivot[1]};
            System.out.println(Arrays.toString(answer));
          } else {
            //only check to the left of the pivot and exclude the first element since we already know that is equal to the target
            int[] rightOfFirstElement = duplicateBinarySearch(target, arr, 1, pivot + 1);

            //if no element matches target to the right of the first element, then print 0 as both elements of the output array
            if (rightOfFirstElement[0] == -1){
              int[] result = {0,0}; 
              System.out.println(Arrays.toString(result));
            } else {
              //if one or more elements match the target to the right of the first element, then print the array with the first index we know and the farthest index that the duplicateBiarySearch provided us
              int [] result = {0, rightOfFirstElement[1]};
              System.out.println(Arrays.toString(result));
            }
          }
        } else { 
          //Since target is not equal to the first element, it can be compared with it to check if it is smaller. If so, check only to the right of the pivot, else check left of it
          int start, end;
          if (target < arr[0]){
            start = pivot + 1;
            end = arr.length;
          } else {
            start = 0;
            end = pivot + 1;
          }
          System.out.println(Arrays.toString(duplicateBinarySearch(target, arr, start, end)));
        }
      }
    }
  }
}
