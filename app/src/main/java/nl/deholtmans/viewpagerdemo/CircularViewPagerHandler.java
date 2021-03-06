package nl.deholtmans.viewpagerdemo;

import androidx.viewpager.widget.ViewPager;

public class CircularViewPagerHandler implements ViewPager.OnPageChangeListener {
    private static final int SET_ITEM_DELAY = 300;
    private ViewPager mViewPager;
    private int lastPage = -1;
    private BookService bookService;

    CircularViewPagerHandler(final ViewPager viewPager) {
        mViewPager = viewPager;
        mViewPager.setCurrentItem(1, false);
        this.bookService = BookService.access();
    }

    @Override
    public void onPageSelected(final int position) {
        mViewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                handleSetCurrentItem(position);
            }
        }, SET_ITEM_DELAY);
    }

    private void handleSetCurrentItem(final int position) {
        final int lastPosition = mViewPager.getAdapter().getCount() - 1;
        System.out.println( "LastPosition " + lastPosition + ", new position " + position);
        if (position == 0) {
            mViewPager.setCurrentItem(lastPosition - 1, false);
        } else if (position == lastPosition) {
            mViewPager.setCurrentItem(1, false);
        }
    }

    @Override
    public void onPageScrollStateChanged(final int state) { }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        System.out.println( "Position " + position + ", position offset " + positionOffset);
    }

}
