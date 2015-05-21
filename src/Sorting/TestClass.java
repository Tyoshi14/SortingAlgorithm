package Sorting;

import inputAndOutput.OutputExcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;


public class TestClass {

	public static void main(String[] args) {

		HashMap<String, HashMap<Integer, ArrayList<Long>>> runningTime=
				new HashMap<String, HashMap<Integer, ArrayList<Long>>>();
		runningTime.put("QuickSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("BubbleSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("HeapSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("InsertSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("MergeSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("ShellSort", new HashMap<Integer, ArrayList<Long>>());
		runningTime.put("RadixSort", new HashMap<Integer, ArrayList<Long>>());
		
		for(int count=0;count<1;count++){
			TestInteger(10,runningTime);
		}
		//测试排序算法的正确性
		//TestSorting();
// 将获得的运行时间时间结果打印到Excel 文件
		
		
		
// 		用来打印数据 显示输出结果
		ArrayList<ArrayList<String>> outputdata=new ArrayList<ArrayList<String>> ();
		ArrayList<String> sortName=new ArrayList<String>();
		sortName.add("QuickSort");
		sortName.add("BubbleSort");
		sortName.add("HeapSort");
		sortName.add("InsertSort");
		sortName.add("MergeSort");
		sortName.add("ShellSort");
		sortName.add("RadixSort");
		
		ArrayList<String> sampleSize=new ArrayList<String>();
		sampleSize.add(" ");
		HashMap<Integer, ArrayList<Long>> quickSortItem=runningTime.get("QuickSort");
		Object[] quick_arr = quickSortItem.keySet().toArray();     
		Arrays.sort(quick_arr); 
		for (Object integer : quick_arr) {
			Integer intValue=(Integer)integer;
			sampleSize.add(String.valueOf(intValue));
		}
		outputdata.add(sampleSize);
		
		for (String  alName : sortName) {
			ArrayList<String> timeSerious=new ArrayList<String>();
			timeSerious.add(alName);
			HashMap<Integer, ArrayList<Long>> timeItem=runningTime.get(alName);
			Object[] key_arr = timeItem.keySet().toArray();     
			Arrays.sort(key_arr);  
			
			for  (Object key : key_arr) { 
				 ArrayList<Long> timeVlueList = timeItem.get(key); 
				 long totalTime=0;
				 for (Long subTime : timeVlueList) {
					totalTime+=subTime;
				 }
				 long average=totalTime/(timeVlueList.size());
				 timeSerious.add(String.valueOf(average));
			}  
			outputdata.add(timeSerious);
		}
		
		String fileName="G:\\WorkSpace\\SortingAlgorithm\\result.xls";
		new OutputExcel().outputFile(outputdata, fileName);
	}


	private static void TestSorting() {
		Integer[] numList={1,6,3,7,9,0};
		Integer[] numList2={1,6,3,7,9,0};
		Integer[] numList3={1,6,3,7,9,0};
		Integer[] numList4={1,6,3,7,9,0};
		Integer[] numList5={1,6,3,7,9,0};
		Integer[] numList6={1,6,3,7,9,0};
		int[] numList7={1,6,3,7,9,0};
		new QuickSort<Integer>()._quickSort(numList, 0, numList.length-1);
		new BubbleSort<Integer>().bubbleSort(numList2,numList2.length );
		new HeapSort<Integer>().headSort(numList3);
		new InsertSort<Integer>().insertSort(numList4);
		new MergeSort().mergeSort(numList5);
		new ShellSort<Integer>().shellSort(numList6);
		new RadixSort().radixSort(numList7);
		
		printSet("Quick",numList);
		printSet("Bubble",numList2);
		printSet("HeapSort",numList3);
		printSet("Insert",numList4);
		printSet("MergeSort",numList5);
		printSet("Shell",numList6);
		printSet("RadixSort",numList7);
	}

	private static void printSet(String string, Integer[] numList) {
		System.out.println(string);
		for (Integer integer : numList) {
			System.out.print("\t"+integer);
		}	
		System.out.println("\n");
	}
	private static void printSet(String string, int[] numList) {
		System.out.println(string);
		for (Integer integer : numList) {
			System.out.print("\t"+integer);
		}	
		System.out.println("\n");
	}

	
	private static void TestInteger(int totalTest,HashMap<String, HashMap<Integer, ArrayList<Long>>> timeRecorder) {
		
//		int numberSize=1000*r.nextInt(10);
		// 当numberSize=0 时，程序运行会出先问题。 具体原因是什么不太清楚。
//		while(numberSize==0){
//			numberSize=1000*r.nextInt(10);
//		}
//		System.out.println(numberSize);
		Random r=new Random();
		for (int j=1; j < totalTest; j++) {
			
			System.out.println("Processing "+j+"th sorting sets.......");
			int numberSize=1000*j;
			Integer[] numList=new Integer[numberSize];
			Integer[] numList2=new Integer[numberSize];
			Integer[] numList3=new Integer[numberSize];
			Integer[] numList4=new Integer[numberSize];
			Integer[] numList5=new Integer[numberSize];
			Integer[] numList6=new Integer[numberSize];
			int[] numList7=new int[numberSize];
			
			for(int i=0;i<numberSize;i++){
				int value=r.nextInt(numberSize*10);
				numList[i]=value;
				numList2[i]=value;
				numList3[i]=value;
				numList4[i]=value;
				numList5[i]=value;
				numList6[i]=value;	
				numList7[i]=value;	
			}
	// 在测试过程中，若是冒泡排序写在前面，当numberSize>6000时，会出现stackoverflow的现象
//	            快排放在前面，就不会出现这样的状况
	// 并且哪个算法的调用过程写在前面，哪个算法就会慢一点。 
	//   失败的原因  Integer[] numList2=numList; 相当于第二次使用的是排好序的序列，测试起点不同步。
//			numList2=numList 是将numList引用传递
//			Java中引用数据类型（包括数组，包括基本类型的数组）是传引用的。
			
			// 测试快速排序的时间
			long time1= new QuickSort<Integer>()._quickSort(numList, 0, numberSize-1);
		    if(!timeRecorder.get("QuickSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time1);
		    	timeRecorder.get("QuickSort").put(numberSize,list);
		    }else{
		    	 timeRecorder.get("QuickSort").get(numberSize).add(time1);
		    }
		   
		    
			// 测试冒泡排序
			long time2= new BubbleSort<Integer>().bubbleSort(numList2,numberSize );
			if(!timeRecorder.get("BubbleSort").containsKey(numberSize)){
			    	ArrayList<Long> list=new ArrayList<Long>();
			    	list.add(time2);
			    	timeRecorder.get("BubbleSort").put(numberSize,list);
			    }else{
			    	timeRecorder.get("BubbleSort").get(numberSize).add(time2);
			    }
			    
			// 测试堆排序
			long time3=new HeapSort<Integer>().headSort(numList3);
			if(!timeRecorder.get("HeapSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time3);
		    	timeRecorder.get("HeapSort").put(numberSize,list);
		    }else{
		    	timeRecorder.get("HeapSort").get(numberSize).add(time3);
		    }
			
		
		
			long time4=new InsertSort<Integer>().insertSort(numList4);
			if(!timeRecorder.get("InsertSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time4);
		    	timeRecorder.get("InsertSort").put(numberSize,list);
		    }else{
		    	timeRecorder.get("InsertSort").get(numberSize).add(time4);
		    }
			
			
			long time5=new MergeSort().mergeSort(numList5);
			if(!timeRecorder.get("MergeSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time5);
		    	timeRecorder.get("MergeSort").put(numberSize,list);
		    }else{
		    	timeRecorder.get("MergeSort").get(numberSize).add(time5);
		    }
			
			
			long time6=new ShellSort<Integer>().shellSort(numList6);
			if(!timeRecorder.get("ShellSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time6);
		    	timeRecorder.get("ShellSort").put(numberSize,list);
		    }else{
		    	timeRecorder.get("ShellSort").get(numberSize).add(time6);
		    }
			
			
			long time7=new RadixSort().radixSort(numList7);
			if(!timeRecorder.get("RadixSort").containsKey(numberSize)){
		    	ArrayList<Long> list=new ArrayList<Long>();
		    	list.add(time7);
		    	timeRecorder.get("RadixSort").put(numberSize,list);
		    }else{
		    	timeRecorder.get("RadixSort").get(numberSize).add(time7);
		    }
			

		}
		
	}

}
