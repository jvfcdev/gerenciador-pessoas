package com.example.gerenciador_pessoas.service;

import com.example.gerenciador_pessoas.model.Pessoa;
import com.example.gerenciador_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaAtualizada.getNome());
                    pessoa.setIdade(pessoaAtualizada.getIdade());
                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(() -> {
                    pessoaAtualizada.setId(id);
                    return pessoaRepository.save(pessoaAtualizada);
                });
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
