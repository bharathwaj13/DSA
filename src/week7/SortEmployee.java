package week7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {

	public static void main(String[] args) {
		
		/*
		 * Find the name of the person whose designation has Engineer and having highest employee id 
		 * 
		 */
		
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(1001,"Sam David","QA Software Engineer"));
		list.add(new Employee(1003,"Gopi","Automation Architect"));
		list.add(new Employee(1006,"Naveen","Jr.Test Engineer"));
		list.add(new Employee(1007,"Balaji","QA Software Engineer"));
		list.add(new Employee(1010,"Koushik","QA Software Engineer"));
		list.add(new Employee(1019,"Narashiman","Digital Marketing Consultant"));
		
		List<Employee> sortedList = list.stream().filter(employee -> employee.getDesignation().contains("Engineer"))
		.sorted(Comparator.comparing(Employee::getEmpID)).collect(Collectors.toList());
		
		System.out.println(sortedList.get(sortedList.size()-1).getName());

	}

}
