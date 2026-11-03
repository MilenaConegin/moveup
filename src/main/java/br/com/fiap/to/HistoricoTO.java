package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class HistoricoTO {

    private Integer idHistorico;

    @NotNull
    @PastOrPresent
    private LocalDate data;

    @NotBlank
    private String transporte;

    @NotNull
    @PositiveOrZero
    private Integer quantidadePassagem;

    @PositiveOrZero
    private double pontos;

    @NotBlank
    @Pattern(
            regexp = "^(ATIVO|INATIVO)$",
            message = "O status deve ser ATIVO ou INATIVO."
    )
    private String status;

    public HistoricoTO(){

    }

    public HistoricoTO(Integer idHistorico, LocalDate data, String transporte, Integer quantidadePassagem, double pontos, String status){
        setIdHistorico(idHistorico);
        setData(data);
        setTransporte(transporte);
        setQuantidadePassagem(quantidadePassagem);
        setPontos(pontos);
        setStatus(status);
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public Integer getQuantidadePassagem() {
        return quantidadePassagem;
    }

    public void setQuantidadePassagem(Integer quantidadePassagem) {
        this.quantidadePassagem = quantidadePassagem;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
