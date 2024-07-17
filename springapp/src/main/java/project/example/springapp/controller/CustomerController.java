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