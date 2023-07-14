package com.arquisoftware.libreriasalvador.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquisoftware.libreriasalvador.Entidades.Usuario;
import com.arquisoftware.libreriasalvador.Exception.RegistroUsuarioException;
import com.arquisoftware.libreriasalvador.Exception.UsuarioNotFoundException;
import com.arquisoftware.libreriasalvador.Repositorios.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        // Realiza cualquier validación adicional o procesamiento de datos
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new RegistroUsuarioException("El nombre de usuario ya está en uso");
        }

        // Guarda el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con el ID: " + id));
    }
    

    public Usuario actualizarUsuario(Usuario usuario) {
        // Implementa la lógica para actualizar la información del usuario
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        // Implementa la lógica para eliminar el usuario por su ID
        usuarioRepository.deleteById(id);
    }

    // Aquí puedes agregar otros métodos relacionados con la gestión de usuarios
    @Transactional
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }
    
}
