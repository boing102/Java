package Zborovna;

import java.util.ArrayList;
import java.util.List;

import Skola.User;
import Trieda.Ziak;
/**
 * Trieda, ktora reprezentuje ucitela. Ten sa stara o vytvaranie, zadavanie a opravovanie domacich uloh studentov.
 * @author Martin Mekota
 *
 */
public class Ucitel extends User{
    private List<Du> domaceUlohy = new ArrayList<Du>(); 
    

	public Ucitel(String meno, int heslo) {
		super(meno, heslo);
    }
    /**
     * 
     * @param a prva otazka
     * @param b druha otazka
     * @param c tretia otazka
     * @param prva prva spravna odpoved	
     * @param druha spravna odpoved
     * @param tretia spravna odpoved
     * @param tr trieda, ktorej du prislucha
     * Vytvori domacu ulohu z matematiky a prida ju do databazy uloh ucitela
     */
    public void vytvorDuMat(String a, String b, String c, int prva, int druha, int tretia, int tr) {
	DuZMatematiky du = new DuZMatematiky(a, b, c, prva, druha, tretia, tr);
	domaceUlohy.add(du);
    }
    /**
     * vytvory domacu ulohu zo slovenciny a prida ju do databazy.
     * @param a prva otazka
     * @param b druha otazka
     * @param c tretia otazka
     * @param prva prva spravna odpoved	
     * @param druha spravna odpoved
     * @param tretia spravna odpoved
     * @param tr trieda, ktorej du prislucha
     */
    public void vytvorDuSj(String a, String b, String c, String prva, String druha, String tretia, int tr) {
	DuZoSlovenciny du = new DuZoSlovenciny(a, b, c, prva, druha, tretia, tr);
	domaceUlohy.add(du);
    }
    /**
     * Zada domacu ulohu zo Sj urcitemu ziakovi.
     * @param z
     * ziak, ktoremu sa zadava uloha.
     */
    public void zadajDuSJ(Ziak z){
		for(int i = 0; i < domaceUlohy.size(); i++){
		    if(z.trieda == domaceUlohy.get(i).getTrieda() && domaceUlohy.get(i) instanceof DuZoSlovenciny)
			z.setDuSj(domaceUlohy.get(i));
		}
    }
    /**
     * Zada domacu ulohu z Mat urcitemu ziakovi.
     * @param z
     * ziak, ktoremu sa zadava uloha
     */
    public void zadajDuMat(Ziak z){
    	for(int i = 0; i < domaceUlohy.size(); i++){
		    if(z.trieda == domaceUlohy.get(i).getTrieda() && domaceUlohy.get(i) instanceof DuZMatematiky)
		    	z.setDuMat(domaceUlohy.get(i));
		}	
    }
    /**
     * Skontroluje ulohy z mat ziakovy a oboduje.
     * @param z
     * ziak, ktoreho uloha sa kontroluje
     */
    public void skontrolujMat(Ziak z) {
    	try{int tempBody = 0;
	    	DuZMatematiky tempDu = (DuZMatematiky) z.getDomacaUloha()[0];
	    	if(tempDu.odpoved1 == tempDu.getspravna1())
	    		tempBody++;
	    	if(tempDu.odpoved2 == tempDu.getspravna2())
	    		tempBody++;
	    	if(tempDu.odpoved3 == tempDu.getspravna3())
	    		tempBody++;
	    	tempDu.setPocetBodov(tempBody);
    	} catch(NullPointerException e) {
    		System.err.println("Este ste nezadali ulohu z matematiky");
    	}
    }
    /**
     * Skontroluje ulohy zo sj ziakovy a oboduje.
     * @param z
     * ziak, ktoreho uloha sa kontroluje
     */
    public void skontrolujSj(Ziak z) {
    	try{
	    	int tempBody = 0;
	    	DuZoSlovenciny tempDu = (DuZoSlovenciny) z.getDomacaUloha()[1];
	    	if(tempDu.odpoved1.equals(tempDu.getSpravna1()))
	    		tempBody++;
	    	if(tempDu.odpoved2.equals(tempDu.getSpravna2()))
	    		tempBody++;
	    	if(tempDu.odpoved3.equals(tempDu.getSpravna3()))
	    		tempBody++;
	    	tempDu.setPocetBodov(tempBody);
    	} catch(NullPointerException e){
    		System.err.println("Este ste nezadali ulohu zo slovenciny");
    	}
    }
    /**
     * 
     * @return
     * vracia databazu vsetkych domacich uloh.
     */
    public List<Du> getDomaceUlohy() {
    	return domaceUlohy;
    }
    /**
     * Informuje o type prihlaseneho pouzivatela.
     */
    public void login(){
	    System.out.println("[INFO]: Prihlasenie ako Ucitel.");
	}
}
