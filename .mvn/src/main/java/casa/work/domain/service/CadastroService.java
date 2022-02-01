package casa.work.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import casa.work.domain.Cadastro;
import casa.work.domain.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository repositorio;

	public Cadastro salvar(Cadastro cadastro) {
		cadastro = repositorio.save(cadastro);
		return cadastro;
	}

	public Page<Cadastro> buscar(Pageable pageable) {
		Page<Cadastro> cadastros = repositorio.findAll(pageable);
		return cadastros;
	}

	public List<Cadastro> buscaTudo() {
		List<Cadastro> cadastros2 = repositorio.findAll();
		return cadastros2;
	}

	public Cadastro buscarPorId(Long id) {
		Cadastro cadastro = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado " + id));
		return cadastro;
	}

	@SuppressWarnings("unchecked")
	public List<Cadastro> buscaPorNome(String nome) {
		List<Cadastro> cadastros = repositorio.buscarPorNome(nome);
		if (cadastros == null) {
			return (List<Cadastro>) new RuntimeException("nome não encontrado ");
		}
		return cadastros;
	}

	public Cadastro atualizar(Long id, Cadastro cadastro) {
		cadastro = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado " + id));
		cadastro.setId(id);
		cadastro = repositorio.save(cadastro);
		return cadastro;
	}

	public void deletar(Long id) {
		repositorio.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado " + id));
		repositorio.deleteById(id);
	}

}
