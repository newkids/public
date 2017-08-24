package apims.login.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import apims.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository("LoginDAO")
public class LoginDAO extends EgovAbstractDAO{
	public EgovMap loginIdPwCheck(LoginVO vo) throws Exception{
		EgovMap egovMap = (EgovMap)select("login.getUser", vo);
		return egovMap;
	}
}
