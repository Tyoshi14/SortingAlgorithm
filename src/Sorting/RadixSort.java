package Sorting;
import java.util.ArrayList;
import java.util.List;

public class RadixSort {  
	
    public long radixSort(int[] data) {  
    	long startTime=System.nanoTime();
    	
        int max = data[0];  
        for (int i = 1; i < data.length; i++) {  
            if (data[i] > max) {  
                max = data[i];  
            }  
        }  
        
        // 下面这段代码是计算所需要的位数，整形数据的取值范围是2^32（4.3*10^9），所以下面取10为基数。最多需要比较10次。
        int time = 0;  
        while (max > 0) {  
            max /= 10;  
            time++;  
        }  
        // 设定10个list保存数据  
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();  
        for (int j = 0; j < 10; j++) {  
            ArrayList<Integer> dataQueue = new ArrayList<Integer>();  
            queue.add(dataQueue);  
        }  
  
        // 开始进行排序  
        for (int i = 0; i < time; i++) {  
            for (int j = 0; j < data.length; j++) {  
                // 取到当前这个数的对应位置上的一位数  
                int x = data[j] % (int) Math.pow(10, i + 1)  
                        / (int) Math.pow(10, i);  
                ArrayList<Integer> returnQueue = queue.get(x);  
                returnQueue.add(data[j]);  
                queue.set(x, returnQueue);  
            }  
  
            int count = 0;  
            for (int k = 0; k < 10; k++) {  
                while (queue.get(k).size() > 0) {  
                    ArrayList<Integer> tempQueue = queue.get(k);  
                    data[count] = tempQueue.get(0);  
                    tempQueue.remove(0);  
                    count++;  
                }  
            }  
        }  
      //  return data;  
        long endTime=System.nanoTime();
        return endTime-startTime;
    }  
}