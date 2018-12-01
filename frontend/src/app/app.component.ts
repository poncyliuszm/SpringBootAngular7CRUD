import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  customers = [];
  customerOrders = [];
  displayedColumns: string[] = ['firstName', 'lastName', 'email'];
  janName: any;


  constructor(private http: HttpClient){

  }

  ngOnInit() {
    this.getCustomers();
  }

  save() {
    let customer = {
      "firstName": "imieTest",
      "secondName": "nazwTEst",
      "email": "email@test"
    };
    this.http.post("http://localhost:8080/customer/save", customer).subscribe((data: any) => {
      console.log("saved");
    })
  }

  updateJan() {
    console.log('update start');
    let janId :number = 1;
    this.http.get("http://localhost:8080/customer/" + janId).subscribe((data: any) => {
      let customer = data;
      customer['firstName'] = this.janName;
      this.http.put("http://localhost:8080/customer/update", customer).subscribe((data: any) => {
        console.log("updated");
        this.getCustomers();
      })
    });
  }

  delete() {
    let customerId = 1;

    this.http.delete("http://localhost:8080/customer/delete/" + customerId).subscribe((data: any) => {
      console.log("deleted");
    })
  }

  getCustomers() {
    this.http.get("http://localhost:8080/customer/list").subscribe((data: any) => {
      this.customers = data;
    });
  }

}


