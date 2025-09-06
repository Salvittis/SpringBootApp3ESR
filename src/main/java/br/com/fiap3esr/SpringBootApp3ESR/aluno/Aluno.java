package br.com.fiap3esr.SpringBootApp3ESR.aluno;

import br.com.fiap3esr.spring_boot_project.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @ElementCollection(targetClass = TipoCarteiraAluno.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "aluno_carteiras", joinColumns = @JoinColumn(name = "aluno_id"))
    @Enumerated(EnumType.STRING)
    private List<TipoCarteiraAluno> carteiras;

    @Embedded
    private Endereco endereco;
}
