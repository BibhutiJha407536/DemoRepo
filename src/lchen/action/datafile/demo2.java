package lchen.action.datafile;

public interface demo2 {
	public void getname();
	public void getage();
	
	default String getname1(){
		String name = "Bibhuti";
		return name;
	}
	
}

class demo4 implements demo2{
	
	public static void main(String[] args){
	
		demo4 d1 = new demo4()	;
	System.out.println(d1.getname1());	
		
		demo2 d = new demo2() {
			
			@Override
			public void getname() {
				System.out.println("overridden method");
				
			}
			
			@Override
			public void getage() {
				// TODO Auto-generated method stub
				System.out.println("overridden method getage()");
				getsalary();
			}
			public void getsalary() {
				// TODO Auto-generated method stub
				System.out.println("overridden method getsalary()");
			}
			
			
		};
	
		d.getname();
		d.getage();
		
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
