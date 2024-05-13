//time->O(n) due to the for-loop
//insertion and retrieval of elements in a Hashmap take
//constant time 
//space->O(2n) due to the hashmap
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Character> mapST=new HashMap<>();
        Map<Character,Character> mapTS=new HashMap<>();


        for(int i=0;i<s.length();i++){
            char charS=s.charAt(i);
            char charT=t.charAt(i);

            if((mapST.containsKey(charS) && mapST.get(charS)!=charT)
            || (mapTS.containsKey(charT) && mapTS.get(charT)!=charS)){
                return false;
            }
            mapTS.put(charT,charS);
            mapST.put(charS,charT);
        }
        return true;
    }
}