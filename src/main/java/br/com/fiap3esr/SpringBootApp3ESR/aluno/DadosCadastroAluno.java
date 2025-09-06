package br.com.fiap3esr.spring_boot_project.aluno;

import br.com.fiap3esr.spring_boot_project.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import java.util.List;

public record DadosCadastroAluno(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        // Lista porque o aluno pode escolher mais de uma carteira (ex: CARRO e MOTO)
        @NotNull
        List<TipoCarteiraAluno> carteiras,

        @NotNull
        @Valid
        DadosEndereco endereco
) {}
