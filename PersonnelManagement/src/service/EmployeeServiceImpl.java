package service;

import java.util.ArrayList;
import java.util.Vector;

import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl {

    EmployeeDaoImpl pd = new EmployeeDaoImpl();

    public Employee findById(int id) {
        return pd.findById(id);
    }

    public ArrayList<Employee> findAll() {

        return pd.findAll();
    }
    
    public boolean insert(Employee entity) {

        return pd.insert(entity) > 0 ? true : false;
    }

    public boolean delete(int id) {
        return pd.delete(id) > 0 ? true : false;
    }

    public boolean update(Employee oldEntity) {
        return pd.update(oldEntity) > 0 ? true : false;
    }
    
    public Vector<Employee> findAll_vector(){
    	 return pd.findAll_vector();
    }
}
