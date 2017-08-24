package apims.detection.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository
public class DetectionDAO extends EgovAbstractDAO{

	// 주민번호 검출 리스트
	List<EgovMap> getJuminList(HashMap<String, Object> pMap) throws Exception{
		List<EgovMap> list = (List<EgovMap>)list("detection.getJuminList", pMap);
		return list;
	}

	// 전화번호 검출 리스트
	List<EgovMap> getPhonList(HashMap<String, Object> pMap) throws Exception{
		List<EgovMap> list = (List<EgovMap>)list("detection.getPhonList", pMap);
		return list;
	}
}
