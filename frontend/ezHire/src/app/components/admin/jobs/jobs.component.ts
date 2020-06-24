import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { JobService } from 'src/app/services/job.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.scss']
})
export class JobsComponent implements OnInit {
  @ViewChild('add') addDialog: TemplateRef<any>;
  @ViewChild('edit') editDialog: TemplateRef<any>;
  public jobs: any[];
  public title;
  public description;
  public minWage;
  public maxWage;

  public eid;
  public etitle;
  public edescription;
  public eminWage;
  public emaxWage;


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

  openEditDialog(job){
    this.eid = job.id;
    this.edescription = job.description;
    this.etitle = job.title;
    this.emaxWage = job.maxWage;
    this.eminWage = job.minWage;

    this.matDialog.open(this.editDialog);
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

  deleteJob(id){
    this.jobService.deleteJob(id).subscribe();
    this.jobs = this.jobs.filter(job => job.id != id);
  }

  editJob(){
    const editedJob = {
      id: this.eid,
      title: this.etitle,
      description: this.edescription,
      minWage: Number(this.eminWage),
      maxWage: Number(this.emaxWage)
    }

    this.jobService.editJob(editedJob).subscribe(jobs => {
      this.jobs = jobs;
      this.matDialog.closeAll();
    })
  }



}
