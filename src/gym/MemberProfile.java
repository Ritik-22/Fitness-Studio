/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MemberProfile {
    String name;
    String address;
    Integer contactNo;
    Integer scheduleId;
    String gender;
    
    public void editProfile(char op,String mname,String address,long contactNo,String gender,int sid,int mid){
        
        if(op=='i')
        {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");

            PreparedStatement st2=con.prepareStatement("Insert into profile(name,gender, address, contactNo, memberId, scheduleid) values(?,?,?,?,?,?)");
                st2.setString(1,mname);
                st2.setString(2,gender);
                st2.setString(3,address);
                st2.setLong(4,contactNo);
                st2.setInt(5,mid);
                st2.setInt(6,sid);

                st2.executeUpdate();
            
            
            st2.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.print("exception is" + ex);
        }
    }
        else if(op=='u')
        {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");

            PreparedStatement st2=con.prepareStatement("Update profile set name=?,gender=?, address=?, contactNo=?, scheduleid=? WHERE memberId=?");
                st2.setString(1,mname);
                st2.setString(2,gender);
                st2.setString(3,address);
                st2.setLong(4,contactNo);
                st2.setInt(5,sid);
                st2.setInt(6,mid);
                

                if(st2.executeUpdate()>0)
                {
                   JOptionPane.showMessageDialog(null, "Member Profile Updated");
                }
                else{
                   JOptionPane.showMessageDialog(null, "Member Id Doesn't Exist");
                }
            
            
            st2.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.print("exception is" + ex);
        }
        }
        else if(op=='d')
        {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");

            PreparedStatement st2=con.prepareStatement("Delete From member WHERE memberId=?");
                
                st2.setInt(1,mid);
                

                if(st2.executeUpdate()>0)
                {
                   JOptionPane.showMessageDialog(null, "Member Profile Deleted");
                }
                else{
                   JOptionPane.showMessageDialog(null, "Member Id doesn't exist");
                }
            
            
            st2.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.print("exception is" + ex);
        }
        catch (ClassNotFoundException ex)
        {
            System.out.print("exception is" + ex);
        }
    }
    }
    
    }
    
    

