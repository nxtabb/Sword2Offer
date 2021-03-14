package Sword2Offer04;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//现有矩阵 matrix 如下：
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//给定 target=5，返回true。
//给定target=20，返回false。
//思路：从左下或右上开始比较，以左下为例，如果当前值小于target，则将当前值的行减1，如果当前值大于target，则当前值的列+1。
//⚠️注意：不要忘了空数组的情况～～～ 错成🐒了
public class MyTest {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20;
        boolean result = findNumberIn2DArray(matrix, target);
        System.out.println(result);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int i=matrix.length-1;
        int j=0;
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[matrix.length-1].length-1]){
            return false;
        }else {
            while (i>=0&&j<=matrix[0].length-1){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){
                    i--;
                }else{
                    j++;
                }
            }
            return false;
        }
    }
}
