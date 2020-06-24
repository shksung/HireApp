import { Component, OnInit } from '@angular/core';
import { JobService } from 'src/app/services/job.service';
import { UserService } from 'src/app/services/user.service';
import { CandidateEditorComponent } from './candidate-editor/candidate-editor.component';
import { GridOptions } from 'ag-grid-community';

@Component({
  selector: 'app-candidate-listing',
  templateUrl: './candidate-listing.component.html',
  styleUrls: ['./candidate-listing.component.css']
})
export class CandidateListingComponent implements OnInit {
  private gridApi;
  private gridColumnApi;
  public gridOptions;
  public columnDefs;
  public defaultColDef;

  rowData;
  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.jobService.fetchCandidates().subscribe(candidates => {
      console.log(candidates);
      this.rowData = candidates;
    })
   this.columnDefs = [
      {headerName: 'Title', field: 'title' },
      {headerName: 'Candidate Name', field: 'name', editable: false },
      {headerName: 'Review Date', field: 'reviewDate', colId: 'ReviewDate',
      editable: true, //cellEditorFramework: CandidateEditorComponent
    },
      {headerName: 'Initial Status', field: 'initialStatus',editable: true},
      {headerName: 'Phone Screen Date', field: 'phoneScreenDate',editable: true},
      {headerName: 'Phone Screen Outcome', field: 'phoneScreenStatus',editable: true},
      {headerName: 'In Person Date', field: 'inPersonDate',editable: true},
      {headerName: 'Feedback', field: 'feedBack',editable: true},
      {headerName: 'Outcome', field: 'outCome', editable: true},
  ];
  // this.defaultColDef = {
  //   editable: true,
  //   sortable: true,
  //   flex: 1,
  //   minWidth: 100,
  //   filter: true,
  //   resizable: true,
  // };
  this.gridOptions =  <GridOptions>{
    enableSorting: true,
    // enable filtering 
    enableFilter: true
  };
  this.gridOptions.editType='fullRow';
  }

  onGridReady(params){
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }

  onSave(){
    this.gridApi.stopEditing();
    console.log(this.rowData);
  }
}
