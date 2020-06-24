import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ICellEditorAngularComp } from 'ag-grid-angular';
import { ICellEditorParams, IAfterGuiAttachedParams } from 'ag-grid-community';

@Component({
  selector: 'app-candidate-editor',
  templateUrl: './candidate-editor.component.html',
  styleUrls: ['./candidate-editor.component.css']
})
export class CandidateEditorComponent implements ICellEditorAngularComp  {
  params;
  constructor() { }
  // ngAfterViewInit(): void {
  //   throw new Error("Method not implemented.");
  // }
  getValue() {
    throw new Error("Method not implemented.");
  }
  isPopup?(): boolean {
    throw new Error("Method not implemented.");
  }
  getPopupPosition?(): string {
    throw new Error("Method not implemented.");
  }
  isCancelBeforeStart?(): boolean {
    throw new Error("Method not implemented.");
  }
  isCancelAfterEnd?(): boolean {
    throw new Error("Method not implemented.");
  }
  focusIn?(): void {
    throw new Error("Method not implemented.");
  }
  focusOut?(): void {
    throw new Error("Method not implemented.");
  }
  getFrameworkComponentInstance?() {
    throw new Error("Method not implemented.");
  }
  afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
    throw new Error("Method not implemented.");
  }

  ngOnInit(): void {
  }

  agInit(params: any): void {
    this.params = params;
    console.log(params);
    this.params.api.startEditingCell()
  }

}
