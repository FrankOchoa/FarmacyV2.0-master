package com.psm.farmacy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.psm.UI.*;
import com.psm.Database.*;
import com.psm.Model.*;

public class HomeFragment extends Fragment {
	
	private View vi;
	private ListView lstLast;
	private List<Take> tomas;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try
		{
			Procedures pr= new Procedures(getActivity());
			tomas= new ArrayList<Take>();
			tomas=pr.srcLast();
		}
		catch(Exception ex)
		{
			Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();			
		}
		super.onCreate(savedInstanceState);
	}



	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		try
		{
		vi=inflater.inflate(R.layout.fragment_home, container, false);		
		lstLast= (ListView) vi.findViewById(R.id.lstLast);
        lstLast.setAdapter(new  itemListLastAdapter(getActivity(),tomas));
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return vi;// super.onCreateView(inflater, container, savedInstanceState);
	}

}
