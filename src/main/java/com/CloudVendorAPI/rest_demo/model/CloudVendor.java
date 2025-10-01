package com.CloudVendorAPI.rest_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cloud_vendor_info") // This annotation is optional if the table name matches the class name.
// no need for the above Table annotation unless you want to specify table name. By default, it takes class name as table name.
// @Table(name = "cloud_vendors") // Example of specifying a custom table name
public class CloudVendor {
    
    @Id
    private String vendorName; //in the mysql table, it will be called vendor_name
    private String vendorId;
    private String vendorAddress;
    private String vendorPhoneNumber;
    
    public CloudVendor() {
    }

    public CloudVendor(String vendorName, String vendorId, String vendorAddress, String vendorPhoneNumber) {
        this.vendorName = vendorName;
        this.vendorId = vendorId;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }
}
