package dao;

import java.util.ArrayList;
import java.util.Vector;

import model.Employee;

public interface IEmployeeDao {

    public Employee findById(int id);

    public ArrayList<Employee> findAll();

    public int insert(Employee entity);

    public int delete(int id);

    public int update(Employee entity);
    
    public Vector<Employee> findAll_vector() ;
}
