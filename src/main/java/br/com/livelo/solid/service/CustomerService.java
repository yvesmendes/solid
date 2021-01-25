package br.com.livelo.solid.service;

import java.util.Collection;

import br.com.livelo.solid.domain.Customer;
import br.com.livelo.solid.domain.CustomerPJ;
import br.com.livelo.solid.repository.AbstractDAO;

public class CustomerService {

	private AbstractDAO<String,Customer> customers;
	private AbstractDAO<String,CustomerPJ> customersPJ;
	
	private PrintService printService;
	private AccountService accountService;
	
	private CustomerService(AbstractDAO<String, Customer> customers, AbstractDAO<String, CustomerPJ> customersPJ, PrintService printService) {
		this.printService = printService;
		this.customers = customers;
		this.customersPJ = customersPJ;
	}
	
	public void add(Customer customer) {
		this.customers.add(customer.getId(), customer);
	}
	
	public void remove(String id) {
		this.customers.remove(id);
	}
	
	public void print(String id) {
		Customer customer = this.customers.getById(id);
		System.out.println(printService.format(customer));
	}
	
	public void printAll() {
		Collection<Customer> customers = this.customers.getAll();
		Collection<CustomerPJ> customersPJ = this.customersPJ.getAll();
		
		customers.stream().forEach(System.out::println);
		customersPJ.stream().forEach(System.out::println);
	}
}
