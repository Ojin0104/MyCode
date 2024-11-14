class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] check = new boolean[bank.length];

        Queue<Gene> que = new ArrayDeque<>();

        que.add(new Gene(startGene,0));

        while(!que.isEmpty()){
            Gene now = que.poll();

            int visit = now.visit;
            String gene = now.gene;
            if(gene.equals(endGene)){
                int count = 0;
                for(int idx = 0 ;idx<bank.length ;idx++){
                    if(((visit>>idx)&1)==1){
                        count++;
                    }
                }
                return count;
            }
            for(int idx = 0 ;idx<bank.length;idx++){
                if(((visit>>idx)&1) ==1){
                    continue;
                }
                if(canMutation(gene,bank[idx])){
                    que.add(new Gene(bank[idx],visit | (1<<idx)));
                    
                }
            }

        }

        return -1;
    }

    static boolean canMutation(String gene1, String gene2){
        int count = 0;
        for(int idx = 0 ;idx<8; idx++){
            if(gene1.charAt(idx)!=gene2.charAt(idx)){
                count++;
            }
        }
        if(count==1)return true;

        return false;
    }

    static class Gene{
        int visit;
        String gene;

        Gene(String gene, int visit){
            this.gene = gene;
            this.visit = visit;
        }
    }
}