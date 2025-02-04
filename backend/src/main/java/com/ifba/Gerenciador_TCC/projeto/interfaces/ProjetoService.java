package com.ifba.Gerenciador_TCC.projeto.interfaces;


import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import java.util.List;


public interface ProjetoService {

    List<Projeto> listarProjetos();

    Projeto obterProjetoPorId(Long id);

    Projeto criarProjeto(Projeto projeto);

    Projeto atualizarProjeto(Long id, Projeto projeto);

    void deletarProjeto(Long id);
}
