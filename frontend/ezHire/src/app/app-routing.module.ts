import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { EndUserComponent } from './components/end-user/end-user.component';
import { LoginComponent } from './components/login/login.component';
import { JobsComponent } from './components/admin/jobs/jobs.component';
import { JobListingComponent } from './components/end-user/job-listing/job-listing.component';
import { ResumeComponent } from './components/end-user/resume/resume.component';
import { AppliedJobsComponent } from './components/end-user/applied-jobs/applied-jobs.component';
import { CandidateListingComponent } from './components/admin/candidate-listing/candidate-listing.component';


const routes: Routes = [
  {path:'', component: LoginComponent},
  { path: 'admin', component: AdminComponent, children: [
    {
      path: 'jobs', 
      component: JobsComponent 
    },
    {
      path: 'candidates', 
      component: CandidateListingComponent 
    }
  
  ]},
  { path: 'user', component: EndUserComponent, children: [{
    path:'job-listing', component: JobListingComponent
  }, {path:'resume', component: ResumeComponent}, {path:'applied-jobs', component: AppliedJobsComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
