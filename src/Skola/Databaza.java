package Skola;


import java.util.ArrayList;
import java.util.List;

import Trieda.Ziak;
import Zborovna.Ucitel;
/**
 * Zhromazduje vsetko osoby, ktore patria do skoly. Tiez obsahuje metody na pracu s databazou.
 * @author Martin Mekota	
 *
 */
public class Databaza{
	
	public static List<User> database = new ArrayList<User>();
	
	/**
	 * Naplni zakladnymi ludmi.	
	 */
	public void napln(){
		database.add(new Ucitel("ucitel", 1));
		database.add(new Ziak("palo", 1,1));
		database.add(new Ziak("lukas", 1,1));
		database.add(new Ziak("zuzka", 1,1));
	}
	/**
	 * Sluzia na vyhladanie objektu v databaze. Ako kluc sluzi meno.
	 * @param meno Meno hladaneho cloveka
	 * @return vrati null alebo hladaneho cloveka
	 */
	public static User vyber(String meno) {
		for(int i = 0; i < database.size(); i ++){
			if(database.get(i).meno.equals(meno))
				return database.get(i);
		}
		return null;
	}
	/**
	 * Sluzi na vrateni objektov ziakov z urcitej triedy.
	 * @param tr trieda, ktorej ziaci budu vrateny
	 * @return vracia ArrayList ziakov urcitej triedy.
	 */
	public static ArrayList<Ziak> vyberTriedu(int tr) {
		ArrayList<Ziak> trieda = new ArrayList<Ziak>();
		for(int i = 0; i < database.size(); i ++){
			if(database.get(i) instanceof Ziak){
				if(((Ziak)database.get(i)).trieda == tr)
					trieda.add(((Ziak)database.get(i)));
			}
		}
		return trieda;
	}
	/**
	 * Overenie hesla.
	 * @param user objekt, ktory sa kontroluje
	 * @param heslo zadane heslo
	 * @return
	 * Vrati true alebo false, podla toho, co je zadane dobre heslo.
	 */
	public static boolean kontrola(User user, int heslo) {
		if(user.heslo == heslo)
			return true;
		return false;
	}

}
