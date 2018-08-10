/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.UserManagementController;
import dao.UserManagementDAO;
import entities.Usermanagement;
import java.math.BigDecimal;

/**
 *
 * @author Ignatius
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(new UserManagementController()
//                .save(true,"2","Rejeki", 
//                        "Ndasem", "admin"));
//        System.out.println(new UserManagementController().save(true,"2","Joko", "Kudus", "admin"));
        System.out.println("result: "
                +new UserManagementController()
                        .login("2", "Ndasem"));
//        System.out.println(new UserManagementController().getAutoId());
    }

}
