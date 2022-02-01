package casa.work.controller.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Erro> objectoNaoEncontrado(RuntimeException e, HttpServletRequest request) {
		Erro erro = new Erro("Objeto não encontrado", HttpStatus.NOT_FOUND.value(), LocalDate.now());
		return new ResponseEntity<Erro>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroCampos> argumentoNaoValido(MethodArgumentNotValidException e, HttpServletRequest request){
		ErroCampos erroCampos = new ErroCampos("Argumento não validado", HttpStatus.BAD_REQUEST.value(), LocalDate.now());
		for(FieldError field : e.getBindingResult().getFieldErrors()){
			erroCampos.setCampos(field.getField(), field.getDefaultMessage());
		}
		return new ResponseEntity<ErroCampos>(erroCampos, HttpStatus.BAD_REQUEST);
	}

}
