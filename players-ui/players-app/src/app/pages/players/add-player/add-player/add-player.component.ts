import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IMyDefaultMonth, IMyDpOptions } from 'mydatepicker';
import { Player } from 'src/app/model/player';
import { PlayersService } from 'src/app/services/players.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  private myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd'
  };
  playerForm : FormGroup; 
  roles: string[] = ['Batsman','Bowler','All-Rounder'];
  statusType: string[] = ['Playing','Retired'];
  placeHolder = 'Select date';
  player: Player;

  public PlayerFormControls = [
    {
      name: 'firstName',
      isRequired: true
    },
    {
      name: 'lastName',
      isRequired: true
    },
    {
      name: 'country',
      isRequired: true
    },
    {
      name: 'role',
      isRequired: true
    },
    {
      name: 'teams',
      isRequired: true
    },
    {
      name: 'birthDate',
      isRequired: true
    },
    {
      name: 'status',
      isRequired: false
    }
  ];


  constructor(private playerService:PlayersService) { }

  ngOnInit() {
    this.playerForm = new FormGroup({});
    this.addControlsToForm(this.playerForm, this.PlayerFormControls);
  }

  addControlsToForm(frmGroup: FormGroup, controlList: any[]) {
    controlList.filter(control => !frmGroup.controls[control.name]).forEach((control) => {
      if (control.isRequired)
        frmGroup.addControl(control.name, new FormControl({ value: '', disabled: control.isDisabled }, Validators.required));

      else
        frmGroup.addControl(control.name, new FormControl({ value: '', disabled: control.isDisabled }));
    });
  }

  proceed() {
    this.player = this.preparePlayerObject();
    this.playerService.addPlayer(this.player).subscribe({
      next: res => console.log(res),
      error: err => console.log(err)
    });
  }

  preparePlayerObject():Player {
    let player = new Player;
    const controls = this.playerForm.controls;
    player.firstName = controls.firstName.value;
    player.lastName = controls.lastName.value;
    player.country = controls.country.value;
    player.role= controls.role.value;
    player.teams = controls.teams.value;
    player.birthDate = controls.birthDate.value.formatted;
    player.status = controls.status.value == 'Playing' ? 1 : 0;
    return player;
  }

}
