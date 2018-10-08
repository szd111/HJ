package util;

import java.io.UnsupportedEncodingException;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @����utf-8��gbk��ת��
 */
public class Utf8Gbk {



    public static Utf8Gbk utf8Gbk;


    //����ģʽ
    public static synchronized Utf8Gbk getInstance() {

        if (utf8Gbk == null) {


            utf8Gbk = new Utf8Gbk();
        }


        return utf8Gbk;



    }


    /**
     * @���� ���ַ�����utf8ת��Ϊgbk
     * @���� txt ��ת�����ַ���
     * @����ֵ String ת����ϵ��ַ���
     * @������ szd
     */

    public String Utf8TogGbk(String txt) {

        String name = "";

        String unicode = null;
        try {
            unicode = new String(txt.getBytes(), "UTF-8");

            name = new String(unicode.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return name;


    }

}
