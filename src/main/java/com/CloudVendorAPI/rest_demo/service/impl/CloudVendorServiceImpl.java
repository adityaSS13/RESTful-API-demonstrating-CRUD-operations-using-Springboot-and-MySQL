// SERVICE LAYER IMPLEMENTATION
package com.CloudVendorAPI.rest_demo.service.impl;
import com.CloudVendorAPI.rest_demo.repository.CloudVendorRepository;
import com.CloudVendorAPI.rest_demo.service.CloudVendorService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CloudVendorAPI.rest_demo.model.CloudVendor;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    // we need to get the repository instance here to call its methods, as the repository talks to the database
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // more business logic
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // more business logic 
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor updated successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // more business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Cloud Vendor deleted successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // more business logic
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // more business logic
        return cloudVendorRepository.findAll();
    }

}
