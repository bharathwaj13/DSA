package week7;

public class Laptop {

	public static void main(String[] args) {

		Computer comp=(String brand,String model) ->{
			if(brand.equals("dell") && model.equals("xps") )
				return "Win11" ;
			else 
				return null;
		};
		
		
		System.out.println(comp.getOSVersion("dell", "xps"));
		System.out.println(comp.getOSVersion("dell", "dell"));

	}

}
