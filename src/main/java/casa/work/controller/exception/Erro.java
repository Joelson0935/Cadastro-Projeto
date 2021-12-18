package casa.work.controller.exception;

import java.io.Serializable;
import java.time.LocalDate;

public class Erro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;
	private Integer codigo;
	private LocalDate data;

	public Erro() {
		super();
	}

	public Erro(String error, Integer codigo, LocalDate data) {
		super();
		this.error = error;
		this.codigo = codigo;
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
