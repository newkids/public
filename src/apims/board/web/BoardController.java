package apims.board.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apims.board.service.BoardService;
import apims.board.service.BoardVO;
import apims.cmm.SearchVO;
import apims.util.LoginManager;

import com.google.gson.Gson;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class BoardController {

	@Resource
	private BoardService service;
		
		private String goLogin = "redirect:/login.do";	// go : login.do

		
		/**
		 * <pre>
		 * 게시판
		 * </pre>
		 * 
		 * @Method Name	: board
		 * @date		: 2017. 08. 21
		 * @return
		 * @throws FPMException
		 */
		@RequestMapping("/board/board.do")
		public String board(HttpServletRequest request,
				ModelMap model) throws Exception{
			
			Map<String, Object> hMap = new HashMap<String, Object>();
			List<EgovMap> list = service.getBoardList(hMap);
						
			model.addAttribute("list", list);

			return "board/board";
			}

		
		/**
		 * <pre>
		 * 공지사항 등록 페이지
		 * </pre>
		 * 
		 * @Method Name	: noticeRegistPage
		 * @date		: 2016. 9. 13.
		 * @return
		 * @throws FPMException
		 */
		@RequestMapping("/board/writePage.do")
		public String writePage(HttpServletRequest request,
								@ModelAttribute("BoardVO") BoardVO vo,
								@ModelAttribute("searchVO") SearchVO searchVO,
								ModelMap model) throws Exception{
			
			Map<String, Object> hMap = new HashMap<String, Object>();
			
			
			return "board/write";
		}
		
		/**
		 * <pre>
		 * 공지사항 등록
		 * </pre>
		 * 
		 * @Method Name	: noticeRegist
		 * @date		: 2016. 9. 13.
		 * @return
		 * @throws FPMException
		 * @throws IOException 
		 */
		@RequestMapping("/board/write.do")
		public void write(HttpServletRequest request,
								 @ModelAttribute("boardVO") BoardVO vo,
								 HttpServletResponse response) throws Exception, IOException{
			Gson gson = new Gson();
			
			Map<String, Object> hMap = new HashMap<String, Object>();
			
			service.insertCommunity(vo);
			
			response.setContentType("application/json");
		    response.setContentType("text/xml;charset=utf-8");
		    response.setHeader("Cache-Control", "no-cache");
		    response.getWriter().write(gson.toJson(hMap));
		}
		
		
		/**
		 * <pre>
		 * 상세 페이지
		 * </pre>
		 * 
		 * @Method Name	: view
		 * @date		: 2017. 08. 21
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/board/view.do")
		public String viewPage(HttpServletRequest request,
								ModelMap model) throws Exception{
			
			Map<String, Object> pMap = new HashMap<String, Object>();

			String cno = (request.getParameter("boardNo") == null)? "" : (request.getParameter("boardNo") == "undefined")? "" : request.getParameter("boardNo");
			pMap.put("boardNo", cno);
			
			EgovMap egov = service.getBoardContent(pMap);
			model.addAttribute("map", egov);
			
			return "board/view";
		}
		
		
		@RequestMapping("/board/modify.do")
		public void modify(HttpServletRequest request,
				 @ModelAttribute("boardVO") BoardVO vo,
				 HttpServletResponse response) throws Exception{
			
			Gson gson = new Gson();
			
			HashMap<String, Object> hMap = new HashMap<String, Object>();
			
			service.updateContent(vo);
			
			response.setContentType("application/json");
			response.setContentType("text/xml;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(gson.toJson(hMap));
			
		}
		
		@RequestMapping("/board/modifyPage.do")
		public String modifyPage(HttpServletRequest request,
				ModelMap model) throws Exception{
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			
			String cno = (request.getParameter("boardNo") == null)? "" : (request.getParameter("boardNo") == "undefined")? "" : request.getParameter("boardNo");
			pMap.put("boardNo", cno);
			
			EgovMap egov = service.getBoardContent(pMap);
			model.addAttribute("map", egov);
			
			return "board/modify";
}
		
		@RequestMapping("/board/delete.do")
		public void delete(HttpServletRequest request,
				 @ModelAttribute("boardVO") BoardVO vo,
				 HttpServletResponse response) throws Exception, IOException{
			
			Gson gson = new Gson();
			
			Map<String, Object> hMap = new HashMap<String, Object>();
			
			service.deleteCommunity(vo.getBoardNo());
			
			response.setContentType("application/json");
			response.setContentType("text/xml;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(gson.toJson(hMap));
			}
		}
