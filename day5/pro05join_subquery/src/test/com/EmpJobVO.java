package test.com;

import java.sql.Date;

public class EmpJobVO {

	private int employee_id;
	private String first_name;
	private String last_name;
	private int salary;
	private Date hire_date;
	private String job_title;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	@Override
	public String toString() {
		return "EmpJobVO [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", salary=" + salary + ", hire_date=" + hire_date + ", job_title=" + job_title + "]";
	}

}
