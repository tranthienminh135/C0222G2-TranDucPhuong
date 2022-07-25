import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../service/dictionary.service';
import {Dictionary} from '../model/dictionary';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionary: Dictionary = {
    word: '',
    mean: ''
  };
  dictionaries: Dictionary[] = [];
  constructor(private dictionaryService: DictionaryService) {
    this.dictionaries = this.dictionaryService.findAll();
  }

  ngOnInit(): void {
  }

  translate(value: string) {
    this.dictionary = {};
    value = value.toLowerCase();
    if (this.dictionaries.filter((data) => data.word.toLowerCase() === value)[0] !== undefined) {
      this.dictionary = this.dictionaries.filter((data) => data.word.toLowerCase() === value)[0];
    } else {
      this.dictionary.mean = 'Not found';
    }
  }
}
