import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CodeChallenges {

  public static int diagonalDifference(List<List<Integer>> arr) {
    int diagonalOne = 0;
    int diagonalTwo = 0;
    int index = 0;
    int negIndex = arr.size() - 1; 
    
    while(index < arr.size()){
        diagonalOne += arr.get(index).get(index);
        diagonalTwo += arr.get(index).get(negIndex);
        index ++;
        negIndex --; 
    }
    
    return Math.abs(diagonalOne - diagonalTwo); 
  }
  
  public static int LonelyInteger(List<Integer> arr){

    HashSet<Integer> set = new HashSet<>();
    
    for(Integer num: arr){
      if(set.contains(num)){
        set.remove(num);
      } else {
        set.add(num);
      }
    }

    return set.iterator().next();
  }

  public static int[] countingSort(int[] arr){
    int[] frequencyArr = new int[100];
    for(int i = 0; i < arr.length; i++){
      int numValue = arr[i];
      frequencyArr[numValue] ++;
    }
    return frequencyArr; 
  }

  public static int[] createArrayFrom1To100() {
    int[] arr = new int[100];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = i;
    }
    return arr;
}

  public static void main(String[] args) {
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(List.of(1, 2, 3));
    arr.add(List.of(4, 5, 6));
    arr.add(List.of(9, 8, 9));

    int result = diagonalDifference(arr);

    int[] testArr = createArrayFrom1To100();
    int[] countSortedArray = countingSort(testArr);

    for(int i = 0; i < countSortedArray.length; i++){
      System.out.println("current value is " + testArr[i]);
    }

    System.out.println(result);
  }
}