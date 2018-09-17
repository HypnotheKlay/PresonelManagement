package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import model.Employee;
import service.DepartmentServiceImpl;

public class EmployeeDaoImpl implements IEmployeeDao {

    Connection conn = DBConnect.getConnection();
    ResultSet rs = null;
    PreparedStatement pt = null;
    DepartmentServiceImpl dsi = new DepartmentServiceImpl();

    //person<===resultst<---perparstatement<---connection<--drivermanager  
    
    //通过人员编号查找人员信息
    public Employee findById(int id) {
        Employee employee = null;
        String sql = "select * from employee where id=?";
        try {
            pt = conn.prepareStatement(sql);//Ԥ�������
            pt.setInt(1, id);
            rs = pt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setProfessional(rs.getString("professional"));
                employee.setDepartment(dsi.findById(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(rs, pt, null);
        }
        return employee;
    }

    //查找所有人员信息
    public ArrayList<Employee> findAll() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = null;
        String sql = "select * from employee";
        try {
            pt = conn.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setProfessional(rs.getString("professional"));
                employee.setDepartment(dsi.findById(rs.getInt("departmentID")));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public Vector findAll_vector() {
        Vector EmployeeVector = new Vector();
        Vector rowData;
        rowData = new Vector();  
        String sql = "select * from employee";
        try {
            pt = conn.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
            	Vector hang=new Vector(); 
                 hang.add(rs.getInt("id"));  
                 hang.add(rs.getString("name"));  
                 hang.add(rs.getString("professional"));
//                 hang.add(rs.getString(dsi.findById(rs.getInt("departmentID")).getName());
                 hang.add(dsi.findById(rs.getInt("departmentID")).getName());
                 hang.add(rs.getInt("power"));
                 hang.add(rs.getString("password")); 
                EmployeeVector.add(hang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return EmployeeVector;
    }
    //添加人员信息
    public int insert(Employee entity) {
        int em = 0;
        String sql = "insert into employee(name,professional,departmentID,power,password)values(?,?,?,?,?)";
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1, entity.getName());
            pt.setString(2, entity.getProfessional());
            pt.setInt(3, entity.getDepartmentID());
            pt.setInt(4, entity.getPower());
            pt.setString(5, entity.getPassword());
            em = pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, pt, null);
        }
        return em;
    }

    //删除人员信息
    public int delete(int id) {
        int em = 0;
        String sql = "delete from employee where id=?";
        try {
            pt = conn.prepareStatement(sql);
            pt.setInt(1, id);
            em = pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, pt, null);
        }
        return em;
    }

    //修改人员信息
    public int update(Employee entity) {
        int em = 0;
        String sql = "update employee set name =?,professional=? ,departmentID=?,power=?,password=? where id=?";
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1, entity.getName());
            pt.setString(2, entity.getProfessional());
            pt.setInt(3, entity.getDepartmentID()); 
            pt.setInt(4, entity.getPower());
            pt.setString(5, entity.getPassword());
            pt.setInt(6, entity.getId());
            em = pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, pt, null);
        }
        return em;
    }
}
