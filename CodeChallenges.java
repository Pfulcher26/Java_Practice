import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CodeChallenges {

  public static List<Integer> breakingRecords(List<Integer> scores) {
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int minScoreTally = 0;
        int maxScoreTally = 0;
        List<Integer> recordArray = new ArrayList<>(List.of(0,0));
        
        for(int score: scores) {
            if(score < minScore){
                minScore = score; 
                minScoreTally++;  
            } 
            if(score > maxScore){
                maxScore = score; 
                maxScoreTally++;
            }
        }
        
        recordArray.set(0, minScoreTally);
        recordArray.set(1, maxScoreTally);
        
        return recordArray;
    }

  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    List<Integer> appleDistances = new ArrayList<>();
    List<Integer> orangeDistances = new ArrayList<>();
    int appleCount = 0;
    int orangeCount = 0;

    for (int apple : apples) {
        int newDistance = apple + a;
        appleDistances.add(newDistance);
    }

    for (int orange : oranges) {
        int newDistance = orange + b;
        orangeDistances.add(newDistance);
    }

    for (int num : appleDistances) {
        if (num >= s && num <= t) {
            appleCount++;
        }
    }

    for (int num : orangeDistances) {
        if (num >= s && num <= t) {
            orangeCount++;
        }
    }

    System.out.println(appleCount);
    System.out.println(orangeCount);
}


  public static void minMaxSum(List<Integer> arr){
    int minSum = 0;
    int maxSum = 0;

    Collections.sort(arr);

    for(int i = 0; i < arr.size() - 1; i++){
      int value = arr.get(i);
      minSum += value;
    }

    maxSum = minSum - arr.get(0) + arr.get(arr.size() - 1);

    System.out.println("The minimum sum is " + minSum + " and the maximum sum is " + maxSum);

  }



  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b){
    
    List<Integer> aliceScores = a;
    List<Integer> bobScores = b; 
    List<Integer> totals = new ArrayList<>(List.of(0, 0));

    for(int i = 0; i < a.size(); i++){
      if(aliceScores.get(i) > bobScores.get(i)){
         int value = totals.get(0);
         value ++; 
         totals.set(0, value);
      } else {
        int value = totals.get(1);
        value ++; 
        totals.set(1, value);
      }
    }

    return totals;

  }

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