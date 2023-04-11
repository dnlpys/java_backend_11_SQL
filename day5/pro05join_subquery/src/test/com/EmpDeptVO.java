package test.com;

import java.sql.Date;

public class EmpDeptVO {

	private int employee_id;
	private String first_name;
	private String last_name;
	private int salary;
	private String department_name;
	private Date hire_date;

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

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return "EmpDeptVO [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", salary=" + salary + ", department_name=" + department_name + ", hire_date=" + hire_date + "]";
	}

}
