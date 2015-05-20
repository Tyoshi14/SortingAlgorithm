package Sorting;

// Merger Sort 因为算法里面需要一个辅助数组，大小为带排序元素的个数 int[]/double[]/E[]
//    记住： 数组必须牢记它的元素类型，也就是所有的元素对象都必须一个样，泛型类型恰恰做不到这一点。
// 思考，是不是可以通过Arraylist的方法，新建一一个对象，完成适用于泛型类型的操作呢？？
//    显然是不可以的，因为在merge() 函数里面有多种下表操作
//		tempSet[third++] = data[left++];  
//		如果利用Arraylist<E> 对于那些空的对象需要新建一个默认类型的E对象，会造成空间的浪费，默认E类也不好选择。

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
	        // 找出中间索引  
	        int center = (left + right) / 2;  
	        // 对左边数组进行递归  
	        sort(data, left, center);  
	        // 对右边数组进行递归  
	        sort(data, center + 1, right);  
	        // 合并  
	        merge(data, left, center, right);  
	    }  
	  
	    /** 
	     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序 
	     *  
	     * @param data 
	     *            数组对象 
	     * @param left 
	     *            左数组的第一个元素的索引 
	     * @param center 
	     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
	     * @param right 
	     *            右数组最后一个元素的索引 
	     */  
	  public  void merge(Integer[] data, int left, int center, int right) {  
	       
	    	int[] tempSet=new int[data.length];
	        // 右数组第一个元素索引  
	        int mid = center + 1;  
	        // third 记录临时数组的索引  
	        int third = left;  
	        // 缓存左数组第一个元素的索引  
	        int tmp = left;  
	        while (left <= center && mid <= right) {  
	            // 从两个数组中取出最小的放入临时数组  data[left] <= data[mid]
	            if (data[left] <= data[mid]) {  
	            	tempSet[third++] = data[left++];  
	            } else {  
	            	tempSet[third++] = data[mid++];  
	            }  
	        }  
	        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
	        while (mid <= right) {  
	        	tempSet[third++] = data[mid++];  
	        }  
	        while (left <= center) {  
	        	tempSet[third++] = data[left++];  
	        }  
	        // 将临时数组中的内容拷贝回原数组中  
	        // （原left-right范围的内容被复制回原数组）  
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
	        // 找出中间索引  
	        int center = (left + right) / 2;  
	        // 对左边数组进行递归  
	        sort(data, left, center);  
	        // 对右边数组进行递归  
	        sort(data, center + 1, right);  
	        // 合并  
	        merge(data, left, center, right);  
	    }  
	  
	    /** 
	     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序 
	     *  
	     * @param data 
	     *            数组对象 
	     * @param left 
	     *            左数组的第一个元素的索引 
	     * @param center 
	     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
	     * @param right 
	     *            右数组最后一个元素的索引 
	     */  
	  public  void merge(Double[] data, int left, int center, int right) {  
	       
		 	Double[] tempSet=new Double[data.length];
	        // 右数组第一个元素索引  
	        int mid = center + 1;  
	        // third 记录临时数组的索引  
	        int third = left;  
	        // 缓存左数组第一个元素的索引  
	        int tmp = left;  
	        while (left <= center && mid <= right) {  
	            // 从两个数组中取出最小的放入临时数组  data[left] <= data[mid]
	            if (data[left] <= data[mid]) {  
	            	tempSet[third++] = data[left++];  
	            } else {  
	            	tempSet[third++] = data[mid++];  
	            }  
	        }  
	        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
	        while (mid <= right) {  
	        	tempSet[third++] = data[mid++];  
	        }  
	        while (left <= center) {  
	        	tempSet[third++] = data[left++];  
	        }  
	        // 将临时数组中的内容拷贝回原数组中  
	        // （原left-right范围的内容被复制回原数组）  
	        while (tmp <= right) {  
	            data[tmp] = tempSet[tmp++];  
	        }  
	    }  

}
