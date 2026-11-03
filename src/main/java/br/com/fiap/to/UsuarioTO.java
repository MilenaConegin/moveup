package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class UsuarioTO {
    private Integer idUsuario;

    @NotBlank
    private String nomeUsuario;

    @Email @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_]).*$",
            message = "A senha deve conter pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial"
    )
    private String senha;

    public UsuarioTO(){

    }

    public UsuarioTO(Integer idUsuario, String nomeUsuario, String email, String senha) {
        setIdUsuario(idUsuario);
        setNomeUsuario(nomeUsuario);
        setEmail(email);
        setSenha(senha);
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
