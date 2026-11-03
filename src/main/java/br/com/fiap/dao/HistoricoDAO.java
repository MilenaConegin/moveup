
package br.com.fiap.dao;

import br.com.fiap.to.HistoricoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class HistoricoDAO {

    public HistoricoTO save(HistoricoTO historico) {
        String sql = "insert into ddd_historico(data_historico, transporte, qtd_passagem, pontos, status) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(historico.getData()));
            ps.setString(2, historico.getTransporte());
            ps.setInt(3, historico.getQuantidadePassagem());
            ps.setDouble(4, historico.getPontos());
            ps.setString(5, historico.getStatus());
            if (ps.executeUpdate() > 0) {
                return historico;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar histórico: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ArrayList<HistoricoTO> findAll() {
        ArrayList<HistoricoTO> historicos = new ArrayList<HistoricoTO>();
        String sql = "select * from ddd_historico order by id_historico";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs != null) {
                while (rs.next()) {
                    HistoricoTO historico = new HistoricoTO();
                    historico.setIdHistorico(rs.getInt("id_historico"));
                    historico.setData(rs.getDate("data_historico").toLocalDate());
                    historico.setTransporte(rs.getString("transporte"));
                    historico.setQuantidadePassagem(rs.getInt("qtd_passagem"));
                    historico.setPontos(rs.getDouble("pontos"));
                    historico.setStatus(rs.getString("status"));
                    historicos.add(historico);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return historicos;
    }

    public HistoricoTO findById(int idHistorico) {
        HistoricoTO historico = new HistoricoTO();
        String sql = "select * from ddd_historico where id_historico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idHistorico);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    historico.setIdHistorico(rs.getInt("id_historico"));
                    historico.setData(rs.getDate("data_historico").toLocalDate());
                    historico.setTransporte(rs.getString("transporte"));
                    historico.setQuantidadePassagem(rs.getInt("qtd_passagem"));
                    historico.setPontos(rs.getDouble("pontos"));
                    historico.setStatus(rs.getString("status"));
                }else {
                    return null;
                }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar histórico: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return historico;
    }

    public boolean delete(int idHistorico) {
        String sql = "delete from ddd_historico where id_historico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idHistorico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir histórico: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public HistoricoTO update(HistoricoTO historico) {
        String sql = "update ddd_historico set data_historico = ?, transporte = ?," +
                " qtd_passagem = ?, pontos = ?, status = ? where id_historico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(historico.getData()));
            ps.setString(2, historico.getTransporte());
            ps.setInt(3, historico.getQuantidadePassagem());
            ps.setDouble(4, historico.getPontos());
            ps.setString(5, historico.getStatus());
            ps.setInt(6, historico.getIdHistorico());
            if (ps.executeUpdate() > 0) {
                return historico;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar histórico: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
