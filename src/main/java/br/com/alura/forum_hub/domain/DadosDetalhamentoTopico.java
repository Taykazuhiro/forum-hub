package br.com.alura.forum_hub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String autor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        String status,
        String curso) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getDataCriacao(), topico.getStatus(), topico.getCurso());
    }
}
