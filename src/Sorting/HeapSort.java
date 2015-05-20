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
	    //�����������ݵķ���  
	    public void swap(E[] data,int i,int j)  
	    {  
	        E temp = data[i];  
	        data[i] = data[j];  
	        data[j] = temp;  
	    }  
	    //�����󶥶�  
	    public void buildMaxHeap(E[] data,int lastIndex)  
	    {  
	        //��lastIndex�ڵ�ĸ��ڵ㿪ʼ����  
	        for(int i=(lastIndex-1)/2;i>=0;i--)  
	        {  
	            //���������жϵĽڵ�  
	            int k = i;  
	            //����Ϊÿ���ڵ㽨���󶥶�,ֻҪ������ڵ㻹���ӽڵ�  
	            while((2*k+1) <= lastIndex)  
	            {  
	                //������ڵ��ֵʱ����  
	                int biggerIndex = 2*k+1;  
	                //˵�������ҽڵ��Ǵ��ڵ�  
	                if(biggerIndex < lastIndex)  
	                {  
	                    //ѡ���ӽڵ�������ֵ   data[biggerIndex] < data[biggerIndex+1]
	                    if(data[biggerIndex].compareTo(data[biggerIndex+1])<0)  
	                    {  
	                        biggerIndex++;  
	                    }  
	                }  
	                //�����ڵ����ӽڵ���бȽ�  data[k] < data[biggerIndex]
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
