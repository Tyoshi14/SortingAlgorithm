package dataStructure;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SkipList<Integer> list=new SkipList<Integer>();
		for(int i=0;i<100;i++){
			list.insert(i);
		}
		
		//System.out.print(list.toString());
	}
	

}
