package com.eventosapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Convidado {
	
	@Id
	private String rg;
	private String nomeconvidado;
	
	@ManyToOne
	private Evento evento;
	
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeconvidado() {
		return nomeconvidado;
	}
	public void setNomeconvidado(String nomeconvidado) {
		this.nomeconvidado = nomeconvidado;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
