package Zborovna;
/**
 * Trieda, ktora reprezentuje domacu ulohu z matematiky. Odpovede su preto Integery.
 * @author Martin Mekota
 *
 */
public class DuZMatematiky extends Du{
    public int odpoved1, odpoved2, odpoved3;

    private int spravna1, spravna2, spravna3;
    
    public DuZMatematiky(String o1, String o2, String o3, int s1, int s2, int s3, int trieda) {
	super(o1, o2, o3, trieda);
	this.spravna1 = s1;
	this.spravna2 = s2;
	this.spravna3 = s3;
    }
    /**
     * Zadanie vsetkych spravnych odpovedi naraz.
     * @param s1
     * @param s2
     * @param s3
     * 
     */
    protected void zadatSpravneOdpovede(int s1, int s2, int s3) {
	this.spravna1 = s1;
	this.spravna2 = s2;
	this.spravna3 = s3;
    }
    /**
     * zadanie prvej odpovede
     * @param odpoved1
     * 
     */
    public void setOdpoved1(int odpoved1) {
	this.odpoved1 = odpoved1;
    }
    /**
     * zadanie druhej odpovede
     * @param odpoved2
     * 
     */
    public void setOdpoved2(int odpoved2) {
	this.odpoved2 = odpoved2;
    }
    /**
     * zadanie tretej odpovede
     * @param odpoved3
     * 
     */
    public void setOdpoved3(int odpoved3) {
	this.odpoved3 = odpoved3;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     *
     * 
     */
    protected int getspravna1() {
    	return spravna1;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     *  
     */
    protected double getspravna2() {
	return spravna2;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     * 
     */
    protected double getspravna3() {
	return spravna3;
    }
}
