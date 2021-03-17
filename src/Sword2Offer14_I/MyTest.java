package Sword2Offer14_I;
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
// 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

//思路：使用动态规划的思想，首先设定一个数组名为dp，将长度<=n的绳子的所有最大乘积假定放入其中，
//当长度为n时，假设剪了一段绳子，长度为i，那么如果后续不进行任何操作，那么结果为 i*（n-i），如果后续还要进行操作，那么最大结果只
// 能为i*（dp[n-i]）
//求这两个的最大值即可

public class MyTest {
    public static void main(String[] args) {
        int n =10;
        int result = cuttingRope(n);
        System.out.println(result);
    }
    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*(dp[i-j])));
            }
        }
        return dp[n];
    }
}
