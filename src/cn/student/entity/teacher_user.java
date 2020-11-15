package cn.student.entity;

public class teacher_user implements java.io.Serializable {

	/**
	 **教师账号密码
	 */
	private static final long serialVersionUID = 1L;
	private String t_username;
	private String t_password;
	public teacher_user() {
		
	}
	public String getT_username() {
		return t_username;
	}
	public void setT_username(String t_username) {
		this.t_username = t_username;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
}
