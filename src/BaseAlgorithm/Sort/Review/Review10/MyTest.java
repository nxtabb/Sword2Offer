package BaseAlgorithm.Sort.Review.Review10;

import java.util.Arrays;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2021/4/6 09:02
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        bubbleSort(array);
        System.out.println("冒泡排序："+ Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        selectSort(array);
        System.out.println("选择排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        insertSort(array);
        System.out.println("插入排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        shellSort(array);
        System.out.println("希尔排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        quickSort(array,0,array.length-1);
        System.out.println("快速排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        int[] temp = new int[array.length];
        mergeSort(array,temp,0,array.length-1);
        System.out.println("归并排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        heapSort(array,array.length);
        System.out.println("大堆排序："+Arrays.toString(array));

        array = new int[]{3,1,6,4,3,87,224,13,7,4,245,13,854};
        radixSort(array);
        System.out.println("基数排序："+Arrays.toString(array));

        int index = binarySearch(array, -1);
        System.out.println(index);
    }

    public static void swap(int[] array,int index1,int index2){
        array[index1] = array[index1]^array[index2];
        array[index2] = array[index1]^array[index2];
        array[index1] = array[index1]^array[index2];
    }

    public static int getMaxRadix(int[] array){
        int largest = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]>array[largest]){
                largest = i;
            }
        }
        return String.valueOf(array[largest]).length();
    }

    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }

    public static void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int index = i;
            for(int j=i+1;j<array.length;j++){
                if(array[index]>array[j]){
                    index = j;
                }
            }
            if(index!=i){
                swap(array,i,index);
            }
        }
    }

    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
            }
        }
    }

    public static void shellSort(int[] array){
        int n = array.length/2;
        while (n>=1){
            for(int i=n;i<array.length;i+=n){
                for(int j=i;j>0;j-=n){
                    if(array[j]<array[j-n]){
                        swap(array,j,j-n);
                    }
                }
            }
            n= n/2;
        }
    }

    public static void quickSort(int[] array,int begin,int end){
        if(begin>=end){
            return;
        }
        int leftIndex = begin;
        int rightIndex = end;
        int temp = array[begin];
        while (leftIndex<rightIndex){
            while (leftIndex<rightIndex&&temp<array[rightIndex]){
                rightIndex--;
            }
            if(leftIndex<rightIndex){
                array[leftIndex]=array[rightIndex];
                leftIndex++;
            }
            while (leftIndex<rightIndex&&array[leftIndex]<temp){
                leftIndex++;
            }
            if(leftIndex<rightIndex){
                array[rightIndex] = array[leftIndex];
                rightIndex--;
            }
            array[leftIndex] = temp;
            quickSort(array,begin,leftIndex-1);
            quickSort(array,leftIndex+1,end);
        }

    }

    public static void mergeSort(int[] array,int[] temp,int begin,int end){
        if(begin>=end){
            return;
        }
        int mid = begin+(end-begin)/2;
        mergeSort(array,temp,begin,mid);
        mergeSort(array,temp,mid+1,end);
        merge(array,temp,begin,mid,end);
    }
    public static void merge(int[] array,int[] temp,int begin,int mid,int end){
        int leftIndex = begin;
        int rightIndex = mid+1;
        int index = 0;
        while (leftIndex<=mid&&rightIndex<=end){
            if(array[leftIndex]<=array[rightIndex]){
                temp[index++] = array[leftIndex++];
            }else {
                temp[index++] = array[rightIndex++];
            }
        }
        while (leftIndex<=mid){
            temp[index++] = array[leftIndex++];
        }
        while (rightIndex<=end){
            temp[index++] = array[rightIndex++];
        }
        index = 0;
        for(int i=begin;i<=end;i++){
            array[i] = temp[index++];
        }
    }

    public static void heapSort(int[] array,int currentLength){
        int init = (currentLength-1-1)/2;
        for(int i=init;i>=0;i--){
            repairHeap(array,currentLength,i);
        }
        for(int i=currentLength-1;i>0;i--){
            swap(array,i,0);
            repairHeap(array,--currentLength,0);
        }
    }
    public static void repairHeap(int[] array,int currentLength,int index){
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        int largest = index;
        if(leftChild<=currentLength-1&&array[leftChild]>array[largest]){
            largest = leftChild;
        }
        if(rightChild<=currentLength-1&&array[rightChild]>array[largest]){
            largest = rightChild;
        }
        if(largest!=index){
            swap(array,largest,index);
            repairHeap(array,currentLength,largest);
        }
    }

    public static void radixSort(int[] array){
        int maxRadix = getMaxRadix(array);
        int[][] bucket = new int[10][array.length];
        int[] bucketNums = new int[10];
        for(int i=1;i<=maxRadix;i++){
            for(int j=0;j<array.length;j++){
                int radix = array[j]/(int)Math.pow(10,i-1)%10;
                bucket[radix][bucketNums[radix]] = array[j];
                bucketNums[radix]++;
            }
            int index = 0;
            for(int m=0;m<bucketNums.length;m++){
                if(bucketNums[m]!=0){
                    for(int n=0;n<bucketNums[m];n++){
                        array[index++] = bucket[m][n];
                    }
                    bucketNums[m] = 0;
                }
            }
        }
    }

    public static int binarySearch(int[] array,int val){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(array[mid] == val){
                return mid;
            }else if(array[mid]<val){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
