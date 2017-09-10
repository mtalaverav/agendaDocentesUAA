package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AgendaF1View {

	 JFrame frameAyudaAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaF1View window = new AgendaF1View();
					window.frameAyudaAgenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgendaF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaAgenda = new JFrame();
		frameAyudaAgenda.getContentPane().setBackground(Color.WHITE);
		frameAyudaAgenda.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameAyudaAgenda.dispose();
			}
		});
		btnSalir.setBounds(688, 516, 97, 25);
		frameAyudaAgenda.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("MANUAL\\Agenda de docentes.jpg"));
		label.setBounds(65, 26, 701, 499);
		frameAyudaAgenda.getContentPane().add(label);
		frameAyudaAgenda.setTitle("Ayuda - Agenda");
		frameAyudaAgenda.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frameAyudaAgenda.setBounds(100, 100, 831, 617);
		frameAyudaAgenda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
