package br.com.fiap.bo;


import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class UsuarioBO {

    UsuarioDAO usuarioDAO;


    public UsuarioTO save (UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.save(usuario);
    }

    public ArrayList<UsuarioTO> findAll(){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findAll();
    }

    public  UsuarioTO findById(int idUsuario){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findById(idUsuario);
    }

    public boolean delete(int idUsuario){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.delete(idUsuario);
    }

    public UsuarioTO update(UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.update(usuario);
    }


}
