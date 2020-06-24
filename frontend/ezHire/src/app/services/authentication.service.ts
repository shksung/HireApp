import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map, first } from 'rxjs/operators';
import { User } from '../constants/user';
import { Constants } from '../constants/constants';



@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
        const loginUser = {
            id: null,
            userName: username, 
            passWord: password,
            role: null, 
            name: null
        }
        const url = Constants.baseUrl + '/login';
        return this.http.post<any>(url, loginUser)
        .pipe(map(user => {
            if (user) {
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
            }

            return user;
        }));
    }

    logout() {
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }

    loginHttp (userName, passWord): Observable<any> {
        const loginUser = {
            id: null,
            userName: userName, 
            passWord: passWord,
            role: null, 
            name: null
        }
        const url = Constants.baseUrl + '/login';
        return this.http.post(url, loginUser)
    }
}