package com.example.trabalhoandroidloginmvc.fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.trabalhoandroidloginmvc.FiapApplication;
import com.example.trabalhoandroidloginmvc.R;
import com.example.trabalhoandroidloginmvc.adapter.EfetuarEntregaAdapter;
import com.example.trabalhoandroidloginmvc.bean.Entrega;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class EfetuarEntregasFragment extends Fragment {

    ExpandableListView expandableList;
    EfetuarEntregaAdapter adapter;
    private List<Entrega> entregas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.efetuar_entregas_fragment, container, false);
        expandableList = (ExpandableListView) view.findViewById(R.id.expandable_listview);
        entregas = new ArrayList<>();
        adapter = new EfetuarEntregaAdapter(getActivity(), entregas);
        expandableList.setAdapter(adapter);

        carregarEntregas();

        return view;
    }

    private void carregarEntregas() {
        FiapApplication.getRequestManager().requestContent(getString(R.string.url_entregas), createSuccessListener(), createErrorListener());
    }

    private Response.Listener<String> createSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(FiapApplication.TAG, response);
                try {
                    Entrega entrega = new Entrega();
                    JSONObject json = new JSONObject(response);
                    if(json.has("idEntrega")){
                        entrega.setId(json.getString("idEntrega"));
                    }
                    if(json.has("endereco")){
                        entrega.setEndereco(json.getString("endereco"));
                    }
                    if(json.has("bairro")){
                        entrega.setBairro(json.getString("bairro"));
                    }
                    if(json.has("cidade")){
                        entrega.setCidade(json.getString("cidade"));
                    }
                    if(json.has("uf")){
                        entrega.setUf(json.getString("uf"));
                    }
                    if(json.has("email")){
                        entrega.setEmail(json.getString("email"));
                    }
                    if(json.has("telefone")){
                        entrega.setTelefone(json.getString("telefone"));
                    }
                    if(json.has("cep")){
                        entrega.setCep(json.getString("cep"));
                    }
                    if(json.has("horarioDe")){
                        entrega.setHoraDe(json.getInt("horarioDe"));
                    }
                    if(json.has("horarioAte")){
                        entrega.setHoraAte(json.getInt("horarioAte"));
                    }
                    if(json.has("dataEntregue")){
                        entrega.setDataEntregue(json.getInt("dataEntregue"));
                    }
                    /*if(json.has("fotoEvidencia")){

                        entrega.setDataEntregue(json.getJSONArray("fotoEvidencia"));
                    }*/
                    entregas.add(entrega);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorData = new String(error.networkResponse.data);
                Log.e(FiapApplication.TAG, errorData);
                error.printStackTrace();
            }
        };
    }
}
