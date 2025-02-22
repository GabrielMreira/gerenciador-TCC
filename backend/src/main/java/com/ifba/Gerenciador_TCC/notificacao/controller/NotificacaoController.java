package com.ifba.Gerenciador_TCC.notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;
import com.ifba.Gerenciador_TCC.notificacao.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public List<Notificacao> listarNotificacoes() {
        return notificacaoService.listarNotificacoes();
    }

    @PutMapping("/{id}/visualizar")
    public Notificacao marcarComoVisualizado(@PathVariable Long id) {
        Notificacao notificacao = notificacaoService.buscarPorId(id);
        if (notificacao != null) {
            notificacao.setVisualizado(true);
            notificacaoService.salvarNotificacao(notificacao);
        }
        return notificacao;
    }
    
    @PostMapping
    public Notificacao criarNotificacao(@RequestBody Notificacao notificacao) {
        notificacao.setData(new java.util.Date());
        notificacao.setVisualizado(false);
        return notificacaoService.salvarNotificacao(notificacao);
    }
}
