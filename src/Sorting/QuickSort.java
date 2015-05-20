package Sorting;

public class QuickSort<E extends Comparable<? super E>> {

	//�����㷨ʵ��, ���������˳��Ϊ��������
	private int getMiddle(E[] list, int low, int high) {     
		  
	     E tmp = list[low];    //����ĵ�һ����Ϊ����   
	    while (low < high) {     
	        while (low < high && list[high].compareTo(tmp)>=0) {     
	            high--;     
	        }     
	        
	        list[low] = list[high];   //������С�ļ�¼�Ƶ��Ͷ�  
	        while (low < high && list[low].compareTo(tmp)<=0) {     
	            low++;     
	        }     
	        list[high] = list[low];   //�������ļ�¼�Ƶ��߶�
	     
	    }     
	   list[low] = tmp;              //�����¼��β    
	  return low;                   //���������λ��     

	}    

	public long _quickSort(E[] list, int low, int high) {  
		long startTime=System.nanoTime(); 
	    if (low < high) {     
	       int middle = getMiddle(list, low, high);  //��list�������һ��Ϊ��     
	        _quickSort(list, low, middle - 1);        //�Ե��ֱ���еݹ�����     
	       _quickSort(list, middle + 1, high);       //�Ը��ֱ���еݹ�����     
	    }     
	    long endTime=System.nanoTime(); 
	    return endTime-startTime;
	}
	

}
