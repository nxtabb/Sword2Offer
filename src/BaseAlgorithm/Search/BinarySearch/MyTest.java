package BaseAlgorithm.Search.BinarySearch;
//二分查找法
/**
 * @Classname Sword2Offer14_I.MyTest
 * @Description TODO
 * @Date 2021/3/13 13:14
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,6,7,7,8,9};
        int n = 7;
        int index = binarySearch(arr, n);
        System.out.println(index);
    }
    public static int binarySearch(int[] arr,int n){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==n){
                return mid;
            }else if(arr[mid]>n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
