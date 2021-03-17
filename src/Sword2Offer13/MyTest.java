package Sword2Offer13;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
// 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
// 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
// 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//输入：m = 2, n = 3, k = 1
//输出：3
public class MyTest {
    public static void main(String[] args){
        int result = movingCount(2, 3, 1);
        System.out.println(result);
    }
    public static int movingCount(int m, int n, int k) {
        int[][] array = new int[m][n];
        int result = 0;
        result += dfs(array,0,0,k);
        return result;
    }
    public static int getSum(int n,int m){
        int sum = 0;
        int temp = 0;
        while (n>0){
            temp = n%10;
            sum += temp;
            n = n/10;
        }
        while (m>0){
            temp = m%10;
            sum += temp;
            m = m/10;
        }
        return sum;
    }
    public static int dfs(int[][] array,int i,int j,int k){
        if(i<0||i>array.length-1||j<0||j>array[0].length-1||getSum(i,j)>k||array[i][j]==-1){
            return 0;
        }
        array[i][j]=-1;
        return dfs(array,i-1,j,k)+dfs(array,i+1,j,k)+ dfs(array,i,j-1,k)+dfs(array,i,j+1,k)+1;

    }
}
