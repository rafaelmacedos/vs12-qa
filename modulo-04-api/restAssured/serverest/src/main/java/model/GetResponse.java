package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResponse {
    private Integer quantidade;
    private Produto[] produtos;
    private String nome;
    private Object preco;
    private String descricao;
    private String _id;
}
