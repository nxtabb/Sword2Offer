package BaseAlgorithm.Sort.Review.Review;

import java.util.Arrays;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2021/3/23 09:31
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        selectSort(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        insertSort(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        shellSort(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        int[] temp = new int[array.length];
        mergeSort(array,temp,0,array.length-1);
        System.out.println(Arrays.toString(array));


        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        heapSort(array,array.length);
        System.out.println(Arrays.toString(array));
        array = new int[]{4,1,4,6,6,1,4,65,5,2,343,652,3431,12,12,5,35};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void swap(int[] array,int index1,int index2){
        array[index1] = array[index1]^array[index2];
        array[index2] = array[index1]^array[index2];
        array[index1] = array[index1]^array[index2];

    }

    public static int getMaxRadix(int[] array){
        int index = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]>array[index]){
                index = i;
            }
        }
        return String.valueOf(array[index]).length();
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
                if(array[j]<array[index]){
                    index = j;
                }
            }
            if(i!=index){
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
        int n = array.length;
        while (n>=1){
            for(int i=n;i<array.length;i+=n){
                for(int j=i;j>0;j-=n){
                    if(array[j]<array[j-n]){
                        swap(array,j,j-n);
                    }
                }
            }
            n = n/2;
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
            while (leftIndex<rightIndex&&array[rightIndex]>temp){
                rightIndex--;
            }
            if(leftIndex<rightIndex){
                array[leftIndex] = array[rightIndex];
                leftIndex++;
            }
            while (leftIndex<rightIndex&&array[leftIndex]<temp){
                leftIndex++;
            }
            if(leftIndex<rightIndex){
                array[rightIndex] = array[leftIndex];
                rightIndex--;
            }
        }
        array[leftIndex] = temp;
        quickSort(array,begin,leftIndex-1);
        quickSort(array,leftIndex+1,end);

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
        while (rightIndex<=end) {
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
        for(int i= currentLength-1;i>0;i--){
            swap(array,i,0);
            repairHeap(array,--currentLength,0);
        }
    }
    public static void repairHeap(int[] array,int currentLength,int index){
        int largest = index;
        int lChild = 2*largest+1;
        int rChild = 2*largest+2;
        if(lChild<currentLength-1&&array[lChild]>array[largest]){
            largest = lChild;
        }
        if(rChild<currentLength-1&&array[rChild]>array[largest]){
            largest = rChild;
        }
        if(largest!=index){
            swap(array,index,largest);
            repairHeap(array,currentLength,largest);
        }
    }

    public static void radixSort(int[] array){
        int maxRadix = getMaxRadix(array);
        int[][] bucket = new int[10][array.length];
        int[] bucketNum = new int[10];
        for(int i=1;i<=maxRadix;i++){
            for(int j=0;j<array.length;j++){
                int radix = array[j]/(int)Math.pow(10,i-1)%10;
                bucket[radix][bucketNum[radix]] = array[j];
                bucketNum[radix]++;
            }
            int index = 0;
            for(int m=0;m<bucketNum.length;m++){
                if(bucketNum[m]!=0){
                    for(int n=0;n<bucketNum[m];n++){
                        array[index++] = bucket[m][n];
                    }
                    bucketNum[m] = 0;
                }
            }
        }

    }
}
