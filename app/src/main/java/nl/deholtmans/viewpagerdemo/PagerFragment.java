package nl.deholtmans.viewpagerdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.pager, container, false);
        final ViewPager pager = result.findViewById(R.id.pager);
        pager.setAdapter(buildAdapter());
        final CircularViewPagerHandler circularViewPagerHandler = new CircularViewPagerHandler(pager);
        pager.addOnPageChangeListener(circularViewPagerHandler);
        return (result);
    }

    private PagerAdapter buildAdapter() {
        return (new SampleAdapter(getActivity(), getChildFragmentManager()));
    }
}
