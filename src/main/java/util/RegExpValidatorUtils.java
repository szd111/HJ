package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/10/9
 * @���� ���������������֤
 */
public class RegExpValidatorUtils {


    /**
     * ��֤����
     *
     * @return ����Ƿ��ϵ��ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean isEmail(String str) {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return match(regex, str);
    }

    /**
     * ��֤IP��ַ
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean isIP(String str) {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
        return match(regex, str);
    }

    /**
     * ��֤��ַUrl
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsUrl(String str) {
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        return match(regex, str);
    }

    /**
     * ��֤�绰����
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsTelephone(String str) {
        String regex = "^(\\d{3,4}-)?\\d{6,8}$";
        return match(regex, str);
    }

    /**
     * ��֤������������(�ַ�������ͬʱ����)
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsPassword(String str) {
        String regex = "[A-Za-z]+[0-9]";
        return match(regex, str);
    }

    /**
     * ��֤�������볤�� (6-18λ)
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsPasswLength(String str) {
        String regex = "^\\d{6,18}$";
        return match(regex, str);
    }

    /**
     * ��֤�����������
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsPostalcode(String str) {
        String regex = "^\\d{6}$";
        return match(regex, str);
    }

    /**
     * ��֤�����ֻ�����
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsHandset(String str) {
        String regex = "^[1]+[3,5]+\\d{9}$";
        return match(regex, str);
    }

    /**
     * ��֤�������֤��
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsIDcard(String str) {
        String regex = "(^\\d{18}$)|(^\\d{15}$)";
        return match(regex, str);
    }

    /**
     * ��֤������λС��
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsDecimal(String str) {
        String regex = "^[0-9]+(.[0-9]{2})?$";
        return match(regex, str);
    }

    /**
     * ��֤����һ���12����
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsMonth(String str) {
        String regex = "^(0?[[1-9]|1[0-2])$";
        return match(regex, str);
    }

    /**
     * ��֤����һ���µ�31��
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsDay(String str) {
        String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
        return match(regex, str);
    }

    /**
     * ��֤����ʱ��
     *
     * @return ����Ƿ�����ַ��ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean isDate(String str) {
// �ϸ���֤ʱ���ʽ��(ƥ��[2002-01-31], [1997-04-30],
// [2004-01-01])��ƥ��([2002-01-32], [2003-02-29], [04-01-01])
// String regex =
// "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
// û��ʱ����֤��YYYY-MM-DD
// String regex =
// "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
// ����ʱ����֤��YYYY-MM-DD 00:00:00
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return match(regex, str);
    }

    /**
     * ��֤��������
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsNumber(String str) {
        String regex = "^[0-9]*$";
        return match(regex, str);
    }

    /**
     * ��֤�����������
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsIntNumber(String str) {
        String regex = "^\\+?[1-9][0-9]*$";
        return match(regex, str);
    }

    /**
     * ��֤��д��ĸ
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsUpChar(String str) {
        String regex = "^[A-Z]+$";
        return match(regex, str);
    }

    /**
     * ��֤Сд��ĸ
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsLowChar(String str) {
        String regex = "^[a-z]+$";
        return match(regex, str);
    }

    /**
     * ��֤��֤������ĸ
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsLetter(String str) {
        String regex = "^[A-Za-z]+$";
        return match(regex, str);
    }

    /**
     * ��֤��֤���뺺��
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsChinese(String str) {
        String regex = "^[\u4e00-\u9fa5],{0,}$";
        return match(regex, str);
    }

    /**
     * ��֤��֤�����ַ���
     *
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsLength(String str) {
        String regex = "^.{8,}$";
        return match(regex, str);
    }

    /**
     * @param regex ������ʽ�ַ���
     * @param str   Ҫƥ����ַ���
     * @return ���str ���� regex��������ʽ��ʽ,����true, ���򷵻� false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    public static void main(String args[]) {


    }
}
