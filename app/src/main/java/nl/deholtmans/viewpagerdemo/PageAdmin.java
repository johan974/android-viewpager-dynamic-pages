package nl.deholtmans.viewpagerdemo;

public class PageAdmin {
    private int curPage;
    private int curBase = 1;
    private int circularPages = 10;

    public PageAdmin( int curPage, int curBase, int circularPages) {
        this.curPage = curPage;
        this.curBase = curBase;
        this.circularPages = circularPages;
    }

    public int updatePosition( int position) {
        if( Math.abs( curBase - position) <= 1) {
            ;
        } else if( curBase == 1 && position == circularPages) {
            curBase = position;
            curPage--;
        } else if( curBase == circularPages && position == 1) {
            curBase = position;
            curPage++;
        } else if( curBase > position){
            curBase--;
            curPage--;
        } else {
            curBase++;
            curPage++;
        }
        return getPage( position);
    }

    public int getPage( int position) {
        return curPage + ( position - curBase);
    }
}
