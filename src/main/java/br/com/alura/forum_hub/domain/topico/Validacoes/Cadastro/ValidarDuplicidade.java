package br.com.alura.forum_hub.domain.topico.Validacoes.Cadastro;

import br.com.alura.forum_hub.domain.topico.dto.DadosCadastroTopico;
import br.com.alura.forum_hub.domain.topico.TopicosRepository;
import br.com.alura.forum_hub.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarDuplicidade implements IValidacaoCadastro {
@Autowired
private TopicosRepository repository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var topico = repository.findByTituloAndMensagem(dados.titulo(),dados.mensagem());
        if (topico != null){
            throw new ValidacaoException("Erro ao executar a solicitação: Tópico duplicado!");
        }
    }
}
