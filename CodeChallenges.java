import java.util.ArrayList;
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
  
  public static void main(String[] args) {
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(List.of(1, 2, 3));
    arr.add(List.of(4, 5, 6));
    arr.add(List.of(9, 8, 9));

    int result = diagonalDifference(arr);
    System.out.println(result);
  }
}