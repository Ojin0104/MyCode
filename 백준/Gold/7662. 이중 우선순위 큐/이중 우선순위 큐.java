import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Integer> minpq=new PriorityQueue<>();
            PriorityQueue<Integer> maxpq=new PriorityQueue<>(((o1, o2) ->o2.compareTo(o1)));
            PriorityQueue<Integer> removemax=new PriorityQueue<>();
            PriorityQueue<Integer> removemin=new PriorityQueue<>(((o1, o2) ->o2.compareTo(o1)));
            for(int j=0;j<N;j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String query=stringTokenizer.nextToken();
                if(query.equals("I")){
                    int num=Integer.parseInt(stringTokenizer.nextToken());
                    minpq.add(num);
                    maxpq.add(num);
                 //   System.out.println(num);
                }else {
                    int num=Integer.parseInt(stringTokenizer.nextToken());
                    if(num==1){

                            if(!maxpq.isEmpty()&&!removemin.isEmpty()) {
                                while (maxpq.peek().equals(removemin.peek())) {

                                    removemin.poll();
                                    maxpq.poll();
                                    if(maxpq.isEmpty()||removemin.isEmpty()) break;
                                }
                            }

                        if(!maxpq.isEmpty()) {
                            removemax.add(maxpq.poll());
                        }
                    }else{

                            if(!minpq.isEmpty()&&!removemax.isEmpty()) {
                                while (minpq.peek().equals(removemax.peek())) {
                                    removemax.poll();
                                    minpq.poll();
                                    if(minpq.isEmpty()||removemax.isEmpty()) {
                                        break;
                                    }
                                }
                            }

                        if(!minpq.isEmpty()) {
                            removemin.add(minpq.poll());
                        }
                    }
                }
            }


                if(!minpq.isEmpty()&&!removemax.isEmpty()) {
                    while (minpq.peek().equals(removemax.peek())) {
                        removemax.poll();
                        minpq.poll();
                        if (minpq.isEmpty() || removemax.isEmpty()) {
                            break;
                        }
                    }
                }


                    if(!maxpq.isEmpty()&&!removemin.isEmpty()) {
                        while (maxpq.peek().equals(removemin.peek())) {

                            removemin.poll();
                            maxpq.poll();
                            if(maxpq.isEmpty()||removemin.isEmpty()) break;
                        }
                    }

           // System.out.println(maxpq.size()+" "+removemin.size());
            if(maxpq.size()==0){
                stringBuilder.append("EMPTY\n");
            }else{
                stringBuilder.append(maxpq.poll()+" "+minpq.poll()+"\n");
            }

        }
        System.out.println(stringBuilder);
    }
}
