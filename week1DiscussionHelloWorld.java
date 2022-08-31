package week1DiscussionHelloWorld;

class week1DiscussionHelloWorld {

	static class helloRecipient {
		
		// attributes/fields
		public String recipient;
		
		//constructors
		public helloRecipient() {
			recipient = "World";
		}
		public helloRecipient(String theRecipient) {
			recipient = theRecipient;
		}
		
		//methods
		public void setRecipient(String newValue) {
			recipient = newValue;
		}
		
		public void hello() {
			String helloOutput = String.format("Hello %s", recipient);
			System.out.println(helloOutput);
		}
		
	}

	public static void main(String args[]) {
		helloRecipient myRecipient = new helloRecipient("World");
		myRecipient.hello();
		myRecipient.setRecipient("Classmates");
		myRecipient.hello();
	}

}
