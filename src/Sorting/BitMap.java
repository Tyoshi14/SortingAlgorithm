package Sorting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class BitMap {

	 private int[] bits = null;  
	 private int length;  
	    //用于设置或者提取int类型的数据的某一位(bit)的值时使用  
	    private final static int[] bitValue = {  
	        0x80000000,//10000000 00000000 00000000 00000000        
	        0x40000000,//01000000 00000000 00000000 00000000        
	        0x20000000,//00100000 00000000 00000000 00000000        
	        0x10000000,//00010000 00000000 00000000 00000000        
	        0x08000000,//00001000 00000000 00000000 00000000        
	        0x04000000,//00000100 00000000 00000000 00000000        
	        0x02000000,//00000010 00000000 00000000 00000000        
	        0x01000000,//00000001 00000000 00000000 00000000        
	        0x00800000,//00000000 10000000 00000000 00000000        
	        0x00400000,//00000000 01000000 00000000 00000000        
	        0x00200000,//00000000 00100000 00000000 00000000        
	        0x00100000,//00000000 00010000 00000000 00000000        
	        0x00080000,//00000000 00001000 00000000 00000000        
	        0x00040000,//00000000 00000100 00000000 00000000        
	        0x00020000,//00000000 00000010 00000000 00000000        
	        0x00010000,//00000000 00000001 00000000 00000000            
	        0x00008000,//00000000 00000000 10000000 00000000        
	        0x00004000,//00000000 00000000 01000000 00000000        
	        0x00002000,//00000000 00000000 00100000 00000000        
	        0x00001000,//00000000 00000000 00010000 00000000        
	        0x00000800,//00000000 00000000 00001000 00000000        
	        0x00000400,//00000000 00000000 00000100 00000000        
	        0x00000200,//00000000 00000000 00000010 00000000        
	        0x00000100,//00000000 00000000 00000001 00000000        
	        0x00000080,//00000000 00000000 00000000 10000000        
	        0x00000040,//00000000 00000000 00000000 01000000        
	        0x00000020,//00000000 00000000 00000000 00100000        
	        0x00000010,//00000000 00000000 00000000 00010000        
	        0x00000008,//00000000 00000000 00000000 00001000        
	        0x00000004,//00000000 00000000 00000000 00000100        
	        0x00000002,//00000000 00000000 00000000 00000010        
	        0x00000001 //00000000 00000000 00000000 00000001              
	    };  
	    public BitMap(int length) {  
	        if(length < 0){  
	            throw new IllegalArgumentException("length必须大于零！");  
	        }  
	        bits = new int[length / 32 + (length % 32 > 0 ? 1 : 0)];  
	        this.length = length;  
	    }  
	    //取index位的值  
	    public int getBit(int index){  
	        if(index <0 || index > length){  
	            throw new IllegalArgumentException("length必须大于零小于" + length);  
	        }  
	        int intData = bits[index/32];  
	        return (intData & bitValue[index%32]) >>> (32 - index%32 -1);  
	    }  
	    //设置index位的值，只能为0或者1  
	    public void setBit(int index,int value){  
	        if(index <0 || index > length){  
	            throw new IllegalArgumentException("length必须大于零小于" + length);  
	        }         
	        if(value!=1&&value!=0){  
	            throw new IllegalArgumentException("value必须为0或者1");  
	        }  
	        int intData = bits[index/32];  
	        if(value == 1){  
	            bits[index/32] = intData | bitValue[index%32];  
	        }else{  
	            bits[index/32] = intData & ~bitValue[index%32];  
	        }  
	    }  
	    public int getLength(){  
	        return length;  
	    }   
	    
	    public void bitmap(){
	    	BitMap bitArray = new BitMap(100000000);   
	    	String phoneNum;
	    	//顺序读取所有的手机号码  
	    	try {
	    		BufferedReader bufferedReader=new  BufferedReader(new FileReader("FilePath")); 
				while((phoneNum = bufferedReader.readLine())!=null){  
				    phoneNum = phoneNum.trim().substring(3);//13573228432  
				    //取139后8位转换为int类型  
				    int phoneNumAsInt = Integer.valueOf(phoneNum);  
				    //设置对应bit值为1  
				    bitArray.setBit(phoneNumAsInt, 1);  
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
	    	//遍历bit数组输出所有存在的号码  
//	    	for(int i = 0;i<sortUnit;i++){  
//	    	    if(bitArray.getBit(i)==1){  
//	    	            writer.write("139" + leftPad(String.valueOf(i + sortUnit*times), 8));  
//	    	            writer.newLine();                         
//	    	    }                 
//	    	}  
//	    	writer.flush();  
	    }
}
