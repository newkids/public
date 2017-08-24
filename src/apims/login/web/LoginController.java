package apims.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apims.login.service.LoginService;
import apims.login.service.LoginVO;
import apims.util.LoginManager;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class LoginController {

	@Resource(name="LoginService")
	private LoginService service;

	private String goMain = "redirect:/main.do";	// go : main.do
	private String alertMsg = "forward:/alert.do";	// go : alert.do	(request.setAttribute("strMessage", msg) [필요]
	
//	redirect : 웹 컨테이너가 웹 브라우저에게 다른 페이지로 이동하라고 명령 (url 변경됨, 리턴값 새로 생성)
//	forward : 웹 컨테이너만 이동 (url 변경안됨, 요청갑 살아있음)

	// login page
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) throws Exception{
		if(null != request.getSession().getAttribute("userId")){
			return goMain;
		}
		return "login/login";
	}

	
	// login check
	@RequestMapping("/loginCheck.do")
	public String loginCheck(HttpServletRequest request,
						HttpServletResponse response,
						@ModelAttribute LoginVO vo,
						ModelMap model){

		System.out.println(vo.getId());
		System.out.println(vo.getPw());

		LoginManager loginManager = new LoginManager();

		try{

			EgovMap egovMap = service.loginIdPwCheck(vo);

			if(null != egovMap){
				// 로그인 성공 (id, pw 일치[O])
				if(loginManager.isDuplication(vo.getId())){
					System.out.println("이미 로그인한 사용자 입니다.");
					request.setAttribute("strMessage", "이미 로그인한 사용자 입니다.");
					return alertMsg;
				}else{
					loginManager.setSession(request.getSession(), vo.getId());
					request.getSession().setAttribute("userId", vo.getId());
					System.out.println("로그인 성공!");
					request.getSession().setAttribute("userId", egovMap.get("id"));
					
					return goMain;
				}
			}else{
				// 로그인 실패 (id, pw 일치[X])
				request.setAttribute("strMessage", "아이디 / 비밀번호 가 일치하지 않습니다.");
				return alertMsg;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		
		if(LoginManager.goDirect(request)){
			return goMain;
		}

		return "login/login";
	}
	

	
	//logout
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/login.do";
	}

	//alert
	@RequestMapping("/alert.do")
	public void alert(HttpServletRequest request,
						HttpServletResponse response){
		try {
			String strMessage = (String)request.getAttribute("strMessage");
			PrintMsgBack(response, strMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//main Page
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request){

		if(null != request.getSession(false)){
			if(null != request.getSession().getAttribute("userId")){
				return "main";
			}
		}
		return "login/login";
		
	}

	public static void PrintMsgBack(HttpServletResponse response, String strMessage) throws IOException{
		//strMessage = URLEncoder.encode(strMessage, "UTF-8").replace("\\", "%20");
		String strMsg = String.format("<script language='javascript'>alert('%s');history.back();</script>", strMessage.replace("'", "\'"));

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(strMsg);
		response.flushBuffer();
	}
	
}
