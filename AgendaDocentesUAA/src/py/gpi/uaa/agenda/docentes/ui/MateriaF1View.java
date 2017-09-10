package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MateriaF1View {

	 JFrame frameAyudaMateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MateriaF1View window = new MateriaF1View();
					window.frameAyudaMateria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MateriaF1View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAyudaMateria = new JFrame();
		frameAyudaMateria.setTitle("Ayuda - Materia");
		frameAyudaMateria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\agenda_android.png"));
		frameAyudaMateria.getContentPane().setBackground(Color.WHITE);
		frameAyudaMateria.setBounds(100, 100, 951, 735);
		frameAyudaMateria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAyudaMateria.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Users\\Melissa\\OneDrive\\Documentos\\UAA 2017\\445 - GESTI\u00D3N DE PROYECTOS INFORM\u00C1TICOS\\PROYECTO\\6 - ENTREGA FINAL\\MANUAL\\MATERIA.jpg"));
		label.setBounds(53, 0, 848, 624);
		frameAyudaMateria.getContentPane().add(label);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAyudaMateria.dispose();
			}
		});
		btnSalir.setBounds(795, 637, 97, 25);
		frameAyudaMateria.getContentPane().add(btnSalir);
	}
}
