package model;

import view.Windows;

/**
 * ���� �����ֵ�ά�������ӿ�
 * ʱ�� 2018/10/18$
 * ���� szd
 */
public interface DictionaryMainTainOperate {


    /**
     *@���� ��������Ŀ¼��ά�� ͨ�������ݿ��е��ֵ����и���
     *@����
     *@����ֵ
     *@������ szd
     *@����ʱ�� 2018/10/15
     *@�޸��˺�������Ϣ

     */
    public void updateTreeNode(String id,String tt);

    /**
     *@���� ��������Ŀ¼ά�� ���ֵ���½���֮�����״�ṹ���и���
     *@����
     *@����ֵ
     *@������ szd
     *@����ʱ�� 2018/10/15
     *@�޸��˺�������Ϣ

     */
    public void updateTreeStructure(Windows w,String name);


}
