/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

import model.Department;

/**
 *
 * @author Administrator
 */
public interface IDepartmentDao {

    public Department findById(int id);
    
    public Department findByName(String name);
    
    public ArrayList<Department> findAll();

    public int insert(Department entity);

    public int delete(Department entity);

    public int update(Department entity);
}
