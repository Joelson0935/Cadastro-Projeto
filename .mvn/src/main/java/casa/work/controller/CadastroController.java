package casa.work.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import casa.work.domain.Cadastro;
import casa.work.domain.CadastroDto;
import casa.work.domain.service.CadastroService;

@RestController
@RequestMapping("/Cadastros")
public class CadastroController {

	@Autowired
	private CadastroService servico;

	@PostMapping
	public ResponseEntity<Cadastro> salvar(@Valid @RequestBody Cadastro cadastro) {
		cadastro = servico.salvar(cadastro);
		return new ResponseEntity<Cadastro>(cadastro, HttpStatus.CREATED);
	}

	@PutMapping("/Atualizar/{cadastroId}")
	public ResponseEntity<Cadastro> atualizar(@Valid @PathVariable Long cadastroId, @RequestBody Cadastro cadastro) {
		Cadastro cad = servico.buscarPorId(cadastroId);
		if (cad != null) {
			cadastro.setId(cadastroId);
			cad = servico.salvar(cadastro);
			return ResponseEntity.ok(cad);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/Todos")
	public ResponseEntity<Page<CadastroDto>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		Page<Cadastro> cadastros = servico.buscar(pageable);
		Page<CadastroDto> cadastrosDto = cadastros.map(cad -> new CadastroDto(cad));
		if (cadastrosDto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cadastrosDto);
	}
	
	@GetMapping("/Tudo")
	public ResponseEntity<List<CadastroDto>> buscarTudo() {
		List<Cadastro> cadastros2 = servico.buscaTudo();
		List<CadastroDto> cadastroDto2 = cadastros2.stream().map(cad2 -> new CadastroDto(cad2))
				.collect(Collectors.toList());
		return ResponseEntity.ok(cadastroDto2);
	}

	@GetMapping("/Nomes")
	public ResponseEntity<List<Cadastro>> buscarPorNome(@RequestParam(name = "nome") String nome) {
		List<Cadastro> cadastros = servico.buscaPorNome(nome);
		return new ResponseEntity<List<Cadastro>>(cadastros, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Cadastro> buscarPorId(@RequestParam(name = "id") Long id) {
		Cadastro cadastro = servico.buscarPorId(id);
		if (cadastro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cadastro);
	}

	@DeleteMapping("/Delete")
	public ResponseEntity<Void> deletar(@RequestParam(name = "deleteId") Long deleteId) {
		Cadastro cadastro = servico.buscarPorId(deleteId);
		if (cadastro == null) {
			return ResponseEntity.notFound().build();
		}
		servico.deletar(deleteId);
		return ResponseEntity.noContent().build();
	}
}
