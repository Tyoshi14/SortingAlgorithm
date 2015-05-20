package Sorting;

public class QuickSort<E extends Comparable<? super E>> {

	//快排算法实现, 排序出来的顺序为递增！！
	private int getMiddle(E[] list, int low, int high) {     
		  
	     E tmp = list[low];    //数组的第一个作为中轴   
	    while (low < high) {     
	        while (low < high && list[high].compareTo(tmp)>=0) {     
	            high--;     
	        }     
	        
	        list[low] = list[high];   //比中轴小的记录移到低端  
	        while (low < high && list[low].compareTo(tmp)<=0) {     
	            low++;     
	        }     
	        list[high] = list[low];   //比中轴大的记录移到高端
	     
	    }     
	   list[low] = tmp;              //中轴记录到尾    
	  return low;                   //返回中轴的位置     

	}    

	public long _quickSort(E[] list, int low, int high) {  
		long startTime=System.nanoTime(); 
	    if (low < high) {     
	       int middle = getMiddle(list, low, high);  //将list数组进行一分为二     
	        _quickSort(list, low, middle - 1);        //对低字表进行递归排序     
	       _quickSort(list, middle + 1, high);       //对高字表进行递归排序     
	    }     
	    long endTime=System.nanoTime(); 
	    return endTime-startTime;
	}
	

}
