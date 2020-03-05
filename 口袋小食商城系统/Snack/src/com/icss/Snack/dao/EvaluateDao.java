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
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "insert into tb_evaluate(createtime,content,uid,oid) values(?,?,?,?)";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setTimestamp(1,evaluate.getCreatetime());
        ps.setString(2,evaluate.getContent());
        ps.setInt(3,evaluate.getUid());
        ps.setString(4,evaluate.getOid());
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过评价编号修改评价
    public  int updateEvaluate(Evaluate evaluate) throws Exception{
        int row = 0;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "update tb_evaluate set content=?,createtime=? where eid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,evaluate.getContent());
        ps.setTimestamp(2,evaluate.getCreatetime());
        ps.setInt(3,evaluate.getEid());
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过评价编号删除评价信息
    public int deleteEvaluate(int eid) throws Exception{
        int row = 0;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "delete from tb_evaluate where eid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setInt(1,eid);
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过用户编号查询用户评价详情
    public List<Evaluate> findEvaluateByUid(int uid) throws Exception{
        List<Evaluate> evaluateList = new ArrayList<Evaluate>();
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "select * from tb_evaluate where uid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setInt(1,uid);
        //5.执行sql返回结果集
        ResultSet rs = ps.executeQuery();
        //6.将结果集中的数据提取到对象的属性中
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


    //通过订单编号查询用户评价详情
    public Evaluate findEvaluateByOid(String oid) throws Exception{
        Evaluate evaluate = null;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "select * from tb_evaluate where oid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,oid);
        //5.执行sql返回结果集
        ResultSet rs = ps.executeQuery();
        //6.将结果集中的数据提取到对象的属性中
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
