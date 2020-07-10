package nl.deholtmans.viewpagerdemo;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SampleAdapter extends FragmentStatePagerAdapter {
    Context ctxt = null;
    private int numberOfPages = 10;

    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt = ctxt;
    }

    @Override
    public int getCount() {
        return (numberOfPages + 2);
    }

    @Override
    public Fragment getItem(final int position) {
        UserFeedback.showShort("SamplerAdapter: getItem: " + position);
        if (position == 0) {
            return (EditorFragment.newInstance(numberOfPages - 1));
        } else if (position == numberOfPages + 1) {
            return (EditorFragment.newInstance(0));
        } else {
            return (EditorFragment.newInstance(position - 1));
        }
    }

    @Override
    public String getPageTitle(int position) {
        return (EditorFragment.getTitle(ctxt, position));
    }
}