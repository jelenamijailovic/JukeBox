package jukebox;

import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

import java.io.File;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class NARODNA extends jukebox {

	MUSIC player= new MUSIC ();
	private int pos=0;
	
	private JFrame frmNarodna;
	
	JComboBox comboBox2 = new JComboBox();
	JButton btnBack = new JButton("BACK");
	JButton btnPlay = new JButton("PLAY");
	JButton btnPause = new JButton("PAUSE");
	JButton btnEnd = new JButton("END");
	JLabel lblNarodnaMuzika = new JLabel("Narodna muzika");
	JLabel lblPROBA = new JLabel("");
	JLabel lblIdePesma = new JLabel("");
	
	
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NARODNA window = new NARODNA();
					window.frmNarodna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	/**
	 * Create the application.
	 */
	public NARODNA() {
		initialize();
	}

	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmNarodna = new JFrame();
		frmNarodna.getContentPane().setBackground(new Color(255, 235, 205));
		frmNarodna.setTitle("NARODNA");
		//frmNarodna.setBounds(100, 100, 521, 410);
		frmNarodna.setBounds(100, 100, 523, 412);
		frmNarodna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNarodna.getContentPane().setLayout(null);
		
		
		lblNarodnaMuzika.setForeground(new Color(255, 99, 71));
		lblNarodnaMuzika.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblNarodnaMuzika.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarodnaMuzika.setBounds(142, 11, 213, 24);
		frmNarodna.getContentPane().add(lblNarodnaMuzika);
		
		
		lblPROBA.setBounds(51, 277, 46, 14);
		frmNarodna.getContentPane().add(lblPROBA);
		
		
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setForeground(new Color(255, 69, 0));
		btnBack.setBackground(new Color(255, 218, 185));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblIdePesma.getText()=="da"){	
					player.end(pos);
					frmNarodna.hide();
				}
				else
					frmNarodna.hide();
;
			
			}
		});
		//btnBack.setBounds(10, 11, 71, 23);
		btnBack.setBounds(10, 11, 67, 23);
		frmNarodna.getContentPane().add(btnBack);
		
		
		
		comboBox2.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox2.setForeground(new Color(255, 69, 0));
		comboBox2.setBackground(new Color(255, 218, 185));
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				obj=comboBox2.getSelectedItem();
				player.setPath(String.valueOf(obj));
			}
			
		});
		comboBox2.setToolTipText("IZABERI");
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Miroslav Ili\u0107- Jo\u0161 te ne\u0161to \u010Dini izuzetnom.mp3", "Miroslav Ili\u0107- Bo\u017Eanstvena \u017Eeno.mp3", "\u0160aban \u0160aulic- Sneg je opet Sne\u017Eana.mp3"}));
		comboBox2.setSelectedIndex(-1);
		//comboBox2.setBounds(101, 123, 304, 34);
		comboBox2.setBounds(101, 123, 304, 34);
		frmNarodna.getContentPane().add(comboBox2);
		
		
		lblIdePesma.setBounds(51, 209, 70, 14);
		frmNarodna.getContentPane().add(lblIdePesma);
		lblIdePesma.setVisible(false);
		
		
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(lblIdePesma.getText()=="da"){
					player.end(pos);
					if(jukebox.stanje<70){
						JOptionPane.showMessageDialog(null, "NEMATE VIŠE NOVCA");
						frmNarodna.hide();
					}
					
					else{
						jukebox.stanje-=70;
						lblPROBA.setText(Double.toString(jukebox.stanje));
						lblStanje.setText(lblPROBA.getText());
						lblPROBA.setVisible(false);
						player.play(pos);
					}
				}
				else{
					if(jukebox.stanje<70){
						JOptionPane.showMessageDialog(null, "NEMATE VIŠE NOVCA");
						frmNarodna.hide();
					}
					else{
						jukebox.stanje-=70;
						lblPROBA.setText(Double.toString(jukebox.stanje));
						lblStanje.setText(lblPROBA.getText());
						lblPROBA.setVisible(false);
						player.play(pos);
						lblIdePesma.setText("da");
					}
				}	
				
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlay.setForeground(new Color(255, 69, 0));
		btnPlay.setBackground(new Color(255, 218, 185));
		//btnPlay.setBounds(406, 251, 89, 23);
		btnPlay.setBounds(405, 273, 89, 23);
		frmNarodna.getContentPane().add(btnPlay);
		
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					player.pause();
			
			}
		});
		btnPause.setBackground(new Color(255, 218, 185));
		btnPause.setForeground(new Color(255, 69, 0));
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 10));
		//btnPause.setBounds(406, 285, 89, 23);
		btnPause.setBounds(405, 307, 89, 23);
		frmNarodna.getContentPane().add(btnPause);
		
		
		
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				player.end(pos);
			}
			
		});
		btnEnd.setForeground(new Color(255, 69, 0));
		btnEnd.setBackground(new Color(255, 218, 185));
		btnEnd.setFont(new Font("Tahoma", Font.BOLD, 10));
		//btnEnd.setBounds(416, 319, 71, 23);
		btnEnd.setBounds(415, 338, 67, 23);
		frmNarodna.getContentPane().add(btnEnd);
		
		
	}
	
}
