/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserManagementDAO;
import entities.Usermanagement;
import java.math.BigDecimal;
import method.BCrypt;

/**
 *
 * @author Ignatius
 */
public class UserManagementController {

    private final UserManagementDAO umDao;
    
    public UserManagementController() {
        umDao = new UserManagementDAO();
    }
    
    public BigDecimal getAutoId(){
        Object obj = umDao.getAutoId();
        BigDecimal ids = new BigDecimal("1");
        if(obj!=null) ids = BigDecimal.valueOf(new Long(obj.toString()));
        return ids;
    }
    
    public boolean save(boolean isUpdate,String id, String username, String password, String akses){
        BigDecimal idBaru = BigDecimal.valueOf(new Long(id));
        if (!isUpdate) idBaru = new UserManagementController().getAutoId();
        Usermanagement u = new Usermanagement(idBaru, username, BCrypt.hashpw(password, BCrypt.gensalt()), akses);
        return umDao.save(u);
    }
    
    public boolean login(String id, String password){
        Usermanagement um = (Usermanagement) umDao.getById(id);
        return BCrypt.checkpw(password, um.getPassword());
    }
    
    public boolean login(String category,String username, String password){
        Usermanagement um = (Usermanagement) umDao.search(category, username).get(0);
        return BCrypt.checkpw(password, um.getPassword());
    }
    
    public boolean delete(String id){
        return umDao.delete(id);
    }
}
