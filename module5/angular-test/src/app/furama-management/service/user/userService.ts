import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private userService:HttpClient) {
  }

  getData() {
    let url = 'https://jsonplaceholder.typicode.com/todos';
    return this.userService.get(url);
  }

}
