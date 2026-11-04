package br.com.fiap.bo;


import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import br.com.fiap.to.VoucherTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class UsuarioBO {

    UsuarioDAO usuarioDAO;

    public UsuarioTO save (UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();

        // Valida o nome
        if (usuario.getNomeUsuario() == null ||
                usuario.getNomeUsuario().isBlank()) {
            throw new IllegalArgumentException(
                    "O nome é obrigatório."
            );
        }

        // Valida o e-mail
        if (usuario.getEmail() == null ||
                !usuario.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException(
                    "Informe um e-mail válido."
            );
        }

        if (usuario.getSenha() == null ||
                !usuario.getSenha().matches(
                        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_]).{8,}$"
                )) {
            throw new IllegalArgumentException(
                    "A senha deve conter no mínimo 8 caracteres, uma letra maiúscula, uma minúscula, um número e um caractere especial."
            );
        }

        return usuarioDAO.save(usuario);
    }

    public ArrayList<UsuarioTO> findAll(){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findAll();
    }

    public  UsuarioTO findById(Integer idUsuario){
        usuarioDAO = new UsuarioDAO();

        if (idUsuario <= 0) {
            throw new IllegalArgumentException(
                    "Informe um ID válido."
            );
        }

        return usuarioDAO.findById(idUsuario);
    }

    public boolean delete(Integer idUsuario){
        usuarioDAO = new UsuarioDAO();

        if (idUsuario <= 0) {
            throw new IllegalArgumentException(
                    "Informe um ID válido."
            );
        }

        return usuarioDAO.delete(idUsuario);
    }

    public UsuarioTO update(UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.update(usuario);
    }
}
