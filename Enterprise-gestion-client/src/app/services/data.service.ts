import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import {Customer} from '../models/customer';

@Injectable()
export class DataService {

  private customerUrl = 'customer';
  private headers = new Headers({'Content-Type': 'application/json'});
  
  constructor(private http: Http) { }

  //Get All customers
  getCustomers(): Promise<Customer[]> {
    return this.http.get(this.customerUrl)
    .toPromise()
    .then(response => response.json() as Customer[])
    .catch(this.errorHandle);
  }
  
  //Get customers by lastName
  getCustomersByLastName(lastname: string): Promise<Customer[]> {
    const url = 'findbylastname/${lastname}';
    return this.http.get(url)
    .toPromise()
    .then(response => response.json() as Customer)
    .catch(this.errorHandle);
  }
  
  //Create customer
  createCustomer(customer: Customer): Promise<Customer> {
    return this.http.post('postcustomer', JSON.stringify(customer), {headers : this.headers})
    .toPromise()
    .then(response => response.json() as Customer)
    .catch(this.errorHandle);
  }
  
  //Delete Customer
  deleteCustomer(id: number): Promise<void> {
    const url = 'deletecustomer/${id}';
    return this.http.delete(url, {headers : this.headers})
    .toPromise()
    .then(() => null)
    .catch(this.errorHandle);
  }
  
  //Handling Errors
  errorHandle(error: any): Promise<any> {
    console.log('Error', error);
    return Promise.reject(error.message || error);
  }
}
