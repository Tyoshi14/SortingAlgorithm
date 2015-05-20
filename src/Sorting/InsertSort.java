package Sorting;


public class InsertSort<E extends Comparable<? super E>> {

	public long insertSort(E[] array) {  
		long startTime=System.nanoTime();
        if (array == null || array.length < 2) {  
        	long endTime=System.nanoTime();  
     		return endTime-startTime;
        }  
  
        for (int i = 1; i < array.length; i++) {  
            E currentValue = array[i];  
            int position = i;  
            for (int j = i - 1; j >= 0; j--) {  
                if (array[j].compareTo(currentValue)>0) {  
                    array[j + 1] = array[j];  
                    position -= 1;  
                } else {  
                    break;  
                }  
            }  
  
            array[position] = currentValue;  
        } 
        
        long endTime=System.nanoTime();  
		return endTime-startTime;
    }  

}
