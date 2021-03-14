package BaseAlgorithm.Sort.InsertSort;

public class MyTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        int[] result = insertSort(arr);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] insertSort(int[] arr){
        //表示需要插n-1次，且第一次代插元素从1开始
        for(int i=1;i<arr.length;i++){
            //表示待插元素，需要和排在前面的数进行比较
            for(int j=i;j>0;j--){
                //如果当前值小于前面一个的值，那么交换
                if(arr[j-1]>arr[j]){
                    arr[j-1] = arr[j-1]^arr[j];
                    arr[j] = arr[j-1]^arr[j];
                    arr[j-1] = arr[j-1]^arr[j];
                }
            }
        }
        return arr;

    }


}
