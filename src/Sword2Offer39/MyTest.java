package Sword2Offer39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为
// target的组合。
//candidates中的数字可以无限制重复被选取。
//说明：所有数字（包括target）都是正整数。
//解集不能包含重复的组合。示例1：输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[[7],[2,2,3]]
public class MyTest {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //创建一个List用于存放结果
        List<List<Integer>> resultList = new LinkedList<>();
        //创建一个暂时存储的List
        List<Integer> tempResult = new LinkedList<>();
        //进行深度优先搜索
        dfs(candidates,target,resultList,tempResult,0);
        return resultList;

    }

    private void dfs(int[] candidates, int target, List<List<Integer>> resultList, List<Integer> tempResult, int index) {
        //如果当前指针超过了候选集，就直接终止
        if(index>=candidates.length){
            return;
        }
        //如果成功了，就将暂存的list复制到result中，并终止
        if(target==0){
            resultList.add(new ArrayList<>(tempResult));
            return;
        }
        //直接跳过当前的数
        dfs(candidates, target, resultList, tempResult, index+1);
        //选择当前的数的情况
        if(target-candidates[index]>=0){
            //破坏现场
            tempResult.add(candidates[index]);
            //进行深度优先搜索，因为可重复，所以index不变
            dfs(candidates,target-candidates[index],resultList,tempResult,index);
            //还原现场
            tempResult.remove(tempResult.size()-1);
        }




    }


}
