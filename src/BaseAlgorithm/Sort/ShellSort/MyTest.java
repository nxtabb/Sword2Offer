package BaseAlgorithm.Sort.ShellSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Sword2Offer14_I.MyTest
 * @Description TODO
 * @Date 2021/3/15 11:22
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,3,45,56,7,61,5,6,7};
        int[] result = shellSort(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shellSort(int[] array){
        //一般希尔排序的增量为 array.length/2去下界
        int n = array.length/2;
        //当增量>=1时进行排序
        while (n>=1){
            //进行直接插入排序
            for(int i=n;i<array.length;i+=n){
                for(int j=i;j>0;j-=n){
                    if(array[j]<array[j-n]){
                        array[j] = array[j]^array[j-n];
                        array[j-n] = array[j]^array[j-n];
                        array[j] = array[j]^array[j-n];
                    }
                }
            }
            //减小增量
            n = n/2;
        }
        return array;
    }
}
