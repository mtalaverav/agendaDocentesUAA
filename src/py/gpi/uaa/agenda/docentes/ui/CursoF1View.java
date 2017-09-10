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

public class CursoF1View {

	 JFrame frameAyudaCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoF1View window = new CursoF1View();
					window.frameAyudaCurso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CursoF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaCurso = new JFrame();
		frameAyudaCurso.setTitle("Ayuda Curso");
		frameAyudaCurso.getContentPane().setBackground(Color.WHITE);
		frameAyudaCurso.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frameAyudaCurso.setBounds(100, 100, 814, 577);
		frameAyudaCurso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAyudaCurso.getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameAyudaCurso.dispose();
			}
		});
		btnSalir.setBounds(689, 483, 97, 25);
		frameAyudaCurso.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("MANUAL\\Curso.jpg"));
		label.setBounds(37, 13, 774, 495);
		frameAyudaCurso.getContentPane().add(label);
	}

}
