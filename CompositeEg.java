package Day4Assignments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


interface Employee {

   public void add(Employee employee) throws Exception;
   public void remove(Employee employee);
   public Employee getChild(int i);
   public String getName();
   public double getSalary();
   public String getDesignation();
   public void print();
   public double getCosting();
}


class Director implements Employee{

	 private String name;
	 private double salary;

	 public Director(String name,double salary){
	  this.name = name;
	  this.salary = salary;
	 }

	 List<Employee> employees = new ArrayList<Employee>();
	 public void add(Employee obj) throws Exception{
		 String c_name = obj.getClass().getName();
		 if(c_name.equalsIgnoreCase("Manager"))
		 {
			 employees.add(obj);
		 }
		 else
		 {
			 throw new Exception("non Manager not allowed to add");
		 }
	    
	 }

	 public Employee getChild(int i) {
	  return employees.get(i);
	 }

	 public String getName() {
	  return name;
	 }

	 public double getSalary() {
	  return salary;
	 }

	 public String getDesignation(){
		 return "Director";
	 }
	 public void print() {
	  System.out.println("-------------");
	  System.out.println("Name ="+getName());
	  System.out.println("Salary ="+getSalary());
	  System.out.println("-------------");

	  Iterator<Employee> employeeIterator = employees.iterator();
	    while(employeeIterator.hasNext()){
	     Employee employee = employeeIterator.next();
	     employee.print();
	    }
	 }
	 public double getCosting() {
		 double costing=salary;
		 for(Employee emp:employees) {
			 costing=emp.getSalary();
		 }
		return costing;
	 }

	 public void remove(Employee employee) {
	  employees.remove(employee);
	 }
	}


class Manager implements Employee{

 private String name;
 private double salary;

 public Manager(String name,double salary){
  this.name = name;
  this.salary = salary;
 }

 List<Employee> employees = new ArrayList<Employee>();
 public void add(Employee employee) {
    employees.add(employee);
 }

 public Employee getChild(int i) {
  return employees.get(i);
 }

 public String getName() {
  return name;
 }

 public double getSalary() {
  return salary;
 }

 public String getDesignation(){
	 return "Manager";
 }
 public void print() {
  System.out.println("-------------");
  System.out.println("Name ="+getName());
  System.out.println("Salary ="+getSalary());
  System.out.println("-------------");

  Iterator<Employee> employeeIterator = employees.iterator();
    while(employeeIterator.hasNext()){
     Employee employee = employeeIterator.next();
     employee.print();
    }
 }
 public double getCosting() {
	 double costing=salary;
	 for(Employee emp:employees) {
		 costing=emp.getSalary();
	 }
	 return costing;
 }

 public void remove(Employee employee) {
  employees.remove(employee);
 }
}


class Developer implements Employee{

	  private String name;
	  private double salary;

	  public Developer(String name,double salary){
	    this.name = name;
	    this.salary = salary;
	  }
	  public void add(Employee employee) {
	    //this is leaf node so this method is not applicable to this class.
	  }

	  public Employee getChild(int i) {
	    //this is leaf node so this method is not applicable to this class.
	    return null;
	  }

	  public String getName() {
	    return name;
	  }

	  public double getSalary() {
	    return salary;
	  }

	  public String getDesignation(){
		return "Developer";  
	  }
	  
	  public void print() {
	    System.out.println("-------------");
	    System.out.println("Name ="+getName());
	    System.out.println("Salary ="+getSalary());
	    System.out.println("-------------");
	  }

	  public double getCosting() {
			 return salary;
		 }
	  public void remove(Employee employee) {
	    //this is leaf node so this method is not applicable to this class.
	  }
	  
	}

 

public class CompositeEg {
	 public static void main(String[] args) {
		 try
		 {
			 Employee dir1 = new Director("dir1", 80000);
		 Employee manager1=new Manager("mgr1",25000);
		 
		  Employee emp1=new Developer("dev1", 10000);
		  Employee emp2=new Developer("dev2", 15000);
		  
		  manager1.add(emp1);
		  manager1.add(emp2);
		  
		  dir1.add(manager1);
		  
		  Employee gManager=new Manager("mgr2", 50000);
		  Employee emp3=new Developer("dev3", 20000);
		  
		  gManager.add(emp3);
		  //gManager.add(manager1);
		  
		  
		  dir1.add(gManager);
		  dir1.print();
		  
		  //dir1.add( new Developer("ldev",19000));
		 
		  System.out.println("Designation: "+gManager.getDesignation());
		  System.out.println("manager1: "+ dir1.getCosting());
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 }
}
