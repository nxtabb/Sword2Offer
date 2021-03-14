package Sword2Offer11;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
//例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//输入：[3,4,5,1,2]
//输出：1
//示例 2：输入：[2,2,2,0,1]
//输出：0



public class MyTest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,0,0,2};
        int result1 = minArray1(arr);
        System.out.println(result1);
    }
    //思路1：暴力解法:从数组的头开始遍历，当碰到当前下表的数大于后一个下标位置的数时，就找到了该分界点
    //特殊情况：当数组长度为0时，那么第一个元素就是分界点，但是特殊情况太多，不可行。
    //思路2：纯二分查找：二分查找需要有两个条件：1、顺序存储   2、任意确定一个值，就能知道要找的值在前面还是后面，
    //该题不满足第二个条件，因为会出现很多重复的值
    //因此最终 思路3：二分查找+暴力
    //先二分查找：如果当前mid小于right 那么 当前值或者前面的值可能是结果，那么 right = mid
    //如果当前mid 大于 right，那么结果一定在mid的后面，因此 left = mid + 1
    //如果 mid = right 那么就需要缩小范围，且不会删掉真正的唯一结果，因此，right--
    //因为数组中肯定存在结果不会出现普通二分查找结果为-1的情况，因此结束循环条件是 left>=right,因此 while(left<right)
    //时间复杂度： O(log2n《time《O（n^2）)
    public static int minArray1(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(numbers[mid]>numbers[right]){
                left = mid + 1;
            }else if(numbers[mid]<numbers[right]){
                right = mid;
            }else if(numbers[mid]==numbers[right]) {
                right--;
            }
        }
        return numbers[left];
    }
}
