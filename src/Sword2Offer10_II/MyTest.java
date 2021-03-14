package Sword2Offer10_II;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。



//思路：考虑最后一步的情况，即 最后一步如果是两步，那么共有f(n-2)种走法，如果最后为一步那么有
//f(n-1)种走法，那么，f(n) = f(n-1)+f(n-2)， 又变成了 斐波那契数列的格式
//固定写法： c = b； b = a + b;  a = c;  其中， a 一般为f（1） ， b 为 f（2）
public class MyTest {
    public static void main(String[] args) {
        int step = 100;
        int ways = numWays(step);
        System.out.println(ways);
    }

    public static int numWays(int n) {
        if(n==0){
            return 0;
        }if(n==1){
            return 1;
        }
        int a = 1;
        int b = 2;
        //n>=3时的情况如下：

        for(int i = 3;i<=n;i++){
            int c = b;
            b = (a+b)%1000000007;
            a = c;

        }
        return b;


    }
}
