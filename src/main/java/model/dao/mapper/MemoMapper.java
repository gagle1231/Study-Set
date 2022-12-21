package model.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.Memo;

/*추후 mybatis로 변경 */
public interface MemoMapper {
	//@Select({"SELECT memoId AS memoId, userId AS userId, groupId AS groupId, memoContents As memoContents FROM MEMO WHERE memoId = #{memoId} "})
	Memo getMemo(String memoId);
	
	
	public int addMemo(Memo memo, String userId, String groupId);
	
	//그룹의 메모 리스트 가져오기
	public List<Memo> getList(String groupId);
	
	// public Memo getMemo(String memoId);

}

