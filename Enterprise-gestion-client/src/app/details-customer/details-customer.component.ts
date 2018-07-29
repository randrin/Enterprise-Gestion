import { Customer } from '../models/customer';
import { DataService } from '../services/data.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-customer-details',
  templateUrl: './details-customer.component.html',
  styleUrls: ['./details-customer.component.css']
})
export class DetailsCustomerComponent implements OnInit {

  @Input() customer: Customer;
  
  constructor(private dataService: DataService) { }

  delete(): void {
    this.dataService.deleteCustomer(this.customer.id)
    .then(() => this.goBack());
  }
  
  ngOnInit() {
  }

  goBack(): void {
    window.location.replace('');
  }
}
