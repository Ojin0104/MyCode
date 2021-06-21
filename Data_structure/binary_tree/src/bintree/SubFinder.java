package week15;
public class SubFinder extends MyNode {
    // proove yourself
	private MyBinTree T=new MyBinTree();
	private MyBinTree S=new MyBinTree();
	int number=0;
	SubFinder(MyBinTree t,MyBinTree s){
    MyBinTree T1=t;
    MyBinTree S1=s;
	}
	
	
	 
    int findSub(MyBinNode v,MyBinNode e) {
    	boolean k=false;
    	if(this.T.hasLeft(v)) {
            if(v.element()==e.element()) {
            k=check(v,e);
            if(k==true) {
            	System.out.print(this.number);
            }
            }else {
            findSub(this.T.left(v),e);
            number++;}
        }
                    
               
        
        if(this.T.hasRight(v)) {
        	  if(v.element()==e.element()) {
                  k=check(v,e);
        	 if(k==true) {
             	System.out.print(this.number);
             }
            findSub(this.T.right(v),e);
            number++;
            
        }}
        return number;
    }
    boolean check(MyBinNode v,MyBinNode e) {
    	
    	if(S.hasLeft(e)) {
    		if(e.left().element()==v.left().element()){
    			check(v.left(),e.left());
    			
    			return true;
    		}else {
    			number=0;
    			return false;}
    	}
    	if(S.hasRight(e)){
    		if(e.right().element()==v.right().element()){
    			check(v.left(),e.left());
    			
    			return true;
    		}else {
    			;
    			return false;}
    }else 
    	number=0;
    	return false;
    	}
   
   
}
 