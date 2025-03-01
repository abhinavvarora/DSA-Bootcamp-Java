public class MinChipsSamePositionE26 {
  public static void main(String[] args) {
    int[] position = {2,2,2,3,3};
    
    int odd, even;
    odd = even = 0;
    for (int i : position) {
      if (i%2 == 0){
        even++;
      } else {
        odd++;
      }
    }

    //check how many chips lie on even numbered positions and how many on odd
    //the smaller of the two is the correct answer
    if (even>odd){
      System.out.println(odd);
    } else {
      System.out.println(even);
    }
  }  
}
