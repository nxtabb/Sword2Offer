package BaseAlgorithm.Sort.RadixSort;

import java.util.Arrays;

public class MyTest{
    public static void main(String[] args) {
        int[] array = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void radixSort(int[] array){
        //得到数组中最大的位数 例如 100 的位数为3
        int maxRadix = getMaxRadix(array);
        //定义一个桶
        int[][] bucket = new int[10][array.length];
        //定义一个桶的计数器
        int[] bucketNum = new int[10];

        //最大位为多少那么就需要遍历多少次
        for(int i=1;i<=maxRadix;i++){
            //遍历数组
            for(int j=0;j<array.length;j++){
                //得到具体位数上的值
                int radix = array[j]/(int)Math.pow(10,i-1)%10;
                //将数组中的数一次放入桶中
                bucket[radix][bucketNum[radix]] = array[j];
                //计数器加1
                bucketNum[radix]++;
            }
            int index = 0;
            //遍历计数器
            for(int m=0;m<bucketNum.length;m++){
                //如果计数器不为0
                if(bucketNum[m]!=0){
                    //根据计数器将桶中的值一次写入array中
                    for(int n=0;n<bucketNum[m];n++){
                        array[index] = bucket[m][n];
                        index++;
                    }
                    //每一次完成排序后，需要将计数器归0
                    bucketNum[m] = 0;
                }
            }


        }
    }

    public static int getMaxRadix(int[] array){
        int largest = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]>=array[largest]){
                largest = i;
            }
        }
        return String.valueOf(array[largest]).length();

    }
}
