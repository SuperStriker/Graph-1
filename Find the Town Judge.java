TC: O(n)
SC: O(n)

Runtime: 3 ms, faster than 94.64% of Java online submissions for Find the Town Judge.
Memory Usage: 57.5 MB, less than 100.00% of Java online submissions for Find the Town Judge.

Approach: Keep track of the number of dependencies for each node from others and also whether each node is depending on others. For the one 
node which donot depend on others, we will check whether it has N-1 dependencies.If yes return the node number, else return -1.

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length ==0) return N==1?1:-1;
        boolean [] T = new boolean[N];
        int[] trusts_count_array = new int[N];
        
        for(int i=0; i< trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            
            T[a-1]=true;
            trusts_count_array[b-1]++;
        }
        for(int i=0; i<N; i++){
            if(T[i] == false){
                if(trusts_count_array[i] == N-1)
                    return i+1;
            }
        }
                    return -1;
    }
}
