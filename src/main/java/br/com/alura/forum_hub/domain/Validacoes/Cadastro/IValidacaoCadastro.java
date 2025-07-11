package br.com.alura.forum_hub.domain.Validacoes.Cadastro;

import br.com.alura.forum_hub.domain.dto.DadosCadastroTopico;

public interface IValidacaoCadastro {

    void validar(DadosCadastroTopico dados);
}
