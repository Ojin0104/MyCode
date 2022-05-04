import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1991트리순회 {
    static  char[] tree;
    static int N;
    public static void main(String args[]) throws IOException {
        char c=3;
System.out.println(c);
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree=new char[67108864];
        int s=1;
        tree[1]='A';
for(int j=0;j<N;j++){

        st=new StringTokenizer(br.readLine());
    if(!st.hasMoreElements())break;
        char a=st.nextToken().charAt(0);

        for(int i=1;i<tree.length;i++){


            if(tree[i]==a){


             a=st.nextToken().charAt(0);

            if (a!='.') {
                tree[2 * i] =a;

            }
            a=st.nextToken().charAt(0);
            if (a!='.') {
                tree[2 * i+1] =a;

                break;
            }}}
        }


        preorder(1);
System.out.println();
inorder(1);
System.out.println();
postorder(1);

    }
    static void preorder(int i) {
        System.out.print(tree[i]);
        if (i <= tree.length/2 ) {
            if (tree[2 * i] != '\u0000') {
                preorder(2 * i);
            }
            if (tree[2 * i + 1] != '\u0000') {
                preorder(2 * i + 1);
            }
        }
    }
    static void postorder(int i) {

        if (i <= tree.length/2 ) {
            if (tree[2 * i] != '\u0000') {
                postorder(2 * i);
            }
            if (tree[2 * i + 1] != '\u0000') {
                postorder(2 * i + 1);
            }
            System.out.print(tree[i]);
        }
    }

    static void inorder(int i) {

        if (i <= tree.length/2 ) {
            if (tree[2 * i] != '\u0000') {
                inorder(2 * i);
            }
            System.out.print(tree[i]);
            if (tree[2 * i + 1] != '\u0000') {
                inorder(2 * i + 1);
            }

        }
    }



}
