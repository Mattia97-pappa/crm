package com.example.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
    

@Id    
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
private String nome;
private String cognome;
private String email;
private String telefono;
private String azienda;

private String citta;
private String settore;
private String note;
private String stato;
   @ManyToOne
    @JoinColumn(name = "operatoreid")
    private Operatore operatore;

public Operatore getOperatore() {
    return operatore;
}
   public void setOperatore(Operatore operatore) {
    this.operatore = operatore;
   }
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
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getTelefono() {
    return telefono;
}
public void setTelefono(String telefono) {
    this.telefono = telefono;
}
public String getAzienda() {
    return azienda;
}
public void setAzienda(String azienda) {
    this.azienda = azienda;
}

public String getCitta() {
    return citta;
}
public void setCitta(String citta) {
    this.citta = citta;
}
public String getSettore() {
    return settore;
}
public void setSettore(String settore) {
    this.settore = settore;
}
public String getNote() {
    return note;
}
public void setNote(String note) {
    this.note = note;
}
public String getStato() {
    return stato;
}
public void setStato(String stato) {
    this.stato = stato;
}



}
