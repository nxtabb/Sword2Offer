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
        //
        for(int i=0;i<arr.length-1;i++){
            int index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[index]>arr[j]){
                    index = j;
                }
            }
            if(index!=i){
                arr[i] = arr[i] ^ arr[index];
                arr[index] = arr[i] ^ arr[index];
                arr[i] = arr[i] ^ arr[index];
            }
        }
        return arr;
    }
}
