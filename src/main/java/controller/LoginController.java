package controller;

import model.LoginImp;
import model.entity.User;

import java.awt.event.ActionEvent;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @���� �Ե�¼�����е�button�����¼�����
 */
public class LoginController {

    /**
     * ���� �Ե�½���п���
     * ʱ�� 2018/9/29
     * rduan
     * ���� flag 0 ��Ȩ��¼ , 1 ��¼Ȩ��
     */
    public int loginController(User user) {

        int flag = 0;
        LoginImp loginImp=new LoginImp();

        String username=user.getName();
        String password=user.getPassword();
        flag=loginImp.loginAccessDb(username,password);

        return flag;


    }

    public static void main(String[] args) {

    }

}
