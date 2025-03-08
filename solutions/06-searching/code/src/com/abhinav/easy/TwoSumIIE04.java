import java.util.Arrays;
public class TwoSumIIE04 {
  public static int[] twoSum(int[] numbers, int target) {
    //basic edge case check
    if (numbers.length == 2){
      int[] result = {1,2};
      return result;
    }

    int[] result = {-1, -1};
    //loop for every element
    for (int i = 0; i < numbers.length; i++){
      int sum = numbers[i] + numbers[numbers.length-1];
      if (sum == target){
        //if the current element + last element happens to be the answer, return it
        result[0] = i+1;
        result[1] = numbers.length;
        return result;
      } else if (sum < target){
        //if the current + last isn't equal or smaller than target then the current cannot possibly be one part of the answer, so continue
        continue;
      } else {
        //it's possible that one of the elements between end and current could sum with current to become the answer, so check them

        //using binary search on the remaining elements
        int start = i + 1;
        int end = numbers.length;
        int middle;
        while (start != end){
          middle = start + (end - start)/2;
          sum = numbers[i] + numbers[middle];
          if (sum == target){
            result[0] = i + 1;
            result[1] = middle + 1;
            return result;
          } else if (sum < target){
            start = middle + 1;
          } else {
            end = middle;
          }
        }

        /*
        inefficient way to do it
        for (int j = i + 1; j < numbers.length - 1; j++){
          if (numbers[i] + numbers[j] == target){
            result[0] = i+1;
            result[1] = j+1;
          }
        }
        */
      }
    }

    return result;
    /*
    //select arbitrary first element
    int indexOfFirst = numbers.length/2;
    int firstElement = numbers[indexOfFirst];

    //check if it can possibly be one part of the answer
    int sum = firstElement + numbers[indexOfFirst+1];
    if (sum == target){
      int[] result = {indexOfFirst, indexOfFirst+1};
    } else if (sum > target) {
      //look to the left
      
    } else {
      //check last
    }

    return result;
    */
  }
  
  public static void main(String[] args){
    int[] arr = {0,0,3,4};
    int goal = 0;
    System.out.println(Arrays.toString(twoSum(arr, goal)));
  }
}
