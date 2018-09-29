package util;

import java.io.FileInputStream;
import java.io.IOException;
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

     *@描述 根据配置文件的路径 和配置参数 读取相应的配置值

     *@参数  path 文件路径，name 参数值

     *@返回值  null

     *@创建人  szd

     *@创建时间  2018/9/27

     *@修改人和其它信息

     */
    public static String readPropertites(String path,String name){

        String names="";
         pps = new Properties();
        try {
            pps.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
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
