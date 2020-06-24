import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.scss']
})
export class ResumeComponent implements OnInit {
  @ViewChild('add') addDialog: TemplateRef<any>;
  
  public vendorContact;
  public vendorEmail;
  public experience;
  public vendor;
  public resume;
  public resumeExists: boolean
  public user;


  constructor(private userService: UserService, private matDialog: MatDialog) { }

  ngOnInit(): void {
    this.userService.fetchResume().subscribe(resume => {
      if(resume) {
        this.resumeExists = true;
        this.resume = resume;
      }
    })

    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  saveResume(){
    const resume = {
      id: null,
      vendorContact : this.vendorContact,
      vendorEmail : this.vendorEmail,
      experience: this.experience,
      vendor: this.vendor,
      submissionDate: new Date()
    }

    this.userService.saveResume(resume).subscribe(resume => {
      this.resume = resume;
      this.resumeExists = true;
      this.matDialog.closeAll();
    })
  }

  openResumeDialog(){
    this.matDialog.open(this.addDialog);
  }

}
