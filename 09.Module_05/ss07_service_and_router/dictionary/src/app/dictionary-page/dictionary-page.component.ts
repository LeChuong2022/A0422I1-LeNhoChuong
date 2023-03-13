import {Component, OnInit} from '@angular/core';
import {Dictionary} from "../model/dictionary";
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  dictionary: Dictionary | undefined;
  dictionarys: Dictionary[] | undefined;

  //DI
  pr

  constructor(private _dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.dictionarys = this._dictionaryService.getAllDictionary();
  }

  showDetail(item: Dictionary){

  }

}
