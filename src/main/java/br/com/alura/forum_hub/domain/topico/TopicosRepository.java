package br.com.alura.forum_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicosRepository extends JpaRepository<Topico, Long>{
    @Query("""
            SELECT t FROM Topico t
            WHERE
            LOWER(t.status) = LOWER(:status)
            """)
    Page<Topico> findAllByStatusIgnoreCase(@Param("status") String status, Pageable paginacao);

    Topico findByTituloAndMensagem(@NotBlank String titulo, @NotBlank String mensagem);
}

