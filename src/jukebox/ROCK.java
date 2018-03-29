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

public class ROCK extends jukebox {

	MUSIC player = new MUSIC();
	private int pos = 0;

	private JFrame frmRock;

	JComboBox comboBox = new JComboBox();
	JButton btnBack = new JButton("BACK");
	JButton btnPlay = new JButton("PLAY");
	JButton btnPause = new JButton("PAUSE");
	JButton btnEnd = new JButton("END");
	JLabel lblRockMuzika = new JLabel("Rock muzika");
	JLabel lblPROBA = new JLabel("");
	JLabel lblIdePesma = new JLabel("");

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ROCK window = new ROCK();
					window.frmRock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ROCK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmRock = new JFrame();
		frmRock.getContentPane().setForeground(new Color(85, 107, 47));
		frmRock.getContentPane().setBackground(new Color(238, 232, 170));
		frmRock.setTitle("ROCK");
		frmRock.setBounds(100, 100, 523, 412);
		frmRock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRock.getContentPane().setLayout(null);

		lblRockMuzika.setForeground(new Color(85, 107, 47));
		lblRockMuzika.setBackground(new Color(250, 250, 210));
		lblRockMuzika.setHorizontalAlignment(SwingConstants.CENTER);
		lblRockMuzika.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblRockMuzika.setBounds(158, 11, 171, 33);
		frmRock.getContentPane().add(lblRockMuzika);

		lblPROBA.setBounds(51, 277, 46, 14);
		frmRock.getContentPane().add(lblPROBA);

		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setForeground(new Color(85, 107, 47));
		btnBack.setBackground(new Color(189, 183, 107));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (lblIdePesma.getText() == "da") {
					player.end(pos);
					frmRock.hide();
				} else
					frmRock.hide();

			}
		});
		// btnBack.setBounds(10, 11, 72, 23);
		btnBack.setBounds(10, 11, 100, 23);
		frmRock.getContentPane().add(btnBack);

		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setForeground(new Color(85, 107, 47));
		comboBox.setBackground(new Color(189, 183, 107));
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				obj = comboBox.getSelectedItem();
				player.setPath(String.valueOf(obj));
				btnPlay.setEnabled(true);
			}

		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Riblja \u010Dorba- Kad hoda\u0161.mp3",
				"Riblja \u010Dorba- Amsterdam.mp3", "EKV- Srce.mp3" }));
		comboBox.setToolTipText("IZABERI");
		comboBox.setSelectedIndex(-1);
		// comboBox.setBounds(113, 129, 241, 33);
		comboBox.setBounds(101, 123, 304, 34);
		frmRock.getContentPane().add(comboBox);

		lblIdePesma.setBounds(51, 209, 70, 14);
		frmRock.getContentPane().add(lblIdePesma);
		lblIdePesma.setVisible(false);

		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (lblIdePesma.getText() == "da") {
					player.end(pos);
					if (jukebox.stanje < 60) {
						JOptionPane.showMessageDialog(null, "NEMATE VI�E NOVCA");
						frmRock.hide();
					}

					else {
						jukebox.stanje -= 60;
						lblPROBA.setText(Double.toString(jukebox.stanje));
						lblStanje.setText(lblPROBA.getText());
						lblPROBA.setVisible(false);
						player.play(pos);
						btnPlay.setEnabled(false);
					}
				} else {
					if (jukebox.stanje < 60) {
						JOptionPane.showMessageDialog(null, "NEMATE VI�E NOVCA");
						frmRock.hide();
					} else {
						jukebox.stanje -= 60;
						lblPROBA.setText(Double.toString(jukebox.stanje));
						lblStanje.setText(lblPROBA.getText());
						lblPROBA.setVisible(false);
						player.play(pos);
						lblIdePesma.setText("da");
						btnPlay.setEnabled(false);
					}
				}

			}
		});
		btnPlay.setForeground(new Color(85, 107, 47));
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlay.setBackground(new Color(189, 183, 107));
		// btnPlay.setBounds(408, 268, 89, 23);
		btnPlay.setBounds(405, 273, 89, 23);
		frmRock.getContentPane().add(btnPlay);

		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				player.pause();
			}

		});
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPause.setForeground(new Color(85, 107, 47));
		btnPause.setBackground(new Color(189, 183, 107));
		// btnPause.setBounds(408, 302, 89, 23);
		btnPause.setBounds(405, 307, 89, 23);
		frmRock.getContentPane().add(btnPause);

		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				player.end(pos);
				btnPlay.setEnabled(true);
			}

		});
		btnEnd.setForeground(new Color(85, 107, 47));
		btnEnd.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEnd.setBackground(new Color(189, 183, 107));
		// btnEnd.setBounds(418, 336, 72, 23);
		btnEnd.setBounds(415, 338, 67, 23);
		frmRock.getContentPane().add(btnEnd);
	}

}
