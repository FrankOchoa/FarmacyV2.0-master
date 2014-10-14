package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;
import com.psm.Database.Procedures;
import com.psm.Model.Lang;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ActivesFragment extends BaseFragment{
	private View vi;	
	private Button btnSearchActive;
	private EditText txtActiveName;
	private ListView lstActives;
	private List<String> activesParent;
	private String textMedicine;
	private int index;
	private String indication;
	private Bundle savedParams;
	
	public static ActivesFragment NewInstance(String name,int index,List<String> actives,String indication)
	{
		ActivesFragment frag= new ActivesFragment();		
		Bundle args = new Bundle();	
		args.putString("textMedicine", name);		
		args.putInt("selSpnType", index);
		args.putStringArrayList("actives", (ArrayList<String>) actives);
		args.putString("indication", indication);
		frag.setArguments(args);
		return frag;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi=inflater.inflate(R.layout.fragment_actives, container, false);
		try
		{
			savedParams=getArguments();
			index=savedParams.getInt("selSpnType");
			textMedicine=savedParams.getString("textMedicine");
			activesParent=savedParams.getStringArrayList("actives");
			indication=savedParams.getString("indication");
		}
		catch(Exception ex)
		{
			ex.getMessage();			
		}
		txtActiveName=(EditText) vi.findViewById(R.id.txtActiveName);
		btnSearchActive=(Button) vi.findViewById(R.id.btnSearchActive);
		lstActives=(ListView) vi.findViewById(R.id.lstActives);
		listeners();
		return vi;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		LoadDatabase(getActivity());		
		super.onCreate(savedInstanceState);
	}
	
	private void listeners()
	{
		btnSearchActive.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {		
				try
				{
					LoadDatabase(getActivity());
					Procedures pr2= new Procedures(getActivity()); 
					List<String> lista= new ArrayList<String>();
					Lang lan=getCurrentLang();
					String criteria=txtActiveName.getText().toString();
					lista=pr2.srcActivos(lan,criteria);
					lstActives.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,lista));
					hideInput(txtActiveName.getWindowToken());
				}
				catch(Exception ex )
				{
					ex.getMessage();
				}
			}
		});	
		
		lstActives.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				String item=lstActives.getItemAtPosition(position).toString();		
				activesParent=savedParams.getStringArrayList("actives");
				if(activesParent==null)
				{
					activesParent= new ArrayList<String>();
				}
				activesParent.add(item);
				Fragment fr=MedicineAddFragment.NewInstance(textMedicine, index, activesParent,indication);
				ReplaceFragment(fr);
				hideInput(txtActiveName.getWindowToken());		    
			}			
		});
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();		
		inflater.inflate(R.menu.actives, menu);		
	}
}
