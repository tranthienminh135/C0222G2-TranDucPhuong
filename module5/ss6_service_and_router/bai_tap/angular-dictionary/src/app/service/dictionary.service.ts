import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries: Dictionary[] = [];
  constructor() {
    this.dictionaries.push({word: 'Hello', mean: 'Xin chao'});
    this.dictionaries.push({word: 'Dog', mean: 'Tài'});
    this.dictionaries.push({word: 'Cat', mean: 'Mèo'});
    this.dictionaries.push({word: 'Rat', mean: 'Chuột'});
  }

  findAll() {
    return this.dictionaries;
  }

  findByWord(word: string) {
    return this.dictionaries.filter(data => data.word === word);
  }
}
