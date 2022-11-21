public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int top, bottom;
        int temp;
        
        int left = 0;
        int right = matrix.length - 1;
        
        while(left < right){
            for(int i = 0; i < right - left; i++){
                top = left;
                bottom = right;
                
                // top left element => [0][0]
                temp = matrix[top][left + i];
                
                // move bottom left [matrix.length - 1][0] to top left [0][0]
                matrix[top][left + i] = matrix[bottom - i][left];
                
                // move bottom right [matrix.length - 1][matrix.length - 1] to bottom left [matrix.length - 1][0]
                matrix[bottom - i][left] = matrix[bottom][right - i];
                
                // move top right [0][matrix.length - 1] to bottom right [matrix.length - 1][matrix.length - 1]
                matrix[bottom][right - i] = matrix[top + i][right];
                
                //move top left to top right
                matrix[top + i][right] = temp;
            }
            
            right -= 1;
            left += 1;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
                
        RotateMatrix  test = new RotateMatrix();
        test.rotate(matrix);
        
        System.out.println();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}