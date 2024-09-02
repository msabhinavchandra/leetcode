class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here
        List<Integer> combination=new ArrayList<Integer>();
        List<List<Integer>> result=new ArrayList<>();
        helper(candidates,combination,0,target,result);
        return result;
    }
    public static void helper(int[] candidates,List<Integer> combination,
    int index,int sum,List<List<Integer>>  result){
        if(sum==0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        if(sum<0||index==candidates.length) return;
        combination.add(candidates[index]);
        helper(candidates,combination,index,sum-candidates[index],result);
        combination.remove(combination.size()-1);
        helper(candidates,combination,index+1,sum,result);
    }
}