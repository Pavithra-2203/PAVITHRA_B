package com.hexaware.tbs.task4;

public class Customer {
	
	 private String customerName;
	    private String email;
	    private String phoneNumber;

	    public Customer()
	    {
	    	
	    }

		public Customer(String customerName, String email, String phoneNumber) {
			super();
			this.customerName = customerName;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	    
	    
		public void displayCustomerDetails() 
		{
	        System.out.println("\n--- Customer Details ---");
	        System.out.println("Name: " + customerName);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + phoneNumber);
	    }

}
