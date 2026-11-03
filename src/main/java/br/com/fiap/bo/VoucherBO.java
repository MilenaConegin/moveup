package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.VoucherDAO;
import br.com.fiap.to.UsuarioTO;
import br.com.fiap.to.VoucherTO;

import java.util.ArrayList;

public class VoucherBO {

    VoucherDAO voucherDAO;

    public VoucherTO save (VoucherTO voucher){
        voucherDAO = new VoucherDAO();

        if (voucher.getNumeroCartao() == null ||
                voucher.getNumeroCartao().isBlank()) {
            throw new IllegalArgumentException(
                    "O número do cartão é obrigatório."
            );
        }

        if (voucher.getTipo() == null ||
                voucher.getTipo().isBlank()) {
            throw new IllegalArgumentException(
                    "O tipo do cartão é obrigatório."
            );
        }

        if (voucher.getStatus() == null ||
                (!voucher.getStatus().equals("ATIVO") &&
                        !voucher.getStatus().equals("INATIVO"))) {
            throw new IllegalArgumentException(
                    "O status deve ser ATIVO ou INATIVO."
            );
        }

        if (voucher.getSaldoDisponivel() < 0) {
            throw new IllegalArgumentException(
                    "O saldo disponível não pode ser negativo."
            );
        }

        return voucherDAO.save(voucher);

    }

    public ArrayList<VoucherTO> findAll(){
        voucherDAO = new VoucherDAO();
        return voucherDAO.findAll();
    }

    public  VoucherTO findByCd(int cdCartao){
        voucherDAO = new VoucherDAO();

        if (cdCartao <= 0) {
            throw new IllegalArgumentException(
                    "Informe um código válido."
            );
        }

        return voucherDAO.findByCd(cdCartao);
    }

    public boolean delete(int cdCartao){
        voucherDAO = new VoucherDAO();

        if (cdCartao <= 0) {
            throw new IllegalArgumentException(
                    "Informe um código válido."
            );
        }

        return voucherDAO.delete(cdCartao);
    }

    public VoucherTO update(VoucherTO voucher){
        voucherDAO = new VoucherDAO();

        if (voucher.getNumeroCartao() == null ||
                voucher.getNumeroCartao().isBlank()) {
            throw new IllegalArgumentException(
                    "O número do cartão é obrigatório."
            );
        }

        if (voucher.getTipo() == null ||
                voucher.getTipo().isBlank()) {
            throw new IllegalArgumentException(
                    "O tipo do cartão é obrigatório."
            );
        }

        if (voucher.getStatus() == null ||
                (!voucher.getStatus().equals("ATIVO") &&
                        !voucher.getStatus().equals("INATIVO"))) {
            throw new IllegalArgumentException(
                    "O status deve ser ATIVO ou INATIVO."
            );
        }

        if (voucher.getSaldoDisponivel() < 0) {
            throw new IllegalArgumentException(
                    "O saldo disponível não pode ser negativo."
            );
        }

        return voucherDAO.update(voucher);
    }
}
