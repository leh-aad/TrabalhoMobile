package quixada.es.ufc.com.trabalhomobile.dao;

import java.util.ArrayList;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.model.Problema;

/**
 * Created by Leh on 04/11/2016.
 */

public class ProblemaDAO {

    private static List<Problema> problemas = new ArrayList<Problema>();

    public void cadastrar(Problema p){
        problemas.add(p);
    }

    public void remove(Problema p ){
        problemas.remove(p);
    }

    public Problema getProblemaById(int id){
        for (Problema p: problemas) {
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }

    public List<Problema> getLista() {
        return problemas;
    }
}
