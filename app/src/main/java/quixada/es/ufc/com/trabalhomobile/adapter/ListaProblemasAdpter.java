package quixada.es.ufc.com.trabalhomobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.model.Problema;


public class ListaProblemasAdpter extends BaseAdapter{

    private Context context;
    private List<Problema> problemas;

    public ListaProblemasAdpter(Context context, List<Problema> problemas){
        this.problemas = problemas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return problemas.size();
    }
    @Override
    public Object getItem(int position) {
        return problemas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return problemas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null);

        TextView nome= (TextView) view.findViewById(R.id.nome_item);
        TextView tipo = (TextView) view.findViewById(R.id.tipo_item);

        Problema p = problemas.get(position);
        nome.setText(p.getNome());
        tipo.setText(p.getTipo());

        return view;
    }
}
