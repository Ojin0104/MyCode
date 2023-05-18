import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String mean=bufferedReader.readLine();
        ArrayList<Character> op=new ArrayList<>();
        for(int i=0;i<mean.length();i++){
            if(!Character.isDigit(mean.charAt(i)))op.add(mean.charAt(i));
        }
        String[] mid=mean.split("\\+");
        ArrayList<String> nums=new ArrayList<>();
        for(String str:mid){
            String[] res= str.split("-");
            for(String st:res){
                nums.add(st);
            }
        }

        boolean flag=false;
        int num=Integer.parseInt(nums.get(0));
        for(int i=1;i<nums.size();i++){
            if(op.get(i-1)=='-')flag=true;
            if(flag)num-=Integer.parseInt(nums.get(i));
            else num+=Integer.parseInt(nums.get(i));
        }

    System.out.println(num);
    }
}
