/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Usermanagement;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Ignatius
 */
public class UserManagementDAO implements InterfaceDAO{

    private final FunctionsDAO fdao;

    public UserManagementDAO() {
        fdao = new FunctionsDAO();
    }
    
    @Override
    public boolean save(Object object) {
        return fdao.save(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(Usermanagement.class, BigInteger.valueOf(new Long(object.toString())));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Usermanagement ORDER BY id");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Usermanagement WHERE "+category+" LIKE %'"+search+"'%");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("FROM Usermanagement WHERE id="+id);
    } 

    @Override
    public Object getAutoId() {
        return fdao.getById("SELECT MAX(ID)+1 FROM Usermanagement");
    }
}
