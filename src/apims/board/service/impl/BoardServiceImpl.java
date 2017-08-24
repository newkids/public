package apims.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apims.board.service.BoardService;
import apims.board.service.BoardVO;
import apims.cmm.SearchVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	private BoardVO vo;
	
	/** 리스트*/
	public List<EgovMap> getBoardList(Map<String, Object> pMap) throws Exception{
		return dao.getBoardList(pMap);
	}
	
	public EgovMap getBoardContent(Map<String, Object> pMap) throws Exception{
		return dao.getBoardContent(pMap);
	}
	
	public BoardVO getSelect(int boardNo) throws Exception{
		return dao.getSelect(boardNo);
	}
	
	public String insertCommunity(BoardVO vo) throws Exception{
		return dao.insertCommunity(vo);
	}
	
	public void updateContent(BoardVO vo) throws Exception{
		dao.updateContent(vo);
	}

	public void deleteCommunity(int boardNo) throws Exception{
		dao.deleteCommunity(boardNo);
	}
}
