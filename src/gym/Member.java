/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Member {
    
    private int memberId;
    String startdate;
    MemberProfile profile;
    MemberReport report;
    
    Member(){
        profile = new MemberProfile();
        report = new MemberReport();
}
    public void insertUpdateDelete(char op,int mid,String mname,String gender,String address,long contactNo,int sid,int age,int height,int weight,int waist,int hip)
    {
        
        if(op=='i')
        {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");

            
                
                
                PreparedStatement st1=con.prepareStatement("Insert into member(memberId, startdate) values(?,now())");
                st1.setInt(1,mid);
                st1.executeUpdate();
                st1.close();
                
                profile.editProfile('i',mname,address,contactNo,gender,sid,mid);
                report.updateReport('i',age,height,weight,waist,hip,mid);
//                PreparedStatement st2=con.prepareStatement("Insert into profile(name,gender, address, contactNo, mid, scheduleid) values(?,?,?,?,?,?)");
//                st2.setString(1,mname);
//                st2.setString(2,gender);
//                st2.setString(3,address);
//                st2.setInt(4,contactNo);
//                st2.setInt(5,mid);
//                st2.setInt(6,sid);
//                PreparedStatement st3=con.prepareStatement("Insert into report(age, height, weight, waist, hip, mId) values(?,?,?,?,?,?)");
//                st3.setInt(1,age);
//                st3.setInt(2,height);
//                st3.setInt(3,weight);
//                st3.setInt(4,waist);
//                st3.setInt(5,hip);
//                st3.setInt(6,mid);
                 
//                st2.executeUpdate();
//                st3.executeUpdate();
          
            
            
            
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
    
    public void fillMemberProfileJtable(JTable table,String value){
        
    try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");
            PreparedStatement ps;
            if(value=="")
            {
                 ps=con.prepareStatement("Select * from member Natural Join profile ");
            }
            else
            {
                ps=con.prepareStatement("Select * from member Natural Join profile WHERE CONCAT(memberId,name,address,contactNo) LIKE ?");
            ps.setString(1,"%"+value+"%");
            }   
               
            ResultSet rs =ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel) table.getModel();
            
            Object[] row;
            while(rs.next())
            {
                row = new Object[7];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(3);
                row[2]=rs.getString(2);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                row[5]=rs.getLong(6);
                row[6]=rs.getInt(7);
                
                model.addRow(row);
            }
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
