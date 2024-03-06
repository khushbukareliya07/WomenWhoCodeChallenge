//tC: O(k*k) = k = rowIndex
//sc: O(n) //intermediate arraylist

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> result = new ArrayList<>();

        //1
        result.add(1);
        if(rowIndex < 1) return result;
        

        //1 1
        result.add(1);
        if(rowIndex == 1) return result;
        List<Integer> temp = new ArrayList<>();
        
        for(int i=2; i<=rowIndex; i++)
        {
            temp = new ArrayList<>();
            int size = result.size();
            for(int j=0; j<size; j++)
            {
                if(j==0) temp.add(result.get(j));
                if(j ==size -1){
                    temp.add(result.get(j));
                break;
                }
                int sum = result.get(j) + result.get(j+1);
                temp.add(sum);
            }
            result = new ArrayList<>(temp);
        }
        return result;
        
    }
}
