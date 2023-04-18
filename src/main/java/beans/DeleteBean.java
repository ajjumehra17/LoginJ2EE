package beans;

import dao.StudentDAO;

public class DeleteBean {
	private int userid;
	public DeleteBean() {

	} 
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public boolean delete() {
	  return new StudentDAO().deleteStudentRecords(this);
	}

}
