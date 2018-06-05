package lchen.action.datafile;

public class demo1 implements demo2{

	private demo1() {
		System.out.println("i am in child");
	}
	
	public void getName(){
		System.out.println("getName demo1 class ");
	}

	static public void main(String[] args) {
		demo1 d = new demo1();
		demo1 d1 = new demo1();
		demo d2 = new demo();
		
		d.getName();
		d1.getName();
		d2.getName();

	}

	@Override
	public void getname() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getage() {
		// TODO Auto-generated method stub
		
	}

}
