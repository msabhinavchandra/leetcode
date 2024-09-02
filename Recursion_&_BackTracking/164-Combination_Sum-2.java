class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        func(candidates,combination,0,target,result);
        // List<List<Integer>> modified=new ArrayList<>(result);
        return result;
    }
    public static void func(int [] candidates,List<Integer> combination,int index,
    int sum,List<List<Integer>> result){
        if(sum==0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        if(sum < 0 || index==candidates.length) return;
        combination.add(candidates[index]);
        func(candidates,combination,index+1,sum-candidates[index],result);
        combination.remove(combination.size()-1);
        for(int j=index+1;j<candidates.length;j++){
            if(candidates[j]!=candidates[index]){
                func(candidates,combination,j,sum,result);
                break;
            }
        }

    }
}