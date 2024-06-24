class Solution {
    public int solution(int[] topping) {
        int[] chulsoo = new int[10001];
        int[] sister = new int[10001];
        
        int answer = 0;
        int sisterCount = 0;
        int chulsooCount = 1;
        
        sisterCount = initStatus(sister,topping);
        chulsoo[topping[0]]++;
        if(sisterCount == chulsooCount)answer++;
        for(int point = 1 ;point < topping.length; point++){
            
            
            //철수 토핑 더함
            
            if(chulsoo[topping[point]]==0)chulsooCount++;
            chulsoo[topping[point]]++;
            
            //동생 토핑 없앰
            if(sister[topping[point]]==1)sisterCount--;
            sister[topping[point]]--;
            
            
            if(sisterCount == chulsooCount)answer++;
        }
        
        return answer;
    }
    
    int initStatus(int[] sister, int[] topping){
        int count = 0;
        sister[topping[0]]--;
        for(int food: topping){
            if(sister[food]==0)count++;
            sister[food]++;
        }
        
        return count;
    }
}