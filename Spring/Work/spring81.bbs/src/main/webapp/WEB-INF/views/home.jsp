<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>   
    <p>  The time on the server is ${serverTime}. </p>
    <hr />
    
    
    <h2> 로그인 처리 </h2>
    <ol>
        <li> <a href="./user"                 target="_blank">./user/                </a> </li>
        <li> <a href="./user/login"           target="_blank">./user/login           </a> </li>
        <li> <a href="./user/logout"          target="_blank">./user/logout          </a> </li>
        <li> <a href="./user/register"        target="_blank">./user/register        </a> </li>
        <li> <a href="./user/unregister"      target="_blank">./user/unregister      </a> </li>
        <li> <a href="./user/usermodify"      target="_blank">./user/usermodify          </a> </li>
        <li> <a href="./user/changepassword"  target="_blank">./user/changepassword  </a> </li>        
        <li>jsp 파일에 layout include 하기
            <ul> 
                <li> login.jsp      </li>
                <li> register.jsp    </li>
                <li> usermodify.jsp      </li>
                <li> changepassword.jsp     </li>
            </ul>
            <xmp>
<div id="wrap">
    <div id="header">
        < %@ include file="../inc/header.jsp" % >
    </div>

    <div id="main-menu">
        < %@ include file="../inc/main-menu.jsp" % >
    </div>

    <div id="container">
    </div>
        
    <div id="sidebar">
        < %@ include file="../inc/bbs-menu.jsp" % >
    </div>
    
    <div id="extra">
        < %@ include file="../inc/extra.jsp" % >
    </div>

    <div id="footer">
        < %@ include file="../inc/footer.jsp" % >
    </div>
</div>            
            </xmp>
        </li>
    </ol>  
    
    <hr />
    
    <h2>board 게시판 만들기</h2>  
    
    <ol>
        <li><a href="./board/boardlist"  target="_blank">./board/boardlist </a></li>
        <li><a href="./board/boardview?boardcd=qna" target="_blank">./board/boardview?boardcd=qna </a></li>
        <li><a href="./board/boardview" target="_blank">./board/boardview  == ./board/boardview?boardcd=free</a></li>
        <li><a href="./board/boardview/qna" target="_blank">./board/boardview/qna</a></li>
        <li><span> boardlist 에 boardview 연결하기 </span> </li>
        <li><span> boardlist의 tr을 클릭하면 boardview 가 열리게 하시오 </span>
            <xmp>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>    
        $(document).ready( function(e){
            
            //boardlist에서 해당 게시글을 클릭하면 boardview 가 열리게 하시오
            $('div#bbs > table > tbody > tr').click( function(e){
                var boardcd = $(this).attr('boardcd');
                //window.location='/board/boardview?boardcd=' + boardcd ;
                window.location='/board/boardview/' + boardcd ;
            });
        });
    </script> 
            </xmp>        
        </li>
        <li><a href="./board/boardmodify?boardcd=qna" target="_blank">./board/boardmodify?boardcd=qna</a></li>
        <li><a href="./board/boardmodify/qna" target="_blank">./board/boardmodify/qna</a></li>
        <li><span> boardview 에 boardmodify 연결하기 </span></li>
        <li><a href="./board/boardwrite" target="_blank">./board/boardwrite</a></li>
        <li><span> boardlist와 boardview 에 boardwrite 연결하기 </span></li>
        <li><span> boardview 에 boarddelete 연결하기 </span></li>
        <li>jsp 파일에 layout include 하기
            <ul> 
                <li> boardlist.jsp      </li>
                <li> boardmodify.jsp    </li>
                <li> boardview.jsp      </li>
                <li> boardwrite.jsp     </li>
            </ul>
            <xmp>
<div id="wrap">
    <div id="header">
        < %@ include file="../inc/header.jsp" % >
    </div>

    <div id="main-menu">
        < %@ include file="../inc/main-menu.jsp" % >
    </div> 

    <div id="container">
    </div>
        
    <div id="sidebar">
        < %@ include file="bbs-menu.jsp" % >
    </div>
    
    <div id="extra">
        < %@ include file="../inc/extra.jsp" % >
    </div>

    <div id="footer">
        < %@ include file="../inc/footer.jsp" % >
    </div>     
