package com.anjawanj.players;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="players")
public class Player {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
  @GenericGenerator(name = "native",strategy = "native")
  private Long id;
  private String firstName;
  private String lastName;
  private String country ;
  private String role;
  private String teams;
  private Date birthDate;
  private Integer status;

}