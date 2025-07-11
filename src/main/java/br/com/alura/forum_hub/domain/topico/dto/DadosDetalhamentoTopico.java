package br.com.alura.forum_hub.domain.topico.dto;

import br.com.alura.forum_hub.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        @NotNull(message = "Informe número do ID válido")
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
