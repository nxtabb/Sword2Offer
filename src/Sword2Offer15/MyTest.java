package Sword2Offer15;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中1的个数。例如，把9表示成二进制是 1001，
// 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
//示例 1：输入：00000000000000000000000000001011
//输出：3  解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
public class MyTest {
    public static void main(String[] args) {
        int n = 2147483647;
        int num = hammingWeight(n);
        System.out.println(num);
    }


    public static int hammingWeight(int n) {
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        while (n/2!=0){
            stack.push(n%2);
            n = n/2;
            last = n%2;

        }
        stack.push(last);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(0);
        }
        int length = 0;
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            length++;
        }
        int num = 0;
        CharSequence sequence = sb.subSequence(length, sb.length());
        System.out.println(sequence);
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i)=='1'){
                num++;
            }
        }
        return num;
    }
}
