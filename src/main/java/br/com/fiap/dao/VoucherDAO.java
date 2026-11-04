
package br.com.fiap.dao;

import br.com.fiap.to.VoucherTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoucherDAO {

    public VoucherTO save(VoucherTO voucher) {
        String sql = "insert into ddd_voucher(numero_cartao, titular_cartao, tipo_cartao, status_cartao, saldo_disponivel) values (?,?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, voucher.getNumeroCartao());
            ps.setString(2, voucher.getTitular());
            ps.setString(3, voucher.getTipo());
            ps.setString(4, voucher.getStatus());
            ps.setDouble(5, voucher.getSaldoDisponivel());
            if (ps.executeUpdate() > 0) {
                return voucher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1) {
                throw new RuntimeException("Número do cartão já cadastrado.");
            }
            System.out.println("Erro ao salvar voucher.");

        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ArrayList<VoucherTO> findAll() {
        ArrayList<VoucherTO> vouchers = new ArrayList<VoucherTO>();
        String sql = "select * from ddd_voucher order by cd_cartao";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VoucherTO voucher = new VoucherTO();
                    voucher.setCdCartao(rs.getInt("cd_cartao"));
                    voucher.setNumeroCartao(rs.getString("numero_cartao"));
                    voucher.setTitular(rs.getString("titular_cartao"));
                    voucher.setTipo(rs.getString("tipo_cartao"));
                    voucher.setStatus(rs.getString("status_cartao"));
                    voucher.setSaldoDisponivel(rs.getDouble("saldo_disponivel"));
                    vouchers.add(voucher);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return vouchers;
    }

    public VoucherTO findByCd(Integer cdCartao) {
        VoucherTO voucher = new VoucherTO();
        String sql = "select * from ddd_voucher where cd_cartao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, cdCartao);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voucher.setCdCartao(rs.getInt("cd_cartao"));
                voucher.setNumeroCartao(rs.getString("numero_cartao"));
                voucher.setTitular(rs.getString("titular_cartao"));
                voucher.setTipo(rs.getString("tipo_cartao"));
                voucher.setStatus(rs.getString("status_cartao"));
                voucher.setSaldoDisponivel(rs.getDouble("saldo_disponivel"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar voucher: " + e.getMessage());

        } finally {
            ConnectionFactory.closeConnection();
        }
        return voucher;
    }

    public boolean delete(Integer cdCartao) {
        String sql = "delete from ddd_voucher where cd_cartao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, cdCartao);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir voucher: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public VoucherTO update(VoucherTO voucher) {
        String sql = "update ddd_voucher set numero_cartao = ?, titular_cartao = ?, tipo_cartao = ?, status_cartao = ?, saldo_disponivel = ? where cd_cartao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, voucher.getNumeroCartao());
            ps.setString(2, voucher.getTitular());
            ps.setString(3, voucher.getTipo());
            ps.setString(4, voucher.getStatus());
            ps.setDouble(5, voucher.getSaldoDisponivel());
            ps.setInt(6, voucher.getCdCartao());
            if (ps.executeUpdate() > 0) {
                return voucher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar voucher: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
