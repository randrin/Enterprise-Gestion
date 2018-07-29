import {Customer} from '../models/customer';
import {DataService} from '../services/data.service';
import {DEPARTMENT} from '../models/department';
import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  employee: Customer = {
    id: null,
    lastName: null,
    firstName: null,
    dateOfBorn: null,
    phoneNumber: null,
    naissance: null,
    email: null,
    department: null,
    matricule: null,
    isActive: false,
    gender: null,
    contactPreference: null,
  };

  departments = DEPARTMENT;
  submitted = false;

  constructor(private dataService: DataService, private location: Location) {}

  ngOnInit() {
  }

  saveEmployee(employee: Customer): void {
    this.submitted = true;
    this.dataService.createCustomer(employee);
  }

  onSubmit() {
    this.submitted = true;
    this.saveCustomer();
  }

  private saveCustomer(): void {
    this.dataService.createCustomer(this.employee);
  }

  goBack(): void {
    window.location.replace('');
  }

  addNewCustomer() {
    this.submitted = false;
    this.employee = new Customer;
  }
}
