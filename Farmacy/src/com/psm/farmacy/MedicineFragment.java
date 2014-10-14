package com.psm.farmacy;

import java.util.List;
import com.psm.Database.Procedures;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MedicineFragment  extends Fragment{
	
	private View vi;
	private ListView lstMedicinas;
	private List<String> medicinas;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_medicine, container, false);
		lstMedicinas=(ListView) vi.findViewById(R.id.lstMedicinas);	
		lstMedicinas.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, medicinas));
		return vi;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		
		try
		{
			Procedures pr= new Procedures(getActivity());
			medicinas=pr.lstMedicinas();
		}
		catch(Exception ex)
		{
			Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();			
		}
		super.onCreate(savedInstanceState);
	}

	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		inflater.inflate(R.menu.medicine, menu);
		ActionBar bar=getActivity().getActionBar();
		bar.setTitle("Medicamentos");		
	}


}
