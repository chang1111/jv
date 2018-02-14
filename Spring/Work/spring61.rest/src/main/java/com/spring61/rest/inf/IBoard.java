package com.spring61.rest.inf;

import java.util.*;

import com.spring61.rest.model.*;

public interface IBoard {
    
    /*
     * Board테이블. 게시판 이름 구하기
     * html의 <title> 에 제목 출력시 사용.
     * boardcd로 boardnm(게시판) 조회
     */
    public String getBoardName(String boardcd);

    /*
     * Board테이블. 게시판 정보 구하기
     * boardcd로 boardcd(게시판코드),boardnm(게시판이름),UseYN(사용여부) 조회
     */
    public ModelBoard getBoardOne(String boardcd);

    /*
     * Board테이블. 게시판의 총 갯수 구하기
     */
    public int getBoardTotalRecord(String searchWord);
    
    /*
     * Board테이블에서 boardcd,boardnm,UseYN 값 반환 
     * 매개변수로 hashmap이 사용되며 hash맵에 4개의 변수 사용 
     * boardcd,searchWord(게시판이름),start(시작페이지),end(끝페이지) 
     * if 조건 2개
     * 1. boardcd가 NULL이 아니고 ''이 아닐때 boardcd= #{boardcd} 쿼리 추가
     * 2. boardnm이 위와 같을때 boardnm like searchWord 쿼리 추가
     * 둘다 아닐시 1=1 조건 검색, boardcd,boardnm,UseYN 그룹묶음,boardcd 내림차순정렬
     * 마지막으로 start,end 범위 조회
     */
    public List<ModelBoard> getBoardPaging(String searchWord, int start, int end);
    
    /*
     * Board테이블. 게시판 전체 리스트 구하기
     * Board테이블의 모든 컬럼을 boardnm기준 정렬 값 반환 
      *
     * Board테이블에서 boardcd,boardnm,UseYN 값 반환 
     * if 조건 2개
     * 1. boardcd가 NULL이 아니고 ''이 아닐 때 boardcd like '%#boardcd%' 추가
     * 2. boardnm이 위와같을 때 boardnm LIKE '%#{boardnm}%' 추가
     * 둘다 아닐시 1=1 조건으로 반환
     */ 
    public List<ModelBoard> getBoardList(String searchWord);
    
    /*
     * Board테이블. 게시판 추가
     * Board 테이블 데이터 insert.
     */
    public int insertBoard(ModelBoard board);
    
    /*
     * Board테이블. 게시판 수정
     * Board 테이블 데이터 update
     */
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue);
    
    /*
     * Board테이블 게시판  삭제
     * Board 테이블에서 delete
     * 
     * delete from tb_bbs_comment     where articleno in ( select articleno from tb_bbs_article where boardcd = ? );
     * delete from tb_bbs_attachfille where articleno in ( select articleno from tb_bbs_article where boardcd = ? );
     * delete from tb_bbs_article     where boardcd = ?;
     * delete from tb_bbs_board       where boardcd = ?;
     *
     * if 조건 3개
     * 1. boardcd 값이 NULL이 아니고 '' 공백이 아닐때 boardcd로 조회문 추가
     * 2. boardnm 값이 위와같을 때 boardnm로 조회문 추가
     * 3. UseYN 값이 NULL이 아닐때 UseYN 조회 추가
     * 3개 조건식이 다 아니면 1=1 조건으로 전부 삭제
     */
    public int deleteBoard(ModelBoard board);
    
    /*
     * Board테이블. Board테이블에 item 추가.
     * 리스트에 들어 있는 항목수 만큼 한번에 multi insert.
     */
    public int insertBoardList(List<ModelBoard> list);
    
    
    
    
    

    /*
     * Article테이블. 특정 게시판의 총 게시물 갯수 구하기
     * 
     * 필수인자: boardcd
     * 선택인자: searchWord. if문 처리. 
     */
    public int getArticleTotalRecord(String boardcd, String searchWord);

    /*
     * Article테이블. 게시판 목록
     * article 테이블에서 start부터 end 까지의 row를 반환한다.
     *
     * 필수인자: boardcd, start, end
     * 선택인자: searchWord. if문 처리. 
     */
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);

    /*
     * Article테이블. 게시글 상세보기
     * articleno(기본키)를 이용하여 article 테이블에서 한 개의 row 를 리턴
     */
    public ModelArticle getArticle(int articleno);

    /*
     * Article테이블. 새로운 게시글  추가
     */
    public int insertArticle(ModelArticle article);

    /*
     * Article테이블. 게시글 수정
     * setValue   : set   절에서 사용될 데이터
     * whereValue : where 절에서 사용될 데이터
     */
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue);

    /*
     * Article테이블. 게시글 삭제
     */
    public int deleteArticle(ModelArticle article);

    /*
     * Article테이블. 조회수 증가
     * articleno 조건으로 찾아서 hit 컬럼의 값을 +1 증가 시킨다.
     */
    public int increaseHit(int articleno);
    
    /*
     * Article테이블. 다음글 보기 
     * articleno,boardcd,searchWord->Map 에 담는다
     */
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchWord);

    /*
     * Article테이블. 이전글 보기 
     * articleno,boardcd,searchWord->Map 에 담는다
     */
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord);

    /*
     * AttachFile테이블. 게시글의 첨부파일 정보 가져오기.
     */
    public ModelAttachFile getAttachFile(int attachFileNo);
    
    /*
     * AttachFile테이블. 게시글의 첨부파일 리스트
     */
    public List<ModelAttachFile> getAttachFileList(int articleno);

    /*
     * AttachFile테이블. 게시글에 새로운 첨부파일 추가 
     */
    public int insertAttachFile(ModelAttachFile attachFile);

    /*
     * AttachFile테이블. 게시글에서 첨부파일 삭제
     */
    public int deleteAttachFile(ModelAttachFile attachFile);

    /*
     * Comment테이블. 게시글에 덧글 한개 가져오기
     */
    public ModelComments getComment(int commentNo);

    /*
     * Comment테이블. 게시글에 덧글 리스트 구하기
     * 게시글 상세보기(articleview)에서 덧글 목록 출력할 때 사용.
     */
    public List<ModelComments> getCommentList(int articleno);
    
    /*
     * Comment테이블. 게시글에 덧글쓰기
     */
    public int insertComment(ModelComments comment);

    /*
     * Comment테이블. 게시글의 덧글수정
     */
    public int updateComment(ModelComments setValue, ModelComments whereValue);

    /*
     * Comment테이블. 게시글에서 덧글삭제
     */
    public int deleteComment(ModelComments comment);

}