/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DepartmentDaoImpl;

import java.util.ArrayList;
import java.util.Vector;

import model.Department;

/**
 *
 * @author Administrator
 */
public class DepartmentServiceImpl implements IDepartmentService{

    DepartmentDaoImpl ddi=new DepartmentDaoImpl();
    
    @Override
    public Department findById(int id) {
        return ddi.findById(id);
        }
    
    public Department findByName(String name){
    	return ddi.findByName(name);
    }

    @Override
    public ArrayList<Department> findAll() {
        return ddi.findAll();
        }
    
    public Vector findAll_vector(){
    	return ddi.findAll_vector();
    }


    @Override
    public boolean insert(Department entity) {
        return ddi.insert(entity)>0?true:false;
        }

    @Override
    public boolean delete(Department entity) {
        return ddi.delete(entity)>0?true:false;
        }

    @Override
    public boolean update(Department entity) {
         return ddi.update(entity)>0?true:false;
        }
    
}
