package com.psm.farmacy;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

public class HistoryFragment extends BaseFragment {

	private TabHost mTabHost;
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		try
		{

		}
		catch(Exception ex)
		{
			ex.getCause();
		}
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		try
		{
			vi=inflater.inflate(R.layout.fragment_history, container, false);		
			mTabHost = (TabHost) vi.findViewById(android.R.id.tabhost);
			mTabHost.setup();
			mViewPager = (ViewPager) vi.findViewById(R.id.pager);
			mTabsAdapter = new TabsAdapter(getActivity(), mTabHost, mViewPager);
			mTabsAdapter.addTab(mTabHost.newTabSpec("one").setIndicator("One"), TabUserFragment.class, null);
			mTabsAdapter.addTab(mTabHost.newTabSpec("two").setIndicator("Two"), TabStadisticsFragment.class, null);
			return vi;       
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return vi;
	}

	public static class TabsAdapter extends FragmentPagerAdapter implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
	{
		private final Context mContext;
		private final TabHost mTabHost;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		static final class TabInfo
		{
			private final String tag;
			private final Class<?> clss;
			private final Bundle args;

			TabInfo(String _tag, Class<?> _class, Bundle _args)
			{
				tag = _tag;
				clss = _class;
				args = _args;
			}
		}

		static class DummyTabFactory implements TabHost.TabContentFactory
		{
			private final Context mContext;

			public DummyTabFactory(Context context)
			{
				mContext = context;
			}

			public View createTabContent(String tag)
			{
				View v = new View(mContext);
				v.setMinimumWidth(0);
				v.setMinimumHeight(0);
				return v;
			}
		}

		public TabsAdapter(FragmentActivity activity, TabHost tabHost, ViewPager pager)
		{
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mTabHost = tabHost;
			mViewPager = pager;
			mTabHost.setOnTabChangedListener(this);
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args)
		{
			tabSpec.setContent(new DummyTabFactory(mContext));
			String tag = tabSpec.getTag();

			TabInfo info = new TabInfo(tag, clss, args);
			mTabs.add(info);
			mTabHost.addTab(tabSpec);
			notifyDataSetChanged();
		}

		@Override
		public int getCount()
		{
			return mTabs.size();
		}

		@Override
		public Fragment getItem(int position)
		{
			TabInfo info = mTabs.get(position);

			return Fragment.instantiate(mContext, info.clss.getName(), info.args);

		}

		public void onTabChanged(String tabId)
		{
			int position = mTabHost.getCurrentTab();
			mViewPager.setCurrentItem(position);
		}

		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
		{
		}

		public void onPageSelected(int position)
		{
			TabWidget widget = mTabHost.getTabWidget();
			int oldFocusability = widget.getDescendantFocusability();
			widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
			mTabHost.setCurrentTab(position);
			widget.setDescendantFocusability(oldFocusability);
		}

		public void onPageScrollStateChanged(int state)
		{
		}

	}

}
