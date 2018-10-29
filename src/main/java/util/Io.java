package util;

import model.database.DatabaseDaoImp;

import java.io.*;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/27
 * @���� ���ļ����ж�ȡд�����
 */
public class Io {

    static Properties pps;
    /**
     * @���� ���������ļ���·�� �����ò��� ��ȡ��Ӧ������ֵ
     * @���� path �ļ�·����name ����ֵ
     * @����ֵ null
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public static String readPropertites(String path, String name) {

        String names = "";
        pps = new Properties();
        try {
            pps.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration enum1 = pps.propertyNames();//�õ������ļ�������

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
     * @���� ���ļ�·��path��д��txt����
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/15
     * @�޸��˺�������Ϣ
     */
    public static void writeToTxt(String path, String txt) {


        File f2 = new File(path);//src��fout.txt�ļ�

        try {

            FileWriter fw = new FileWriter(f2, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String temp;
            bw.newLine();
            bw.write(txt);
            bw.flush();//�ѻ���������д���ļ�
            bw.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * @���� ���ļ�·��path�ж�ȡ����
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/15
     * @�޸��˺�������Ϣ
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
               // System.out.println(i+"������"+text);
                i++;
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return contents;
    }


    public static void main(String args[]) {

        Io io=new Io();

        // io.writeToTxt("C:\\Users\\admin\\Desktop\\github\\HJ-master\\src\\main\\resources\\szd","sssss");
        // io.writeToTxt("C:\\Users\\admin\\Desktop\\github\\HJ-master\\src\\main\\resources\\szd","sssswws");
        // io.writeToTxt("C:\\Users\\admin\\Desktop\\github\\HJ-master\\src\\main\\resources\\szd","sssswwws");
        String xx[]=io.readFromTxt("src/main/resources/tree/tree44").split("\\$");
        DatabaseDaoImp dd=new DatabaseDaoImp();

        try {
            Connection c=dd.getConnection();
            for (int i = 1; i < 4; i++) {

                String id = xx[i].split("\\#")[1].split(" ")[1];
                String name = xx[i].split("\\#")[1].split(" ")[0];

                String sql = "insert into scott.�ֵ�_ͨ��_zbgc(zbgcnm,zbgcxh,zbgcdh,zbgcjc)values('"+id+"','"+id+"','"+id+"','"+name+"')";


                System.out.println("==" + sql);
               // dd.executeQuerys(sql.toString().trim(), c);
                System.out.println(i+"===xx==" + id + "  " + name);
            }
            dd.destroy(c);

        }catch (Exception e){
            e.printStackTrace();
        }
       // dd.destroy(c);
    }

}
