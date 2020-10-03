package org.ep.mapper;

import java.util.List;

import org.ep.domain.BoardVO;
import org.ep.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 5")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
