package com.apicadastro.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codPessoa;

	private String cpf;
	private String nome;
	private String sexo;
	private String email;
	private String nacionalidade;
	private String naturalidade;
	
	private String datanasc;
	private Date datacad = new Date();
	
	
	
	/*public Pessoa(String cpf, String nome, String sexo, String email, String estado, String pais) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.estado = estado;
		this.pais = pais;
	}*/
	
	public Pessoa() {
	}
	
	public Pessoa(Long codPessoa, String cpf, String nome, String sexo, String email, String nacionalidade, String naturalidade, String datanasc) {
		
		this.codPessoa = codPessoa;
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.datanasc = datanasc;
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDatanasc() {
		return datanasc;
	}
	
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	
	public Date getDatacad() {
		return datacad;
	}
	
	public void setDatacad(Date datacad) {
		this.datacad = datacad;
	}
	
	public Long getCodPessoa() {
		return codPessoa;
	}
	
}
