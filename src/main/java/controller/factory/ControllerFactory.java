package controller.factory;

import controller.DataMainTainController;
import controller.DictionaryMainTainController;
<<<<<<< HEAD
=======
import controller.LoginController;
>>>>>>> branch1

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/27
<<<<<<< HEAD
 * @����
=======
 * @���� ����ģʽѡ�񴴽�ʵ����
>>>>>>> branch1
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
<<<<<<< HEAD
            return new DictionaryMainTainController();
=======
            return new LoginController();
>>>>>>> branch1
        }

        return null;
    }

}
