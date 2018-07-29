import { Customer } from '../models/customer';
import { DataService } from '../services/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer[];
  selectedCustomer: Customer;
  
  constructor(private dataService: DataService) { }

  getCustomers() {
    this.dataService.getCustomers().then(customers => this.customers = customers);
  }
  
  ngOnInit() {
    this.getCustomers();
  }

  onSelect(cust: Customer): void {
    this.selectedCustomer = cust;
  }
}
