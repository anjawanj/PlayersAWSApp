package com.anjawanj.players;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  private PlayersRepository playersRepository;
  private MapperFacade mapperFacade;

  public PlayerServiceImpl(PlayersRepository playersRepository,@Autowired MapperFacade mapperFacade){
    this.playersRepository = playersRepository;
    this.mapperFacade = mapperFacade;
  }

  @Override
  public Player addPlayer(PlayerDTO playerDTO) {
    Player player = mapperFacade.map(playerDTO,Player.class);
    return playersRepository.save(player);
  }

  @Override
  public List<Player> getAllPlayers() {
    Iterable<Player> playerIterator = playersRepository.findAll();
    List<Player> playerList = new ArrayList<>();
    playerIterator.forEach(playerList::add);
    return playerList;
  }
}
