//T->O(n) worst case the number of elements in the array
//S->O(n) because ur saving and using that array to solve the 
//problem.

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int counter=0;
        int[] newflowerbed=new int[flowerbed.length+2];
        System.arraycopy(flowerbed,0,newflowerbed,1,flowerbed.length);
        newflowerbed[0]=0;
        newflowerbed[newflowerbed.length-1]=0;

        for(int i=1;i<newflowerbed.length-1;i++){
            if(newflowerbed[i-1]==0 && newflowerbed[i]==0 && 
            newflowerbed[i+1]==0){
                newflowerbed[i]=1;
                counter+=1;
            }

        }
        return n<=counter;
    }
}

//Alternate
// O(n) TC because of the loop through the entire array
//O(1) no extra space needed we are doing it as we go
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // over here the 
        // 1s will act as the checkpoints to check
        // whether a flower can be placed there or not
        int empty = flowerbed[0] == 0 ? 1 : 0;
        //indicates empty==0 if flowerbed[0]==0 else 1.
        // to compensate the initial 0 if it exists at 0-index
        for (int f : flowerbed) {
            if (f == 1) { // if f == 1
                n -= (empty - 1) / 2; // int division, round toward 0.
                empty = 0; // setting it to 0 again, checkpoint kind of a thing.
            } else {
                empty++; // incrementing it as we see 0s 
            }
            // n will be decremented as we generate more than 3 0s
            // at a time.
        }
        n -= empty / 2;
        // to compensate the last indexed 0, in case if we could keep
        // a flower there or not. we are checking for only 2 

        // if we can keep more that's ok but make sure
        // they are not less.
        return n <= 0;
    }
}

