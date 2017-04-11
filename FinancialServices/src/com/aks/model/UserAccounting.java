package com.aks.model;

public class UserAccounting {
	private String companyId;
	private String companyName;
	private int noOfAccountant;
	private String department;
	private String qualification;
	private String workExperience;
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
	public int getNoOfAccountant() {
		return noOfAccountant;
	}
	public void setNoOfAccountant(int noOFAccountant) {
		this.noOfAccountant = noOfAccountant;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public UserAccounting(String companyId, String companyName,
			int noOfAccountant, String department, String qualification,
			String workExperience) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.noOfAccountant = noOfAccountant;
		this.department = department;
		this.qualification = qualification;
		this.workExperience = workExperience;
	}
	public UserAccounting() {
		super();
		// TODO Auto-generated constructor stub
	}

}
