package apims.board.service;

import java.util.List;
import java.util.Map;

import apims.cmm.SearchVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface BoardService {
	/**   list 가져오기 */
	List<EgovMap> getBoardList(Map<String, Object> pMap) throws Exception;
	
	// 게시판 내용
	public EgovMap getBoardContent(Map<String, Object> pMap) throws Exception;
	
	/**  단건 가져오기 */
	BoardVO getSelect(int boardNo) throws Exception;
	
	//글 삽입
	public String insertCommunity(BoardVO vo) throws Exception;
	
	//글 수정
	public void updateContent(BoardVO vo) throws Exception;
	
	//글 삭제
	void deleteCommunity(int boardNo) throws Exception;
	
}
