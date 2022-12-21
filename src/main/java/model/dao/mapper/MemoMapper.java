package model.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.Memo;


public interface MemoMapper {
	@Select({"SELECT memoId AS memoId, userId AS userId, groupId AS groupId, memoContents As memoContents FROM MEMO WHERE memoId = #{memoId} "})
	Memo getMemo(String memoId);
	
	@Select({"SELECT memoId,userId,groupId,memoContents As memoId,userId,groupId,memoContents FROM MEMO  WHERE groupId = #{groupId}"})
	List<Memo> getList(String groupId, String userId);
	
	
	public int addMemo(Memo memo, String userId, String groupId);
	
	// public List<Memo> getList(String groupId, String userId);
	
	// public Memo getMemo(String memoId);

}

