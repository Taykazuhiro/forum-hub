package br.com.alura.forum_hub.domain.topico.dto;

import br.com.alura.forum_hub.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data, String Status, String autor, String curso) {
    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
