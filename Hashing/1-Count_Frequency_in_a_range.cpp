//time complexity-->O(n)  due to the loop
//and SC->O(n) due to the array.
//actually u need not count the space of something which your about to return as a result.

vector<int> countFrequency(int n, int x, vector<int> &nums){
    vector<int> res(n);
    for(int i=0;i<nums.size();i++)
    {
        res[nums[i]-1]+=1;
    }
    // Write your code here.
    return res;

}