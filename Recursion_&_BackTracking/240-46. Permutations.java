class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        boolean[] vis=new boolean[n];
        findPermutations(curr,result,n,vis,nums);
        return result;

    }

    public void findPermutations(List<Integer> curr,List<List<Integer>> result,int n,boolean[] vis,int[] nums){
        if(curr.size()==n){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                vis[i]=true;
                curr.add(nums[i]);
                findPermutations(curr,result,n,vis,nums);
                vis[i]=false;
                curr.remove(curr.size()-1);
            }
        }

    }
    /*Algorithm 
    to be precise this algorithm is more or less similar to the campus biks solutions
    where we find all the permutations with the help of bitmasking, more or less like 
    travelling salesman problem too.
    1-> try with all the numbers as the starting element
    2-> and mark it visited
    3-> now check out for all the different possibilities, with the fact that the current is
    already marked
    4-> before trying for any possibility check wheather that can be picked or not
    if it is not visited then pick it, if it is visited then don't pick try for other 
    possibilities 
    5-> if the curr size is equal to the nums then add the curr to the result and return.
    */
}