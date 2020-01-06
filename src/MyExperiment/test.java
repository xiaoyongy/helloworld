package MyExperiment;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class test {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            String sourceFileUrl = "d:/Image/001_1_1_f02.dat";//文件存放目录

            String targetFileUrl = "d:/p1.png";//输出目录
            in = new FileInputStream(sourceFileUrl);
            out = new FileOutputStream(targetFileUrl);
            int data = 0;
            while ((data=in.read())!=-1){
                //将读取到的字节异或上一个数，加密输出
                out.write(data^(0xc6));//0xc6可以改
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //在finally中关闭开启的流
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
