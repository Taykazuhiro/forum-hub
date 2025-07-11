package br.com.alura.forum_hub.domain.Validacoes;

import br.com.alura.forum_hub.domain.Topico;
import br.com.alura.forum_hub.domain.TopicosRepository;
import br.com.alura.forum_hub.domain.Validacoes.Cadastro.IValidacaoCadastro;
import br.com.alura.forum_hub.domain.dto.DadosAtualizacaoTopico;
import br.com.alura.forum_hub.domain.dto.DadosCadastroTopico;
import br.com.alura.forum_hub.infra.exceptions.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidaTopicos {
    @Autowired
    private TopicosRepository repository;

    @Autowired
    private List<IValidacaoCadastro> validacaoCadastroList;

    public Topico cadastro(@Valid DadosCadastroTopico dados) {
        validacaoCadastroList.forEach(v -> v.validar(dados));
        var topico = new Topico(dados);
        repository.save(topico);
        return topico;
    }

    public Topico detalhamentoTopico(Long id) {
        if (id != null) {
            return repository.getReferenceById(id);
        } else {
            throw new ValidacaoException("Informe o ID para realizar a busca");
        }
    }

    public Topico atualizacao(@Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return topico;
    }
}
