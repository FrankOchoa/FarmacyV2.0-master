package com.psm.farmacy;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;


public class MedicationFragment extends BaseFragment {
	
	private ExpandableListView exlstMedication;
	private CheckBox chkShowAll;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {		
		vi=inflater.inflate(R.layout.fragment_medication, container, false);	
		exlstMedication=(ExpandableListView)vi.findViewById(R.id.exlstMedication);
		chkShowAll=(CheckBox)vi.findViewById(R.id.chkShowAll);
		return vi;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		setHasOptionsMenu(true);
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		inflater.inflate(R.menu.medication, menu);
		ActionBar bar=getActivity().getActionBar();
		bar.setTitle("Tratamientos");		
	}

}
