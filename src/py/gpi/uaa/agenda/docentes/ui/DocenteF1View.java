package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DocenteF1View {

	 JFrame AyudaDocente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocenteF1View window = new DocenteF1View();
					window.AyudaDocente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DocenteF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AyudaDocente = new JFrame();
		AyudaDocente.getContentPane().setBackground(Color.WHITE);
		AyudaDocente.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AyudaDocente.dispose();
			}
		});
		btnSalir.setBounds(673, 514, 97, 25);
		AyudaDocente.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("MANUAL\\Docente.jpg"));
		label.setBounds(60, 35, 691, 466);
		AyudaDocente.getContentPane().add(label);
		AyudaDocente.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		AyudaDocente.setTitle("Ayuda Docente");
		AyudaDocente.setBounds(100, 100, 797, 606);
		AyudaDocente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
