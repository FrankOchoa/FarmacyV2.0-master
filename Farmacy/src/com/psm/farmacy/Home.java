package com.psm.farmacy;

//import com.psm.Database.Procedures;
//import com.psm.Model.Lang;
import com.psm.Database.Procedures;
import com.psm.utilery.*;

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

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //Leer Shared
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
        try
        {
        //Procedures pr= new Procedures(this);
        //List<String> lista= pr.LstPeriodos(Lang.French);
        //int id=pr.SrcPeriodo("Ans", Lang.French);
       // List<String> lista= pr.LstActivos(Lang.French);
        //List<String[]> lista= pr.LstExcipientes(Lang.English);
        //int id=pr.SrcExcipiente("Drops", Lang.English);       
        DateOperations.GenerateSchedule("20140205102511", 1, 8);
        }catch(Exception ex)
        {        	
        	String exep=ex.getMessage();
        	Toast.makeText(this, exep, Toast.LENGTH_LONG).show();
        	exep.toString();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    	FragmentManager fragmentManager = getSupportFragmentManager();
    	Fragment fragment= new Fragment();
    	switch(position)
    	{
    		case 0:
    			fragment= PlaceholderFragment.newInstance(position + 1);
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
	    		fragment= new MedicationFragment();
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        if(mNavigationDrawerFragment.isDrawerOpen())
        {
        	actionBar.setTitle(getResources().getString(R.string.app_name));
        }
        else
        {
        	actionBar.setTitle(mTitle);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;            
        }
        if(id==R.id.ProfileAdd)
        {
        	Toast.makeText(this,"Adding a new profile",Toast.LENGTH_LONG).show();
        	Fragment frag= new ProfileAddFragment();
        	CambiarFragment(frag);
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void CambiarFragment(Fragment frag)
    {
    	FragmentManager fragmentManager = getSupportFragmentManager();    
    	FragmentTransaction FT =fragmentManager.beginTransaction();
		FT.replace(R.id.container, frag);
		FT.addToBackStack(null);
		FT.commit();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
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
