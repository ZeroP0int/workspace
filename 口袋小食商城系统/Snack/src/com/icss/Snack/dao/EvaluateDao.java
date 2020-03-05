package com.icss.Snack.dao;

import com.icss.Snack.entity.Evaluate;
import com.icss.Snack.util.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EvaluateDao {

    public int addEvaluate(Evaluate evaluate) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "insert into tb_evaluate(createtime,content,uid,oid) values(?,?,?,?)";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setTimestamp(1,evaluate.getCreatetime());
        ps.setString(2,evaluate.getContent());
        ps.setInt(3,evaluate.getUid());
        ps.setString(4,evaluate.getOid());
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ�����۱���޸�����
    public  int updateEvaluate(Evaluate evaluate) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "update tb_evaluate set content=?,createtime=? where eid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,evaluate.getContent());
        ps.setTimestamp(2,evaluate.getCreatetime());
        ps.setInt(3,evaluate.getEid());
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ�����۱��ɾ��������Ϣ
    public int deleteEvaluate(int eid) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "delete from tb_evaluate where eid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setInt(1,eid);
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ���û���Ų�ѯ�û���������
    public List<Evaluate> findEvaluateByUid(int uid) throws Exception{
        List<Evaluate> evaluateList = new ArrayList<Evaluate>();
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "select * from tb_evaluate where uid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setInt(1,uid);
        //5.ִ��sql���ؽ����
        ResultSet rs = ps.executeQuery();
        //6.��������е�������ȡ�������������
        while (rs.next()){
            Evaluate evaluate = new Evaluate();
            evaluate.setUid(rs.getInt("uid"));
            evaluate.setEid(rs.getInt("eid"));
            evaluate.setOid(rs.getString("oid"));
            evaluate.setCreatetime(rs.getTimestamp("createtime"));
            evaluate.setContent(rs.getString("content"));
            evaluateList.add(evaluate);
        }
        return evaluateList;
    }


    //ͨ��������Ų�ѯ�û���������
    public Evaluate findEvaluateByOid(String oid) throws Exception{
        Evaluate evaluate = null;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "select * from tb_evaluate where oid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,oid);
        //5.ִ��sql���ؽ����
        ResultSet rs = ps.executeQuery();
        //6.��������е�������ȡ�������������
        if (rs.next()){
            evaluate = new Evaluate();
            evaluate.setUid(rs.getInt("uid"));
            evaluate.setEid(rs.getInt("eid"));
            evaluate.setOid(rs.getString("oid"));
            evaluate.setCreatetime(rs.getTimestamp("createtime"));
            evaluate.setContent(rs.getString("content"));

        }
        return evaluate;
    }


    public static void main(String[] args)throws Exception{
        EvaluateDao evaluateDao = new EvaluateDao();
        /*Evaluate evaluate = new Evaluate();
        evaluate.setContent("zyt");
        evaluate.setUid(2);
        evaluate.setOid("2");
        //evaluate.setEid(2);
        evaluate.setCreatetime(new Timestamp(System.currentTimeMillis()));
        int row = evaluateDao.addEvaluate(evaluate);
        System.out.println(row);*/

        List<Evaluate> evaluateList = evaluateDao.findEvaluateByUid(2);
        System.out.println(evaluateList.size());
    }
}
