import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../modules/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public currentUser: User = this.userService.currentUser;

  constructor(private router: Router, private userService: UserService) {
  }

  ngOnInit() {
  this.router.events.subscribe(evt => {
    if(!(evt instanceof NavigationEnd)){
      return;
    }
    window.scrollTo(0,0)
  })
  }

}
