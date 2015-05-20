package Sorting;

// Merger Sort ��Ϊ�㷨������Ҫһ���������飬��СΪ������Ԫ�صĸ��� int[]/double[]/E[]
//    ��ס�� ��������μ�����Ԫ�����ͣ�Ҳ�������е�Ԫ�ض��󶼱���һ��������������ǡǡ��������һ�㡣
// ˼�����ǲ��ǿ���ͨ��Arraylist�ķ������½�һһ��������������ڷ������͵Ĳ����أ���
//    ��Ȼ�ǲ����Եģ���Ϊ��merge() ���������ж����±����
//		tempSet[third++] = data[left++];  
//		�������Arraylist<E> ������Щ�յĶ�����Ҫ�½�һ��Ĭ�����͵�E���󣬻���ɿռ���˷ѣ�Ĭ��E��Ҳ����ѡ��

public class MergeSort{
	
	  public  long mergeSort(Integer[] data) {  
		  	long startTime=System.nanoTime();
	        sort(data, 0, data.length - 1); 
	        long endTime=System.nanoTime();
	        return endTime-startTime;
	    }  
	  
	   public  void sort(Integer[] data, int left, int right) {  
	        if (left >= right)  
	            return;  
	        // �ҳ��м�����  
	        int center = (left + right) / 2;  
	        // �����������еݹ�  
	        sort(data, left, center);  
	        // ���ұ�������еݹ�  
	        sort(data, center + 1, right);  
	        // �ϲ�  
	        merge(data, left, center, right);  
	    }  
	  
	    /** 
	     * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ���� 
	     *  
	     * @param data 
	     *            ������� 
	     * @param left 
	     *            ������ĵ�һ��Ԫ�ص����� 
	     * @param center 
	     *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص����� 
	     * @param right 
	     *            ���������һ��Ԫ�ص����� 
	     */  
	  public  void merge(Integer[] data, int left, int center, int right) {  
	       
	    	int[] tempSet=new int[data.length];
	        // �������һ��Ԫ������  
	        int mid = center + 1;  
	        // third ��¼��ʱ���������  
	        int third = left;  
	        // �����������һ��Ԫ�ص�����  
	        int tmp = left;  
	        while (left <= center && mid <= right) {  
	            // ������������ȡ����С�ķ�����ʱ����  data[left] <= data[mid]
	            if (data[left] <= data[mid]) {  
	            	tempSet[third++] = data[left++];  
	            } else {  
	            	tempSet[third++] = data[mid++];  
	            }  
	        }  
	        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����  
	        while (mid <= right) {  
	        	tempSet[third++] = data[mid++];  
	        }  
	        while (left <= center) {  
	        	tempSet[third++] = data[left++];  
	        }  
	        // ����ʱ�����е����ݿ�����ԭ������  
	        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩  
	        while (tmp <= right) {  
	            data[tmp] = tempSet[tmp++];  
	        }  
	    }  



	  public  long mergeSort(Double[] data) {  
			long startTime=System.nanoTime();
	        sort(data, 0, data.length - 1); 
	    	long endTime=System.nanoTime();
	    	return endTime-startTime;
	    }  
	  
	   public  void sort(Double[] data, int left, int right) {  
	        if (left >= right)  
	            return;  
	        // �ҳ��м�����  
	        int center = (left + right) / 2;  
	        // �����������еݹ�  
	        sort(data, left, center);  
	        // ���ұ�������еݹ�  
	        sort(data, center + 1, right);  
	        // �ϲ�  
	        merge(data, left, center, right);  
	    }  
	  
	    /** 
	     * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ���� 
	     *  
	     * @param data 
	     *            ������� 
	     * @param left 
	     *            ������ĵ�һ��Ԫ�ص����� 
	     * @param center 
	     *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص����� 
	     * @param right 
	     *            ���������һ��Ԫ�ص����� 
	     */  
	  public  void merge(Double[] data, int left, int center, int right) {  
	       
		 	Double[] tempSet=new Double[data.length];
	        // �������һ��Ԫ������  
	        int mid = center + 1;  
	        // third ��¼��ʱ���������  
	        int third = left;  
	        // �����������һ��Ԫ�ص�����  
	        int tmp = left;  
	        while (left <= center && mid <= right) {  
	            // ������������ȡ����С�ķ�����ʱ����  data[left] <= data[mid]
	            if (data[left] <= data[mid]) {  
	            	tempSet[third++] = data[left++];  
	            } else {  
	            	tempSet[third++] = data[mid++];  
	            }  
	        }  
	        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����  
	        while (mid <= right) {  
	        	tempSet[third++] = data[mid++];  
	        }  
	        while (left <= center) {  
	        	tempSet[third++] = data[left++];  
	        }  
	        // ����ʱ�����е����ݿ�����ԭ������  
	        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩  
	        while (tmp <= right) {  
	            data[tmp] = tempSet[tmp++];  
	        }  
	    }  

}
