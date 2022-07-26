import { Component, OnInit } from '@angular/core';
import {Todo} from '../model/todo';
import {TodoService} from '../service/todo.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  todoForm: FormGroup;

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.findAll();
    this.todoForm = new FormGroup({
      content: new FormControl()
    })
  }

  findAll() {
    this.todoService.findAll().subscribe(value => {
      this.todos = value;
    });
  }

  successTodo(id: number) {
    this.todoService.successTodo(id).subscribe(value => {
      alert(value.content + ' is done, good job!');
      this.findAll();
    });
  }

  addTodo() {
    let todo: Todo = {
      content: this.todoForm.value.content,
      status: true
    }
    this.todoService.saveTodo(todo).subscribe(value => {
      alert("Add todo success!");
      this.findAll();
      this.todoForm.reset();
    });
  }
}
