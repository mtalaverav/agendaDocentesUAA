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

public class CertificacionF1View {

	 JFrame frameAyudaCertificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CertificacionF1View window = new CertificacionF1View();
					window.frameAyudaCertificacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CertificacionF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaCertificacion = new JFrame();
		frameAyudaCertificacion.getContentPane().setBackground(Color.WHITE);
		frameAyudaCertificacion.setBackground(Color.WHITE);
		frameAyudaCertificacion.setTitle("Ayuda Certificacion");
		frameAyudaCertificacion.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frameAyudaCertificacion.setBounds(100, 100, 794, 612);
		frameAyudaCertificacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAyudaCertificacion.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameAyudaCertificacion.dispose();
			}
		});
		btnSalir.setBounds(667, 527, 97, 25);
		frameAyudaCertificacion.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("MANUAL\\Certificacion.jpg"));
		label.setBounds(49, 13, 688, 509);
		frameAyudaCertificacion.getContentPane().add(label);
	}
}
