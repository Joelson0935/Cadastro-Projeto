package casa.work.controller.exception;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ErroCampos implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;
	private Integer codigo;
	private LocalDate data;
	private List<Campos> campos = new ArrayList<>();

	public ErroCampos() {
		super();
	}

	public ErroCampos(String error, Integer codigo, LocalDate data) {
		super();
		this.error = error;
		this.codigo = codigo;
		this.data = data;
	}

	public class Campos {
		
		private String fieldName;
		private String fieldError;

		public Campos() {
			super();
		}

		public Campos(String fieldName, String fieldError) {
			super();
			this.fieldName = fieldName;
			this.fieldError = fieldError;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldError() {
			return fieldError;
		}

		public void setFieldError(String fieldError) {
			this.fieldError = fieldError;
		}

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

	public List<Campos> getCampos() {
		return campos;
	}
	
	public void setCampos(String nome, String erro) {
		campos.add(new Campos(nome, erro));
	}
}
