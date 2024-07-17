package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Customer;
import project.example.springapp.model.Products;
import project.example.springapp.repository.ProductRepo;
import project.example.springapp.repository.CustomerRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
@Service
public class CustomerServices {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
//
//    ArrayList stations =new ArrayList();
//
//    public CustomerService(){
//        stations.add(new Customer(101,"Indian Oil","DLF, Gachibowli, Hyderabad",3,"9293947519"));
//        stations.add(new Customer(102,"Reliance",",Kukatpalli, Hyderabad",2,"9373286472"));
//        stations.add(new Customer(103,"Bharat Petroleum","Balaji Colony, Tirupati",3,"8762648362"));
//        stations.add(new Customer(104,"HP","marathahalli, Bangalore",3,"6828483622"));
//    }

    public void addCustomer(Customer customer) {
        //stations.add(station);
        customerRepo.save(customer);
    }

    public List<Customer> customerList() {
//       return stations;
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {

//        for (int i = 0; i <=stations.size(); i++) {
//            if (stationsList().get(i).getStation_id() == id) {
//                return stationsList().get(i);
//            }
//        }
//        return null;

        return customerRepo.findById(id).orElse(null);

    }

    public List<Customer> getCustomerByState(String state) {
        return customerRepo.findByState(state);
    }

    public void updateCustomer(Customer customer) {
//        int index=0;
//        for(int i=0;i<stations.size();i++){
//            if(stationsList().get(i).getStation_id()== station.getStation_id()){
//                index=i;
//                stations.set(index,station);
//            }
//        }
        customerRepo.save(customer);

    }

    public void deleteCustomer(int customerId) {
//        int index=0;
//        for(int i=0;i<stations.size();i++){
//            if(stationsList().get(i).getStation_id()==station){
//                index=i;
//            }
//        }
//        stations.remove(index);
        customerRepo.deleteById(customerId);
    }


    public void deleteorder(int proid,int cusid){

//        customerRepo.deleteorderbycustomer(proid,cusid);

//        Set<Products> productsSet;
//        int count=0;
//        Customer customer = customerRepo.findById(cusid).get();
//        productsSet =customer.getProductSet();
//        for(Products product:productsSet){
//           if(product.getProductId()==proid){
//               productsSet.remove(count);
//               customer.setProductSet(productsSet);
//           }
//            count++;
//        }
//        customerRepo.save(customer);
//
//        customerRepo.deleteorderbycustomer();
        }


    public Customer getCustomerByCustomerName(String name) {
        return customerRepo.findByCustomername(name);
    }

//    public void addorder(int cusId, int proId){
//        Customer customer= customerRepo.findById(cusId).get();
//        Products product = productRepo.findById(proId).get();
//        customer.setProductsSet(product);
//        customerRepo.save(customer);
//    }
}

