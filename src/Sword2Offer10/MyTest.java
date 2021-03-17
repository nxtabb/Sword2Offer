package Sword2Offer10;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：F(0) = 0,F(1)= 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
/**
 * @Classname Sword2Offer14_I.MyTest
 * @Description TODO
 * @Date 2021/3/13 10:38
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int fib = Solution.fib(50);
        System.out.println(fib);
    }

    static class Solution {
        public static int fib(int n) {
            if(n==0){
                return 0;
            }
            int a = 0;
            int b = 1;
            int c ;
            for(int i=2;i<=n;i++){
                c = b;
                b = (a + b)%((int)(Math.pow(10,9)+7));
                a = c;
            }
            return b;
        }
    }
}



