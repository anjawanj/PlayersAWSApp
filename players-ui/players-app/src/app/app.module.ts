import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayersListComponent } from './pages/players/players-list/players-list.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AddPlayerComponent } from './pages/players/add-player/add-player/add-player.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MyDatePickerModule } from 'mydatepicker/dist/my-date-picker.module';
import { PlayersService } from './services/players.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PlayersListComponent,
    DashboardComponent,
    AddPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MyDatePickerModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxDatatableModule           
  ],
  providers: [PlayersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
