package com.academiavivere.projetosemana3.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataCadastro;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 15, unique = true)
	private String login;

	@Column(nullable = false, length = 10)
	private String password;

	@Column(length = 11)
	private String phone;
	
	@Column(length = 100)
	private String email;

	@Column(nullable = false)
	private char profile;

	@Column(nullable = false)
	private char status;

	public User() {

	}

	public User(Integer id, Date dataCadastro, String name, String login, String password, String phone,
			String email, char profile, char status) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.name = name;
		this.login = login;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.profile = profile;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getProfile() {
		return profile;
	}

	public void setProfile(char profile) {
		this.profile = profile;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
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
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
