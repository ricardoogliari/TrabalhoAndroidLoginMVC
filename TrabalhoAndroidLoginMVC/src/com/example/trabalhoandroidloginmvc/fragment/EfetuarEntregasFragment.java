package com.example.trabalhoandroidloginmvc.fragment;

import com.example.trabalhoandroidloginmvc.R;
import com.example.trabalhoandroidloginmvc.R.id;
import com.example.trabalhoandroidloginmvc.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class EfetuarEntregasFragment extends Fragment {

	ExpandableListView expandableList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.efetuar_entregas_fragment, container);
		expandableList = (ExpandableListView)view.findViewById(R.id.expandable_listview);
		return view;
	}
}
