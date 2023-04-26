import java.util.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    static int n=0;
    HashMap<String,Integer> map = new HashMap<>();
    String[][] tickets;

    int[] c;
    String[] answer = {};
    public String[] solution(String[][] tickets) {
        this.tickets=tickets;

        n=tickets.length;
        c=new int[n];

        Arrays.sort(tickets,(o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            else{
                return o1[0].compareTo(o2[0]);
            }
        });



        arr.add("ICN");
        DFS("ICN",0);

        return answer;
    }
    ArrayList<String> arr = new ArrayList<>();

    public void DFS(String cur, int level){

        if(answer.length>0) return;
        if(level==n){
            answer = new String[arr.size()];

            for(int i=0; i<arr.size(); i++)
                answer[i]=arr.get(i);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(cur) && c[i]==0){
                arr.add(tickets[i][1]);
                c[i]=1;
                DFS(tickets[i][1],level+1);
                c[i]=0;
                arr.remove(arr.lastIndexOf(tickets[i][1]));
            }
        }

    }
}