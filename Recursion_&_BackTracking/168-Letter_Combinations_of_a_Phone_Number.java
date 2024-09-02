 class Solution {
    public List<String> letterCombinations(String digits) {
        //your code goes here
        List<String> result=new ArrayList<>();
        String[] combination={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        func(0,"",digits,combination,result);
        return result;
    }
    public static void func(int index,String str,String digits,
    String[] combination,List<String> result){
        if(index==digits.length()){
            result.add(new String(str));
            return;
        }
        int number=digits.charAt(index)-'0';
        for(int i=0;i<combination[number].length();i++){
            func(index+1,str+combination[number].charAt(i),digits,combination,result);
        }
    }
}