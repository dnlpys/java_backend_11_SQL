package test.com;

public class ViewEmpDeptVO {

	private int empno;
	private String fname;
	private int deptno;
	private String dname;
	private int sal;
	private double comm;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "ViewEmpDeptVO [empno=" + empno + ", fname=" + fname + ", deptno=" + deptno + ", dname=" + dname
				+ ", sal=" + sal + ", comm=" + comm + "]";
	}

}
