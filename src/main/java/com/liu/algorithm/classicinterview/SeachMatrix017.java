package com.liu.algorithm.classicinterview;

/**
 * @author liu
 */
public class SeachMatrix017 {

    public boolean searchMatrix(int[][] matrix,int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0,y = n - 1;
        while (x < m && y >= 0){
            if(matrix[x][y] == target){
                return true;
            }
            if(matrix[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
