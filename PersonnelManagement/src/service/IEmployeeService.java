package service;

import java.util.ArrayList;
import java.util.Vector;

import model.Employee;

public interface IEmployeeService {

    public Employee findById(int id);

    public ArrayList<Employee> findAll();

    public boolean insert(Employee entity);

    public boolean delete(Employee entity);

    public boolean update(Employee entity);
    
    public Vector<Employee> findAll_vector();
}
