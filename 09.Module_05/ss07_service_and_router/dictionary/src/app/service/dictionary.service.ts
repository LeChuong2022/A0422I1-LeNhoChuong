import {Injectable} from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  private _dictionarys: Dictionary[] = [
    {englishWord: 'hello', vietnamWord: 'xin chào'},
    {englishWord: 'goodbye', vietnamWord: 'tạm biệt'},
    {englishWord: 'thank you', vietnamWord: 'cảm ơn'},
    {englishWord: 'wake up', vietnamWord: 'thức dậy'},
  ]

  constructor() {
  }

  getAllDictionary(): Dictionary[] {
    return this._dictionarys;
  }

  getDictionaryByIndex(index: number) {
    return this._dictionarys[index];
  }
}
