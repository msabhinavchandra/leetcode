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

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> mp1=new HashMap<Character,Integer>();
        Map<Character,Integer> mp2=new HashMap<Character,Integer>();

        for(int i=0;i<s.length();i++){
            mp1.put(s.charAt(i),mp1.getOrDefault(s.charAt(i),0)+1);
            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> a:mp1.entrySet()){
            if(!a.getValue().equals(mp2.getOrDefault(a.getKey(),0)))
                return false;
        }return true;

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ar1=s.toCharArray();
        char[] ar2=t.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return Arrays.equals(ar1,ar2);
    }
} 