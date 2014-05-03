package Zborovna;
/**
 * Trieda, ktora reprezentuje domacu ulohu zo slovenciny. Odpovede su preto stringy.
 * @author marti_000
 *
 */
public class DuZoSlovenciny extends Du{
    public String odpoved1, odpoved2, odpoved3;    
    private String spravna1, spravna2, spravna3;
    
    public DuZoSlovenciny(String o1, String o2 ,String o3, String spravna1, String spravna2, String spravna3, int trieda) {
	super(o1, o2, o3, trieda);
	this.spravna1 = spravna1;
	this.spravna2 = spravna2;
	this.spravna3 = spravna3;
    }
    
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     * 
     */
    protected String getSpravna1() {
        return spravna1;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     */
    protected void setSpravna1(String spravna1) {
        this.spravna1 = spravna1;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     */
    protected String getSpravna2() {
        return spravna2;
    }
    /**
     * vrati spravnu odpoved. Protected je preto, aby ju mohol pouzivat iba trieda ucitel.
     * 
     */
    protected String getSpravna3() {
        return spravna3;
    }
    /**
     * zadanie prvej odpovede
     * @param odpoved1
     * 
     */
    public void setOdpoved1(String odpoved1) {
        this.odpoved1 = odpoved1;
    }
    /**
     * zadanie druhej odpovede
     * @param odpoved2
     * 
     */
    public void setOdpoved2(String odpoved2) {
        this.odpoved2 = odpoved2;
    }
    /**
     * zadanie tretej odpovede
     * @param odpoved3
     * 
     */
    public void setOdpoved3(String odpoved3) {
        this.odpoved3 = odpoved3;
    }
    
    
}
