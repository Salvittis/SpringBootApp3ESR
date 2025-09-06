package br.com.fiap3esr.SpringBootApp3ESR.aluno;

import java.util.List;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        List<TipoCarteiraAluno> carteiras
) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCarteiras());
    }
}
