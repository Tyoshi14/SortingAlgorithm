package Sorting;

// http://baike.baidu.com/view/178698.htm?fromtitle=%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95&fromid=1801475&type=syn
// Shell ≈≈–ÚÀ„∑®ºÚΩÈ
public class ShellSort<E extends Comparable<? super E>> {
	public long shellSort(E[] list){
		long startTime=System.nanoTime();  
		int d = list.length;
		while(true){
			   d = d / 2;
			   for(int x=0;x<d;x++){
				   for(int i=x+d;i<list.length;i=i+d){
					   E temp = list[i];
					   int j; 
					   for(j=i-d;j>=0&&list[j].compareTo(temp)>0;j=j-d){
						   list[j+d] = list[j];
					   }
					   list[j+d] = temp;
				   }
			   }
			   if(d == 1){
				   break;
		    }
	  }
		long endtTime=System.nanoTime();  
		return endtTime-startTime;
	}
}
