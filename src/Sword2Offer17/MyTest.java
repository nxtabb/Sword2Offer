package Sword2Offer17;
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
// 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public class MyTest {
    public static void main(String[] args) {
        int[] ints = printNumbers(5);
        for (int i : ints) {
            System.out.println(i);
        }
    }
    public static int[] printNumbers(int n) {
        int length = (int)Math.pow(10,n);
        int[] result = new int[length-1];
        for(int i=0;i<result.length;i++){
            result[i] = i+1;
        }
        return result;
    }
}
