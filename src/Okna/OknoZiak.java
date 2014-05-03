package Okna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Skola.Databaza;
import Trieda.Ziak;
import Zborovna.DuZMatematiky;
import Zborovna.Ucitel;
/**
 * Zakladne okno ziaka odkial moze prezerat svoje Du a pomahat svojim spoluziakom. Tiaz vidi, kolko dostal bodov s poslednej DU.
 * @author Martin Mekota
 *
 */
public class OknoZiak extends JFrame {

	private JPanel panel;
	public Ziak ziak;
	private JTextField vyhladajZiaka;

	public OknoZiak(Ziak z) {
		setTitle("Okno Ziak");
		this.ziak = z;
		//System.out.println(ziak.getDomacaUloha()[0].getOtakza1());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 364);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(5, 297, 507, 23);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					logout();
				}
			});
		panel.setLayout(null);
		panel.add(logoutButton);
		
		JButton MatikaButn = new JButton("Matematika");
		MatikaButn.setBounds(425, 25, 87, 272);
		MatikaButn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matikaDu();
			}
		});
		panel.add(MatikaButn);
		
		JButton sjButton = new JButton("Slovencina");
		sjButton.setBounds(5, 25, 83, 272);
		sjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sjDu();
			}
		});
		panel.add(sjButton);
		
		vyhladajZiaka = new JTextField();
		vyhladajZiaka.setBounds(5, 5, 507, 20);
		panel.add(vyhladajZiaka);
		vyhladajZiaka.setColumns(10);
		
		JButton hladatButton = new JButton("Vyhladaj");
		hladatButton.setBounds(88, 25, 337, 33);
		hladatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vyhladaj();
			}
		});
		panel.add(hladatButton);
		
		JLabel lblPocetBodovMat = new JLabel("Pocet bodov z matematiky: ");
		if(ziak.getDomacaUloha()[0] != null)
			lblPocetBodovMat.setText(lblPocetBodovMat.getText() + ziak.getDomacaUloha()[0].getPocetBodov());
		lblPocetBodovMat.setBounds(261, 154, 154, 14);
		panel.add(lblPocetBodovMat);
		
		JLabel lblPocetBodovZoSj = new JLabel("Pocet bodov zo slovenciny: ");
		if(ziak.getDomacaUloha()[1] != null)
			lblPocetBodovZoSj.setText(lblPocetBodovZoSj.getText() + ziak.getDomacaUloha()[1].getPocetBodov());
		lblPocetBodovZoSj.setBounds(98, 227, 154, 14);
		panel.add(lblPocetBodovZoSj);
		
	}
	
	private void logout(){
		
			dispose();
			new Login();
		
	}
	
	private void matikaDu(){
		try {
			dispose();
			new OknoMatika(ziak);
		} catch (NullPointerException e) {
			System.err.println("Nie je vytvorena uloha z Matematiky.  Vytvorte a zadajte najprv ulohu. Restartujte aplikaciu.");
		}
	}
	
	private void sjDu(){
		try {
			dispose();
			new OknaSlovencina(ziak);
		} catch (NullPointerException e) {
			System.err.println("Nie je vytvorena uloha zo Slovenciny.  Vytvorte a zadajte najprv ulohu. Restartujte aplikaciu.");
		}
	}
	
	private void vyhladaj() {
		
		if(Databaza.vyber(vyhladajZiaka.getText()) == null){
				System.err.println("Tento ziak sa v skole nenachadza");
			return;
		}
		if(Databaza.vyber(vyhladajZiaka.getText()) instanceof Ucitel){
			System.err.println("Vyhladal si ucitela");
			return;
		}
		try{
			dispose();
			new OknoPomoc((Ziak) Databaza.vyber(vyhladajZiaka.getText()),ziak);	
		} catch(NullPointerException e) {
			System.err.println("Hladany ziak este nema zadane ulohy. \nVytvorte a zadajte najprv ulohy z obidvoch predmetov "
					+ "a skuste znova. Restartujte aplikaciu");			
		}
	}

}
