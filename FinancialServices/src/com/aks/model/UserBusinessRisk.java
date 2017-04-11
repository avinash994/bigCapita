package com.aks.model;

public class UserBusinessRisk {
	private String companyId;
	private String companyName;
	private String advisoryType;
	private int budget;
	private int timePeriod;
	private String productLine;
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
	public String getAdvisoryType() {
		return advisoryType;
	}
	public void setAdvisoryType(String advisoryType) {
		this.advisoryType = advisoryType;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(int timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public UserBusinessRisk(String companyId, String companyName,
			String advisoryType, int budget, int timePeriod,
			String productLine) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.advisoryType = advisoryType;
		this.budget = budget;
		this.timePeriod = timePeriod;
		this.productLine = productLine;
	}
	public UserBusinessRisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
