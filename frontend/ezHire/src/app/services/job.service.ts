import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { constants } from 'buffer';
import { Constants } from '../constants/constants';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private http: HttpClient) { }

  public fetchJobs() : Observable<any> {
    const url = Constants.baseUrl + Constants.Urls.fetchJobs;
      return this.http.get(url);
  }

  public postJob(newJob): Observable<any> {
    const url = Constants.baseUrl + Constants.Urls.postJob;
    return this.http.post(url, newJob);
  }

}

