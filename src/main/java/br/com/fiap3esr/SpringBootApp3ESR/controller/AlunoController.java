package br.com.fiap3esr.SpringBootApp3ESR.controller;

import br.com.fiap3esr.spring_boot_project.aluno.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados) {
        // Regra de negócio: VANS e CAMINHOES só podem ser escolhidos se aluno já tiver CNH
        if (dados.carteiras().contains(TipoCarteiraAluno.VANS) || dados.carteiras().contains(TipoCarteiraAluno.CAMINHOES)) {
            // Obs: Como você ainda não tem campo "possui CNH" no Aluno,
            // deixei a validação fixa aqui.
            // Se quiser, pode adicionar no DTO um boolean "possuiCNH".
            throw new IllegalArgumentException("Para Vans e Caminhões é necessário já possuir CNH!");
        }

        var aluno = new Aluno(null, dados.nome(), dados.email(), dados.carteiras(),
                new br.com.fiap3esr.spring_boot_project.endereco.Endereco(dados.endereco()));

        repository.save(aluno);
    }

    @GetMapping
    public List<DadosListagemAluno> listarAlunos() {
        return repository.findAll().stream().map(DadosListagemAluno::new).toList();
    }
}
