package apims.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import apims.login.service.LoginService;
import apims.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginDAO dao;

	public EgovMap loginIdPwCheck(LoginVO vo) throws Exception{
		EgovMap egovMap = dao.loginIdPwCheck(vo);
		return egovMap;
	}
}
