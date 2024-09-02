//For any unique things take into a set and convert it into a 
//list .. then you optimize.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //your code goes here
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subseq=new ArrayList<>();
        func(0,nums,subseq,result);
        return result;

    }

    public static void func(int index,int[] arr,List<Integer> subseq,List<List<Integer>> result){
        //Base condition
        if(index==arr.length){
            result.add(new ArrayList<Integer>(subseq));
            return;
        }
        //pick
        subseq.add(arr[index]);
        //check
        func(index+1,arr,subseq,result);
        //not pick
        subseq.remove(subseq.size()-1);//backtracking
        //making sure we don't perform duplicate recursion calls
        for(int j=index+1;j<=arr.length;j++){
            if(j==arr.length||arr[j]!=arr[index]){
                func(j,arr,subseq,result);
                break;
            }
        }
    }
}