public class KthMissingPositiveNumberE08 {
  public static int findKthPositive(int[] arr, int k) {
    int numberOfMissing = 0;
    //iterate over array
    for (int i = 0; i < arr.length; i++){
      //using index + 1 as the correct array of integer numbers,
      //current number minus that and however many there were already missing gives us the correct number of missing integers up the current iterable
      numberOfMissing += arr[i] - (i + 1 + numberOfMissing);
      //if at any moment numberOfMissing reaches k or higher, the expected output is some number behind the current iterable in relation to numberOfMissing and k
      if (numberOfMissing >= k){
        return arr[i] - (numberOfMissing - k) - 1; 
      }
    }
    //if k happens to be one of the numbers not present before the last value of the array, it is treated differently because going backwards is different from moving forwards from a number when subtracting
    return numberOfMissing < k? arr[arr.length-1] + k - numberOfMissing : arr[arr.length-1] - numberOfMissing + k - 1;
  }

  public static void main(String[] args) {
    int[] numbers = {1,2,1000};
    System.out.println(findKthPositive(numbers, 3));
  }
}
