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


public class PUNK extends jukebox{

	MUSIC player= new MUSIC ();
	private int pos=0;
	
	private JFrame frmPunk;
	
	JComboBox comboBox1 = new JComboBox();
	JButton btnBack = new JButton("BACK");
	JButton btnPlay = new JButton("PLAY");
	JButton btnPause = new JButton("PAUSE");
	JButton btnEnd = new JButton("END");
	JLabel lblPunkMuzika = new JLabel("Punk muzika");
	JLabel lblPROBA = new JLabel("");
	JLabel lblIdePesma = new JLabel("");
	
	
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PUNK window = new PUNK();
					window.frmPunk.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public PUNK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmPunk = new JFrame();
		frmPunk.setTitle("PUNK");
		frmPunk.getContentPane().setBackground(new Color(224, 255, 255));
		//frmPunk.setBounds(100, 100, 520, 410);
		frmPunk.setBounds(100, 100, 523, 412);
		frmPunk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPunk.getContentPane().setLayout(null);
		
		
		lblPunkMuzika.setHorizontalAlignment(SwingConstants.CENTER);
		lblPunkMuzika.setForeground(new Color(0, 139, 139));
		lblPunkMuzika.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblPunkMuzika.setBackground(new Color(224, 255, 255));
		lblPunkMuzika.setBounds(156, 11, 175, 33);
		frmPunk.getContentPane().add(lblPunkMuzika);
		
		
		lblPROBA.setBounds(51, 277, 46, 14);
		frmPunk.getContentPane().add(lblPROBA);
		
		
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setForeground(new Color(0, 139, 139));
		btnBack.setBackground(new Color(102, 205, 170));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(lblIdePesma.getText()=="da"){	
					player.end(pos);
					frmPunk.hide();
				}
				else
					frmPunk.hide();
			}
			
		});
		btnBack.setBounds(10, 11, 67, 23);
		frmPunk.getContentPane().add(btnBack);
		
		
		comboBox1.setForeground(new Color(0, 139, 139));
		comboBox1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox1.setBackground(new Color(102, 205, 170));
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				obj=comboBox1.getSelectedItem();
				player.setPath(String.valueOf(obj));
				
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Hladno Pivo-Pitala si me.mp3", "Hladno pivo - Pravo ja.mp3", "Goblini -  Voz.mp3"}));
		comboBox1.setToolTipText("IZABERI");
		comboBox1.setSelectedIndex(-1);
		//comboBox1.setBounds(104, 114, 258, 33);
		comboBox1.setBounds(101, 123, 304, 34);
		frmPunk.getContentPane().add(comboBox1);
		
		
		
		lblIdePesma.setBounds(51, 209, 70, 14);
		frmPunk.getContentPane().add(lblIdePesma);
		lblIdePesma.setVisible(false);
		
		
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(lblIdePesma.getText()=="da"){
						player.end(pos);
						if(jukebox.stanje<50){
							JOptionPane.showMessageDialog(null, "NEMATE VIŠE NOVCA");
							frmPunk.hide();
						}
						
						else{
							jukebox.stanje-=50;
							lblPROBA.setText(Double.toString(jukebox.stanje));
							lblStanje.setText(lblPROBA.getText());
							lblPROBA.setVisible(false);
							player.play(pos);
						}
					}
					else{
						if(jukebox.stanje<50){
							JOptionPane.showMessageDialog(null, "NEMATE VIŠE NOVCA");
							frmPunk.hide();
						}
						else{
							jukebox.stanje-=50;
							lblPROBA.setText(Double.toString(jukebox.stanje));
							lblStanje.setText(lblPROBA.getText());
							lblPROBA.setVisible(false);
							player.play(pos);
							lblIdePesma.setText("da");
						}
					}	
				
			}
			
		});
		btnPlay.setForeground(new Color(0, 139, 139));
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlay.setBackground(new Color(102, 205, 170));
		btnPlay.setBounds(405, 273, 89, 23);
		frmPunk.getContentPane().add(btnPlay);
		
		
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				player.pause();
			}
			
		});
		btnPause.setForeground(new Color(0, 139, 139));
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPause.setBackground(new Color(102, 205, 170));
		btnPause.setBounds(405, 307, 89, 23);
		frmPunk.getContentPane().add(btnPause);
		
		
		
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				player.end(pos);
			}
			
		});
		btnEnd.setForeground(new Color(0, 139, 139));
		btnEnd.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEnd.setBackground(new Color(102, 205, 170));
		btnEnd.setBounds(415, 338, 67, 23);
		frmPunk.getContentPane().add(btnEnd);
		
	}
		
		
	
}


