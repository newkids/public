package apims.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import apims.board.service.BoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository
public class BoardDAO extends EgovAbstractDAO {

	
	public List<EgovMap> getBoardList(Map<String, Object> pMap) throws Exception{
		List<EgovMap> list = (List<EgovMap>)list("board.list", pMap);
		return list;
	}
	
	public EgovMap getBoardContent(Map<String, Object> pMap) throws Exception{
		EgovMap egovMap = selectForEgovMap("board.getBoardContent", pMap);
		return egovMap;
	}
	
	public String insertCommunity(BoardVO vo) throws Exception{
		String cno = (String)insert("board.insertCommunity", vo);
		return cno;
	}
	
	/** 단건 가져오기*/
	public BoardVO getSelect(int boardNo) throws Exception{
		BoardVO boardVO = (BoardVO)select("board.select", boardNo);
		return boardVO;
	}
	
	
	public EgovMap selectForEgovMap(String queryId, Object parameterObject) {
		logger.debug("SQL ID : " + queryId);
		@SuppressWarnings("deprecation")
		EgovMap egovMap = (EgovMap) getSqlMapClientTemplate().queryForObject(queryId, parameterObject);

		if (egovMap != null){
			EgovMap copyEgovMap = new EgovMap();
			List keyList = egovMap.keyList();
			if (keyList != null && keyList.size() > 0){
				int keyListSize = keyList.size();
				for (int j = 0; j < keyListSize; j++){
					String key = (String) keyList.get(j);
					copyEgovMap.put(key, egovMap.get(key));
				}
			}
			return copyEgovMap;
		}else{
			return egovMap;
		}
	}

	public int updateContent(BoardVO vo) throws DataAccessException{
		return update("board.modContent", vo);
	}
	
	/** 삭제*/
	public void deleteCommunity(int boardNo) throws Exception{
		delete("board.delete", boardNo);
	}
}
