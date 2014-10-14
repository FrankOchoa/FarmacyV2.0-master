package com.psm.farmacy;

import com.google.android.gms.internal.lv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TabStadisticsFragment extends BaseFragment{

	TextView tvHistorialEstadisticas;
	ListView lvHistorialStadisticas;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_tab_stadistics, container, false);
		tvHistorialEstadisticas  = (TextView) vi.findViewById(R.id.tvHistorialStadisticas);
		lvHistorialStadisticas = (ListView) vi.findViewById(R.id.lvHistorialStadisticas);
		//		tvRegistroHistorial=(TextView)vi.findViewById(R.id.tvUsuario);
		//		txtMedicIncCount=(EditText)vi.findViewById(R.id.txtMediIncCount);
		//		txtMedicineCount=(EditText)vi.findViewById(R.id.txtMedicineCount);
		//		txtUserCount=(EditText)vi.findViewById(R.id.txtUserCount);
		//		LoadDatabase(getActivity());
		//		txtUserCount.setText(pr.countUser());
		//		txtMedicineCount.setText(pr.countMedicine());
		//		txtMedicationCount.setText(pr.countMedication());
		//		txtMedicIncCount.setText(0);

		return vi;
	}


}
