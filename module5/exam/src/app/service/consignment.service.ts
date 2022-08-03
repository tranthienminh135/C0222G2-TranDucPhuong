import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Consignment} from '../../model/consignment';

let headers = new Headers();
headers.append('Content-Type', 'application/json');
headers.append('authentication', `${localStorage.getItem("token")}`);

@Injectable({
  providedIn: 'root'
})
export class ConsignmentService {
  private URL_CONSIGNMENT = "http://localhost:8080/rest/consignment";

  constructor(private httpClient: HttpClient) { }

  findAllConsignment(page: number): Observable<Consignment[]> {
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGNMENT + "/page?page=" + page);
  }

  deleteConsignment(id: number): Observable<Consignment> {
    return this.httpClient.delete(this.URL_CONSIGNMENT + "/delete/" + id);
  }

  createConsignment(consignment: Consignment): Observable<Consignment> {
    return this.httpClient.post(this.URL_CONSIGNMENT + "/create", consignment, { headers: new HttpHeaders({'json': localStorage.getItem("token")}) });
  }

  searchConsignment(searchObj: any): Observable<Consignment[]> {
    let dateEndSearch = searchObj.dateEndSearch;
    let nameSearch = searchObj.nameSearch;
    let dateInStart = searchObj.startDate;
    let dateInEnd = searchObj.endDate;
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGNMENT + "/page" + "?dateInStartSearch=" + dateInStart + "&dateInEndSearch=" + dateInEnd + "&productNameSearch=" + nameSearch + "&endDateSearch=" + dateEndSearch);
  }

  findById(idEdit: number): Observable<Consignment> {
    return this.httpClient.get(this.URL_CONSIGNMENT + "/find/" + idEdit);
  }

  update(consignment: Consignment): Observable<Consignment> {
    return this.httpClient.patch(this.URL_CONSIGNMENT + "/update", consignment);
  }
}
