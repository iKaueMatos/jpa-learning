package model;


import jakarta.persistence.*;
import model.DadosPessoais;
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded // Pegue os atributos da classe Dados Pessoais
	private DadosPessoais dadosPessoais;

	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Cliente() {
	}
	public String getNome() {
		return this.dadosPessoais.getNome(); //Metodo delegate pegando dados da classe dados pessoais
	}

	public String getCpf() {
		return this.dadosPessoais.getCpf(); //Metodo delegate pegando dados da classe dados pessoais
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
