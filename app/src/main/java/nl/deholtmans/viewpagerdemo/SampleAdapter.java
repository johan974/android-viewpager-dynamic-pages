package nl.deholtmans.viewpagerdemo;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import nl.deholtmans.viewpagerdemo.EditorFragment.PAGE_ACTION;

public class SampleAdapter extends FragmentStatePagerAdapter {
    Context ctxt = null;
    private int numberOfCircularPages = 10;
    private PageAdmin pageAdmin;
    private int pageNumber = 7;

    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt = ctxt;
        pageAdmin = new PageAdmin( pageNumber, 1, 10);
    }

    @Override
    public int getCount() {
        return (numberOfCircularPages + 2);
    }

    @Override
    public Fragment getItem(final int position) {
        pageNumber = pageAdmin.updatePosition(position);
        //lastPosition = position; // determineLastPosition( position, lastPosition);
        if (position == 0) {
            return (EditorFragment.newInstance(numberOfCircularPages - 1, pageNumber));
        } else if (position == numberOfCircularPages + 1) {
            return (EditorFragment.newInstance(0, pageNumber));
        } else {
            return (EditorFragment.newInstance(position - 1, pageNumber));
        }
    }

    @Override
    public String getPageTitle(int position) {
        return (EditorFragment.getTitle(ctxt, position));
    }
}