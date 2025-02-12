package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T14:46:22-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public Usuario dtoToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.email( usuarioDTO.getEmail() );
        usuario.id( usuarioDTO.getId() );
        usuario.nome( usuarioDTO.getNome() );
        usuario.senha( usuarioDTO.getSenha() );
        usuario.tipoCurso( usuarioDTO.getTipoCurso() );
        usuario.tipoUsuario( usuarioDTO.getTipoUsuario() );
        usuario.username( usuarioDTO.getUsername() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.id( usuario.getId() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.tipoCurso( usuario.getTipoCurso() );
        usuarioDTO.tipoUsuario( usuario.getTipoUsuario() );
        usuarioDTO.username( usuario.getUsername() );

        return usuarioDTO.build();
    }
}
