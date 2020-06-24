import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-applied-jobs',
  templateUrl: './applied-jobs.component.html',
  styleUrls: ['./applied-jobs.component.scss']
})
export class AppliedJobsComponent implements OnInit {
  columnDefs = [
    {headerName: 'Title', field: 'title' },
    {headerName: 'Description', field: 'description' },
    {headerName: 'Minimum Wage', field: 'minWage'},
    {headerName: 'Maximum Wage', field: 'maxWage'}
];

  rowData;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.fetchAppliedJobs().subscribe(jobs => {
      if(jobs) {
        this.rowData = jobs;
      }
    })
  }

}
