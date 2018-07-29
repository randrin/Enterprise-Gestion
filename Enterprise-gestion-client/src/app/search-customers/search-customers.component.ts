import { Customer } from '../models/customer';
import { DataService } from '../services/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-customers',
  templateUrl: './search-customers.component.html',
  styleUrls: ['./search-customers.component.css']
})
export class SearchCustomersComponent implements OnInit {
  
  lastName: string;
  customers: Customer[];
  
  searchCustomers() {
    this.dataService.getCustomersByLastName(this.lastName)
      .then(customers => this.customers = customers);
  }

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.lastName = '';
  }

  onSubmit() {
    this.searchCustomers();
  }
}
