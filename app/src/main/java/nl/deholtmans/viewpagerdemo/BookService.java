package nl.deholtmans.viewpagerdemo;

public class BookService {
    private static BookService singleton;
    private long pageNumber = 1;
    private int maxPage = 20;

    public static BookService access() {
        if( singleton == null) {
            singleton = new BookService();
            singleton.pageNumber = Math.round( Math.random() * singleton.maxPage);
        }
        return singleton;
    }
    public long getPage() {
        return pageNumber;
    }
    public long getNextPage() {
        if( ++pageNumber >= maxPage) {
            pageNumber = maxPage;
        }
        return pageNumber;
    }
    public long getPreviousPage() {
        if( --pageNumber < 1) {
            pageNumber = 1;
        }
        return pageNumber;
    }
}
