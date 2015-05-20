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
        
        // ������δ����Ǽ�������Ҫ��λ�����������ݵ�ȡֵ��Χ��2^32��4.3*10^9������������ȡ10Ϊ�����������Ҫ�Ƚ�10�Ρ�
        int time = 0;  
        while (max > 0) {  
            max /= 10;  
            time++;  
        }  
        // �趨10��list��������  
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();  
        for (int j = 0; j < 10; j++) {  
            ArrayList<Integer> dataQueue = new ArrayList<Integer>();  
            queue.add(dataQueue);  
        }  
  
        // ��ʼ��������  
        for (int i = 0; i < time; i++) {  
            for (int j = 0; j < data.length; j++) {  
                // ȡ����ǰ������Ķ�Ӧλ���ϵ�һλ��  
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