package com.academiavivere.projetosemana3.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_cashbook")
public class Cashbook implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataLancamento;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private char type;

	@Column(nullable = false)
	private double value;

	@Column(nullable = false)
	private double saldoParcial;

	@ManyToOne
	private Client client;

	public Cashbook() {

	}

	public Cashbook(Integer id, Date dataLancamento, String descricao, char type, double value, Client client) {
		super();
		this.id = id;
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.type = type;
		this.value = value;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cashbook))
			return false;
		Cashbook other = (Cashbook) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cashbook [id=" + id + ", dataLancamento=" + dataLancamento + ", descricao=" + descricao + ", type="
				+ type + ", value=" + value + ", client=" + client + "]";
	}

}
