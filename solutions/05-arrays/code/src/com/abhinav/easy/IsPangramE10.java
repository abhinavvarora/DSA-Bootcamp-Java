public class IsPangramE10 {
  static boolean isPresent(int a, char[] arr){
    for (char letter : arr) {
      if (a == letter){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    String sentence = "TheQuickbrownFoxjumpsovertheLazydog";
    sentence = sentence.toLowerCase();
    char[] arrSentence = sentence.toCharArray();
    for (int i = 97; i<123; i++){
      if (!isPresent(i, arrSentence)){
        System.out.println(false);
      }
    }
    System.out.println(true);
  }
}