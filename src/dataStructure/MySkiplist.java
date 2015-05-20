package dataStructure;
/**
 * 这种是能够想到的最简单的实现，但是这样耗费的内存空间比较大，不如skipList
 */
public class MySkiplist<T> {

	  final int MaxValue=6;
	  private int level=0;
	  private skipNode<T> []  list;
	  
	  public MySkiplist() {
		  list= new skipNode[MaxValue] ;
		  skipNode<T> header=new skipNode(null,null,null); 
		  for(int i=0; i< MaxValue; i++){
			  list[i]=header;
		  }
	  }
	  
     public void insert(){
    	 
     }
	
     
	
	
	
	
	
	private class skipNode<T>{
		private T value;
		private skipNode<T> next=null;
		private skipNode<T> down=null;
		
		public skipNode(T _value,skipNode<T> _next,skipNode<T> _down){
			this.value=_value;
			this.next=_next;
			this.down=_down;
		}
	}	
}

