package util;

import java.io.FileInputStream;
import java.io.IOException;
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

     *@���� ���������ļ���·�� �����ò��� ��ȡ��Ӧ������ֵ

     *@����  path �ļ�·����name ����ֵ

     *@����ֵ  null

     *@������  szd

     *@����ʱ��  2018/9/27

     *@�޸��˺�������Ϣ

     */
    public static String readPropertites(String path,String name){

        String names="";
         pps = new Properties();
        try {
            pps.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration enum1 = pps.propertyNames();//�õ������ļ�������
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);

            if(strKey.equals(name)){
                System.out.println(strKey + "=" + strValue);

                names=strValue;
            }


        }

        return  names;

    }

}
