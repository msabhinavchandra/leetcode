 
#brute_force_solution(linear_search)

def aggressiveCows(stalls:list, k:int)->int:
    new = sorted(stalls)
    def cows_possible_or_not(Lis:list,min_dis:int,no_cows=int)->bool:
        last=Lis[0]
        count_cows=1
        start=Lis[1]
        for i in range(1,len(Lis)):

            if(Lis[i]-last>=min_dis):
                count_cows+=1
                last=Lis[i]

        if(count_cows>=no_cows):
            return True
        else:
            return False

    max_of_min =1
    for i in range(1,max(stalls)-min(stalls)+1):
        # max_of_min=
        if(cows_possible_or_not(new,i,k)):
            max_of_min=max(max_of_min,i)
        else:
            return i-1

    return max_of_min

#striver_optimized_solution(binary_search)

def aggressiveCows(stalls:list, k:int)->int:
    new = sorted(stalls)
    def cows_possible_or_not(Lis:list,min_dis:int,no_cows=int)->bool:
        last=Lis[0]
        count_cows=1
        start=Lis[1]
        for i in range(1,len(Lis)):

            if(Lis[i]-last>=min_dis):
                count_cows+=1
                last=Lis[i]

        if(count_cows>=no_cows):
            return True
        else:
            return False

    low=0
    high=max(new)-min(new)
    while low<=high:
        mid=(low+high)//2
        if(cows_possible_or_not(new,mid,k)):

            low=mid+1
        else:
            high=mid-1

    return high























