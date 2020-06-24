import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-end-user',
  templateUrl: './end-user.component.html',
  styleUrls: ['./end-user.component.scss']
})
export class EndUserComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
