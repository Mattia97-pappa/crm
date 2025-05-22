package com.example.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="operatore")
public class Operatore {
    

@Id    
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
private String nome;
private String cognome;
private String username;
private String password;
private String ruolo;


public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getCognome() {
    return cognome;
}
public void setCognome(String cognome) {
    this.cognome = cognome;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getRuolo() {
    return ruolo;
}
public void setRuolo(String ruolo) {
    this.ruolo = ruolo;
}
public Object withDefaultPasswordEncoder() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'withDefaultPasswordEncoder'");
}





}
