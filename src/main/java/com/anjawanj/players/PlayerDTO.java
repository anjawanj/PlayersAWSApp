package com.anjawanj.players;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerDTO{

  private String firstName;
  private String lastName;
  private String country ;
  private String role;
  private String teams;
  private LocalDate birthDate;
  private Integer status;

}