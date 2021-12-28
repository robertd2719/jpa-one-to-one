package io.robb.jpastuff.jpaonetoone.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class AccountDetails {

    @Id
    Long id;
    String userName;
    String passWord;
}
