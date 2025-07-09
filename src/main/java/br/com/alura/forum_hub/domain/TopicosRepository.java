package br.com.alura.forum_hub.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;


public interface topicosRepository extends JpaRepository<Topico, Long> {
   // Page<Topico> findAllByStatusTrue(Pag paginacao);
}
