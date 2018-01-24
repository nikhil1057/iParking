package com.employee.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.employee.client.GreetingService;
import com.employee.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Connection con;
	Statement st;
	ResultSet rs;

	public Connection graph() {
		try {
			Class.forName("org.neo4j.jdbc.Driver");
			return DriverManager.getConnection("jdbc:neo4j://localhost:7474", "neo4j", "wanrltw");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String signup(String s1, String s2, String s3, String s4, String s5) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String query = "";
		int i = 0, j = 0, k = 0;
		try {
			con = graph();
			System.out.println(con);
			st = con.createStatement();
			Validations vv = new Validations();
			i = vv.validateEmailAddress(s2);
			j = vv.validateMobileNumber(s3);
			k = vv.validatePassword(s4, s5);
			if (i == 0 && j == 0 && k == 0) {
				query = "CREATE(n:signup{name:'" + s1 + "',email:'" + s2 + "',phone:" + s3 + ",password:'" + s4
						+ "'}) ";
				System.out.println(query);
				st.executeQuery(query.toLowerCase());
			} else if (i == 1 || j == 1 || k == 1) {
				return "Data Incorrect";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "Signed In";
	}

	@Override
	public String singin(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		con = graph();
		String s = "Login Failed";
		System.out.println(con);
		try {
			st = con.createStatement();
			String query = "MATCH (n:signup)" + "WHERE n.email='" + s1 + "'and n.password='" + s2 + "'"
					+ "RETURN n.email,n.password";
			System.out.println(query);
			rs = st.executeQuery(query.toLowerCase());
			if (rs.next()) {
				s = "Logged In";
			} else
				s = "Email Or Password Incorrect";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return s;
	}

	@Override
	public String val(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String s = "hi";

		con = graph();
		System.out.println(con);
		try {
			st = con.createStatement();
			String query = "MATCH(c:area) WHERE c.uid = '" + s1 + "' SET c.token = '"+ s2 +"'";
			System.out.println(query);
		 st.executeQuery(query.toLowerCase());
				s = "Token updated";
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return s;
	}


	@Override
	public String rec(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		// TODO Auto-generated method stub
		con = graph();
		String k="Fields are not inserted";
		System.out.println(con);
		try {
			Statement stmt = con.createStatement();
			String query = "CREATE(n:area{add1:'" + s1 + "',add2:'" + s2 + "',area:'"
					+ s3 + "',landmark:'"+ s4 +"',city:'"+ s5 +"',pincode:'" + s6 +"',name:'"+ s7 +"',uid:'" + s8 +"',token:0})";
			System.out.println(query);
			stmt.executeQuery(query.toLowerCase());
			
		} catch (Exception e) {
			e.printStackTrace();
			return k;
		}
		return "Thank you For Registration";
	}
}
