package model.database;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/9/26
 * @���� ���ݿ�ĳ���ӿ� �Դ������ݿ������ ���� ���� ɾ��
 */
public interface DatabaseDao {


    /**
     * @���� ��ȡ���ݿ������
     * @����
     * @����ֵ Connection
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public Connection getConnection();


    /**
     * @���� �ر����ݿ������
     * @���� connection ���ݿ�����
     * @����ֵ null
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public void destroy(Connection connection);


    /**
     * @���� ������Ӧ��sql���ִ�в�ѯ����
     * @���� sql ���
     * @����ֵ ResultSet �����
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public ResultSet executeQuery(String sql,Connection connection);

    /**
     * @���� ������Ӧ��sql���ִ�в�ѯ����,������
     * @���� sql ���
     * @����ֵ ResultSet �����
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */
    public ResultSet executeQuerys(String sql,String []params,Connection connection);



    /**
     * @���� ����sql�����и��²���
     * @���� sql ���
     * @����ֵ int �ɹ����
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */

    public int executeUpdate(String sql,Connection connection);

    /**
     * @���� ����sql�����и��²���,��������
     * @���� sql ���
     * @����ֵ int �ɹ����
     * @������ szd
     * @����ʱ�� 2018/9/27
     * @�޸��˺�������Ϣ
     */

    public int executeUpdates(String sql,String []params,Connection connection);



}

