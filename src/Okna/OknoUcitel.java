package Okna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Skola.Databaza;
import Trieda.Ziak;
import Zborovna.Ucitel;
/**
 * Okno ucitela v aplikacii. Odtialto sa da pristupovat k tvorbe a zadavani du. Takisto kontrole.
 * @author Martin Mekota
 *
 */
public class OknoUcitel extends JFrame {

	private JPanel panel;
	private Ucitel ucitel;

	public OknoUcitel(Ucitel u) {
		setTitle("Okno Ucitel");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.ucitel = u;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JButton vytvorMat = new JButton("Vytvor Ulohu Z Matematiky");
		vytvorMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vytvorMatiku();
			}
		});
		vytvorMat.setBounds(125, 11, 183, 23);
		panel.add(vytvorMat);
		
		JButton zadajMatiku = new JButton("Zadaj Ulohu Z Matematiky");
		zadajMatiku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zadajMatiku();
			}
		});
		zadajMatiku.setBounds(130, 41, 174, 23);
		panel.add(zadajMatiku);
		
		JButton vytvorSJ = new JButton("Vytvor Ulohu Zo Slovenciny");
		vytvorSJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vytvorSj();
			}
		});
		vytvorSJ.setBounds(125, 75, 183, 23);
		panel.add(vytvorSJ);
		
		JButton zadajSj = new JButton("Zadaj Ulohu Zo Slovenciny");
		zadajSj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zadajSj();
			}
		});
		zadajSj.setBounds(125, 109, 183, 23);
		panel.add(zadajSj);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					logout();
				}
			});
		logoutBtn.setBounds(172, 227, 89, 23);
		panel.add(logoutBtn);
		
		JButton kontrolaSjBtn = new JButton("Skontroluj Ulohu Zo Slovenciny");
		kontrolaSjBtn.setBounds(125, 143, 183, 23);
		kontrolaSjBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skontrolujSj();
				}
			});
		panel.add(kontrolaSjBtn);
		
		JButton kontrolaMatBtn = new JButton("Skontroluj Ulohu Z Matematiky");
		kontrolaMatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skontrolujMat();
				}
			});
		kontrolaMatBtn.setBounds(125, 177, 183, 23);
		panel.add(kontrolaMatBtn);
	}
	
	private void logout(){
		dispose();
		new Login();
	}
	
	private void vytvorMatiku(){
		dispose();
		new OknoVytvorMat(ucitel);		
	}
	
	private void zadajMatiku(){
		dispose();
		new OknoZadajMat(ucitel);		
	}
	
	private void vytvorSj(){
		dispose();
		new OknoVytvorSj(ucitel);		
	}
	
	private void zadajSj(){
		dispose();
		new OknoZadajSj(ucitel);		
	}
	/**
	 * Skontroluje ulohy zo slovenciny a oboduje.
	 */
	private void skontrolujSj(){
		for(int i = 0; i < Databaza.database.size(); i++) {
			if(Databaza.database.get(i) instanceof Ziak) {
				ucitel.skontrolujSj((Ziak) Databaza.database.get(i));
			}
		}
		System.out.println("Skontrolovane Sj");
	}
	/**
	 * Skontroluje ulohy z mat. a oboduje.
	 */
	private void skontrolujMat(){
		for(int i = 0; i < Databaza.database.size(); i++) {
			if(Databaza.database.get(i) instanceof Ziak) {
				ucitel.skontrolujMat((Ziak) Databaza.database.get(i));
			}
		}
		System.out.println("Skontrolovane Mat");
	}

}
