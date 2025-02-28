public class WrongSearchInPeakMountain {
  public static int findMax(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    int middle = start + (end-start)/2;
    if (arr.length == 0) {
      return - 1;
    }
    while (start != end) {
      if (arr[middle] > arr[middle+1]){
        end = middle;
      } else {
        start = middle + 1;
      }
      middle = start + (end-start)/2;
    }
    return end;
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
    int[] myArr = {0,0,1,2,2,3,4,3,2,1};
    int target = 3;

    //find the peak
    int indexPeak = findMax(myArr);
    System.out.println(indexPeak);
    
    int indexAnswer = -1;
    if (target <= myArr[indexPeak]){
      int end = indexPeak + 1;
      
      //Search to the left of currently found answer and store it in tempAnswer
      while (true){
        int tempAnswer = binarySearch(target, myArr, 0, end);
        //if target index is not found then break the loop
        if (tempAnswer == -1){
          break;
        } else {
          indexAnswer = tempAnswer;
        }
        //setting end to currently known least index of target so the left can be searched from there
        end = indexAnswer;
      }
    } else {
      //set end to mountain's last index + 1 right now and later set it to known values of target index to keep narrowing the search to smaller and smaller indices
      int end = myArr.length;
      
      //Search to the left of currently found answer and store it in tempAnswer
      while (true){
        int tempAnswer = binarySearch(target, myArr, indexPeak + 1, end);
        //if target index is not found then output -1
        if (tempAnswer == -1){
          break;
        } else {
          indexAnswer = tempAnswer;
        }
        //setting end to currently known least index of target so the left can be searched from there
        end = indexAnswer;
      }
    }
    
    //if target not found, print so
    if (indexAnswer == - 1){
      System.out.println("Target not found");
    } else {
      System.out.println("Smallest index of target is " + indexAnswer);
    }
  }
}