</div>            
            </xmp>
        </li>
    </ol>    
    <hr />
    
    
    
    <h2>article 게시판 만들기</h2>  
    <ul>
        <li><a href="./board/articlelist"  target="_blank">./board/articlelist</a> </li>
        <li><a href="./board/articleview?boardcd=free&articleno=17&curPage=1&searchWord="   target="_blank">/board/articleview?boardcd=free&amp;articleno=17&amp;curPage=1&amp;searchWord=  </a></li>
        <li><a href="./board/articlewrite?boardcd=free"                                     target="_blank">/board/articlewrite?boardcd=free                                                </a></li>
        <li><a href="./board/articlemodify?boardcd=free&articleno=17&curPage=1&searchWord=" target="_blank">/board/articlemodify?boardcd=free&amp;articleno=17&amp;curPage=1&amp;searchWord=</a></li>
        <li><a href="./board/articledelete?boardcd=free&articleno=17&curPage=1&searchWord=" target="_blank">/board/articledelete?boardcd=free&amp;articleno=17&amp;curPage=1&amp;searchWord=</a></li>
    </ul>
    <br />
    <hr />
    
    <h2> RestController </h2>    
    <ol>
        <li>build.gradle 라이브러리 추가
            <xmp>
    // json library :: @ResponseBody를 이용해 json 데이터를 반환하기 위한 라이브러리
    compile "org.codehaus.jackson:jackson-mapper-asl:1.9.13"
        
    // JsonView를 사용하기 위한 라이브러리
    compile group: 'net.sf.json-lib', name: 'json-lib-ext-spring', version: '1.0.2'
            </xmp>
        </li>
        <li>RestConroller.java 만들기
            <xmp>
@Controller
@RequestMapping("/restservice")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    
    @Autowired
    @Qualifier("serviceboard")    
    private IServiceBoard boardsrv; 

    @Autowired
    private IServiceUser usersrv;
    
    // http://localhost/restservice/ajaxone
    @RequestMapping(value = "/ajaxone", method = RequestMethod.GET)
    public String ajaxone(Model model) {
        logger.info("RestController.ajaxone");
        return "restservice/ajaxone";       
    }
    
    // http://localhost/restservice/jsonview
    @RequestMapping(value = "/jsonview", method = RequestMethod.GET)
    public @ResponseBody ModelBoard AjaxView(@RequestParam("boardcd") String boardcd) {
        return  boardsrv.getBoardOne(boardcd);
    }
    
    // http://localhost/restservice/login
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST} )
    public @ResponseBody ModelUser login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        return usersrv.login(id, pw);
    }
}
            </xmp>
        </li>
        <li>ajaxone.jsp 작성
            <p>
                <a href="./restservice/ajaxone?id=free"    target="_blank">./restservice/ajaxone?id=free    </a> <br />
            </p>
        </li>
        <li>ajaxlist.jsp  작성
            <p>
                <a href="./restservice/ajaxlist?id=free"   target="_blank">./restservice/ajaxlist?id=free   </a> <br />
            </p>
        </li>        
        <li>댓글용 rest 서비스 만들기
            <ol>
                <li>./restservice/commentadd    만들기 </li>
                <li>./restservice/commentedit   만들기 </li>
                <li>./restservice/commentdelete 만들기 </li>
            </ol>
        </li>
    </ol>  
    
    <hr />
   
    
    <h2> 오류 페이지 설정 </h2>
    <ol>
        <li>web.xml 에 아래 내용 추가</li>
    </ol>
  
    <xmp>
        <!-- 에러 페이지 설정 -->
        <error-page>
            <error-code>403</error-code>
            <location>/WEB-INF/views/common/error.jsp</location>
        </error-page>
    
        <error-page>
            <error-code>404</error-code>
            <location>/WEB-INF/views/common/error/404.jsp</location>
        </error-page>
    
        <error-page>
            <error-code>500</error-code>
            <location>/WEB-INF/views/common/error/500.jsp</location>
        </error-page>  
    </xmp>
    <hr />
   
</body>
</html>
