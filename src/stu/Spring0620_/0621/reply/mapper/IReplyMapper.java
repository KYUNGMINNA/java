package stu.Spring0620_;

import java.util.List;
import java.util.Map;

import com.spring.myweb.command.ReplyVO;

public interface IReplyMapper {
	
	
	
	void replyRegist(ReplyVO vo);//댓글 등록
	List<ReplyVO> getList(Map<String, Object> data);//목록 요청
	int getTotal(int bno);//댓글 개수
	
	
	
	int pwCheck(ReplyVO vo);//비길번호 확인
	void update(ReplyVO vo);//댓글 수정
	void delete(int rno);//댓글 삭제
	

}
