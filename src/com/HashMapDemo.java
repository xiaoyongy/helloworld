package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class HashMapDemo {

    /**
     * @param args
     * @author Wentasy
     * @since 2012年4月23日17:36:53
     * 给定任意一个字符串“today is a special day”，
     * 长度为任意，要求找出其出现次数最多的字符及计算次数。
     * （可以用HashMap，HashSet，Collections实现）
     */
    public static void main(String[] args) {
        countChar();
    }

    private static void countChar(){
        Scanner scan = new Scanner(System.in);//构造输入流
        String str = "";//接受从键盘输入的字符串
        System.out.println("请输入一行字符串：");
//		str = scan.next();//注意：使用next方法如果你输入的字符串包括空格，则你将得到错误的结果
        str = scan.nextLine();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//创建HashMap对象

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);//截取第i个位置的字符
            Integer val = 1;//记录出现次数的变量
            Integer oldVal = map.put(ch, val);//把出现次数放到Map中
            //put方法返回与 key 关联的旧值；如果 key 没有任何映射关系，则返回 null。（返回 null 还可能表示该映射之前将 null 与 key 关联。）
            if (oldVal != null){
                map.put(ch, oldVal + 1);//如果不为空，将加1的旧指放到Map中
            }
        }

        System.out.println(map);//打印存放字符和出现次数的映射关系
        int max = 0;//出现次数的最大值
        Character ch1 = null;//记录出现次数最多的字符
        Set<Character> set = new HashSet<Character>();//创建Set对象
        set = map.keySet();//将Map转为Set对象
        Iterator<Character> it = set.iterator();//获得Set对象的迭代器
        while (it.hasNext()){
            Character ch = (Character)it.next();//获取元素
            Integer pos = map.get(ch);//通过Key查找Value
            //逐一比较，找出现次数最多的字符和出现次数
            if (pos > max){
                max = pos;
                ch1 = ch;
            }
        }

        //打印结果
        System.out.println("字符串" + str + "中出现最多的字符是：" + ch1 + "\n" + "出现次数为：" + max);
    }

}

