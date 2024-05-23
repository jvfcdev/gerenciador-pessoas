package com.example.gerenciador_pessoas;

import com.example.gerenciador_pessoas.model.Pessoa;
import com.example.gerenciador_pessoas.repository.PessoaRepository;
import com.example.gerenciador_pessoas.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João Victor");
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa created = pessoaService.criarPessoa(pessoa);

        assertEquals("João Victor", created.getNome());
        verify(pessoaRepository, times(1)).save(pessoa);
    }
}
