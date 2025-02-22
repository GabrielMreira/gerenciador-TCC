package com.ifba.Gerenciador_TCC.notificacao.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "notificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String remetente;
    
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private boolean visualizado;
}
