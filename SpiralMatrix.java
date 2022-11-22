import java.util.*;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    int top = 0;
    int left = 0;
    int bottom = matrix.length;
    int right = matrix[0].length;
    List<Integer> matrixOutput = new LinkedList<Integer> ();

    while(left < right && top < bottom) {
      // every element of the top row
      System.out.print("Top loop: ");
      for(int col = left; col < right; col++){
        matrixOutput.add(matrix[top][col]);
        System.out.print(matrix[top][col]);
      }
      System.out.println();
      top += 1;

      // every element in the right col
      System.out.print("Right col loop: ");
      for(int row = top; row < bottom; row++){
        matrixOutput.add(matrix[row][right - 1]);
        System.out.print(matrix[row][right - 1]);
      }
      System.out.println();
      right -= 1;

      // boundaries crossed
      if(left >= right || top >= bottom){
        break;
      }

      // every element in the bottom row
      System.out.print("Bottom loop: ");
      for(int col = right - 1; col > left - 1; col--){
        matrixOutput.add(matrix[bottom - 1][col]);
        System.out.print(matrix[bottom - 1][col] + " ");
      }
      System.out.println();
      bottom -= 1;


      // every element in the left col going up
      System.out.print("Left col loop: ");
      for(int i = bottom - 1 ; i > top - 1; i--){
        matrixOutput.add(matrix[i][left]);
        System.out.print(matrix[i][left]);
      }
      System.out.println();
      left += 1;
    }

    System.out.println(matrixOutput);
    return matrixOutput;
  }
  
  public static void main(String[] args) {
    // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    // int[][] matrix = {{3,4},{5,6,},{9,10}};
    // int[][] matrix = {{3},{6},{9}};
    int[][] matrix = {{3},{2}};

    // System.out.println("Expected: ");
    // System.out.println("1 2 3 4 8 12 11 10 9 5 6 7");

    SpiralMatrix  test = new SpiralMatrix();
    List<Integer> matrixOutput = test.spiralOrder(matrix);
  }
}