package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Brand;
import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class BrandDao {
	//��
		public  int Add(Brand brand) throws Exception{
			int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "insert into tb_brand(brand_id,name,phone,email,address,state) values(?,?,?,?,?,?)";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1,brand.getBrand_id());
			ps.setString(2,brand.getName());
		    ps.setString(3,brand.getPhone());
		    ps.setString(4,brand.getEmail());
		    ps.setString(5,brand.getAddress());
		    ps.setString(6,brand.getState());
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
			
		}
		//��
	    public int updateBrand(Brand brand) throws Exception{
	    	int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "update tb_brand set brand_id=?,name=?,phone=?,email=?,address=?,state=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1,brand.getBrand_id());
			ps.setString(2,brand.getName());
		    ps.setString(3,brand.getPhone());
		    ps.setString(4,brand.getEmail());
		    ps.setString(5,brand.getAddress());
		    ps.setString(6,brand.getState());
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
	    	}
	    //ɾ
	    public int deleteBrand(int brand_id) throws Exception {
	    	int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "delete from tb_brand where bran_id=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1, brand_id);
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
	    }
	    /*
	     * ��ѯ�û�����
	     */
	    public Brand findBrandBybrandid(int brand_id)throws Exception{
	    	        Brand brand = null;
	    	       //1.�������ݿ�
	    			java.sql.Connection connection = DBFactory.openConnection();
	    			//��дsql���
	    			String sql = "select * from tb_brand where brand_id=?";
	    			//����ִ��sql�Ķ���
	    			PreparedStatement ps = connection.prepareStatement(sql);
	    			//����ռλ����ֵ
	    			ps.setInt(1, brand_id);
	    			//ִ��sql���ؽ����
	    			ResultSet rs = ps.executeQuery();
	    			if(rs.next()) {
	    				brand=new Brand();
	    				brand.setBrand_id(rs.getInt("brand_id"));
	    				brand.setName(rs.getString("name"));
	    				brand.setEmail(rs.getString("email"));
	    				brand.setAddress(rs.getString("address"));
	    				brand.setPhone(rs.getString("phone"));
	    				brand.setState(rs.getString("state"));
	    				
	    			}
	    			rs.close();
	    			ps.close();
	    			return brand;
	     }
	  //��ѯ�ж�������
	    public List<Brand> findAllBrandList() throws Exception{
	    	List<Brand> brandList = new ArrayList<Brand>();
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_brand";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Brand brand=new Brand();
				brand.setBrand_id(rs.getInt("brand_id"));
				brand.setName(rs.getString("name"));
				brand.setEmail(rs.getString("email"));
				brand.setAddress(rs.getString("address"));
				brand.setPhone(rs.getString("phone"));
				brand.setState(rs.getString("state"));
				
				brandList.add(brand);
			}
			rs.close();
			ps.close();
	    	return brandList;
	    } 
	    //��ѯĳ�������ж���
	    public int findBrandCount() throws Exception{
	    	int count = 0;
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select count(*) from tb_brand";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			return count;
	    }   
 public static void main(String[] args) throws Exception {
			
	        BrandDao brandDao = new BrandDao();
	        
	        Brand brand = new Brand();
	        brand.setName("�ຼ");
	        brand.setEmail("1567286783@qq.com");
	        brand.setAddress("�����в�ƽ��");
	        brand.setPhone("13562534546");
	        brand.setState("0");
	        
	        int row = brandDao.Add(brand);
	       
	       /* List<Cart> cartList = cartDao.findAllCartList();
	        System.out.println(cartList.size());    
	    */    
	       }   
}
