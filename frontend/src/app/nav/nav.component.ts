import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  loaded : boolean ;

  constructor() { }

  ngOnInit() {
    this.loaded = true
  }

}
