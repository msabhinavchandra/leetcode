//got tle
//checkout the optimal solution in the future
class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        StringBuilder sb=new StringBuilder();
        ArrayList<String> result=new ArrayList<>();
        int n=s.length();
        boolean[] vis=new boolean[n];
        findPerms(sb,s,result,n,vis);
        return result;
        
    }
    
    public void findPerms(StringBuilder sb,String s,ArrayList<String> result,int n,boolean[] vis){
        if(sb.length()==n){
            if(!result.contains(sb.toString())){
                result.add(sb.toString());
            }
            return;
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                vis[i]=true;
                sb.append(s.charAt(i));
                findPerms(sb,s,result,n,vis);
                sb.deleteCharAt(sb.length()-1);
                vis[i]=false;
            }
        }
        
    }
    
}