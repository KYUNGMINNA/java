package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class BoardDAO_11_0518 implements IBoardDAO_10_0518 {

	private DataSource ds;
	
	private BoardDAO_11_0518() {
		try {
			InitialContext ct=new InitialContext();
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/myOracle");
			
		}catch(NamingException e ) {
			e.printStackTrace();
		}
		
	}
	
	private static BoardDAO_11_0518 dao=new BoardDAO_11_0518();
	
	public static BoardDAO_11_0518 getInstance() {
		if(dao ==null) dao=new BoardDAO_11_0518();
		return dao;
	}
	
	
	
	//////////////////////////////////////////////////////
	@Override
	public void regist(String writer, String title, String content) {
		String sql="INSERT INTO my_board(board_id,writer,title,content) VALUES(board_seq.NEXTVAL,?,?,?)";

		try(Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3,content);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<BoardVO_9_0518> listBoard() {
		List<BoardVO_9_0518> articles=new ArrayList<>();
		String sql="SELECT * FROM my_board ORDER BY board_id DESC";
		
		try(Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery())
		{
			while(rs.next()) {
				BoardVO_9_0518 vo=new BoardVO_9_0518(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit"));
				articles.add(vo);
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return articles;
	}

	@Override
	public BoardVO_9_0518 contentBoard(int bId) {
		String sql="SELECT * FROM my_board WHERE board_id=?";
		BoardVO_9_0518 vo=null;
		try(
				Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				)
		{
			pstmt.setInt(1, bId);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new BoardVO_9_0518(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {

	}

	@Override
	public void deleteBoard(int bId) {

	}

}
