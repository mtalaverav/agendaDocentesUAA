package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FacultadF1View {

	 JFrame frameAyudaFacultad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultadF1View window = new FacultadF1View();
					window.frameAyudaFacultad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacultadF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaFacultad = new JFrame();
		frameAyudaFacultad.getContentPane().setBackground(Color.WHITE);
		frameAyudaFacultad.setTitle("Ayuda Facultad");
		frameAyudaFacultad.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\agenda_android.png"));
		frameAyudaFacultad.setBounds(100, 100, 754, 580);
		frameAyudaFacultad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAyudaFacultad.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameAyudaFacultad.dispose();
			}
		});
		btnSalir.setBounds(632, 487, 97, 25);
		frameAyudaFacultad.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\MANUAL\\Facultad.jpg"));
		label.setBounds(25, 45, 704, 429);
		frameAyudaFacultad.getContentPane().add(label);
	}
}
