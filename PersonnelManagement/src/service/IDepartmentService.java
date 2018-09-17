/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

import model.Department;

/**
 *
 * @author Administrator
 */
public interface IDepartmentService {

    public Department findById(int id);
    
    public Department findByName(String name);

    public ArrayList<Department> findAll();

    public boolean insert(Department entity);

    public boolean delete(Department entity);

    public boolean update(Department entity);
}
