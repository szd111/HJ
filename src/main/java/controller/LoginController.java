package controller;

import model.LoginImp;
import model.entity.User;

import java.awt.event.ActionEvent;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 对登录界面中的button进行事件控制
 */
public class LoginController {

    /**
     * 描述 对登陆进行控制
     * 时间 2018/9/29
     * rduan
     * 参数 flag 0 无权登录 , 1 登录权限
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
