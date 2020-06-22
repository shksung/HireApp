import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  fetchResume(){
    var user = JSON.parse(localStorage.getItem('currentUser'));
    const url = Constants.baseUrl + Constants.Urls.fetchResume.replace(':userId', user.id)
    return this.http.get(url);
  }

  saveResume(resume){
    var user = JSON.parse(localStorage.getItem('currentUser'));
    const url = Constants.baseUrl + Constants.Urls.saveResume.replace(':userId', user.id)
    return this.http.post(url, resume);
  }


   applyForJob(jobId){
    var user = JSON.parse(localStorage.getItem('currentUser'));
    const url = Constants.baseUrl + Constants.Urls.submitResumeForJob.replace(':jobId', jobId).replace(':userId', user.id);
    return this.http.get(url);

  }

  fetchAppliedJobs(){
    var user = JSON.parse(localStorage.getItem('currentUser'));
    const url = Constants.baseUrl + Constants.Urls.fetchAppliedJobs.replace(':userId', user.id);
    return this.http.get(url);
  }
}
