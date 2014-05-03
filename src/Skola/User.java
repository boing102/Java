package Skola;
/**
 * Zakladny prvok databazy. Sluzi len na prihlasovanie do aplikacie.
 * @author Martin Mekota
 *
 */
public class User {
	public String meno;
	public int heslo;
	
	public User(String m, int h) {
		this.meno = m;
		this.heslo = h;
	}
	/**
	 * Metoda, ktora informuje aky typ sa uzivatela sa prihlasil. Bude sa pomocou nej demonstrovat polymorfizmus..
	 */
	public void login(){
	    System.out.println("[INFO]: Prihlasenie ako User");
	}

}
