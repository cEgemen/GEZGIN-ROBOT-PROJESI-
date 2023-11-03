import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtLabirentOyunlarnaHos;

	/**
	 * Launch the application.
	 */
	public void gizle()
	{
		this.setVisible(false);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 571);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLabirentOyunlarnaHos = new JTextField("Labirent Oyunlarına Hos Geldiniz");
		txtLabirentOyunlarnaHos.setEditable(false);
		txtLabirentOyunlarnaHos.setForeground(new Color(148, 0, 211));
		txtLabirentOyunlarnaHos.setBackground(new Color(135, 206, 250));
		txtLabirentOyunlarnaHos.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabirentOyunlarnaHos.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		txtLabirentOyunlarnaHos.setBounds(133, 10, 767, 45);
		txtLabirentOyunlarnaHos.setBorder(null);
		contentPane.add(txtLabirentOyunlarnaHos);
		txtLabirentOyunlarnaHos.setColumns(10);
		
		JButton b1 = new JButton("Problem 1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gizle();
				P1 p=new P1();
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(255, 182, 193));
		b1.setBounds(257, 354, 206, 56);
		Image i1=new ImageIcon(this.getClass().getResource("/s.png")).getImage();
		b1.setIcon(new ImageIcon(i1));
		contentPane.add(b1);
		
		JButton b2 = new JButton("Problem 2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gizle();
				P2 p2=new P2();
			}
		});
		b2.setBackground(new Color(255, 182, 193));
		b2.setForeground(new Color(0, 0, 0));
		b2.setBounds(591, 354, 206, 56);
		Image i2=new ImageIcon(this.getClass().getResource("/s.png")).getImage();
		b2.setIcon(new ImageIcon(i2));
		contentPane.add(b2);
		
		JLabel l2 = new JLabel("");
		l2.setBounds(466, 128, 180, 133);
		Image i3=new ImageIcon(this.getClass().getResource("/m1.png")).getImage();
		l2.setIcon(new ImageIcon(i3));
		contentPane.add(l2);
		
		JLabel l1 = new JLabel("");
		l1.setBounds(170, 128, 180, 140);
		Image i4=new ImageIcon(this.getClass().getResource("/m2.png")).getImage();
		l1.setIcon(new ImageIcon(i4));
		contentPane.add(l1);
		
		JLabel l3 = new JLabel("");
		l3.setBounds(774, 118, 162, 140);
		Image i5=new ImageIcon(this.getClass().getResource("/m3.png")).getImage();
		l3.setIcon(new ImageIcon(i5));
		contentPane.add(l3);
		this.setVisible(true);
	}
}
