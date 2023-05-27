class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack=[]
        # summ=0
        # req=0
        for i in operations:
            if i=='+':
                stack.append(int(stack[-1]+int(stack[-2])))

            elif i=='D':
                stack.append(2*int(stack[-1]))
            elif i=='C':
                stack.pop()
            else:
                stack.append(int(i))

    

        return sum(stack)
#alternate
class Solution:
    def calPoints(self, operations: List[str]) -> int:
        record=[]
        for i,n in enumerate(operations):
            if n=="C":
                record.pop(-1)
            elif n=="D":
                record.append(2*int(record[-1]))
            elif n=="+":
                record.append(int(record[-1])+int(record[-2]))
            else:
                record.append(int(operations[i]))
        return sum(record)
