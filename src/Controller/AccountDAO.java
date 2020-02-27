/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DAO{

    public AccountDAO() {
        getInstance();
    }
    public ArrayList<Account> getAllAccount()
    {
        ArrayList<Account> listAccount = new ArrayList();
        String sql = "Select * from account";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String userName = rs.getString("Username");
                String passWord = rs.getString("Password");
                Account a = new Account(userName, passWord);
                listAccount.add(a);
            }
            System.out.println(listAccount);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listAccount;
    }
    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        ad.getAllAccount();
    }
}
