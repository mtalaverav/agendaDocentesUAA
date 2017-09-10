package py.gpi.uaa.agenda.docentes.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.gpi.uaa.agenda.docentes.dao.CertificacionDao;
import py.gpi.uaa.agenda.docentes.dao.DocenteDao;
import py.gpi.uaa.agenda.docentes.dao.MateriaDao;
import py.gpi.uaa.agenda.docentes.model.Certificacion;
import py.gpi.uaa.agenda.docentes.model.Docente;
import py.gpi.uaa.agenda.docentes.model.Materia;
import java.awt.Toolkit;

public class CertificacionView {

	JFrame frmCertificacion;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CertificacionView window = new CertificacionView();
					window.frmCertificacion.setVisible(true);
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
			// System.exit(0);
			frmCertificacion.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public CertificacionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCertificacion = new JFrame();
		frmCertificacion.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frmCertificacion.getContentPane().setBackground(new Color(204, 204, 255));
		frmCertificacion.getContentPane().setLayout(null);

		JLabel lblCertificacion = new JLabel("Certificacion");
		lblCertificacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCertificacion.setBounds(102, 13, 120, 44);
		frmCertificacion.getContentPane().add(lblCertificacion);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(34, 92, 56, 16);
		frmCertificacion.getContentPane().add(lblCodigo);

		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setBounds(34, 149, 56, 16);
		frmCertificacion.getContentPane().add(lblDocente);

		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setBounds(34, 210, 56, 16);
		frmCertificacion.getContentPane().add(lblMateria);

		// materia
		MateriaDao materiaDao = new MateriaDao();
		List<Materia> materias = materiaDao.recuperarMateria();
		ArrayList<String> stringComboMaterias = new ArrayList<>();
		for (Materia materia : materias) {
			stringComboMaterias.add(materia.getDescripcionMateria());
		}
		JComboBox<Materia> cboMateria = new JComboBox(stringComboMaterias.toArray());
		cboMateria.setBounds(102, 207, 101, 22);
		frmCertificacion.getContentPane().add(cboMateria);

		// docente
		DocenteDao docenteDao = new DocenteDao();
		List<Docente> docentes = docenteDao.recuperarDocente();
		ArrayList<String> stringComboDocentes = new ArrayList<>();
		for (Docente docente : docentes) {
			stringComboDocentes.add(docente.getNombreDocente());
		}

		JComboBox<Docente> cboDocente = new JComboBox(stringComboDocentes.toArray());
		cboDocente.setBounds(102, 146, 101, 22);
		frmCertificacion.getContentPane().add(cboDocente);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(102, 87, 101, 22);
		frmCertificacion.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Certificacion certificacion = new Certificacion();

				try {

					certificacion.setIdCertificacion(txtCodigo.getText());

					Docente doc = new Docente();
					doc.setNombreDocente(cboDocente.getSelectedItem().toString());
					certificacion.setDocente(doc);

					Materia mat = new Materia();
					mat.setIdMateria(cboMateria.getSelectedItem().toString());
					certificacion.setMateria(mat);

					CertificacionDao certDao = new CertificacionDao();
					Boolean isInserted = certDao.insertarCertificacion(certificacion);

					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Registro Correcto!", "", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro", null,
								JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (SQLException e) {

					System.out.println(e.getMessage());

				}
			}
		});
		btnAgregar.setBounds(55, 297, 97, 25);
		frmCertificacion.getContentPane().add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Certificacion certificacion = new Certificacion();

				certificacion.setIdCertificacion(txtCodigo.getText());

				Docente doc = new Docente();
				doc.setNombreDocente(cboDocente.getSelectedItem().toString());
				certificacion.setDocente(doc);

				Materia mat = new Materia();
				mat.setIdMateria(cboMateria.getSelectedItem().toString());
				certificacion.setMateria(mat);

				CertificacionDao certDao = new CertificacionDao();
				Boolean isDeleted = certDao.eliminarCertificacion(certificacion);

				if (isDeleted) {
					JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnEliminar.setBounds(184, 297, 97, 25);
		frmCertificacion.getContentPane().add(btnEliminar);

		JButton btnSalir = new JButton("Cancelar");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnSalir.setBounds(265, 345, 97, 25);
		frmCertificacion.getContentPane().add(btnSalir);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("nuevo.png"));
		label.setBounds(215, 92, 187, 150);
		frmCertificacion.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CertificacionF1View visivble = new CertificacionF1View();
				visivble.frameAyudaCertificacion.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon("ayuda.png"));
		label_1.setBounds(314, 17, 65, 62);
		frmCertificacion.getContentPane().add(label_1);
		frmCertificacion.setTitle("Certificacion");
		frmCertificacion.setBounds(100, 100, 422, 467);
		frmCertificacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
