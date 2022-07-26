import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from '../model/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private URL_TODO = "http://localhost:3000/todo";
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.URL_TODO);
  }

  successTodo(id: number): Observable<Todo> {
    let todo: Todo = {
      id: id,
      status: false
    }
    return this.httpClient.patch(this.URL_TODO + '/' + id, todo);
  }

  saveTodo(todo: Todo): Observable<Todo> {
    return this.httpClient.post(this.URL_TODO, todo);
  }
}
