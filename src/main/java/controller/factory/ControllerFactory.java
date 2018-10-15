package controller.factory;

import controller.DataMainTainFirstController;

import controller.DataMainTainSecondController;
import controller.DataMainTainThirdController;
import controller.DataMainTainFourthController;
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

            return new DataMainTainFirstController();
        } else if (name.equals("DictionaryMainTain")) {
            return new DictionaryMainTainController();
        } else if (name.equals("Login")) {

            return new LoginController();
        } else if (name.equals("DataMainTainSecond")) {
            return new DataMainTainSecondController();
        } else if (name.equals("DataMainTainThird")) {
            return new DataMainTainThirdController();
        } else if (name.equals("DataMainTainFourth")) {
            return new DataMainTainFourthController();

        }

        return null;
    }

}
