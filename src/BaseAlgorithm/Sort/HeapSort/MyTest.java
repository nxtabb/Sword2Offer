package BaseAlgorithm.Sort.HeapSort;

import java.util.Arrays;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2021/3/19 10:48
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,6,7,2,6,6,2,6,8,3,5,8,9,3,3};
        heapSort(array,array.length);
        System.out.println(Arrays.toString(array));

    }
    public static void heapSort(int[] array,int currentLength){
        for(int i = (currentLength-2)/2;i>=0;i--){
            repairHeap(array,currentLength,i);
        }

        for(int i = currentLength-1;i>0;i--){
            swap(array,i,0);
            repairHeap(array,i,0);
        }

    }
    public static void repairHeap(int[] array,int currentLength,int index){
        int largest = index;
        int lChild = index*2+1;
        int rChild = index*2+2;
        if(lChild<currentLength&&array[lChild]>array[largest]){
            largest = lChild;
        }
        if(rChild<currentLength&&array[rChild]>array[largest]){
            largest = rChild;
        }
        if(largest!=index){
            swap(array,largest,index);
            repairHeap(array,currentLength,largest);
        }

    }
    public static void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
