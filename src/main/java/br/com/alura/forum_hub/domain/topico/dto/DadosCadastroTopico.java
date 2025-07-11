package br.com.alura.forum_hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank (message = "Não é possível salvar tópico sem um título!")
        String titulo,

        @NotBlank(message = "Não é possível salvar tópico sem o conteúdo")
        String mensagem,

        @NotBlank(message = "Não é possível salvar tópico sem autor")
        String autor,

        @NotBlank (message = "Não é possível salvar tópico sem curso")
        String curso) {
}
