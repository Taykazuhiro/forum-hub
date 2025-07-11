package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.domain.*;
import br.com.alura.forum_hub.domain.Validacoes.ValidaTopicos;
import br.com.alura.forum_hub.domain.dto.DadosAtualizacaoTopico;
import br.com.alura.forum_hub.domain.dto.DadosCadastroTopico;
import br.com.alura.forum_hub.domain.dto.DadosDetalhamentoTopico;
import br.com.alura.forum_hub.domain.dto.DadosListagemTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository repository;

    @Autowired
    private ValidaTopicos validador;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var topico = validador.cadastro(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public Page<DadosListagemTopico> listar (@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){
        return repository.findAllByStatusIgnoreCase("aberto", paginacao).map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = validador.detalhamentoTopico(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = validador.atualizacao(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        validador.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/resolved/{id}")
    @Transactional
    public ResponseEntity fechar(@PathVariable Long id){
        validador.fechar(id);
        return ResponseEntity.noContent().build();
    }

}