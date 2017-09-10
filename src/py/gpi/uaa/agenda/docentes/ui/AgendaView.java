package py.gpi.uaa.agenda.docentes.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import py.gpi.uaa.agenda.docentes.dao.DocenteDao;
import py.gpi.uaa.agenda.docentes.model.Docente;

public class AgendaView {

	JFrame frmAgendaDeDocentes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaView window = new AgendaView();
					window.frmAgendaDeDocentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void confirmar() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cancelar?", "Mensaje de Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Create the application.
	 */
	public AgendaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeDocentes = new JFrame();
		frmAgendaDeDocentes.getContentPane().setBackground(new Color(204, 204, 255));
		frmAgendaDeDocentes.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		frmAgendaDeDocentes.setTitle("Agenda de Docentes - Universidad Autonoma de Asuncion");
		frmAgendaDeDocentes.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("agenda_android.png"));
		frmAgendaDeDocentes.setBounds(100, 100, 513, 586);
		frmAgendaDeDocentes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaDeDocentes.getContentPane().setLayout(null);

		JLabel lblAgenda = new JLabel("Agenda de Docentes");
		lblAgenda.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblAgenda.setBounds(32, 13, 244, 56);
		frmAgendaDeDocentes.getContentPane().add(lblAgenda);

		DocenteDao docenteDao = new DocenteDao();

		// COMBOBOX - DOCENTE

		List<Docente> docentes = docenteDao.recuperarDocente();
		ArrayList<String> stringComboDocente = new ArrayList<>();
		for (Docente docente : docentes) {
			stringComboDocente.add(docente.getNombreDocente());
		}

		JButton btnNuevo = new JButton("Docente");
		btnNuevo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DocenteView visible = new DocenteView();
				visible.docenteView.setVisible(true);
			}
		});
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(300, 258, 136, 43);
		frmAgendaDeDocentes.getContentPane().add(btnNuevo);
		
		JButton btnNuevo_1 = new JButton("Materia");
		btnNuevo_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnNuevo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MateriaView visible = new MateriaView();
				visible.frameMateria.setVisible(true);
			}
		});
		btnNuevo_1.setBounds(32, 112, 136, 43);
		frmAgendaDeDocentes.getContentPane().add(btnNuevo_1);
		
		JButton btnNuevoCurso = new JButton("Curso");
		btnNuevoCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnNuevoCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CursoView visible = new CursoView();
				visible.frameCurso.setVisible(true);
			}
		});
		btnNuevoCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNuevoCurso.setBounds(300, 337, 136, 43);
		frmAgendaDeDocentes.getContentPane().add(btnNuevoCurso);
		
		JButton btnNuevo_2 = new JButton("Consulta de Postulantes");
		btnNuevo_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnNuevo_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CertificacionConsultaView visible = new CertificacionConsultaView();
				visible.frameCertificacion.setVisible(true);
			}
		});
		btnNuevo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNuevo_2.setBounds(32, 182, 264, 49);
		frmAgendaDeDocentes.getContentPane().add(btnNuevo_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(374, 430, 97, 25);
		frmAgendaDeDocentes.getContentPane().add(btnCancelar);
		
		JButton btnAgregarCertificacion = new JButton("Agregar Certificacion");
		btnAgregarCertificacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CertificacionView visible = new CertificacionView();
				visible.frmCertificacion.setVisible(true);
			}
		});
		btnAgregarCertificacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnAgregarCertificacion.setBounds(32, 258, 221, 43);
		frmAgendaDeDocentes.getContentPane().add(btnAgregarCertificacion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("agenda.png"));
		label.setBounds(85, 337, 194, 164);
		frmAgendaDeDocentes.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("logo2.png"));
		lblNewLabel.setBounds(300, 32, 171, 188);
		frmAgendaDeDocentes.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pikachu.png"));
		label_1.setBounds(413, 483, 70, 43);
		frmAgendaDeDocentes.getContentPane().add(label_1);
		
		JLabel lblDesarrolladoPor = new JLabel("Desarrollado Por: ");
		lblDesarrolladoPor.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblDesarrolladoPor.setBounds(303, 497, 113, 16);
		frmAgendaDeDocentes.getContentPane().add(lblDesarrolladoPor);
		
		JLabel ayudaAgenda = new JLabel("");
		ayudaAgenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AgendaF1View visible = new AgendaF1View();
				visible.frameAyudaAgenda.setVisible(true);
			}
		});
		ayudaAgenda.setIcon(new ImageIcon("ayuda.png"));
		ayudaAgenda.setBounds(438, 0, 57, 63);
		frmAgendaDeDocentes.getContentPane().add(ayudaAgenda);
	}
}
