import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
    public static void main(String args[]){

        ArrayList<Point> arr=new ArrayList<>();
        arr.add(new Point(3,2,6));
        arr.add(new Point(2,1,2));
        arr.add(new Point(4,7,28));
        Collections.sort(arr);
        for(Point now:arr){
            System.out.println(now.size);
        }
        long c= Integer.MAX_VALUE;
        int d=10000;
        long a=((long)Integer.MAX_VALUE+2)*3;
        long b=Integer.MAX_VALUE+d;
        if(a>b)System.out.println(a);
        System.out.println(Math.min(3,3.14));

    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int size;

        Point(int x,int y,int size){
            this.x=x;
            this.y=y;
            this.size=size;
        }


        @Override
        public int compareTo(Point o) {
            return o.size-this.size;
        }
    }
}
