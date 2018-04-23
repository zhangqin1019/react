package biz;

import java.util.List;

import entity.user;
import Dao.*;

public class userBiz {
	userDao users=new userDao();
	public user getUserByNameAndPwd(String userName,String userPwd){
		return users.getUserByNameAndPwd(userName, userPwd);
	}
	public user getUserByUserId(int userId){
		return users.getUserByUserId(userId);
	}
	public List<user> getAlluser(){
		return users.getAlluser();
	}
	public boolean addUser(user user){
		int count= users.addUser(user);
		boolean isAdd=true;
		if(count>0)
		{
			isAdd=true;
		}
		else
		{
			isAdd=false;
		}
		return isAdd;
	}
	public boolean deleteUserInfoById(int UserId){
		int count=users.deleteUserInfoById(UserId);
		boolean isDelete=true;
		if(count>0)
		{
			isDelete=true;
		}
		else
		{
			isDelete=false;
		}
		return isDelete;
	}
	public boolean updateUserInfo(user user){
		int count=users.updateUserInfo(user);
		boolean isUpdate=false;
		if(count>0)
		{
			isUpdate=true;
		}
		else
		{
			isUpdate=false;
		}
		return isUpdate;
	}
}
