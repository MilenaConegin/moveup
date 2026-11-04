package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class VoucherTO {
    private Integer cdCartao;

    @NotBlank
    @Size(max = 20)
    private String numeroCartao;

    @NotBlank
    @Size(max = 100)
    private String titular;

    @NotBlank
    @Size(max = 30)
    private String tipo;

    @NotBlank
    @Pattern(
            regexp = "^(ATIVO|INATIVO)$",
            message = "O status deve ser ATIVO ou INATIVO."
    )
    private String status;

    @PositiveOrZero
    private Double saldoDisponivel;

    public VoucherTO(){

    }

    public VoucherTO(Integer cdCartao ,String numeroCartao, String titular, String tipo, String status, Double saldoDisponivel){
        setCdCartao(cdCartao);
        setNumeroCartao(numeroCartao);
        setTitular(titular);
        setTipo(tipo);
        setStatus(status);
        setSaldoDisponivel(saldoDisponivel);

    }

    public Integer getCdCartao() {
        return cdCartao;
    }

    public void setCdCartao(Integer cdCartao) {
        this.cdCartao = cdCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(Double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }
}
