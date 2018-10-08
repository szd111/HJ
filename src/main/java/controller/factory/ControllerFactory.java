package controller.factory;

import controller.DataMainTainController;
import controller.DictionaryMainTainController;
<<<<<<< HEAD
=======
import controller.LoginController;
>>>>>>> branch1

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/27
<<<<<<< HEAD
 * @描述
=======
 * @描述 工厂模式选择创建实体类
>>>>>>> branch1
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
