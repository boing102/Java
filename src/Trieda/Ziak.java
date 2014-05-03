package Trieda;

import Skola.User;
import Zborovna.Du;
/**
 * Trieda reprezentuje ziaka a metody, ktore spristupnuju jemu pridelene domace ulohy.
 * @author Martin Mekota
 *
 */
public class Ziak extends User{
    private Du domacaUloha[] = new Du[2];
    public int trieda;
    

	public Ziak(String m, int h, int tr){
    	super(m,h);
    	this.trieda = tr;
    }
	/**
	 * Kazdy ziak moze mat len jednu domacu ulohu zo sj a jednu z mat. Preto pole DomacaUloha dvojprvkove.
	 * Vrati cele toto pole
	 * 
	 */
    public Du[] getDomacaUloha() {
        return domacaUloha;
    }
    /**
     * Nastavy cele pole s oboma ulohami.
     * @param domacaUloha
     */
    public void setDomacaUloha(Du[] domacaUloha) {
        this.domacaUloha = domacaUloha;
    }
    /**
     * Nastavi len ulohu z mat.
     * @param du
     */
    public void setDuMat(Du du){
    	domacaUloha[0] = du;
    }
    /**
     * Nastavi len ulohu zo Sj
     * @param du
     */
    public void setDuSj(Du du){
    	domacaUloha[1] = du;
    }
    
    /**
     * Informuje o type prihlaseneho pouzivatela.
     */
    public void login(){
	    System.out.println("[INFO]: Prihlasenie ako Ziak.");
	}    

}
