// CONTROLLER LAYER - to handle HTTP requests and responses. This layer seamlessly interacts 
// with the service layer and going forward, it will also interact with the repository layer 
package com.CloudVendorAPI.rest_demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.CloudVendorAPI.rest_demo.model.CloudVendor;
import com.CloudVendorAPI.rest_demo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendors")
public class CloudVendorController {

    /*
     Why @Autowired is not used in the constructor here?
     Spring framework 4.3 onwards, if a class has only one constructor, the @Autowired annotation can be omitted
     and Spring will use that constructor for dependency injection automatically.
     */

    //CloudVendor cloudVendor;
    // programming to the interface, we are not creating the object of the implementation class, 
    // i.e. CloudVendorServiceImpl here. We are creating the object of the interface, i.e. CloudVendorService.
    // Spring will automatically inject the object of the implementation class here, i.e. CloudVendor.
    // Why create object of interface? - to achieve loose coupling, flexibility, and easier testing.
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // read specific cloud vendor details from DB:
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        //return new CloudVendor("AWS", vendorId, "Seattle, WA", "123-456-7890");
        //return cloudVendor;
        return cloudVendorService.getCloudVendor(vendorId);
    }

    // read all cloud vendor details from DB:
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        // @RequestBody binds the HTTP request body to a transfer or domain object, enabling 
        // automatic deserialization of the inbound HTTP request body onto a Java object.
        //this.cloudVendor = cloudVendor;
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        //this.cloudVendor = cloudVendor;
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
       // this.cloudVendor = null;
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted successfully";
    }
}

