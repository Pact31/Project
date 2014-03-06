package leapmotion;

public class main {

	public static void main(String[] args) {
		LeapDataBase DB = new LeapDataBase();
		
		DB.write("test.txt");
		System.out.println(DB.table.size());
	}

}
