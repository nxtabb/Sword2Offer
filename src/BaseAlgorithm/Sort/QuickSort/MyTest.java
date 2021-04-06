package BaseAlgorithm.Sort.QuickSort;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
//begin 序列的的最左侧下标，序列右侧下标
    public static void quickSort(int[] array,int begin,int end){
        int left = begin;
        int right = end;
        int temp = array[begin];
        //如果刚进入方法left就>=right，则直接返回
        if(left>=right){
            return;
        }else {
            while (left<right){
                //从右开始看，如果右侧大于临界值，切left<right
                while (temp<=array[right]&&left<right){
                    //right--
                    right--;
                }
                //当右侧走完了以后，肯定是碰到右侧小于临界值的情况了，那么将right的值赋值给left，且left++
                if(left<right){
                    array[left] = array[right];
                    left++;
                }
                //开始进行左侧的遍历,如果左侧的值小于临界值
                while (temp>=array[left]&&left<right){
                    //left++
                    left++;
                }
                //碰到了临界值小于左侧值的情况
                if(left<right){
                    //将left赋值给right
                    array[right] = array[left];
                    //做完后需要right--
                    right--;
                }
            }
            //做完一个序列的完整快排，需要将临界值赋值给left
            array[left] = temp;
            //开始递归地对每个小序列进行排序
            quickSort(array,0,left-1);
            quickSort(array,left+1,end);
        }
    }
}
