package br.com.tela.cadastro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedStoredProcedureQuery(
    name = "sp_login_usuario",
    procedureName = "sp_login_usuario",
    parameters = {
        @StoredProcedureParameter(name = "p_email", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "p_senha", mode = ParameterMode.IN, type = String.class)
    }
    )
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "tipo_cliente", length = 50, nullable = false)
    private String tipoCliente;
    
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 50, nullable = false, unique = true)
    private String cpf;
    
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
    
    @Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeCompleto) {
		this.nome = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	    
}
