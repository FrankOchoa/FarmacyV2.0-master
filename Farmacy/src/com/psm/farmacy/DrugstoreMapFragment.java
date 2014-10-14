package com.psm.farmacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class DrugstoreMapFragment extends SupportMapFragment {

	//private View vi;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//vi= inflater.inflate(R.layout.fragment_drugstore_map, container, false);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
