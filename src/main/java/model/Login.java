package model;

/**
 * ���� ��¼�ӿ�
 * ʱ�� 2018/9/29$
 * ���� rduan
 */
public interface Login {

    /**
     * ���� �������ݿ���е�¼�ж�
     * ʱ�� 2018/9/29
     * rduan
     * ����
     */
    public int loginAccessDb(String user, String name);


    /**
     *@���� ���е�¼�û���ݵ����
     *@����
     *@����ֵ
     *@������ szd
     *@����ʱ�� 2018/10/15
     *@�޸��˺�������Ϣ

     */
    public void checkAut(String check);


}
