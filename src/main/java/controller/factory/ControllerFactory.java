package controller.factory;

<<<<<<< HEAD
import controller.*;
=======
import controller.DataMainTainFirstController;

import controller.DataMainTainSecondController;
import controller.DataMainTainThirdController;
import controller.DataMainTainFourthController;
import controller.DictionaryMainTainController;


import controller.LoginController;
>>>>>>> 41cd98c8cb3a434a3cf5e6fe3758b90cf74c38fd


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
<<<<<<< HEAD

        } else if (name.equals("DataMainTainThird")) {
            return new DataMainTainThirdController();

        } else if (name.equals("DataMainTainFourth")) {
            return new DataMainTainFourthController();

        } else if (name.equals("DictionaryMainTainSecond")) {
            return new DictionaryMainTainSecondController();

        } else if (name.equals("DictionaryMainTainThird")) {
            return new DictionaryMainTainThirdController();

        } else if (name.equals("DictionaryMainTainTFourth")) {
            return new DictionaryMainTainFourthController();
=======
        } else if (name.equals("DataMainTainThird")) {
            return new DataMainTainThirdController();
        } else if (name.equals("DataMainTainFourth")) {
            return new DataMainTainFourthController();

>>>>>>> 41cd98c8cb3a434a3cf5e6fe3758b90cf74c38fd
        }

        return null;
    }

}
