package model;

/**
 * 描述 登录接口
 * 时间 2018/9/29$
 * 作者 rduan
 */
public interface Login {

    /**
     * 描述 访问数据库进行登录判断
     * 时间 2018/9/29
     * rduan
     * 参数
     */
    public int loginAccessDb(String user, String name);


    /**
     *@描述 进行登录用户身份的审核
     *@参数
     *@返回值
     *@创建人 szd
     *@创建时间 2018/10/15
     *@修改人和其它信息

     */
    public void checkAut(String check);


}
