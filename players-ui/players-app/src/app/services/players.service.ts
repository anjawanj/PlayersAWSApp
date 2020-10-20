import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from 'src/app/model/player';
import { Observable } from 'rxjs/internal/Observable';

@Injectable()
export class PlayersService {

    constructor(private httpclient: HttpClient) { }

    getAllPlayers(): Observable<any> {
        return this.httpclient.get<any>('http://localhost:8080/api/v1/players');
    }

    addPlayer(player:Player): Observable<any> {
        return this.httpclient.post<any>('http://localhost:8080/api/v1/players', player);
    }

}
