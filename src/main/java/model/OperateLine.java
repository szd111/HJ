package model;

import view.Windows;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/10/9
 * @���� �Ա��һ�н��в��� �������һ�У�ɾ��һ�У��ύһ�У�����һ��
 */
public interface OperateLine {


    /**
     * @���� ���������һ�� ��һ�����ݿ���ж�ȡһ�����ݲ��뵽��һ�����ݿ��
     * @���� length�еĸ���,key�ǽ��в����ʵ��ؼ���,column��table1�ж�Ӧkey������,table1 ��ȡ�ı�, w �����洰��
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void addRowTable(int length,String key,String column,String tablename,final Windows w);

    /**
     * @���� ������ɾ��һ��,�����ض������� ���ض������ݿ����
     * @���� column ��Ӧ������,tablename ��Ӧ��Ҫɾ���ı�,w������Ĵ���
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void deleteRowTable(String column,String tablename,final Windows w);

    /**
     * @���� �������ָ�������ύ�����ݿ����
     * @���� w �����洰�� ,columnname table�е��������Խ����ظ��ж�,tablename �ύ�����ݿ����,length �����ĳ���
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void uploadRowTable(final Windows w,String columnname,String tablename,int length);


    /**
     * @���� ������е����е����ݽ����޸�;
     * @���� length �еĸ���, key�޸��е�������Ϣ, column key����Ӧ������,tablename �޸ĵı�,w ������Ĵ���
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void updateRowTable(int length,String key, String column, String tablename, Windows w);


    /**
     * @���� ������е��н��г��� ��ԭ����������ݿ���е�״̬
     * @���� length�еĸ���,key�ǽ��в����ʵ��ؼ���,column��table1�ж�Ӧkey������,table1 ��ȡ�ı�, w �����洰��
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void withdrawRowTable(int length, String key2, String tablename, Windows w);
}
