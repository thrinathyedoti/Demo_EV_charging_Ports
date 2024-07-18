package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.springapp.model.Customer;
import project.example.springapp.service.CustomerServices;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerServices customerService;

    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "Successfully Registered, "+customer.getCustomername();
    }

    @GetMapping("allcustomers")
    public List<Customer> allCustomer(){
        return customerService.customerList();
    }
    @RequestMapping("/getcustomerbyid/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }
    @GetMapping("getcustomerbystate/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state){
        return customerService.getCustomerByState(state);
    }
    @RequestMapping("getcustomerbyname/{name}")
    public Customer getCustomerByCustomerName(@PathVariable String name){
        return customerService.getCustomerByCustomerName(name);
    }
    @GetMapping("filtercustomersc")
    public List<Customer> customerFilter1(@RequestParam(required = false, defaultValue = "Andhra Pradesh") String state, @RequestParam(required = false, defaultValue = "Tirupati") String city){
        return customerService.filterCustomer1(state, city);
    }

    @GetMapping("filtercustomersca")
    public List<Customer> customerFilter2(@RequestParam(required = false, defaultValue = "Andhra Pradesh") String state, @RequestParam(required = false, defaultValue = "Tirupati") String city,@RequestParam(required = false, defaultValue = "Balaji Nagar") String area){
    return customerService.filterCustomer2(state, city, area);
    }

    @PutMapping("/updatecustomer")
    public String updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return "Updated Successfully";
    }

    @DeleteMapping("/deletecustomer/{staId}")
    public String deleteCustomer(@PathVariable("staId") int customerId){
        customerService.deleteCustomer(customerId);
        return "deleted Succesfully...";
    }

//    @DeleteMapping("{cusId}/deleteorder/{proId}")
//    public String deleteorder(@PathVariable int cusId,@PathVariable int proId){
//    customerService.deleteorder(cusId,proId);
//        return "Order Deleted Successfully";
//    }
//
//    @PutMapping("{cusId}/order/{proId}")
//    public String addorder(@PathVariable int cusId,@PathVariable int proId){
//        customerService.addorder(cusId,proId);
//        return "Ordered Successfully";
//    }

}