package br.com.alura.forum_hub.domain.topico.Validacoes;

import br.com.alura.forum_hub.domain.topico.Topico;
import br.com.alura.forum_hub.domain.topico.TopicosRepository;
import br.com.alura.forum_hub.domain.topico.Validacoes.Cadastro.IValidacaoCadastro;
import br.com.alura.forum_hub.domain.topico.dto.DadosAtualizacaoTopico;
import br.com.alura.forum_hub.domain.topico.dto.DadosCadastroTopico;
import br.com.alura.forum_hub.infra.exceptions.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
         Optional<Topico> topico = Optional.of(repository.getReferenceById(dados.id()));
         if (topico.isPresent()){
             var topicoAtualizado = topico.get();
             topicoAtualizado.atualizarInformacoes(dados);
             return topicoAtualizado;
         }
        throw new ValidacaoException("Não foi possível atualizar. Tópico não existe.");
    }

    public void deletar(Long id) {
        Optional<Topico> topico = Optional.of(repository.getReferenceById(id));
        if (topico.isPresent()){
            repository.deleteById(id);
        }

    }

    public void fechar(Long id) {
        Optional<Topico> topico = Optional.of(repository.getReferenceById(id));
        if (topico.isPresent()){
            var topicoFechado = topico.get();
            topicoFechado.fecharTopico();
        }
    }
}
