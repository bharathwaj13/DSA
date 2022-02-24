package week7;

public interface Mobile {
	
	static int getOSVersion() {
		return 9;
	}
	
	default void closeApplication() {
		System.out.println("Application closed in Mobile Interface");
	}

}
