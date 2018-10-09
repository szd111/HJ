package model;

import model.entity.Columns;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @������ shizhendong
 * @����ʱ�� 2018/10/8
 * @���� �Ա���в�ѯ ���ݱ��� ��ȡ����ֶκͱ������
 */
public interface SelectTable {


    /**
     * @���� ���ݱ�����ȡ����ֶ������ֶ�����
     * @���� name ����
     * @����ֵ ArrayList<Columns> ����ʵ���list����
     * @������ szd
     * @����ʱ�� 2018/10/8
     * @�޸��˺�������Ϣ
     */

    public ArrayList<Columns> getColumnName(String name) throws SQLException;


}
