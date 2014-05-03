package Okna;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Skola.Databaza;
import Trieda.Ziak;
import Zborovna.Ucitel;
/**
 * Okno pomocou, ktoreho sa prihlasuje do aplikacie. Sucastou je anonymna trieda listeneru.
 * @author Martin Mekota
 *
 */
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextField prihlMeno;
	private JPasswordField prihlHeslo;

	
	public Login() {
		setResizable(false);
		setTitle("Login");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 339);
		setVisible(true);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel menoLabel = new JLabel("Meno:");
		menoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menoLabel.setBounds(201, 35, 73, 14);
		panel.add(menoLabel);
		
		prihlMeno = new JTextField();
		prihlMeno.setBounds(194, 63, 86, 20);
		panel.add(prihlMeno);
		prihlMeno.setColumns(10);
		
		JLabel hesloLabel = new JLabel("Heslo:");
		hesloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hesloLabel.setBounds(214, 174, 46, 14);
		panel.add(hesloLabel);
		
		prihlHeslo = new JPasswordField();
		prihlHeslo.setBounds(202, 199, 71, 20);
		panel.add(prihlHeslo);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String meno = prihlMeno.getText();
					String pw = new String(prihlHeslo.getPassword());
					if (Databaza.kontrola(Databaza.vyber(meno), Integer.parseInt(pw))) {
						if(Databaza.vyber(meno) instanceof Ziak){
							loginZiak((Ziak) Databaza.vyber(meno));
							Databaza.vyber(meno).login();
						}
						if(Databaza.vyber(meno) instanceof Ucitel){
							loginUcitel((Ucitel) Databaza.vyber(meno));
							Databaza.vyber(meno).login();
						}
					}
				} catch (NumberFormatException e1) {
					System.err.println("Heslo mozu byt len cisla.");
					
				} catch (NullPointerException e2) {
					e2.printStackTrace();
					System.err.println("Zle prihlasovacie meno alebo heslo. Skuste ucitel a 1.");
				}
			}
		});
		loginBtn.setBounds(193, 241, 89, 23);
		panel.add(loginBtn);
		
		
	}
	/**
	 * Metoda, ktora zavola ziakovo okno po prihlaseni ziaka.
	 * @param z
	 */
	public void loginZiak(Ziak z){
		dispose();
		new OknoZiak(z);
	}
	/**
	 * Metoda, ktora zavola ucitelovo okno po prihlaseni ucitela.
	 * @param u
	 */
	public void loginUcitel(Ucitel u){
		dispose();
		new OknoUcitel(u);
	}
	
	public static void main(String[] args) {
		Databaza db = new Databaza();
		db.napln();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login loginOkno = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
