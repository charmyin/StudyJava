package java.awt;

public class TestChangeProtectedString {
	
	public static void main(String[] args){
		
		Window window = new Window();
		window.warningString = "ok";
		
		System.out.println(window.warningString);
		
		
	}
}
