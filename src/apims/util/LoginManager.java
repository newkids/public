package apims.util;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import apims.board.service.BoardVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

public class LoginManager implements HttpSessionBindingListener{

	private static Hashtable loginUsers = new Hashtable();

	// 중복 로그인 체크
	public boolean isDuplication(String id){

		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = (HttpSession)e.nextElement();
			if(loginUsers.get(session).equals(id) ){
				//System.out.println("이미 로그인 중인 사용자 입니다.");
				return true;
			}
		}
		return false;
	}

	// 세션에 로그인 유저 추가
	public void setSession(HttpSession session, String id){
		session.setAttribute(id, this);
	}

	// 로그인 유저 삭제
	public void removeLoginUser(String id){
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		while(e.hasMoreElements()){
			session = (HttpSession)e.nextElement();
			if(loginUsers.get(session).equals(id)){
				loginUsers.remove(session);
			}
		}
	}

	public static boolean goDirect(HttpServletRequest request){
		if(null != request.getSession(false)){
			if(null != request.getSession().getAttribute("userId")){
				return true;
			}
		}
		return false;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		loginUsers.put(event.getSession(), event.getName());
		System.out.println("로그인");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		loginUsers.remove(event.getSession());
		System.out.println("로그아웃");
	}
	
	public static BoardVO getMemberInfo(){
			if (EgovUserDetailsHelper.isAuthenticated()) {
				return (BoardVO)EgovUserDetailsHelper.getAuthenticatedUser();
			} else {
			    return null;
			}
	}	
}
