import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { EndUserComponent } from './components/end-user/end-user.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomMaterialModule } from './custom-material.module';
import { JobsComponent } from './components/admin/jobs/jobs.component';
import { JobService } from './services/job.service';
import { HttpClientModule } from '@angular/common/http';
import { UserHeaderComponent } from './components/user-header/user-header.component';
import { JobListingComponent } from './components/end-user/job-listing/job-listing.component';
import { ResumeComponent } from './components/end-user/resume/resume.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    EndUserComponent,
    LoginComponent,
    HeaderComponent,
    JobsComponent,
    UserHeaderComponent,
    JobListingComponent,
    ResumeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    CustomMaterialModule
  ],
  providers: [JobService],
  bootstrap: [AppComponent]
})
export class AppModule { }
