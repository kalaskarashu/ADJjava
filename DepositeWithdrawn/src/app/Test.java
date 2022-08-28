package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		double a2=500;
		Account ac1=new Account();
		ac1.setId(1);
		int p=ac1.getId();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		PreparedStatement ps=con.prepareStatement("select * from bank");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			double a1=rs.getDouble(2);
			System.out.println(a1);
			ac1.setAmount(a1);
			ac1.setWithdrawn(500);
			double bal=ac1.getAmount();
			System.out.println("get bal:"+bal);
			PreparedStatement ps1=con.prepareStatement("update bank set amount=? where id=?");
			ps1.setDouble(1,bal);
			ps1.setInt(2, p);
			int r=ps1.executeUpdate();
			if(r==1)
			{
				System.out.println("Updated sucessufffy");
			}
			
		}
		else
		{
			System.out.println("adad");
		}
		
	}

}
