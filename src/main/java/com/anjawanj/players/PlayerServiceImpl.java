package com.anjawanj.players;

import java.util.Collections;
import java.util.List;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  private PlayersRepository playersRepository;
  private MapperFacade mapperFacade;

  public PlayerServiceImpl(PlayersRepository playersRepository,MapperFacade mapperFacade){
    this.playersRepository = playersRepository;
    this.mapperFacade = mapperFacade;
  }

  @Override
  public Player addPlayer(PlayerDTO playerDTO) {
    return playersRepository.save(mapperFacade.map(playerDTO,Player.class));
  }

  @Override
  public List<Player> getAllPlayers() {
    return Collections.unmodifiableList(IterableUtils.toList(playersRepository.findAll()));
  }
}
