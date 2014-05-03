package Okna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Trieda.Ziak;
import Zborovna.DuZoSlovenciny;
/**
 * Okno v ktorom ziak zadava odpovede domacej ulohy z sj
 * @author Martin Mekota
 *
 */
public class OknaSlovencina extends JFrame {

	private JPanel contentPane;
	public Ziak ziak;
	private JTextField otazka1;
	private JTextField otazka2;
	private JTextField otazka3;
	private JTextField pomoc1;
	private JTextField pomoc2;
	private JTextField pomoc3;
	
	public OknaSlovencina(Ziak z) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.ziak = z;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOtazka1 = new JLabel();
		String o1 = "Otazka 1: " + ziak.getDomacaUloha()[1].getOtakza1();
		lblOtazka1.setText(o1);
		lblOtazka1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtazka1.setBounds(37, 41, 193, 14);
		contentPane.add(lblOtazka1);
		
		JLabel lblOtazka2 = new JLabel();
		String o2 = "Otazka 2: " + ziak.getDomacaUloha()[1].getOtazka2();
		lblOtazka2.setText(o2);
		lblOtazka2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtazka2.setBounds(37, 104, 193, 14);
		contentPane.add(lblOtazka2);
		
		JLabel lblOtazka3 = new JLabel();
		String o3 = "Otazka 3: " + ziak.getDomacaUloha()[1].getOtazka3();
		lblOtazka3.setText(o3);
		lblOtazka3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtazka3.setBounds(37, 175, 193, 14);
		contentPane.add(lblOtazka3);
		
		otazka1 = new JTextField();
		otazka1.setBounds(84, 66, 86, 20);
		contentPane.add(otazka1);
		otazka1.setColumns(10);
		
		otazka2 = new JTextField();
		otazka2.setColumns(10);
		otazka2.setBounds(84, 129, 86, 20);
		contentPane.add(otazka2);
		
		otazka3 = new JTextField();
		otazka3.setColumns(10);
		otazka3.setBounds(84, 200, 86, 20);
		contentPane.add(otazka3);
		
		JTextPane pomoc1 = new JTextPane();
		pomoc1.setText("Pomoc pre otazku1: ");
		String p1 = pomoc1.getText();
		if(ziak.getDomacaUloha()[1].getPomocOtazke1() == null)
			p1 = p1 + "\n ziadna rada.";
		else
			p1 = p1 + "\n" + ziak.getDomacaUloha()[1].getPomocOtazke1();
		pomoc1.setText(p1);
		pomoc1.setEditable(false);
		pomoc1.setBounds(284, 22, 126, 64);
		contentPane.add(pomoc1);
		
		JTextPane pomoc2 = new JTextPane();
		pomoc2.setText("Pomoc pre otazku2: ");
		p1 = pomoc2.getText();
		if(ziak.getDomacaUloha()[1].getPomocOtazke2() == null)
			p1 = p1 + "\n ziadna rada.";
		else
			p1 = p1 + "\n" + ziak.getDomacaUloha()[1].getPomocOtazke2();
		pomoc2.setText(p1);
		pomoc2.setEditable(false);
		pomoc2.setBounds(284, 97, 126, 64);
		contentPane.add(pomoc2);
		
		JTextPane pomoc3 = new JTextPane();
		pomoc3.setText("Pomoc pre otazku3: ");
		p1 = pomoc3.getText();
		if(ziak.getDomacaUloha()[1].getPomocOtazke3() == null)
			p1 = p1 + "\n ziadna rada.";
		else
			p1 = p1 + "\n" + ziak.getDomacaUloha()[1].getPomocOtazke3();
		pomoc3.setText(p1);
		pomoc3.setEditable(false);
		pomoc3.setBounds(284, 175, 126, 64);
		contentPane.add(pomoc3);
		
		JButton btnUlozit = new JButton("Ulozit");
		btnUlozit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ulozit();
			}
			
		});
		btnUlozit.setBounds(172, 238, 89, 23);
		contentPane.add(btnUlozit);
	}
	
	private void ulozit() {
		try{
			DuZoSlovenciny temp = (DuZoSlovenciny) ziak.getDomacaUloha()[1];
			temp.setOdpoved1(otazka1.getText());
			temp.setOdpoved2(otazka2.getText());
			temp.setOdpoved3(otazka3.getText());
			dispose();
			new OknoZiak(ziak);
		} catch (NumberFormatException e) {
			System.out.println("Nezadal si niektoru odpoved..");
		}
	} 
}

