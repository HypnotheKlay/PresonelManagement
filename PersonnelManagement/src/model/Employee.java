package model;

public class Employee {

    private int id;                 //人员编号
    private String name;            //人员名称
    private String professional;    //职业
    private int departmentID;       //部门编号
    private int power;              //人员权限
	private String password;        //人员密码
    private Department department;
    
    
    public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
    
     public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", professional=" + professional + ", department=" + department + '}';
    }

}
