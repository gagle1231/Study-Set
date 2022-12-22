package model.dao;
   
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;
   
public class MemoDAO {
   
   private JDBCUtil jdbcUtil = null;
   
   public MemoDAO() {         
      jdbcUtil = new JDBCUtil();   // JDBCUtil 객체 생성
   }
   
   // 메모 작성
   public int addMemo(Memo memo, String userId, String groupId) throws SQLException, ParseException {
      String sql = "INSERT INTO MEMO VALUES( 'm'||SEQUENCE_MEMOID.NEXTVAL, ?, ?, ? )";
      
      Object[] param = new Object[] { userId, groupId, memo.getMemoContents() };
      
      jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정
      
      try {
         int result = jdbcUtil.executeUpdate(); // insert 문 실행
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close(); // resource 반환
      }
      
      return 0;
   }
   //그룹 메모 리스트 가져오기
   public List<Memo> getGroupMemoList(String groupId, String userId) {
	      String sql = "SELECT * FROM MEMO WHERE groupId = ? and userId = ?";
	      jdbcUtil.setSqlAndParameters(sql, new Object[] { groupId, userId });
	      
	      try {
	         ResultSet rs = jdbcUtil.executeQuery(); // query 실행
	         List<Memo> memoList = new ArrayList<Memo>();
	         while (rs.next()) {
	            Memo memo = new Memo(
	                  rs.getString("memoId"), 
	                  rs.getString("userId"),
	                  rs.getString("groupId"), 
	                  rs.getString("memoContents"));
	            memoList.add(memo);
	         }
	         return memoList;

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close(); // resource 반환
	      }
	      return null;
	   }
   // 메모리스트 가져오기 (모든 원소 다 가져오나?) + 매개변수 userId
   public List<Memo> getList(String groupId) {
      String sql = "SELECT * FROM MEMO WHERE groupId = ? ";
      jdbcUtil.setSqlAndParameters(sql, new Object[] { groupId });
      
      try {
         ResultSet rs = jdbcUtil.executeQuery(); // query 실행
         List<Memo> memoList = new ArrayList<Memo>();
         while (rs.next()) {
            Memo memo = new Memo(
                  rs.getString("memoId"), 
                  rs.getString("userId"),
                  rs.getString("groupId"), 
                  rs.getString("memoContents"));
            memoList.add(memo);
         }
         return memoList;

      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close(); // resource 반환
      }
      return null;
   }
   
   // 메모 가져오기 (매개변수: memoId)
   public Memo getMemo(String memoId) {
      String sql = "SELECT * FROM MEMO WHERE memoId = ?";
      jdbcUtil.setSqlAndParameters(sql, new Object[] { memoId });
      
      try {
         ResultSet rs = jdbcUtil.executeQuery(); // query 실행
         
         if (rs.next()) {
            Memo memo = new Memo(
                  rs.getString("memoId"), 
                  rs.getString("userId"),
                  rs.getString("groupId"), 
                  rs.getString("memoContents"));
            return memo;
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close(); // resource 반환
      }
      return null;
   }
   
}