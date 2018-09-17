/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import model.Department;

/**
 *
 * @author Administrator
 */
public class DepartmentDaoImpl implements IDepartmentDao{
    
    Connection conn=DBConnect.getConnection();
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    //通过部门编号查找部门信息
    public Department findById(int id) {
        Department department=null;
        String sql="select * from department where id=?";
        try{
            pt=conn.prepareStatement(sql);
            pt.setInt(1, id);
            rs=pt.executeQuery();
            if(rs.next()){
                department=new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setMaName(rs.getString("MaName"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnect.close(rs,pt,null);
        }
        return department;
        }

    public Department findByName(String name) {
        Department department=null;
        String sql="select * from department where name=?";
        try{
            pt=conn.prepareStatement(sql);
            pt.setString(1, name);
            rs=pt.executeQuery();
            if(rs.next()){
                department=new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setMaName(rs.getString("MaName"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnect.close(rs,pt,null);
        }
        return department;
        }   
    
    
    //查找部门的所有信息
    public ArrayList<Department> findAll() {
        ArrayList<Department> departmentList=new ArrayList<Department>();
        Department department=null;
        String sql="select * from department";
        try{
            pt=conn.prepareStatement(sql);
            rs=pt.executeQuery();
            while(rs.next()){
                department=new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setMaName(rs.getString("MaName"));
                departmentList.add(department);
            }
        }catch(SQLException e){
        }
        return departmentList;
    }

    public Vector findAll_vector() {
        Vector department = new Vector();
        Vector rowData;
        rowData = new Vector();  
        String sql = "select * from department";
        try {
            pt = conn.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
            	Vector hang=new Vector(); 
                 hang.add(rs.getInt("id"));  
                 hang.add(rs.getString("name"));  
                 hang.add(rs.getString("MaName")); 
                 department.add(hang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
    
    //添加部门信息
    public int insert(Department entity) {
        int de=0;
        String sql="insert into department(name,MaName)values(?,?)";
        try{
            pt=conn.prepareStatement(sql);
            pt.setString(1, entity.getName());
            pt.setString(2, entity.getMaName());
            de=pt.executeUpdate();
        }catch(SQLException e){
        }finally{
            DBConnect.close(null, pt, null);
        }
        return de;
        }

    //删除部门信息
    public int delete(Department entity) {
        int de=0;
        String sql="delete from department where id=?";
        try{
            pt=conn.prepareStatement(sql);
            pt.setInt(1, entity.getId());
            de=pt.executeUpdate();
        }catch(SQLException e){
        }finally{
            DBConnect.close(null, pt, null);
        }
        return de;
        }

    //更新部门信息
    public int update(Department entity) {
        int de=0;
        String sql="update department set name=?,MaName=? where id=?";
        try{
            pt=conn.prepareStatement(sql);
            pt.setString(1, entity.getName());
            pt.setString(2, entity.getMaName());
            pt.setInt(3, entity.getId());
            de=pt.executeUpdate();
        }catch(SQLException e){
        }finally{
            DBConnect.close(null, pt, null);
        }
        return de;
    }
    
}
