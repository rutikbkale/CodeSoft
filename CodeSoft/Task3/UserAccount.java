
public class UserAccount {

	private int actNo;
	private String name;
	private int pin;
	private int amount;

//	Parameterized constructor
	public UserAccount(int actNo, String name, int pin, int amount) {
		super();
		this.actNo = actNo;
		this.name = name;
		this.pin = pin;
		this.amount = amount;
	}

//	Default constructor
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

//	Getters and Setters
	public int getActNo() {
		return actNo;
	}

	public void setActNo(int actNo) {
		this.actNo = actNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
