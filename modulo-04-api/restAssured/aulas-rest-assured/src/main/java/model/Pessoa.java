package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private Integer idPessoa;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
}
