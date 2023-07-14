package com.arquisoftware.libreriasalvador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquisoftware.libreriasalvador.Entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    boolean existsByUsername(String username);
}
