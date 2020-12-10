package com.anjawanj.players;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PlayersController {

  private PlayerService playerService;

  public PlayersController(PlayerService playerService){
    this.playerService = playerService;
  }

  @PostMapping(value = "/players")
  public ResponseEntity<Player> test(@RequestBody PlayerDTO playerDTO){
    Player player = playerService.addPlayer(playerDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(player);
  }

  @GetMapping(value = "/players")
  public ResponseEntity<List<Player>> test(){
    List<Player> players = playerService.getAllPlayers();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Cache-Control", "max-age=36000,must-revalidate");
    return ResponseEntity
        .status(HttpStatus.OK)
        .headers(headers)
        .body(players);
  }


}

