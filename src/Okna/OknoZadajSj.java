package Okna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Skola.Databaza;
import Trieda.Ziak;
import Zborovna.Ucitel;
/**
 * Sluzi na zadanie ulohy danej triedy zo slovenciny
 * @author Martin Mekota
 *
 */
public class OknoZadajSj extends JFrame{

	private JPanel panel;
	private JTextField trieda;
	public Ucitel ucitel;
	
	public OknoZadajSj(Ucitel u) {
		setTitle("Zadanie Slovenciny");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setVisible(true);
		this.ucitel = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTrieda = new JLabel("Vyber triedy:");
		lblTrieda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrieda.setBounds(175, 64, 84, 14);
		panel.add(lblTrieda);
		
		trieda = new JTextField();
		trieda.setBounds(174, 100, 86, 20);
		panel.add(trieda);
		trieda.setColumns(10);
		
		JButton zadatBtn = new JButton("Zadat");
		zadatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zadajDu();
			}

		});
		zadatBtn.setBounds(172, 205, 89, 23);
		panel.add(zadatBtn);
	}
	private void zadajDu() {
		ArrayList<Ziak> ziaci = Databaza.vyberTriedu(Integer.parseInt(trieda.getText()));
		for(int i = 0; i < ziaci.size(); i++)
			ucitel.zadajDuSJ(ziaci.get(i));
		dispose();
		new OknoUcitel(ucitel);
		
	}
}
