package quixada.es.ufc.com.trabalhomobile.model;

/**
 * Created by Leh on 09/11/2016.
 */

public class Usuario {
    private String email;
    private String senha;
    private String tipo;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
