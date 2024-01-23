package com.vendormanagement.model;

public class Vendor
{
    private int vendor_id;
    private String vendor_name;
    private int bank_accno;
    private String bank_name;
    private String addressline;
    private String city;
    private String country;
    private int zipcode;
	/**
	 * @param vendor_id
	 * @param vendor_name
	 * @param bank_accno
	 * @param bank_name
	 * @param addressline
	 * @param city
	 * @param country
	 * @param zipcode
	 */
    public Vendor()
    {
    	
    }
	public Vendor(int vendor_id, String vendor_name, int bank_accno, String bank_name, String addressline, String city,
			String country, int zipcode) {
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.bank_accno = bank_accno;
		this.bank_name = bank_name;
		this.addressline = addressline;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}
	public Vendor(String vendor_name, int bank_accno, String bank_name, String addressline, String city,
			String country, int zipcode) {
		this.vendor_name = vendor_name;
		this.bank_accno = bank_accno;
		this.bank_name = bank_name;
		this.addressline = addressline;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}
	public Vendor(int vendor_id)
	{
		this.vendor_id=vendor_id;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public int getBank_accno() {
		return bank_accno;
	}
	public void setBank_accno(int bank_accno) {
		this.bank_accno = bank_accno;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAddressline() {
		return addressline;
	}
	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
    
}
