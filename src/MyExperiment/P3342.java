package MyExperiment;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class P3342 {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                String[] fileName = GetFileName.getFileName("d:/Image/");
                int i = 0;
                for (String name : fileName) {
                    FileInputStream in = null;
                    FileOutputStream out = null;
                    try {
                        in = new FileInputStream("d:/Image/" + name);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try {
                        out = new FileOutputStream("d:/Image/"+name+".png");
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    int data = 0;
                    try {
                        while ((data=in.read())!=-1){
                            //将读取到的字节异或上一个数，加密输出
                            out.write(data^(0xc6));
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        pool.submit(r);
        pool.shutdown();

    }

}
class GetFileName {
    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        return fileName;
    }

}