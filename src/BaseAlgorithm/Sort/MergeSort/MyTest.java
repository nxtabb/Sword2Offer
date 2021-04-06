package BaseAlgorithm.Sort.MergeSort;

import java.util.Arrays;

/**
 * @Classname Mytest
 * @Description TODO
 * @Date 2021/3/18 14:11
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        //待排序数组
        int[] arr = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        //创建一个备用数组
        int[] temp = new int[arr.length];
        //归并排序
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //sort
    public static void mergeSort(int[] array,int begin,int end,int[] temp) {
        //如果待排序数组小于等于1时，跳出递归
        if(begin>=end){
            return;
        }else {
            //计算中心点的下标
            int mid = begin+(end-begin)/2;
            //对左侧的数组进行排序
            mergeSort(array,begin,mid,temp);
            //对右侧的数组进行排序
            mergeSort(array,mid+1,end,temp);
            //合并
            merge(array,begin,mid,end,temp);
        }
    }
    public static void merge(int[] array,int begin,int mid,int end,int[] temp){
        //左侧序列起点在array的下标
        int leftIndex = begin;
        //右侧序列起点在array的下标
        int rightIndex = mid+1;
        //临时下标，代表临时数组的下标
        int index = 0;
        //当且仅当左侧数组的游标小于等于mid 且右侧数组的游标小于等于end
        while (leftIndex<=mid&&rightIndex<=end){
            //如果左侧数组的游标位置的值小于等于右侧数组的游标的值
            if(array[leftIndex]<=array[rightIndex]){
                //将左侧该值的放入temp中
                temp[index++] = array[leftIndex++];
            }else {
                //将右侧该值放入到temp中
                temp[index++] = array[rightIndex++];
            }
        }
        //如果左侧还剩余元素，就将其一股脑放入temp（此时右侧不可能还剩元素）
        while (leftIndex<=mid){
            temp[index++] = array[leftIndex++];
        }
        //如果右侧还剩余元素，就将其一股脑放入temp（此时左侧不可能还剩元素）
        while (rightIndex<=end){
            temp[index++] = array[rightIndex++];
        }
        //将temp的全部放入arr的局部，以 begin和end作为array的局部起点和终点
        index = 0;
        for(int i=begin;i<=end;i++){
            array[i] = temp[index++];
        }

    }
}
