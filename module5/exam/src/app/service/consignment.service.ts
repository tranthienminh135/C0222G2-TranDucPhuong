import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Consignment} from '../../model/consignment';

@Injectable({
  providedIn: 'root'
})
export class ConsignmentService {
  private URL_CONSIGNMENT = "http://localhost:3000/consignment";

  constructor(private httpClient: HttpClient) { }

  findAllConsignment(): Observable<Consignment[]> {
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGNMENT);
  }

  deleteConsignment(id: number): Observable<Consignment> {
    return this.httpClient.delete(this.URL_CONSIGNMENT + "/" + id);
  }

  saveConsignment(consignment: Consignment): Observable<Consignment> {
    return this.httpClient.post(this.URL_CONSIGNMENT, consignment);
  }

  searchConsignment(searchObj: any): Observable<Consignment[]> {
    let dateEndSearch = searchObj.dateEndSearch;
    let nameSearch = searchObj.nameSearch;
    let dateInStart = searchObj.startDate;
    let dateInEnd = searchObj.endDate;
    if (nameSearch == null) {
      nameSearch = '';
    }
    if (dateEndSearch == null) {
      dateEndSearch = '';
    }
    if (dateInStart == null) {
      dateInStart = '0001-01-01';
    }
    if (dateInEnd == null) {
      dateInEnd = '8000-01-01';
    }
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGNMENT + "?dateIn_gte=" + dateInStart + "&dateIn_lte=" + dateInEnd + "&product.name_like=" + nameSearch + "&dateEnd_like=" + dateEndSearch);
  }
}
