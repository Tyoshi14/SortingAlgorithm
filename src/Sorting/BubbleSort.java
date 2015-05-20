package Sorting;

public class BubbleSort<E extends Comparable<? super E>> {

//Ϊ�˻�ò���ʱ�䣬����ֱ�ӷ��ز���ʱ�䡣
	public long bubbleSort(E[] a, int n) {
			
			long startTime=System.nanoTime();  
	        for (int i = 0; i < n; i++) {
	            int flag = 0;
	            for (int j = n - 1; j > i; j--) {// i or i-1 ?
	            	//a[j] < a[j - 1]
	                if (a[j].compareTo(a[j - 1])<0) {
	                    E x = a[j];
	                    a[j] = a[j - 1];
	                    a[j - 1] = x;
	                    flag = 1;
	                }
	            }
	            if (flag == 0)
	                break;
	        }
//	        return a;
	        long endTime=System.nanoTime(); 
	        return endTime-startTime;
	    }

}
