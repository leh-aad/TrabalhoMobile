package quixada.es.ufc.com.trabalhomobile.model;

import java.io.Serializable;

/**
 * Created by Leh on 04/11/2016.
 */

public class Problema implements Serializable {
    private String nome;
    private String descricao;
    private String tipo;
    private long id;

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }
}
