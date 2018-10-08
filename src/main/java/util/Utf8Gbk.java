package util;

import java.io.UnsupportedEncodingException;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述utf-8和gbk的转换
 */
public class Utf8Gbk {



    public static Utf8Gbk utf8Gbk;


    //单列模式
    public static synchronized Utf8Gbk getInstance() {

        if (utf8Gbk == null) {


            utf8Gbk = new Utf8Gbk();
        }


        return utf8Gbk;



    }


    /**
     * @描述 将字符串从utf8转换为gbk
     * @参数 txt 待转换的字符串
     * @返回值 String 转换完毕的字符串
     * @创建人 szd
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
