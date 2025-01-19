package com.ifba.Gerenciador_TCC.documento.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoDTO {

    private Long id;

    @NotNull(message = "O ID do projeto não pode ser vazio")
    private Long idProjeto;

    @NotEmpty(message = "O nome do documento não pode estar vazio")
    private String nomeDocumento;

    @NotEmpty(message = "O tipo do documento não pode estar vazio")
    private String tipoDocumento;

    private String descricao;

    @NotNull(message = "A data de envio não pode ser vazia")
    private LocalDate dataEnvio;

    @NotNull(message = "A URL do arquivo não pode ser vazia")
    private String urlArquivo;
}
