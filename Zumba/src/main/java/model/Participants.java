package model;

public class Participants {
	
	private int pID;
	private String name;
	private  String email;
	private  String phone;
	private  String gender;
	private  int batchID;
	
	
	public Participants() {
		
	}


	public Participants(int pID, String name, String email, String phone, String gender, int batchID) {
		super();
		this.pID = pID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.batchID = batchID;
	}


	public int getpID() {
		return pID;
	}


	public void setpID(int pID) {
		this.pID = pID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getBatchID() {
		return batchID;
	}


	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	
	@Override
	public String toString() {
		return "Participants [pID=" + pID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + ", batchID=" + batchID + "]";
	}

	
	
	
	
	
}
