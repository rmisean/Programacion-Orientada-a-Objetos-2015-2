import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserDB {
	ArrayList<String> name;

	public UserDB(ArrayList<String> name) {
		this.name = name;
	}

	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	
	public static ArrayList<String> load(){

		try {
			
			FileInputStream fis = new FileInputStream("./UDB.pf");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			ArrayList<String> udb = (ArrayList<String>)ois.readObject();
			ois.close();
			return udb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void save(ArrayList<String> udb){
		
		try {
			FileOutputStream fos = new FileOutputStream("./UDB.pf",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(udb);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
