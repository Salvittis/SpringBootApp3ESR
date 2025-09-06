package br.com.fiap3esr.SpringBootApp3ESR.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
