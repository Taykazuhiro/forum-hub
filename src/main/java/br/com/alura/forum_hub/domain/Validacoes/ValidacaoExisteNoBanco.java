package br.com.alura.forum_hub.domain.Validacoes;

import br.com.alura.forum_hub.domain.DadosAtualizacaoTopico;
import br.com.alura.forum_hub.domain.Topico;
import br.com.alura.forum_hub.domain.TopicosRepository;
import br.com.alura.forum_hub.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidacaoExisteNoBanco implements IValidacaoExiste{
    @Autowired
    private TopicosRepository repository;

    @Override
    public void validar(Long id) {
        if (id == null){
            throw new ValidacaoException("Campo id não pode estar vazio!");
        }

    }

        }

