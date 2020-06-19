import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { JobService } from 'src/app/services/job.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {
  @ViewChild('add') addDialog: TemplateRef<any>;
  public jobs: any[];
  public title;
  public description;
  public minWage;
  public maxWage;


  constructor(private jobService: JobService, private matDialog: MatDialog) { }

  ngOnInit(): void {
    this.jobService.fetchJobs().subscribe(jobs => {
      console.log(jobs);
      this.jobs = jobs;
    })
  }

  openJobDialog(){
    this.matDialog.open(this.addDialog);
  }

  addJob(){
    const newJob = {
      id: null,
      title: this.title,
      description: this.description,
      minWage: Number(this.minWage),
      maxWage: Number(this.maxWage)
    }

    this.jobService.postJob(newJob).subscribe(job => {
      this.jobs.push(job);
      this.matDialog.closeAll();
    })
  }

}
