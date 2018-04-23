package entity;

public class user {
  private int userId;
  private String userName;
  private String userPwd;
  private int userAge;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPwd() {
	return userPwd;
}
public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}
public int getUserAge() {
	return userAge;
}
public void setUserAge(int userAge) {
	this.userAge = userAge;
}
public user(){}
public user(int userId,String userName,String userPwd,int userAge){
	this.userId=userId;
	this.userName=userName;
	this.userPwd=userPwd;
	this.userAge=userAge;
}
}
