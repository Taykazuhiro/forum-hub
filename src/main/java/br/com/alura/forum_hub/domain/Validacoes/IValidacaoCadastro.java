package br.com.alura.forum_hub.domain.Validacoes;

import br.com.alura.forum_hub.domain.DadosCadastroTopico;

public interface IValidacaoCadastro {

    void validar(DadosCadastroTopico dados);
}
