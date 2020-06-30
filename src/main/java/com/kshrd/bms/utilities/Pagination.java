package com.kshrd.bms.utilities;

public class Pagination {
    private int page;
    private int limit;
    private int nextPage;
    private int previousPage;
    private int totalCount;
    private int totalPages;
    private int pagesToShow;
    private int startPage;
    private int endPage;
    private int offset;

    public Pagination(){
        page = 1;
        limit= 5;
        offset = 0;
        nextPage = 1;
        previousPage = 1;
        startPage = 1;
    }

    public Pagination(int page, int limit){
        this.page = page;
        this.limit = limit;
    }

    public Pagination(int page, int limit, int nextPage, int previousPage, int totalCount, int totalPages, int pagesToShow, int startPage, int endPage, int offset) {
        this.page = page;
        this.limit = limit;
        this.nextPage = nextPage;
        this.previousPage = previousPage;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pagesToShow = pagesToShow;
        this.startPage = startPage;
        this.endPage = endPage;
        this.offset = offset;
    }

    public int totalPages(){
        return (int) Math.ceil((double) getTotalCount() / limit);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getNextPage() {
        return page+1;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return page == 1 ? 1 : page - 1;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages();
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPagesToShow() {
        return pagesToShow;
    }

    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return getTotalPages();
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getOffset() {
        return (page-1) * limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
