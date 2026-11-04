package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public UsuarioTO save(UsuarioTO usuario) {
        String sql = "insert into ddd_usuario(nome_usuario, email_usuario, senha_usuario) values(?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {

            if (e.getErrorCode() == 1) {
                throw new RuntimeException("Usuário já cadastrado.");
            }
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ArrayList<UsuarioTO> findAll(){
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();
        String sql = "select * from ddd_usuario order by id_usuario";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                    while (rs.next()){
                        UsuarioTO usuario = new UsuarioTO();
                        usuario.setIdUsuario(rs.getInt("id_usuario"));
                        usuario.setNomeUsuario(rs.getString("nome_usuario"));
                        usuario.setEmail(rs.getString("email_usuario"));
                        usuario.setSenha(rs.getString("senha_usuario"));
                        usuarios.add(usuario);
                    }
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " +e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findById(Integer idUsuario){
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from ddd_usuario where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return usuario;
    }

    public boolean delete(Integer idUsuario){
        String sql = "delete from ddd_usuario where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "update ddd_usuario set nome_usuario = ?, email_usuario = ?, senha_usuario = ? where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getIdUsuario());
            if (ps.executeUpdate() > 0){
                return usuario;
            }else{
                return null;
            }
        } catch (SQLException e) {

        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}

