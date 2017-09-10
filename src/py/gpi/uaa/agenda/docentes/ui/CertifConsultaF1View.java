package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CertifConsultaF1View {

 JFrame frameAyudaConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CertifConsultaF1View window = new CertifConsultaF1View();
					window.frameAyudaConsulta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CertifConsultaF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaConsulta = new JFrame();
		frameAyudaConsulta.getContentPane().setBackground(Color.WHITE);
		frameAyudaConsulta.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frameAyudaConsulta.setTitle("Ayuda Consulta de Postulantes");
		frameAyudaConsulta.setBounds(100, 100, 998, 679);
		frameAyudaConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAyudaConsulta.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameAyudaConsulta.dispose();
			}
		});
		btnSalir.setBounds(856, 594, 97, 25);
		frameAyudaConsulta.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("MANUAL\\CONSULTA.jpg"));
		label.setBounds(12, 0, 941, 588);
		frameAyudaConsulta.getContentPane().add(label);
	}

}
