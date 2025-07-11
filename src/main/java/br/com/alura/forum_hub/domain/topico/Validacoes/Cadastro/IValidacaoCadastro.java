package br.com.alura.forum_hub.domain.topico.Validacoes.Cadastro;

import br.com.alura.forum_hub.domain.topico.dto.DadosCadastroTopico;

public interface IValidacaoCadastro {

    void validar(DadosCadastroTopico dados);
}
