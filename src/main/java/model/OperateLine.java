package model;

import view.Windows;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/10/9
 * @���� �Ա��һ�н��в��� �������һ�У�ɾ��һ�У��ύһ�У�����һ��
 */
public interface OperateLine {


    /**
     * @���� ���������һ��
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void addRowTable(final Windows w);

    /**
     * @���� ������ɾ��һ��
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void deleteRowTable(final Windows w);

    /**
     * @���� �������ָ�������ύ�����ݿ���
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void uploadRowTable(final Windows w);


    /**
     * @���� ������е��н��г���
     * @����
     * @����ֵ
     * @������ szd
     * @����ʱ�� 2018/10/9
     * @�޸��˺�������Ϣ
     */
    public void withdrawRowTable(final Windows w);
}
