package apims.detection.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import apims.detection.service.DetectionService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("DetectionService")
public class DetectionServiceImpl implements DetectionService {
	@Resource
	private DetectionDAO dao;

	// 주민번호 검출 리스트
	public List<EgovMap> getJuminList(HashMap<String, Object> pMap) throws Exception{
		List<EgovMap> list = dao.getJuminList(pMap);
		return list;
	}

	// 전화번호 검출 리스트
	
	public List<EgovMap> getPhonList(HashMap<String, Object> pMap) throws Exception{
		List<EgovMap> list = dao.getPhonList(pMap);
		return list;
	}
}
