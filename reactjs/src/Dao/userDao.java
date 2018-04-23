package Dao;

import java.sql.*;
import java.util.*;

import entity.*;

public class userDao extends BaseDao{
	public user getUserByNameAndPwd(String userName,String userPwd){  
		Connection conn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		user user=null;
		try {
			conn=this.getConnection();
			String sql="select * from userInfo where userName=? and userPwd=?";
			psm=conn.prepareStatement(sql);
			psm.setString(1, userName);
			psm.setString(2, userPwd);
			rs=psm.executeQuery();
			while(rs.next())
			{
				user=new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setUserAge(rs.getInt("userAge"));
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		finally{
			this.closeAll(conn, psm, rs);
		}
		return user;
	}
	public user getUserByUserId(int userId){
		Connection conn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		user user=null;
		try {
			conn=this.getConnection();
			String sql="select * from userInfo where userId=?";
			psm=conn.prepareStatement(sql);
			psm.setInt(1, userId);
			rs=psm.executeQuery();
			while(rs.next())
			{
				user=new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
			    user.setUserPwd(rs.getString("userPwd"));
			    user.setUserAge(rs.getInt("userAge"));
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		finally{
			this.closeAll(conn, psm, rs);
		}
		return user;
	}
	public List<user> getAlluser(){
		List<user> userInfoList=new ArrayList<user>();
		Connection conn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		try {
			conn=this.getConnection();
			String sql="select * from userInfo";
			psm=conn.prepareStatement(sql);
			rs=psm.executeQuery();
			while(rs.next())
			{
				user user=new user();
				user.setUserId(rs.getInt("UserId"));
				user.setUserName(rs.getString("UserName"));
				user.setUserPwd(rs.getString("UserPwd"));
				user.setUserAge(rs.getInt("userAge"));
				userInfoList.add(user);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		finally
		{
			this.closeAll(conn, psm, rs);
		}
		return userInfoList;
	}
	public int addUser(user user){
		int count;
		if(getUserByUserId(user.getUserId())==null)
		{
			String sql="insert into userInfo values(?,?,?,?)";
			Object[] param={user.getUserId(),user.getUserName(),user.getUserPwd(),user.getUserAge()};
			count=this.exceuteUpdate(sql, param);
		}
		else
		{
			count=0;
		}
		return count;
	}
	public int deleteUserInfoById(int UserId){
		String sql="delete from userInfo where userId=?";
		Object[] param={UserId};
		return this.exceuteUpdate(sql, param);
	}
	public int updateUserInfo(user user){
		String sql="update userInfo set userName=?,userPwd=?,userAge=? where userId=?";
		Object[] param={user.getUserName(),user.getUserPwd(),user.getUserAge(),user.getUserId()};
		return this.exceuteUpdate(sql, param);
	}
}

