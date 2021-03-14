package Sword2Offer03;


import java.util.HashSet;
import java.util.Set;

//找出数组中重复的数字。
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
// 但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
public class MyTest {
    public static void main(String[] args) {
        int repeatNumber = findRepeatNumber3(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
    }
    //时间优先
    //使用一个Set，如果添加失败则返回false
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            boolean add = mySet.add(nums[i]);
            if(add==false){
                return nums[i];
            }
        }
        return 0;
    }
    //时间优先算法2
    //使用一个数组，将原数组的值作为新数组的下标的值加1，如果有重复，则新数组的值一定会大于1
    public static int findRepeatNumber2(int[] nums) {
        int[] new_arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            new_arr[nums[i]]++;
            if(new_arr[nums[i]]>1){
                return nums[i];
            }
        }
        return 0;
    }
    //空间优先：
    //一个萝卜一个坑的方法
    public static int findRepeatNumber3(int[] nums){
        int temp;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }else {
                    temp = nums[i];
                    nums[i]=nums[temp];
                    nums[temp]=temp;
                }
            }
        }
        return -1;
    }

}
