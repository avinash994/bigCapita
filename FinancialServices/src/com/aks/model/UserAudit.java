package com.aks.model;

public class UserAudit {
	private String companyId;
	private String companyName;
	private String Address;
	private int budget;
	private String auditNature;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getAuditNature() {
		return auditNature;
	}
	public void setAuditNature(String auditNature) {
		this.auditNature = auditNature;
	}
	public UserAudit(String companyId, String companyName, String address,
			int budget, String auditNature) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		Address = address;
		this.budget = budget;
		this.auditNature = auditNature;
	}
	public UserAudit() {
		super();
		// TODO Auto-generated constructor stub
	}
}
