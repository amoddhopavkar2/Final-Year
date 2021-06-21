package calculatorws_client_application;


public class CalculatorWS_Client_Application {
	
	public static void main(String[] args) {
		try {
			int i = 10;
			int j = 20;
			int result = add(i, j);
			System.out.println("Result = " + result);
		} catch(Exception ex) {
			System.out.println("Exception : " + ex);
		}
	}

	private static int add(int i, int j) {
		org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
		org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
		return port.add(i, j);
	}
}