package week15;

public class ProblemMain {
    public static void main(String args[]) {

    	MyBinTree T=new MyBinTree(23);
    	
    	T.inserLeft(T.root(),10);
    	T.inserLeft(T.root().left(),7);
    	T.inserRight(T.root().left().left(),10);
    	T.inserRight(T.root().left(),17);
    	T.inserLeft(T.root().left().right(), 13);
    	T.inserRight(T.root().left().right(), 20);
    	
    	T.inserRight(T.root(),33);
    	T.inserLeft(T.root().right(),27);
    	T.inserLeft(T.root().right().left(),25);
    	T.inserRight(T.root().right().left(),30);
    	T.inserRight(T.root().right(),33);
    	
    	MyBinTree S=new MyBinTree(33);
    	S.inserLeft(S.root(),27);
    	S.inserLeft(S.root().left(),25);
    	S.inserRight(S.root().left(),30);
    	
    	SubFinder K=new SubFinder(T,S);
    	System.out.print(K.findSub(T.root(), S.root()));
}}