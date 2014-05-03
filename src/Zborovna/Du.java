package Zborovna;

/**
 * 
 * Tato trieda sluzi ako sablona k dvom typom domacich uloh. Trieda obsahuje zapuzdrenie a zakladne atributy.
 * @author Martin Mekota
 *
 */

public class Du {
    private String otakza1, otazka2, otazka3, pomocOtazke1, pomocOtazke2, pomocOtazke3;
    private int pocetBodov, trieda;
    

    public Du(String o1, String o2, String o3, int tr) {
	this.otakza1 = o1;
	this.otazka2 = o2;
	this.otazka3 = o3;
	this.trieda = tr;
    }
    /**
     * 
     * @return trieda
     * Trieda, ktorej je domaca uloha urcena.
     */
    public int getTrieda() {
        return trieda;
    }
    /**
     * 
     * @param trieda
     * Nastavy triedu, ktorej je urcena Du.
     */
    public void setTrieda(int trieda) {
        this.trieda = trieda;
    }
    /**
     * 
     * @return
     * Kolko bodov ziskal ziak za domacu ulohu
     */
    public int getPocetBodov() {
    	return pocetBodov;
    }
    /**
     * 
     * @param pocetBodov
     * Nastavi, kolko bodov dostal ziak za danu ulohu
     */
    protected void setPocetBodov(int pocetBodov) {
    	this.pocetBodov = pocetBodov;
    }
    /**
     * 
     * @return
     * Vrati radu k prvej otazke
     */
    public String getPomocOtazke1() {
	return pomocOtazke1;
    }
    /**
     * 
     * @return
     * vrati radu k druhej otazke
     */
    public String getPomocOtazke2() {
	return pomocOtazke2;
    }
    /**
     * 
     * @return
     * vrati radu k tretej otazke
     */
    public String getPomocOtazke3() {
	return pomocOtazke3;
    }
    /**
     * 
     * @param pomocOtazke
     * text rady pre danu otazku
     * @param c
     * ktorej otazky sa rada tyka
     */
    public void setPomocOtazke(String pomocOtazke, int c) {
    	if(c == 1)
    		this.pomocOtazke1 = pomocOtazke;
    	else if(c == 2)
    		this.pomocOtazke2 = pomocOtazke;
    	else if(c == 3)
    		this.pomocOtazke3 = pomocOtazke;
    }

    /**
     * 
     * @return
     * vrati prvu otazku ulohy
     */
    public String getOtakza1() {
    	return otakza1;
    }
    /**
     * 
     * @param otakza1
     * nastavy prvu otazku ulohy
     */
    protected void setOtakza1(String otakza1) {
	this.otakza1 = otakza1;
    }
    /**
     * 
     * @return
     * vrati druhu otazku ulohy
     */
    public String getOtazka2() {
	return otazka2;
    }
    /**
     * 
     * @param otazka2
     * nastavy druhu otazku ulohy
     */
    protected void setOtazka2(String otazka2) {
	this.otazka2 = otazka2;
    }
    /**
     * 
     * @return
     * vrati tretiu otazku ulohy
     */
    public String getOtazka3() {
	return otazka3;
    }
    /**
     * 
     * @param otazka3
     * nastavy tretiu otazku ulohy
     */
    protected void setOtazka3(String otazka3) {
	this.otazka3 = otazka3;
    }
    
}
