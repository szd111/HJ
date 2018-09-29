import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Properties;

public class TestMains {


    private static Logger logger = Logger.getLogger(TestMains.class);

    public static void main(String[] args) throws Exception {
        // debug级别的信息
        logger.debug("This is a debug");
        // info级别的信息
        logger.info("This is a info");
        // error级别的信息
        logger.error("This is a error");

        Properties pps = new Properties();
                pps.load(new FileInputStream("src/main/resources/sql.propertites"));
                Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
                 while(enum1.hasMoreElements()) {
                         String strKey = (String) enum1.nextElement();
                         String strValue = pps.getProperty(strKey);
                         System.out.println(strKey + "=" + strValue);

                     }

    }


}
