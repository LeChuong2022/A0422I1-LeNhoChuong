import {Component, OnInit} from '@angular/core';
import {Dictionary} from "../model/dictionary";
import {ActivatedRoute} from "@angular/router";
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  dictionaryDetail: Dictionary | undefined;

  constructor(
    private _activatedRoute: ActivatedRoute,
    private _dictionaryService: DictionaryService
  ) {
  }

  ngOnInit(): void {
    let dictionaryIndex = this._activatedRoute.snapshot.params['index'];
    this.dictionaryDetail = this._dictionaryService.getDictionaryByIndex(dictionaryIndex);
  }

}
