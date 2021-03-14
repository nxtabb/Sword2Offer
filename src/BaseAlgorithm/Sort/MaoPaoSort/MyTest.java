package BaseAlgorithm.Sort.MaoPaoSort;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2021/3/11 08:56
 * @Created by nxt
 */
//冒泡排序,升序， 原理：依次比较两个相邻的元素，将大的放后面，这样每次遍历就会将最大的放到最后
public class MyTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,1,7,21,45,233,2,56,8};
        int[] result = maoPaoSort(arr);
        for(int i:result){
            System.out.println(i);
        }
    }
    public static int[] maoPaoSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    nums[j] = nums[j]^nums[j+1];
                    nums[j+1] = nums[j]^nums[j+1];
                    nums[j] = nums[j]^nums[j+1];
                }
            }
        }
        return nums;
    }
}