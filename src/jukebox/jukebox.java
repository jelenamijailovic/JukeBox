package jukebox;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import jukebox.PUNK.BaseMouseListener;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class jukebox {

	public JFrame frmJukebox;
	public JTextField textField;
	public static double stanje=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jukebox window = new jukebox();
					window.frmJukebox.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Object obj;
	JLabel lblIzaberiVrstuMuzike = new JLabel("Izaberi vrstu muzike");
	public JLabel lblStanje = new JLabel("");
	JLabel lblPreostaliNovac = new JLabel("PREOSTALI NOVAC:");
	JTable table= new JTable();
	JButton btnPunk = new JButton("PUNK");
	JButton btnRock = new JButton("ROCK");
	JButton btnNarodna = new JButton("NARODNA");
	JButton btnProveriStanje = new JButton("Proveri stanje");
	JButton btnUbaciNovac = new JButton("UBACI NOVAC");
	JLabel lblDinara = new JLabel("dinara");
	JLabel lblCenovnik = new JLabel("CENOVNIK:");
	
	
	
	
	/**
	 * Create the application.
	 */
	public jukebox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmJukebox = new JFrame();
		frmJukebox.setTitle("JUKEBOX");
		frmJukebox.getContentPane().setBackground(new Color(253, 245, 230));
		frmJukebox.setBounds(100, 100, 450, 300);
		frmJukebox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJukebox.getContentPane().setLayout(null);
		
		
		lblIzaberiVrstuMuzike.setForeground(new Color(219, 112, 147));
		lblIzaberiVrstuMuzike.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblIzaberiVrstuMuzike.setBounds(103, 11, 249, 37);
		frmJukebox.getContentPane().add(lblIzaberiVrstuMuzike);
	
		
		lblPreostaliNovac.setVisible(false);
		lblPreostaliNovac.setForeground(new Color(219, 112, 147));
		lblPreostaliNovac.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreostaliNovac.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreostaliNovac.setBounds(304, 207, 120, 14);
		frmJukebox.getContentPane().add(lblPreostaliNovac);
		
		
		btnPunk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblStanje.isVisible()) {
					if(stanje<50){
						lblStanje.setText("Nemate vi�e novca");
						JOptionPane.showMessageDialog(null, "UBACITE NOVAC!");
					}
					else{
						lblStanje.setText(Double.toString(stanje)+" dinara");
						PUNK p = new PUNK();
						p.NewScreen();
						lblPreostaliNovac.setVisible(false);
						lblStanje.setVisible(false);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "PROVERI STANJE ILI UBACI NOVAC!");
				}
					
			}
		});
		
		btnPunk.setForeground(new Color(219, 112, 147));
		btnPunk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPunk.setBackground(new Color(255, 192, 203));
		btnPunk.setBounds(168, 59, 89, 23);
		frmJukebox.getContentPane().add(btnPunk);
		
		
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblStanje.isVisible()) {
					if(stanje<60){
						lblStanje.setText("Nemate vi�e novca");
						JOptionPane.showMessageDialog(null, "UBACITE NOVAC!");
					}
					else{
						lblStanje.setText(Double.toString(stanje)+" dinara");
						ROCK r= new ROCK();
						r.NewScreen();
						lblPreostaliNovac.setVisible(false);
						lblStanje.setVisible(false);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "PROVERI STANJE ILI UBACI NOVAC!");
				}
			
			}
			
		});
		btnRock.setForeground(new Color(219, 112, 147));
		btnRock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRock.setBackground(new Color(255, 192, 203));
		btnRock.setBounds(168, 117, 89, 23);
		frmJukebox.getContentPane().add(btnRock);
		
		
		btnNarodna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblStanje.isVisible()) {
					if(stanje<70){
						lblStanje.setText("Nemate vi�e novca");
						JOptionPane.showMessageDialog(null, "UBACITE NOVAC!");
					}
					else{
						lblStanje.setText(Double.toString(stanje)+" dinara");
						NARODNA n= new NARODNA();
						n.NewScreen();
						lblPreostaliNovac.setVisible(false);
						lblStanje.setVisible(false);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "PROVERI STANJE ILI UBACI NOVAC!");
				}
			}
			
		});
		btnNarodna.setForeground(new Color(219, 112, 147));
		btnNarodna.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNarodna.setBackground(new Color(255, 192, 203));
		btnNarodna.setBounds(156, 176, 114, 23);
		frmJukebox.getContentPane().add(btnNarodna);
		

		textField = new JTextField();
		textField.setForeground(new Color(219, 112, 147));
		textField.setBounds(10, 197, 68, 20);
		textField.setColumns(10);
		frmJukebox.getContentPane().add(textField);
		
		
		lblStanje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStanje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStanje.setForeground(new Color(219, 112, 147));
		lblStanje.setBounds(278, 232, 146, 14);
		frmJukebox.getContentPane().add(lblStanje);
		
		
		btnProveriStanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					lblPreostaliNovac.setVisible(true);
					lblStanje.setVisible(true);
					lblStanje.setText(Double.toString(stanje)+" dinara");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "GRE�KA");
				}
			}
		});
		btnProveriStanje.setBackground(new Color(255, 192, 203));
		btnProveriStanje.setForeground(new Color(219, 112, 147));
		btnProveriStanje.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProveriStanje.setBounds(304, 173, 120, 23);
		frmJukebox.getContentPane().add(btnProveriStanje);
		
		
		
		
		btnUbaciNovac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPreostaliNovac.setVisible(true);
				lblStanje.setVisible(true);
				String n;
				n=textField.getText();
				try{
					double novac= Double.parseDouble(n);
					stanje+=novac;
					lblStanje.setText(Double.toString(stanje)+" dinara");
					textField.setText(null);
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Novac nije unet");
				}
				
				
			}
		});
		btnUbaciNovac.setBackground(new Color(255, 192, 203));
		btnUbaciNovac.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUbaciNovac.setForeground(new Color(219, 112, 147));
		btnUbaciNovac.setBounds(10, 228, 150, 23);
		frmJukebox.getContentPane().add(btnUbaciNovac);
		
		
		
		lblDinara.setForeground(new Color(219, 112, 147));
		lblDinara.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDinara.setBounds(88, 200, 46, 14);
		frmJukebox.getContentPane().add(lblDinara);
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(new Color(253, 245, 230));
		table.setEnabled(false);
		table.setForeground(new Color(219, 112, 147));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"PUNK", "50 dinara"},
				{"ROCK", "60 dinara"},
				{"NARODNA", "70 dinara"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(10, 97, 120, 48);
		frmJukebox.getContentPane().add(table);
		
		
		lblCenovnik.setForeground(new Color(219, 112, 147));
		lblCenovnik.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCenovnik.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenovnik.setBounds(33, 83, 75, 14);
		frmJukebox.getContentPane().add(lblCenovnik);
		
		
		
		
	
		
		
	}
}
