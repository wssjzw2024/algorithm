package com.liu.algorithm.array.project01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 */
public class SpiralOrder002 {

    /**
     * 模拟
     * 思路 模拟螺旋矩阵的路径
     *  初始在左上角，初始方向是向右，当路径超出界限或之间访问过的
     *  顺时针，进入下一个方向
     * 步骤
     * 1.初始list<Integer> 接受数据
     * 2.获取矩阵的行m，列n
     * 3.新建visited矩阵
     * 4.新建顺时针数组
     * 5.初始化total
     * 6.初始row col
     * 7.循环
     * 8.将matrix[row][col]加入数组
     * 9.visites[row][col] = true;
     * 10.nextRow = row + directions[direcitionIndex][0];
     *    nextCol = col + directions[0][direcitionIndex];
     * 判断 nextRow、nextCol是否过界，visited[nextRow][nextCol]是否true
     * 11. row col移动
     * 12.返回result
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        int total = m * n;
        int row = 0,col = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return result;
    }

    /**
     * 按层模拟
     * 思路
     *  可以将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层的元素。
     * 步骤
     * 1.初始list<Integer> 接受数据
     * 2.获取矩阵的行row，列col
     * 3.初始化 left = 0，right = col - 1，top = 0,bottom = row - 1
     * 4.当left <= right , top <= bottom
     * 5.从左到右遍历上侧元素，依次为 (top,left)到 (top,right)。
     * 6.从上到下遍历右则元素，依次为(top + 1，right)到(bottom,right)
     * 7.如果 left<right 且 top<bottom则从右到左遍历下侧元素，依次为 (bottom,right−1)到 (bottom,left+1)，
     * 以及从下到上遍历左侧元素，依次为 (bottom,left)到 (top+1,left)。
     * 8.遍历完当前层的元素之后，将 left 和 top 分别增加 1，将 right和 bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder1(int[][] matrix){
        List<Integer> order = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return order;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0,right = cols - 1,top = 0,bottom = rows - 1;
        while (left <= right && top <= bottom){
            for (int i = left; i < right; i++) {
                order.add(matrix[left][i]);
            }
            for (int i = top + 1; i < bottom; i++) {
                order.add(matrix[i][bottom]);
            }
            if(left < right && top < bottom){
                for (int i = right - 1; i > left ; i--) {
                    order.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top ; i--) {
                    order.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
