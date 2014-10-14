package com.psm.farmacy;

import com.psm.Database.Procedures;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

public class Home extends ActionBarActivity
implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	public Procedures pr;
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;
	public static ActionBar action;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Leer Shared
		try{
			SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
			Toast.makeText(this, String.valueOf(sharedPref.getInt("lang",0)), Toast.LENGTH_LONG).show() ;
			//       
			setContentView(R.layout.activity_home);    
			mNavigationDrawerFragment = (NavigationDrawerFragment)
					getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
			mTitle = getTitle();

			// Set up the drawer.
			mNavigationDrawerFragment.setUp(
					R.id.navigation_drawer,
					(DrawerLayout) findViewById(R.id.drawer_layout));
			try{
				Fragment f= new HomeFragment();
				CambiarFragment(f);  
			}catch(Exception ex){        	
				String exep=ex.getMessage();
				Toast.makeText(this, exep, Toast.LENGTH_LONG).show();
				exep.toString();
			}
		}catch(Exception ex){
			ex.getMessage();
		}
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment= new Fragment();
		switch(position)
		{
		case 0:
			fragment= new HomeFragment();
			mTitle = getString(R.string.navDrw_Home);
			break;
		case 1:
			fragment = new ProfileFragment(); 	 
			mTitle = getString(R.string.navDrw_Profile);  
			break;
		case 2:
			fragment= new HistoryFragment();
			break;
		case 3:
			fragment= new MedicFragment();
			mTitle = getString(R.string.navDrw_Medication); 
			break;
		case 4:
			fragment= new DrugstoreMapFragment();
			mTitle=getString(R.string.navDrw_Drugstores);
			break;
		case 5: 
			fragment = new ConfigurationFragment();	 
			mTitle = getString(R.string.navDrw_Configuration);        
			break;
		case 6:
			fragment = new OpenGLFragment();
			mTitle=getString(R.string.navDrw_About);  
			break;
		default:    			
			fragmentManager.beginTransaction()
			.replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
			.commit();
			break;
		}
		CambiarFragment(fragment);
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.navDrw_Home);
			break;
		case 2:
			mTitle = getString(R.string.navDrw_Profile);                
			break;
		case 3:
			mTitle = getString(R.string.navDrw_Medication);               
			break;
		case 4:
			mTitle = getString(R.string.navDrw_Configuration);            	
			break;
		case 5:
			mTitle=getString(R.string.navDrw_Drugstores);
			break;
		case 6:
			mTitle=getString(R.string.navDrw_About);
			break;
		}
	}

	public void restoreActionBar() {
		action = getSupportActionBar();
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		action.setDisplayShowTitleEnabled(true);
		if(mNavigationDrawerFragment.isDrawerOpen())
		{
			action.setTitle(getResources().getString(R.string.app_name));
		}
		else
		{
			action.setTitle(mTitle);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {            
			getMenuInflater().inflate(R.menu.home, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		Fragment frag= new Fragment();
		if (id == R.id.action_settings) {
			return true;     
		}
		if(id==R.id.ProfileAdd)
		{        	
			frag= new ProfileAddFragment(false, 0);
			CambiarFragment(frag);
		}
		if(id==R.id.MedicineAdd)
		{
			frag= new MedicineAddFragment();
			CambiarFragment(frag);
		}
		if(id==R.id.MedicationAdd)
		{
			frag=new MedicationAddFragment();
			CambiarFragment(frag); 	
		}
		return super.onOptionsItemSelected(item);
	}

	public void CambiarFragment(Fragment frag)
	{
		FragmentManager fragmentManager = getSupportFragmentManager();    
		FragmentTransaction FT =fragmentManager.beginTransaction();
		FT.replace(R.id.container, frag);
		FT.commit();
	}
	public static class PlaceholderFragment extends Fragment {

		private static final String ARG_SECTION_NUMBER = "section_number";

		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container, false);            
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((Home) activity).onSectionAttached(
					getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}

}
