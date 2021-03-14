package BaseAlgorithm.Sort.SelectSort;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2021/3/13 14:40
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        int[] result = selectSort(arr);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] selectSort(int[] arr){
        //表示需要选n-1次
        for(int i=0;i<arr.length-1;i++){
            //当前没排序的最开始的位置，假设该位置为最小值
            int index = i;
            //从假设最小的后一个位置开始遍历，如果找到比假设的值还小，那么就把当前位置的坐标赋值给假定最小坐标
            for(int j=i+1;j<arr.length;j++){
                if(arr[index]>arr[j]){
                    index = j;
                }
            }
            //如果假定坐标已经变了,那么就需要更换两个值。
            if(index!=i){
                arr[i] = arr[i] ^ arr[index];
                arr[index] = arr[i] ^ arr[index];
                arr[i] = arr[i] ^ arr[index];
            }
        }
        return arr;
    }
}
