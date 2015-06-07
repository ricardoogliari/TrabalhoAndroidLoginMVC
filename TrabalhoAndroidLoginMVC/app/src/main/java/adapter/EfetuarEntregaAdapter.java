package adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabalhoandroidloginmvc.R;

import bean.Entrega;

public class EfetuarEntregaAdapter extends BaseExpandableListAdapter {

	private List<Entrega> entregas;
    private Context context;
	
	public EfetuarEntregaAdapter(Context context, List<Entrega> listGroups) {
		this.entregas = listGroups;
        this.context = context;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return entregas.get(groupPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
        return entregas.get(groupPosition).hashCode();
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
        final Entrega store = entregas.get(groupPosition);
        ChildHolder holder = null;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.entregas_item_expanded, parent, false);

            holder = new ChildHolder();

            holder.nome = (TextView) convertView.findViewById(R.id.nome);
            holder.endereco = (TextView) convertView.findViewById(R.id.endereco);
            holder.cidade = (TextView) convertView.findViewById(R.id.cidade);
            holder.telefone = (TextView) convertView.findViewById(R.id.telefone);
            holder.email = (TextView) convertView.findViewById(R.id.email);
            holder.buttonMapa = (Button) convertView.findViewById(R.id.button_mapa);
            holder.buttonSelecionar = (Button) convertView.findViewById(R.id.button_selecionar);

            convertView.setTag(holder);
        } else {
            holder = (ChildHolder) convertView.getTag();
        }

        holder.buttonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo
            }
        });
        holder.buttonSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
            }
        });

        return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
        return entregas.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return entregas.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
        return entregas.get(groupPosition).hashCode();
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
        final Entrega store = entregas.get(groupPosition);
        GroupHolder holder = null;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.entregas_item, parent, false);

            holder = new GroupHolder();

            holder.bairro = (TextView) convertView.findViewById(R.id.bairro);
            holder.numero = (TextView) convertView.findViewById(R.id.numero_pedido);
            holder.periodo = (TextView) convertView.findViewById(R.id.periodo);
            holder.imageSeta = (ImageView) convertView.findViewById(R.id.image_arrow);

            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }

        holder.imageSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo
            }
        });

        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

    class GroupHolder{
        TextView bairro;
        TextView numero;
        TextView periodo;
        ImageView imageSeta;
    }

    class ChildHolder {
        TextView nome;
        TextView endereco;
        TextView cidade;
        TextView telefone;
        TextView email;
        Button buttonMapa;
        Button buttonSelecionar;
    }
}
