//brute force
// tv->O(n*n) because of the nested loops
//sc->O(n) because of the visited array which we are maintaining
//brute force

vector<int> getFrequencies(vector<int>& v) {
    // Write Your Code Here
    int n=v.size();
    vector<bool> visited(v.size(),false);
    vector<int> result;
    int maxfeq=0, minfreq=v.size();
    int maxele=0, minele=0;

    for(int i=0;i<n;i++){

        if(visited[i]==true){
            continue;
        }

        //count frequenecy
        int count=1;
        for(int j=i+1;j<n;j++)
        {
            if(v[i]==v[j])
            {
                visited[j]=true;
                count++;
            }

        }

        if(count>maxfeq){
            maxele=v[i];
            maxfeq=count;
        }

        if(count==maxfeq && v[i]<maxele){

            maxele=v[i];

            maxfeq=count;

        }
        if(count==minfreq &&  v[i]<minele){
            minele=v[i];

            minfreq=count;
        }

        if(count<minfreq){
            minele=v[i];
            minfreq=count;

        }

    }

    result.push_back(maxele);
        result.push_back(minele);

        return result;


}

//optimal approach
//using hashmap.

// optimal approach
//tc->O(n) for traversing through the array insertion and retrival of the 
//elements in a map take O(1) time 
//sc->O(n) , map takes O(n) space for n elements in an input array.
// N = size of the array. It is for the map we are using

vector<int> getFrequencies(vector<int>& v) {
    // Write Your Code Here
    unordered_map<int,int> map;
    vector<int> result;
    int n=v.size();
    for(int i=0;i<n;i++)
    {
        map[v[i]]++;
        // basically it's map[v[i]]+=1
    }
    int maxfreq=0,minfreq=n;
    int maxele=0,minele=0;

    for(auto it:map){
        int count=it.second;
        int element=it.first;       

        if(count>maxfreq){
            maxfreq=count;
            maxele=element;
        }

        if(count==maxfreq && element<maxele){
            maxele=element;
        }

         if(count==minfreq && element<minele){
            minele=element;
        }

        if(count<minfreq){
            minfreq=count;
            minele=element;
        }
    }
    result.push_back(maxele);
    result.push_back(minele);

    return result;

}