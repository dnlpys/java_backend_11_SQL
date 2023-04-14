package test.com.yangssem;

public class EmpDeptJobVO {
	private int employee_id;
	private String job_title;
	private String department_name;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "EmpDeptJobVO [employee_id=" + employee_id + ", job_title=" + job_title + ", department_name="
				+ department_name + "]";
	}

}
