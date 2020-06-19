import { Component, OnInit } from '@angular/core';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrls: ['./job-listing.component.css']
})
export class JobListingComponent implements OnInit {
  public jobs:any[];
  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.jobService.fetchJobs().subscribe(jobs => {
      this.jobs = jobs;
    })
  }

}
