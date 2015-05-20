package Sorting;

public class HeapSort<E extends Comparable<? super E>>  {

	  public long headSort(E[] sortArray)  
	    {  
		  	long startTime=System.nanoTime();  
	        for(int i=0;i<sortArray.length-1;i++)  
	        {  
	           buildMaxHeap(sortArray,sortArray.length-1-i);  
	           swap(sortArray,0,sortArray.length-1-i);  
	        }  
//	        return sortArray;  
	        long endTime=System.nanoTime();  
	        return endTime-startTime;
	    }  
	    //交换两个数据的方法  
	    public void swap(E[] data,int i,int j)  
	    {  
	        E temp = data[i];  
	        data[i] = data[j];  
	        data[j] = temp;  
	    }  
	    //建立大顶堆  
	    public void buildMaxHeap(E[] data,int lastIndex)  
	    {  
	        //从lastIndex节点的父节点开始舰堆  
	        for(int i=(lastIndex-1)/2;i>=0;i--)  
	        {  
	            //保存正在判断的节点  
	            int k = i;  
	            //这里为每个节点建立大顶堆,只要这个根节点还有子节点  
	            while((2*k+1) <= lastIndex)  
	            {  
	                //假设左节点的值时最大的  
	                int biggerIndex = 2*k+1;  
	                //说明还有右节点是存在的  
	                if(biggerIndex < lastIndex)  
	                {  
	                    //选出子节点中最大的值   data[biggerIndex] < data[biggerIndex+1]
	                    if(data[biggerIndex].compareTo(data[biggerIndex+1])<0)  
	                    {  
	                        biggerIndex++;  
	                    }  
	                }  
	                //将跟节点与子节点进行比较  data[k] < data[biggerIndex]
	                if(data[k].compareTo(data[biggerIndex])<0)  
	                {  
	                    swap(data,k,biggerIndex);  
	                    k = biggerIndex;  
	                }else  
	                {  
	                    break;  
	                }  
	            }  
	        }
	    }
}
