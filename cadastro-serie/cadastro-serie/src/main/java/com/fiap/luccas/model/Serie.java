package com.fiap.luccas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	private String nomeSerie;
	private String descricaoSerie;
	private String paisSerie;
	private String criadorSerie;
	private String imagePath;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNomeSerie() {
		return nomeSerie;
	}
	public void setNomeSerie(String nomeSerie) {
		this.nomeSerie = nomeSerie;
	}
	public String getDescricaoSerie() {
		return descricaoSerie;
	}
	public void setDescricaoSerie(String descricaoSerie) {
		this.descricaoSerie = descricaoSerie;
	}
	public String getPaisSerie() {
		return paisSerie;
	}
	public void setPaisSerie(String paisSerie) {
		this.paisSerie = paisSerie;
	}
	public String getCriadorSerie() {
		return criadorSerie;
	}
	public void setCriadorSerie(String criadorSerie) {
		this.criadorSerie = criadorSerie;
	}
	@Override
	public String toString() {
		return "Serie [Id=" + Id + ", nomeSerie=" + nomeSerie + ", descricaoSerie=" + descricaoSerie + ", paisSerie="
				+ paisSerie + ", criadorSerie=" + criadorSerie + "]";
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	

}
