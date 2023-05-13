package br.com.amigoscode.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	
	private String country;
	private String city;
	private String postCode;
	
	public Address(String country, String city, String postCode) {
		super();
		this.country = country;
		this.city = city;
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", postCode=" + postCode + "]";
	}
	
}
