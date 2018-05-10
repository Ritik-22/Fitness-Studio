/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import static java.lang.Math.pow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MemberReport {
    int age, height, weight, waist, hip;
    double bmi,whr;
    String diet1;
    String diet2;
    String diet3;
    MemberReport(){
    diet1="Your BMI falls into the underweight range for your height. At this level you would be advised to gain weight as a very low BMI is associated with health risks.";
    diet2="Your BMI is within the healthy range - well done!\n" +
"\n" +
"At this level you wouldn't be advised that you need to lose weight, but we understand many people want to lose a few pounds to feel better or for a holiday or special occasion. If that's your objective, then Diet Plan can help. However remember you are already a healthy weight, so don't go lower than the target our service will set you.";
    diet3="Your BMI falls within the overweight range - losing weight to get back into the healthy range will have significant health benefits for you. Losing just 10% of your body weight can help to reduce your cholesterol level and lower blood pressure. Both benefits are important for heart health and can help protect against heart disease. \n" +
"\n" +
"Diet Plan can help you to achieve your weight loss goal.";
    }
    public void updateReport(char op,int age,int height,int weight,int waist,int hip,int mid)
    {
        bmi=weight/(height*height*0.0001);
        whr=waist/hip;
        if(op=='i')
        {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");

  
                PreparedStatement st3=con.prepareStatement("Insert into report(age, height, weight, waist, hip, mId,diet) values(?,?,?,?,?,?,?)");
                st3.setInt(1,age);
                st3.setInt(2,height);
                st3.setInt(3,weight);
                st3.setInt(4,waist);
                st3.setInt(5,hip);
                st3.setInt(6,mid);
                if(bmi<=18.5){
                    st3.setString(7, diet1);
                }
                if(bmi>18.5&&bmi<25){
                    st3.setString(7, diet2);
                }
                if(bmi>25)
                {
                    st3.setString(7, diet3);
                }
                  
                st3.executeUpdate();
          
            
            
            st3.close();
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

  
                PreparedStatement st3=con.prepareStatement("Update report set age=?, height=?, weight=?, waist=?, hip=? where mId=?");
                st3.setInt(1,age);
                st3.setInt(2,height);
                st3.setInt(3,weight);
                st3.setInt(4,waist);
                st3.setInt(5,hip);
                st3.setInt(6,mid);
                  
                if(st3.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Member Reprot Updated");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Member doesn't exist (hint: Add New)");}
          
            
            
            st3.close();
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

  
                PreparedStatement st3=con.prepareStatement("Delete From report WHERE mId=?");
                
                st3.setInt(1,mid);
                  
                if(st3.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Member Reprot Deleted");
                }
          
            
            
            st3.close();
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

    public void displayReport(int mid)
    {
       
    
}
        
 
    
}
