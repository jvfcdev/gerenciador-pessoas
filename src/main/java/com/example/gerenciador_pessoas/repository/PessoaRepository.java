package com.example.gerenciador_pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciador_pessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
