import { Component, OnInit } from '@angular/core';
import { JobService } from 'src/app/services/job.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrls: ['./job-listing.component.scss']
})
export class JobListingComponent implements OnInit {
  public jobs:any[];
  public resume;
  public resumeExists;
  constructor(private jobService: JobService, private userService: UserService) { }

  ngOnInit(): void {
    this.jobService.fetchJobs().subscribe(jobs => {
      this.jobs = jobs;
    })
    this.userService.fetchResume().subscribe(resume => {
      if(resume) {
        this.resume = resume;
        this.resumeExists = true;
      }
    });
  }

  applyForJob(jobId) {
    if(this.resumeExists) {
      this.userService.applyForJob(jobId).subscribe(res => {
        alert("Success!")
      })
    } else {
      alert("Error. Please go to resume tab and create a resume")
    }
  }

}
