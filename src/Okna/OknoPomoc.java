package Okna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Trieda.Ziak;
/**
 * Okno na zadavanie rad spoluziakom.
 * @author Martin Mekota	
 *
 */
public class OknoPomoc extends JFrame {

	private JPanel contentPane;
	private Ziak hladany, hladajuci;
	private JTextPane pomoc1Mat;
	private JTextPane pomoc2Mat;
	private JTextPane pomoc3Mat;
	private JTextPane pomoc1Sj;
	private JTextPane pomoc2Sj;
	private JTextPane pomoc3Sj;
	private JLabel lblMatematika;
	private JLabel lblSlovencina;
	
	public OknoPomoc(Ziak hladany, Ziak hladajuci) {
		setTitle("Zadanie rady");
		this.hladajuci = hladajuci;
		this.hladany = hladany;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPomocPriDomacej = new JLabel("Pomoc pri domacej ziakovi: ");
		lblPomocPriDomacej.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomocPriDomacej.setBounds(150, 27, 195, 14);
		contentPane.add(lblPomocPriDomacej);
		
		JLabel lblZnenieOtazkyJe = new JLabel("Znenie otazky je v toolTipe");
		lblZnenieOtazkyJe.setHorizontalAlignment(SwingConstants.CENTER);
		lblZnenieOtazkyJe.setBounds(176, 84, 144, 14);
		contentPane.add(lblZnenieOtazkyJe);
		
		
		pomoc1Mat = new JTextPane();
		pomoc1Mat.setToolTipText(hladany.getDomacaUloha()[0].getOtakza1());
		pomoc1Mat.setBounds(30, 69, 111, 58);
		
		contentPane.add(pomoc1Mat);
		
		pomoc2Mat = new JTextPane();
		pomoc2Mat.setToolTipText(hladany.getDomacaUloha()[0].getOtazka2());
		pomoc2Mat.setBounds(30, 156, 111, 58);
		contentPane.add(pomoc2Mat);
		
		pomoc3Mat = new JTextPane();
		pomoc3Mat.setToolTipText(hladany.getDomacaUloha()[0].getOtazka3());
		pomoc3Mat.setBounds(30, 233, 111, 58);
		contentPane.add(pomoc3Mat);
		
		pomoc1Sj = new JTextPane();
		pomoc1Sj.setToolTipText(hladany.getDomacaUloha()[1].getOtakza1());
		pomoc1Sj.setBounds(346, 69, 111, 58);
		contentPane.add(pomoc1Sj);
		
		pomoc2Sj = new JTextPane();
		pomoc2Sj.setToolTipText(hladany.getDomacaUloha()[1].getOtazka2());
		pomoc2Sj.setBounds(346, 156, 111, 58);
		contentPane.add(pomoc2Sj);
		
		pomoc3Sj = new JTextPane();
		pomoc3Sj.setToolTipText(hladany.getDomacaUloha()[1].getOtazka3());
		pomoc3Sj.setBounds(346, 233, 111, 58);
		contentPane.add(pomoc3Sj);
		
		lblMatematika = new JLabel("Matematika");
		lblMatematika.setBounds(43, 44, 65, 14);
		contentPane.add(lblMatematika);
		
		lblSlovencina = new JLabel("Slovencina");
		lblSlovencina.setBounds(370, 44, 65, 14);
		contentPane.add(lblSlovencina);
		
		JButton ulozitBtn = new JButton("Ulozit");
		ulozitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ulozit();
				}
			});
		ulozitBtn.setBounds(203, 292, 89, 23);
		contentPane.add(ulozitBtn);
		
	}
	
	private void ulozit(){
		if(pomoc1Mat != null)
			hladany.getDomacaUloha()[0].setPomocOtazke(pomoc1Mat.getText(), 1);
		if(pomoc2Mat.getText() != null)
			hladany.getDomacaUloha()[0].setPomocOtazke(pomoc2Mat.getText(), 2);
		if(pomoc3Mat.getText() != null)
			hladany.getDomacaUloha()[0].setPomocOtazke(pomoc3Mat.getText(), 3);
		if(pomoc1Sj.getText() != null)
			hladany.getDomacaUloha()[1].setPomocOtazke(pomoc1Sj.getText(), 1);
		if(pomoc2Sj.getText() != null)
			hladany.getDomacaUloha()[1].setPomocOtazke(pomoc2Sj.getText(), 2);
		if(pomoc3Sj.getText() != null)
			hladany.getDomacaUloha()[1].setPomocOtazke(pomoc3Sj.getText(), 3);
		dispose();
		new OknoZiak(hladajuci);
	}
}
