package com.example.gerenciador_pessoas;

import com.example.gerenciador_pessoas.model.Pessoa;
import com.example.gerenciador_pessoas.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        pessoaRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void testCriarPessoa() throws Exception {
        String pessoaJson = "{\"nome\":\"João Victor\",\"idade\":24}";

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pessoaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("João Victor")));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void testListarPessoas() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João Victor");
        pessoa.setIdade(24);
        pessoaRepository.save(pessoa);

        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome", is("João Victor")));
    }
}
