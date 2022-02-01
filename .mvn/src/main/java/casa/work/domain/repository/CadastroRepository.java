package casa.work.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import casa.work.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

	@Query("select c from Cadastro c where c.nome like %?1%")
	List<Cadastro> buscarPorNome(String nome);
}

