package com.spring81.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.PagingHelper;
import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelBoard;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired // 인스턴스 생성
	IServiceBoard srvboard;

    // /board/boardlist
	// /board/boardlist?searchWord=
	@RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
	public String boardlist( Model model
	        , @RequestParam(defaultValue="") String searchWord 
	        , @RequestParam(defaultValue="1") Integer curPage) {
		logger.info("/board/boardlist");
		
		// 전체 레코드 수 가져오기
		int totalRecord = srvboard.getBoardTotalRecord(searchWord);
		 
        // 페이징을 위한 코드 추가
		PagingHelper paging = new PagingHelper(totalRecord, curPage, 5, 5);
		
		List<ModelBoard> result = srvboard.getBoardPaging("", searchWord, paging.getStartRecord(), paging.getEndRecord());
		
		// list		
        model.addAttribute("list"   , result);
        
        // 페이징을 위한 Url 변수들 추가
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        
        // 페이징을 처맇기 위한 변수 추가
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink()); 
		
		return "board/boardlist"; // views / board / boardlist.jsp
	}

    // /board/boardview   <===> /board/boardview?boardcd=free
    // /board/boardview?boardcd=qna
    @RequestMapping(value = "/board/boardview", method = RequestMethod.GET)
    public String boardview( Model model
            , @RequestParam(defaultValue="free") String boardcd ) {
        logger.info("/board/boardview");
         
        ModelBoard result = srvboard.getBoardOne(boardcd);
        
        // boardnm, board
        //model.addAttribute("boardnm", srvboard.getBoardName(boardcd) );
        model.addAttribute("boardnm", result.getBoardnm() );
        model.addAttribute("board"  , result  );
        
        return "board/boardview"; // views / board / boardview.jsp
    }
    
    // /board/boardview/qna
    @RequestMapping(value = "/board/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardviewPath( Model model
            , @PathVariable(value="boardcd") String boardcd ) {
        logger.info("/board/boardview");
         
        ModelBoard result = srvboard.getBoardOne(boardcd);
        
        // boardnm, board
        //model.addAttribute("boardnm", srvboard.getBoardName(boardcd) );
        model.addAttribute("boardnm", result.getBoardnm() );
        model.addAttribute("board"  , result  );
        
        return "board/boardview"; // views / board / boardview.jsp
    }
    

    // /board/boardmodify   <===> /board/boardmodify?boardcd=free
    // /board/boardmodify?boardcd=qna
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.GET)
    public String boardmodify( Model model
            , @RequestParam(defaultValue="free") String boardcd 
            , HttpServletRequest request) {
        logger.info("/board/boardmodify");
         
        ModelBoard result = srvboard.getBoardOne(boardcd);
        
        String actionurl = request.getRequestURL().toString();
        
        // boardnm, actionurl, board
        //model.addAttribute("boardnm", srvboard.getBoardName(boardcd) );
        model.addAttribute("boardnm"  , result.getBoardnm() );
        model.addAttribute("board"    , result  );
        model.addAttribute("actionurl", actionurl );
        
        return "board/boardmodify"; // views / board / boardmodify.jsp
    }
    
    // /board/boardmodify/free
    // /board/boardmodify/qna
    @RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodifyPath( Model model
            , @PathVariable(value="boardcd") String boardcd 
            , HttpServletRequest request) {
        logger.info("/board/boardmodify/{boardcd}");
         
        ModelBoard result = srvboard.getBoardOne(boardcd);
        
        String actionurl = request.getRequestURL().toString();
        
        // boardnm, actionurl, board
        //model.addAttribute("boardnm", srvboard.getBoardName(boardcd) );
        model.addAttribute("boardnm"  , result.getBoardnm() );
        model.addAttribute("board"    , result  );
        model.addAttribute("actionurl", actionurl );
        
        return "board/boardmodify"; // views / board / boardmodify.jsp
    }
    

    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.POST)
    public String boardmodify( Model model
                             , @ModelAttribute ModelBoard setValue
                             , RedirectAttributes rttr ) {
        logger.info("/board/boardmodify");
        
        ModelBoard whereValue = new ModelBoard();
        whereValue.setBoardcd(   setValue.getBoardcd() );
         
        int result = srvboard.updateBoard(setValue, whereValue);
        
        if( result > 0 ) {       
            return "redirect:/board/boardlist";
        }
        else {
            // RedirectAttibutes 를 이용하여 오류 메시지 전달.
            rttr.addFlashAttribute("msg", WebConstants.MSG_FAIL_UPDATE_TABLE);
            rttr.addFlashAttribute("boardcd", setValue.getBoardcd()  );
            
            return "redirect:/board/boardmodify"; 
        }
    }

    // /board/boardwrite  
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.GET)
    public String boardwrite( Model model) {
        logger.info("/board/boardwrite");
         
        return "board/boardwrite"; // views / board / boardwrite.jsp
    }

    // /board/boardwrite  
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.POST)
    public String boardwrite( Model model
            , @ModelAttribute ModelBoard board
            , RedirectAttributes rttr ) {
        logger.info("/board/boardwrite");
        
        int result = srvboard.insertBoard(board);
        
        if( result > 0 ) { 
            return "redirect:/board/boardview/" + board.getBoardcd();
        }
        else {
            rttr.addFlashAttribute("msg"  , WebConstants.MSG_FAIL_INSERT_TABLE);
            rttr.addFlashAttribute("board", board);
            
            return "redirect:/board/boardwrite";            
        }   
    }
    // /board/boarddelete
    @RequestMapping(value = "/board/boarddelete", method = RequestMethod.POST)
    public String boarddelete( Model model
            , @RequestParam(value="boardcd") String boardcd
            , RedirectAttributes rttr) {
        logger.info("/board/boarddelete");
        
        ModelBoard board = new ModelBoard();
        board.setBoardcd( boardcd );
        
        int result = srvboard.deleteBoard(board);
        
        if( result > 0 ) { 
            return "redirect:/board/boardlist";
        }
        else {
            rttr.addFlashAttribute("msg"  , WebConstants.MSG_FAIL_DELETE_TABLE);
            rttr.addFlashAttribute("board", board);
            
            return "redirect:/board/boardwrite";            
        }   
    }
}
