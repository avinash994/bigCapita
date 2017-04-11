package com.aks.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aks.model.UserAccount;
import com.aks.model.UserAccounting;
import com.aks.model.UserAudit;
import com.aks.model.UserBusinessRisk;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

		String sql = "Select a.COMPANY_ID, a.COMPANY_PASSWORD from AKS_LOGIN a where a.COMPANY_ID = ? and a.COMPANY_PASSWORD= ?";
		System.out.println("findUser : "+userName+" "+password);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		System.out.println(pstm);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			System.out.println(rs.getString("COMPANY_ID"));
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.COMPANY_ID, a.COMPANY_PASSWORD from AKS_LOGIN a " + " where a.COMPANY_ID = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("COMPANY_PASSWORD");
//			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
//			user.setGender(gender);
			return user;
		}
		return null;
	}

	/*public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}
*/
/*	public static UserAudit findAuditdetail(Connection conn, String CompanyId) throws SQLException {
		String sql = "Select a.COMPANY_ID, a.COMPANY_NAME, a.REGISTERED_OFFICE_ADDRESS,a.BUDGET,a.NATURE_OF_AUDIT from AKS_AUDIT a where a.COMPANY_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, CompanyId);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String companyId = rs.getString("companyId");
			String CompanyName = rs.getString("companyName");
			String address=rs.getString("Address");
			int budget=rs.getInt("budget");
			String natureAudit=rs.getString("auditNature");
			UserAudit detail = new UserAudit(companyId,CompanyName,address,budget,natureAudit);
			return detail;
		}
		return null;
	}*/

	public static void updateAudit(Connection conn, UserAudit detail) throws SQLException {
		String sql = "Update AKS_AUDIT set COMPANY_NAME =?, REGISTERED_OFFICE_ADDRESS=?,BUDGET=?,NATURE_OF_AUDIT=? where COMPANY_ID=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		System.out.println("CompanyId "+detail.getCompanyId()+" Company Address: "+detail.getAddress());
		pstm.setString(5, detail.getCompanyId());
		pstm.setString(1, detail.getCompanyName());
		pstm.setString(2, detail.getAddress());
		pstm.setInt(3, detail.getBudget());
		pstm.setString(4, detail.getAuditNature());
		pstm.executeUpdate();
	}
	public static void updateAccounting(Connection conn, UserAccounting detail) throws SQLException {
		String sql = "Update AKS_ACCOUNTING set COMPANY_NAME =?, NO_OF_ACCOUNTANT_REQUIRED=?,DEPARTMENT_WORK=?,QUALIFICATION_REQUIRED=?,WORK_EXPERIENCE=? where COMPANY_ID=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(6, detail.getCompanyId());
		pstm.setString(1, detail.getCompanyName());
		pstm.setInt(2, detail.getNoOfAccountant());
		pstm.setString(3, detail.getDepartment());
		pstm.setString(4, detail.getQualification());
		pstm.setString(5, detail.getWorkExperience());
		pstm.executeUpdate();
	}
	public static void updateBusinessRisk(Connection conn, UserBusinessRisk detail) throws SQLException {
		String sql = "Update AKS_BUSINESS_RISK set COMPANY_NAME =?, ADVISORY_TYPES=?,BUDGET=?,TIME_PERIOD=?,PRODUCT_LINE=? where COMPANY_ID=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(6, detail.getCompanyId());
		pstm.setString(1, detail.getCompanyName());
		pstm.setString(2, detail.getAdvisoryType());
		pstm.setInt(3, detail.getBudget());
		pstm.setInt(4, detail.getTimePeriod());
		pstm.setString(5, detail.getProductLine());
		pstm.executeUpdate();
	}

	public static void insertUser(Connection conn, UserAccount account) throws SQLException {
		String sql = "Insert into AKS_LOGIN(COMPANY_ID,COMPANY_NAME,COMPANY_PASSWORD,PHONE) values (?,?,?,?)";
		System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, account.getUserName());
		pstm.setString(2, account.getCompanyName());
		pstm.setString(3, account.getPassword());
		pstm.setLong(4, account.getPhone());

		pstm.executeUpdate();
	}
	
	public static void insertAuditDetails(Connection conn, UserAudit details) throws SQLException {
		String sql = "Insert into AKS_AUDIT(COMPANY_ID,COMPANY_NAME,REGISTERED_OFFICE_ADDRESS,BUDGET,NATURE_OF_AUDIT) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, details.getCompanyId());
		pstm.setString(2, details.getCompanyName());
		pstm.setString(3, details.getAddress());
		pstm.setInt(4, details.getBudget());
		pstm.setString(5, details.getAuditNature());

		pstm.executeUpdate();
	}
	public static void insertAccountingDetails(Connection conn, UserAccounting details) throws SQLException {
		String sql = "Insert into AKS_ACCOUNTING(COMPANY_ID,COMPANY_NAME,NO_OF_ACCOUNTANT_REQUIRED,DEPARTMENT_WORK,QUALIFICATION_REQUIRED,WORK_EXPERIENCE) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, details.getCompanyId());
		pstm.setString(2, details.getCompanyName());
		pstm.setInt(3, details.getNoOfAccountant());
		pstm.setString(4, details.getDepartment());
		pstm.setString(5, details.getQualification());
		pstm.setString(6, details.getWorkExperience());

		pstm.executeUpdate();
	}
	
	public static void insertBusinessRiskDetails(Connection conn, UserBusinessRisk details) throws SQLException {
		String sql = "  INSERT INTO AKS_BUSINESS_RISK (COMPANY_ID, COMPANY_NAME, ADVISORY_TYPES, BUDGET, TIME_PERIOD, PRODUCT_LINE) VALUES (?,?,?,?,?,?)";
		
		System.out.println(sql);
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, details.getCompanyId());
		pstm.setString(2, details.getCompanyName());
		pstm.setString(3, details.getAdvisoryType());
		pstm.setInt(4, details.getBudget());
		pstm.setInt(5, details.getTimePeriod());
		pstm.setString(6, details.getProductLine());

		pstm.executeUpdate();
	}
/*
	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}
*/

	

	
}