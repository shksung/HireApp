import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/constants/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
        this.authService.login(this.username, this.password).subscribe(user => {
          if(user.role == 'ADMIN') {
            this.router.navigate(['/admin'])
          } else {
            this.router.navigate(['user'])
          }
        })

    }
  }

