public class SearchInRotatedSortedArray {
  public static int findPivot(int[] arr){
    int start, end, middle;
    start = 0;
    end = arr.length;
    //if pivot doesn't exist, the array isn't rotated in the first place. In that case, treat the last element as pivot.
    if (!(arr[end-1] < arr[start])){ 
      return end-1;
    }
    while (true){
      middle = start + (end-start)/2;
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
    int middle = start + (end-start)/2;
    while (start != end){
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        end = middle;
      } else {
        start = middle + 1;
      }
      middle = start + (end-start)/2;
    }
    return -1;
  }

  public static void main(String[] args) {
    int target = 4;
    int[] arr = {4,5,6,7,8,9,1,2,3};  
    int pivot = findPivot(arr);
    //Check if element is smaller than first element. If yes, check to the right of the pivot, else to the left. 
    int start, end;
    start = 0;
    end = 0;
    boolean targetFound = false;
    if (target == arr[0]){
      System.out.println(0);
      targetFound = true;
    } else if(target < arr[0]){
      start = pivot + 1;
      end = arr.length;
    } else {
      start = 0;
      end = pivot + 1;
    }
    if (!targetFound){
      System.out.println(binarySearch(target, arr, start, end));
    }

    //Older idea, less efficient:
    // now just check to the left first, else check right
    // int checkLeft = binarySearch(target, arr, 0, pivot + 1);
    // if (checkLeft != -1){
    //   System.out.println(checkLeft);
    // } else {
    //   int checkRight = binarySearch(target, arr, pivot + 1, arr.length);
    //   if (checkRight != -1){
    //     System.out.println(checkRight);
    //   } else {
    //     System.out.println("target not found");
    //   }
    // }

  }
}
