package com.psm.farmacy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MedicFragment  extends Fragment{
	
	private View vi;
	private Button btnTratamientos;
	private Button btnMedicinas;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_medic, container, false);
		btnMedicinas=(Button) vi.findViewById(R.id.btnMedicines);
		btnTratamientos=(Button) vi.findViewById(R.id.btnMedications);
		createListeners();
		return vi;
	}
	
	private void createListeners()
	{
		btnMedicinas.setOnClickListener(clickMedicina);
		btnTratamientos.setOnClickListener(clickTratamiento);
	}
	
	public OnClickListener clickMedicina = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.container,new MedicineFragment());
			transaction.commit();
		}
	};
	public OnClickListener clickTratamiento = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.container,new MedicationFragment());
			transaction.commit();
		}
	};
}
