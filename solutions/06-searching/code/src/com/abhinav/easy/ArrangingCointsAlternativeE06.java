public class ArrangingCointsAlternativeE06 {
  public static int arrangeCoins(int n){
    //k(k+1)/2<=n
    //k^2 + k - 2n <= 0
    //(-1 + sqrt(1 + 8n))/2
    return (int) (Math.sqrt(1 + 8 * (long) n) - 1)/2;
  }

  public static void main(String[] args) {
    System.out.println(arrangeCoins(5));
  }
}
