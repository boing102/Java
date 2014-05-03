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

import Zborovna.Ucitel;
/**
 * Sluzi na vytvorenie testu zo slovenciny
 * @author Martin Mekota
 *
 */
public class OknoVytvorSj extends JFrame{
	private JPanel panel;
	private JTextField otazka1;
	private JTextField otazka2;
	private JTextField otazka3;
	private JLabel lblOtazka1;
	private JLabel lblOtazka2;
	private JLabel lblOtazka3;
	private JTextField odpoved1;
	private JTextField odpoved2;
	private JTextField odpoved3;
	private JLabel lblOdpoved1;
	private JLabel lblOdpoved2;
	private JLabel lblOdpoved3;
	private JTextField pocetBodov;
	private JLabel lblPocetBodov;
	private JLabel lblTrieda;
	private JTextField trieda;
	private JButton vytvor;
	Ucitel u;
	

	public OknoVytvorSj(Ucitel u) {
		setTitle("Vytvorenie slovenciny");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setVisible(true);
		this.u = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 443);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		otazka1 = new JTextField();
		otazka1.setBounds(78, 34, 166, 20);
		panel.add(otazka1);
		otazka1.setColumns(10);
		
		otazka2 = new JTextField();
		otazka2.setBounds(78, 65, 166, 20);
		panel.add(otazka2);
		otazka2.setColumns(10);
		
		otazka3 = new JTextField();
		otazka3.setBounds(78, 96, 166, 20);
		panel.add(otazka3);
		otazka3.setColumns(10);
		
		lblOtazka1 = new JLabel("Otazka 1:");
		lblOtazka1.setBounds(10, 37, 58, 14);
		panel.add(lblOtazka1);
		
		lblOtazka2 = new JLabel("Otazka 2:");
		lblOtazka2.setBounds(10, 68, 58, 14);
		panel.add(lblOtazka2);
		
		lblOtazka3 = new JLabel("Otazka 3:");
		lblOtazka3.setBounds(10, 99, 58, 14);
		panel.add(lblOtazka3);
		
		odpoved1 = new JTextField();
		odpoved1.setColumns(10);
		odpoved1.setBounds(78, 217, 166, 20);
		panel.add(odpoved1);
		
		odpoved2 = new JTextField();
		odpoved2.setColumns(10);
		odpoved2.setBounds(78, 186, 166, 20);
		panel.add(odpoved2);
		
		odpoved3 = new JTextField();
		odpoved3.setColumns(10);
		odpoved3.setBounds(78, 155, 166, 20);
		panel.add(odpoved3);
		
		lblOdpoved1 = new JLabel("Odpoved 1:");
		lblOdpoved1.setBounds(10, 158, 58, 14);
		panel.add(lblOdpoved1);
		
		lblOdpoved2 = new JLabel("Odpoved 2:");
		lblOdpoved2.setBounds(10, 189, 58, 14);
		panel.add(lblOdpoved2);
		
		lblOdpoved3 = new JLabel("Odpoved 3:");
		lblOdpoved3.setBounds(10, 220, 58, 14);
		panel.add(lblOdpoved3);
		
		pocetBodov = new JTextField();
		pocetBodov.setBounds(84, 270, 86, 20);
		panel.add(pocetBodov);
		pocetBodov.setColumns(10);
		
		lblPocetBodov = new JLabel("Pocet Bodov:");
		lblPocetBodov.setBounds(10, 273, 64, 14);
		panel.add(lblPocetBodov);
		
		lblTrieda = new JLabel("Trieda:");
		lblTrieda.setBounds(10, 316, 46, 14);
		panel.add(lblTrieda);
		
		trieda = new JTextField();
		trieda.setColumns(10);
		trieda.setBounds(55, 313, 86, 20);
		panel.add(trieda);
		
		vytvor = new JButton("Vytvorit");
		vytvor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vytvorDu();
			}

		});
		vytvor.setBounds(362, 190, 89, 23);
		panel.add(vytvor);
	}
	
	public void vytvorDu() {
		u.vytvorDuSj(otazka1.getText(), otazka2.getText(), otazka3.getText(), odpoved1.getText(), odpoved2.getText(), odpoved3.getText(),  Integer.parseInt(trieda.getText()));
		dispose();
		new OknoUcitel(u);
	}

}
