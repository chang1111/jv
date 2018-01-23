package com.spring.exam08;

public class PagingHelper {  

    private int           rowsPerPage    ; //페이지당 출력할 레코드 수. 기본값은 10으로 한다.
    private int           pagesPerBlock  ; //페이징시 나타낼 페이지 수. 기본값은 10으로 한다.
    
    private int           totalPage;      // 총 페이지 개수
    private int           firstPage;      // 첫번째 페이지 번호
    private int           lastPage;       // 마지막 페이지 번호
    private int           prevLink;       // 이전 게시물
    private int           nextLink;       // 다음 게시물
    private int           startRecord;    // 목록을 구할때 쓰이는 ROWNUM 시작
    private int           endRecord;      // 목록을 구할때 쓰이는 ROWNUM 끝
    private int           listNo;         // 목록에서 위에서 순서대로 붙여지는 번호
    private int[]         pageLinks;      // 첫번쩨 페이지 번호부터 시작하여 1씩 증가하여 마지막 페이지번호까지의 int[] 배열
    private int           totalLastPage;
    private int           totalFirstPage;
      
    public int getFirstPage() {
        return firstPage;
    }
    
    public int getLastPage() {
        return lastPage;
    }
    
    public int getPrevLink() {
        return prevLink;
    }
    
    public int getNextLink() {
        return nextLink;
    }
    
    public int getStartRecord() {
        return startRecord;
    }
    
    public int getEndRecord() {
        return endRecord;
    }
    
    public int getListNo() {
        return listNo;
    }
    
    public int[] getPageLinks() {
        return pageLinks;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getPagesPerBlock() {
        return pagesPerBlock;
    }

    public int getTotalLastPage() {
        return totalLastPage;
    }

    public int getTotalFirstPage() {
        return 1;
    }
    
    public PagingHelper(int totalRecord, int curPage) {
        super();
        
        this.rowsPerPage    = 10;
        this.pagesPerBlock  = 10; 
        
        setPagingValue(totalRecord, curPage, this.rowsPerPage, this.pagesPerBlock);
    }
    
    public PagingHelper(int totalRecord, int curPage, int rowsPerPage, int pagesPerBlock) {
        super();
        this.rowsPerPage = rowsPerPage;
        this.pagesPerBlock = pagesPerBlock;
        
        setPagingValue(totalRecord, curPage, rowsPerPage, pagesPerBlock);
    }
    

    public void setPagingValue(int totalRecord, int curPage) {
    
        setPagingValue(totalRecord, curPage, this.rowsPerPage, this.pagesPerBlock);
    }
    
    public void setPagingValue(int totalRecord, int curPage, int rowsPerPage, int pagesPerBlock) {
        
        this.totalPage = ((totalRecord % rowsPerPage) == 0)  
                ? totalRecord / rowsPerPage : totalRecord / rowsPerPage + 1;
        
        this.totalLastPage = this.totalPage;
        
        int totalBlock = ((totalPage % pagesPerBlock) == 0)
                ? totalPage / pagesPerBlock : totalPage / pagesPerBlock + 1;
        
        int currentBlock = ((curPage % pagesPerBlock) == 0) 
                ?  curPage / pagesPerBlock : curPage / pagesPerBlock + 1;
        
        this.firstPage = (currentBlock - 1) * pagesPerBlock + 1;
        
        this.lastPage = currentBlock * pagesPerBlock;
        
        if (currentBlock >= totalBlock) {
            this.lastPage = totalPage;
        }
        
        pageLinks = makeArray(firstPage, lastPage);
        
        if (currentBlock > 1) {
            this.prevLink = firstPage - 1;
        }
        
        if (currentBlock < totalBlock) {
            this.nextLink = lastPage + 1;
        }
        
        this.listNo = totalRecord - (curPage - 1) * rowsPerPage;
        this.startRecord = (curPage - 1) * rowsPerPage + 1;
        this.endRecord = startRecord + rowsPerPage - 1;
    }

    private int[] makeArray(int first, int last) {
        int size = last - first + 1;
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = first++;
        }
        
        return ret;
    }
    
}
