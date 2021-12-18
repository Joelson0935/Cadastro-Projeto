package casa.work.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "branco ou nulo não são aceitos")
	@Size(min = 3, message = "mínimo de 3 caracteres")
	private String nome;
	
	private Integer idade;
	@NotBlank(message = "branco ou nulo não são aceitos")
	@Size(min = 8, message = "mínimo de 8 caracteres")
	private String senha;

	public Cadastro() {

	}

	public Cadastro(Long id, String nome, Integer idade, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
	}

	public Cadastro(String nome, Integer idade, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(id, other.id);
	}

}
