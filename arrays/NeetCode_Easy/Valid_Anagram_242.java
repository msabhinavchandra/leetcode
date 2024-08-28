class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> cm=new HashMap<Character,Integer>();
        StringBuilder sb1=new StringBuilder(s);
        StringBuilder sb2=new StringBuilder(t);
        for(char c:s.toCharArray()){
            int n=cm.getOrDefault(c,0)+1;
            cm.put(c,n);
        }
        for(char c:t.toCharArray()){
            if(!cm.containsKey(c)) return false;
            int n=cm.get(c)-1;
            cm.put(c,n);
        }
        for(Map.Entry<Character,Integer> m:cm.entrySet()){
            if(m.getValue()!=0) return false;
        }
        return true;

    }
}

