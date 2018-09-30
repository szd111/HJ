package controller.factory;

import controller.DataMainTainController;
import controller.DictionaryMainTainController;
import controller.LoginController;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/27
 * @���� ����ģʽѡ�񴴽�ʵ����
 */
public class ControllerFactory {


    /**
     * @���� ��ȡcontroller�����ʵ����ķ��� ����ʵ������
     * @���� name ʵ������
     * @����ֵ name��Ӧ��ʵ����
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */

    public Object getConTrollers(String name) {


        if (name == null) {

            return null;
        }

        //����ʵ��������ѡ��
        if (name.equals("DataMainTain")) {

            return new DataMainTainController();
        } else if (name.equals("DictionaryMainTain")) {
            return new DictionaryMainTainController();
        } else if (name.equals("Login")) {
            return new LoginController();
        }

        return null;
    }

}
