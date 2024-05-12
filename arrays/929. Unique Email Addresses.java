class Solution {
    //SC->O(n) an array on n elements where n are the number of emails given.
    private String processLocalName(String localName){
        int plusIndex=localName.indexOf('+');//takes O(m)m->no of characters.
        //0-indexing
        String processedLocalName=plusIndex==-1?localName:localName.substring(0,plusIndex);//this is an excluding range.O(1)
        return processedLocalName.replace(".","");)//O(1)
    }

    public int numUniqueEmails(String[] emails) {
        //takes O(m*n) where n->no of emails in the array.
        Set<String> uniqueEmails=new HashSet<>();

        for(String email:emails){
            //it will split at @,and @ will be ignored naturally.
            String[] parts=email.split("@");//O(1)
            String localName=processLocalName(parts[0]);//O(m)
            String domainName=parts[1];//O(1)
            uniqueEmails.add(localName+"@"+domainName);//O(1)
        }

        return uniqueEmails.size();

    }
}

//if we want to solve this without any in built functions?
//same TC->O(n*m) n->no of strings, m->No of letters in the string.

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails=new HashSet<>();

        for(String email:emails){
            int i=0;
            String localName="";
            String domainName="";
            while(i<email.length() && email.charAt(i)!='+' && email.charAt(i)!='@'){
                if(email.charAt(i)!='.'){
                    localName+=email.charAt(i);
                }
                i++;
            }
            while(i<email.length() && email.charAt(i)!='@'){
                i++;
            }
            domainName=email.substring(i+1);
            uniqueEmails.add(localName+"@"+domainName);
        }
        return uniqueEmails.size();
    }
}

