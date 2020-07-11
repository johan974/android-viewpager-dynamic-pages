package nl.deholtmans.viewpagerdemo;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import nl.deholtmans.viewpagerdemo.EditorFragment.PAGE_ACTION;

public class SampleAdapter extends FragmentStatePagerAdapter {
    Context ctxt = null;
    private int numberOfCircularPages = 10;
    private int lastPosition = 1;
    private long pageNumber = 1;
    private static BookService bookService;
    private PAGE_ACTION pageAction;


    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt = ctxt;
        bookService = BookService.access();
        pageNumber = bookService.getPage();
    }

    @Override
    public int getCount() {
        return (numberOfCircularPages + 2);
    }

    @Override
    public Fragment getItem(final int position) {
        pageNumber = determinePageNumber(position, lastPosition, pageNumber);
        lastPosition = position; // determineLastPosition( position, lastPosition);
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

    private long determinePageNumber(int newPosition, int lastPosition, long lastPageNumber) {
        if (lastPosition < 0 || newPosition == lastPosition) {
            return lastPageNumber;
        } else if (newPosition > lastPosition) {
            return lastPageNumber + ( newPosition - lastPosition);
        }
        return lastPageNumber + (newPosition - lastPosition);
    }

    private int determineLastPosition( int position, int lastPosition) {
        if( position == lastPosition) {
            return position;
        }
        if( position > lastPosition) {
            return lastPosition + 1;
        }
        return lastPosition - 1;
    }
}