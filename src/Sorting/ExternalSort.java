package Sorting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class ExternalSort {

	public static int BUFFER_SIZE = 10;

    public File sort(File file) throws IOException {
        ArrayList<File> files = split(file);
        return process(files);
    }
    
    // recursive method to merge the lists until we are left with a
    // single merged list
    private File process(ArrayList<File> list) throws IOException {
        if (list.size() == 1) {
            return list.get(0);
        }
        ArrayList<File> inter = new ArrayList<File>();
        // ��ȡһ��merge��������ķ������γ��µ����飬���뵽�µ��ļ��б��У��ٴν�����ͬ��process������ֱ���ļ��б�ArrayList<File>ֻ��һ���ļ�Ϊֹ��
        for (Iterator<File> itr = list.iterator(); itr.hasNext();) {
            File one = itr.next();
            if (itr.hasNext()) {
                File two = itr.next();
                inter.add(merge(one, two));
            } else {
                return one;
            }
        }
        return process(inter);
    }
    
    
    /**
     * Splits the original file into a number of sub files. 
     */
    private ArrayList<File> split(File file) throws IOException {
        ArrayList<File> files = new ArrayList<File>();
        int[] buffer = new int[BUFFER_SIZE];
        FileInputStream fr = new FileInputStream(file);
        boolean fileComplete = false;
        while (!fileComplete) {
            int index = buffer.length;
            for (int i = 0; i < buffer.length && !fileComplete; i++) {
                buffer[i] = readInt(fr);
                if (buffer[i] == -1) {
                    fileComplete = true;
                    index = i;
                }
            }
            if (buffer[0] > -1) {
                Arrays.sort(buffer, 0, index);
                //Random().nextInt() function says :All 232 possible int values are produced with (approximately) equal probability. 
                // But we can not guarantee that we will not get the same number
                File f = new File("set" + new Random().nextInt());
                FileOutputStream writer = new FileOutputStream(f);
                for (int j = 0; j < index; j++) {
                    writeInt(buffer[j], writer);
                }
                writer.close();
                files.add(f);
            }

        }
        fr.close();
        return files;
    }
    
    /**
     * Merges two sorted files into a single file.
     * 
     * @param one
     * @param two
     * @return
     * @throws IOException
     */
    private File merge(File one, File two) throws IOException {
        FileInputStream fis1 = new FileInputStream(one);
        FileInputStream fis2 = new FileInputStream(two);
        File output = new File("merged" + new Random().nextInt());
        FileOutputStream os = new FileOutputStream(output);
        int a = readInt(fis1);
        int b = readInt(fis2);
        boolean finished = false;
        while (!finished) {
            if (a != -1 && b != -1) {
                if (a < b) {
                    writeInt(a, os);
                    a = readInt(fis1);
                } else {
                    writeInt(b, os);
                    b = readInt(fis2);
                }
            } else {
                finished = true;
            }

            if (a == -1 && b != -1) {
                writeInt(b, os);
                b = readInt(fis2);
            } else if (b == -1 && a != -1) {
                writeInt(a, os);
                a = readInt(fis1);
            }
        }
        os.close();
        return output;
    }

    private void writeInt(int value, FileOutputStream merged)
            throws IOException {
    	// ͨ������λ��д��һ��int���ݵ��ļ���
        merged.write(value);
        merged.write(value >> 8);
        merged.write(value >> 16);
        merged.write(value >> 24);
        merged.flush();
    }

    // FileOutputStream is meant for writing streams of raw bytes such as image data. 
    private int readInt(FileInputStream fis) throws IOException {
        int buffer = fis.read();
        if (buffer == -1) {
            return -1;
        }
        //a|=b����˼���ǰ�a��b��λ��Ȼ��ֵ��a   ��λ�����˼�����Ȱ�a��b������2���ƣ�Ȼ���û�������൱��a=a|b
        //ͨ��4�ζ�ȡ��ƴ��һ��32bit��int���ݡ�
        buffer |= (fis.read() << 8);
        buffer |= (fis.read() << 16);
        buffer |= (fis.read() << 24);
        return buffer;
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("mainset");
        Random random = new Random(System.currentTimeMillis());
        FileOutputStream fw = new FileOutputStream(file);
        for (int i = 0; i < BUFFER_SIZE * 3; i++) {
            int ger = random.nextInt();
            ger = ger < 0 ? -ger : ger;
            fw.write(ger);
            fw.write(ger >> 8);
            fw.write(ger >> 16);
            fw.write(ger >> 24);
        }
        fw.close();
        ExternalSort sort = new ExternalSort();
        System.out.println("Original:");
        dumpFile(sort, file);
        File f = sort.sort(file);
        System.out.println("Sorted:");
        dumpFile(sort, f);

    }

    private static void dumpFile(ExternalSort sort, File f)
            throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(f);
        int i = sort.readInt(fis);
        while (i != -1) {
            System.out.println(Integer.toString(i));
            i = sort.readInt(fis);
        }
    }
    
}
