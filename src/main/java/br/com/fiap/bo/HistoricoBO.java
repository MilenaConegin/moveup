
package br.com.fiap.bo;

import br.com.fiap.dao.HistoricoDAO;
import br.com.fiap.to.HistoricoTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class HistoricoBO {

    HistoricoDAO historicoDAO;

    public HistoricoTO save(HistoricoTO historico) {
        historicoDAO = new HistoricoDAO();

        // Valida a data
        if (historico.getData() == null ||
                historico.getData().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Informe uma data válida."
            );
        }

        // Valida o transporte
        if (historico.getTransporte() == null ||
                historico.getTransporte().isBlank()) {
            throw new IllegalArgumentException(
                    "O transporte é obrigatório."
            );
        }

        // Valida a quantidade de passagens
        if (historico.getQuantidadePassagem() == null ||
                historico.getQuantidadePassagem() < 0) {
            throw new IllegalArgumentException(
                    "A quantidade de passagens não pode ser negativa ou nula."
            );
        }

        // Valida o status
        if (historico.getStatus() == null ||
                !(historico.getStatus().equalsIgnoreCase("ATIVO") ||
                        historico.getStatus().equalsIgnoreCase("INATIVO"))) {
            throw new IllegalArgumentException(
                    "O status deve ser ATIVO ou INATIVO."
            );
        }

        return historicoDAO.save(historico);
    }

    public ArrayList<HistoricoTO> findAll() {

        historicoDAO = new HistoricoDAO();
        return historicoDAO.findAll();
    }

    public HistoricoTO findById(int idHistorico) {

        historicoDAO = new HistoricoDAO();

        if (idHistorico <= 0) {
            throw new IllegalArgumentException(
                    "Informe um ID válido."
            );
        }

        return historicoDAO.findById(idHistorico);
    }

    public boolean delete(int idHistorico) {
        historicoDAO = new HistoricoDAO();

        if (idHistorico <= 0) {
            throw new IllegalArgumentException(
                    "Informe um ID válido."
            );
        }

        return historicoDAO.delete(idHistorico);
    }

    public HistoricoTO update(HistoricoTO historico) {
        historicoDAO = new HistoricoDAO();

        // Valida a data
        if (historico.getData() == null ||
                historico.getData().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Informe uma data válida."
            );
        }

        // Valida o transporte
        if (historico.getTransporte() == null ||
                historico.getTransporte().isBlank()) {
            throw new IllegalArgumentException(
                    "O transporte é obrigatório."
            );
        }

        // Valida a quantidade de passagens
        if (historico.getQuantidadePassagem() == null ||
                historico.getQuantidadePassagem() < 0) {
            throw new IllegalArgumentException(
                    "A quantidade de passagens não pode ser negativa ou nula."
            );
        }

        // Valida o status
        if (historico.getStatus() == null ||
                !(historico.getStatus().equalsIgnoreCase("ATIVO") ||
                        historico.getStatus().equalsIgnoreCase("INATIVO"))) {
            throw new IllegalArgumentException(
                    "O status deve ser ATIVO ou INATIVO."
            );
        }

        return historicoDAO.update(historico);
    }
}
