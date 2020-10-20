package com.anjawanj.players;


import java.util.List;

public interface PlayerService {

  Player addPlayer(PlayerDTO playerDTO);

  List<Player> getAllPlayers();

}
