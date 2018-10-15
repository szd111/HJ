package controller.factory;

import controller.DataMainTainFirstController;

import controller.DataMainTainSecondController;
import controller.DataMainTainThirdController;
import controller.DataMainTainFourthController;
import controller.DictionaryMainTainController;


import controller.LoginController;


/**
 * @创建人 shizhendong
 * @创建时间 2018/9/27
 * @描述 工厂模式选择创建实体类
 */
public class ControllerFactory {


    /**
     * @描述 获取controller下面的实体类的方法 根据实体名称
     * @参数 name 实体名称
     * @返回值 name对应的实体类
     * @创建人 szd
     * @创建时间 2018/9/27
     * @修改人和其它信息
     */

    public Object getConTrollers(String name) {


        if (name == null) {

            return null;
        }

        //根据实体名进行选择
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
