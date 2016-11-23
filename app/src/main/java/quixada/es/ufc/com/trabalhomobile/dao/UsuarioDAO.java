package quixada.es.ufc.com.trabalhomobile.dao;

import java.util.ArrayList;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.model.Usuario;

/**
 * Created by Leh on 09/11/2016.
 */

public class UsuarioDAO {

    private static List<Usuario> usuarios= new ArrayList<Usuario>();

    public void adicionar(Usuario usuario){
        usuarios.add(usuario);
    }

    public List<Usuario> getLista() {
        return usuarios;
    }
}
