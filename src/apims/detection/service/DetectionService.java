package apims.detection.service;

import java.util.HashMap;
import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface DetectionService {
	// 주민번호 검출 리스트
	List<EgovMap> getJuminList(HashMap<String, Object> pMap) throws Exception;

	// 전화번호 검출 리스트
	List<EgovMap> getPhonList(HashMap<String, Object> pMap) throws Exception;
}
