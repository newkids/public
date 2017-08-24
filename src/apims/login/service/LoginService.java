package apims.login.service;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface LoginService {
	EgovMap loginIdPwCheck(LoginVO vo) throws Exception;
}
