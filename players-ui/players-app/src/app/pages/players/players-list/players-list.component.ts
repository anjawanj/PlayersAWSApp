import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { PlayersService } from 'src/app/services/players.service';

@Component({
  selector: 'app-players-list',
  templateUrl: './players-list.component.html',
  styleUrls: ['./players-list.component.scss']
})
export class PlayersListComponent implements OnInit {

  columns:any[];
  rows:any[];
  @ViewChild('dateTpl',{static: false}) dateTpl: TemplateRef<any>;
  @ViewChild('statusTpl',{static: false}) statusTpl: TemplateRef<any>;
  
  constructor(private playerService:PlayersService) { }

  ngOnInit() {
    this.getPlayersListData();
    
  }

  ngAfterViewInit() {
    this.columns=[
      {prop:"firstName", name: "First Name", width:100},
      {prop:"lastName", name: "Last Name", width:100 },
      {prop:"country", name: "Country", width:100},
      {prop:"role", name: "Role", width:100 },
      {prop:"teams", name: "Teams", width:200 },
      {prop:"birthDate", name: "Birth Date", width:100,cellTemplate: this.dateTpl },
      {prop:"status", name: "Status", width:80,cellTemplate: this.statusTpl  }     
  ];
  }

  getPlayersListData(){
    this.playerService.getAllPlayers().subscribe({
      next: res => this.rows = res,
      error: err => console.log(err)
    });
  }

}
