package util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/27
 * @描述 对文件进行读取写入操作
 */
public class Io {

    static Properties pps;

    /**
     * @描述 根据配置文件的路径 和配置参数 读取相应的配置值
     * @参数 path 文件路径，name 参数值
     * @返回值 null
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */
    public static String readPropertites(String path, String name) {

        String names = "";
        pps = new Properties();

        try {
            pps.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration enum1 = pps.propertyNames();//得到配置文件的名字

        while (enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);

            if (strKey.equals(name)) {


                names = strValue;

            }


        }


        return names;


    }


    /**
     * @描述 向文件路径path中写入txt内容
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/15
     * @修改人和其它信息
     */
    public static void writeToTxt(String path, String txt) {


        File f2 = new File(path);//src下fout.txt文件

        try {

            FileWriter fw = new FileWriter(f2, true);


            BufferedWriter bw = new BufferedWriter(fw);

            String temp;

            bw.newLine();
            bw.write(txt);

            bw.flush();//把缓冲区内容写到文件

            bw.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * @描述 从文件路径path中读取内容
     * @参数
     * @返回值
     * @创建人 szd
     * @创建时间 2018/10/15
     * @修改人和其它信息
     */
    public static String readFromTxt(String path) {

        int i=0;
        File file = new File(path);
        String contents = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                contents += text + "$";
               // System.out.println(i+"　　　"+text);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return contents;
    }


    public static void main(String args[]) {


        Io io=new Io();

    }

}
