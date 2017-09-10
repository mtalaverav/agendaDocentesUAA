package py.gpi.uaa.agenda.docentes.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.gpi.uaa.agenda.docentes.dao.FacultadDao;
import py.gpi.uaa.agenda.docentes.dao.MateriaDao;
import py.gpi.uaa.agenda.docentes.model.Facultad;
import py.gpi.uaa.agenda.docentes.model.Materia;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MateriaView {

	JFrame frameMateria;
	private JTextField txtCodMateria;
	private JTextField txtDescripcion;
	private JTextField txtCargaHoraria;
	private JTextField txtCantCreditos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MateriaView window = new MateriaView();
					window.frameMateria.setVisible(true);
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
			frameMateria.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public MateriaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMateria = new JFrame();
		frameMateria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\agenda_android.png"));
		frameMateria.setTitle("Materia");
		frameMateria.getContentPane().setBackground(new Color(204, 204, 255));
		frameMateria.setBounds(100, 100, 456, 624);
		frameMateria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMateria.getContentPane().setLayout(null);

		FacultadDao facultadDao = new FacultadDao();

		// combo facultad
		List<Facultad> facultades = facultadDao.recuperarFacultades();
		ArrayList<String> stringComboFacultades = new ArrayList<>();
		for (Facultad facultad : facultades) {
			stringComboFacultades.add(facultad.getDescripcion());
		}
		JComboBox<Facultad> cboFacultad = new JComboBox(stringComboFacultades.toArray());
		cboFacultad.setBounds(132, 358, 116, 22);
		frameMateria.getContentPane().add(cboFacultad);

		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblMateria.setBounds(104, 26, 95, 26);
		frameMateria.getContentPane().add(lblMateria);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(31, 117, 89, 16);
		frameMateria.getContentPane().add(lblCodigo);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(23, 172, 97, 16);
		frameMateria.getContentPane().add(lblDescripcion);

		JLabel lblCargaHoraria = new JLabel("Carga Horaria:");
		lblCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargaHoraria.setBounds(12, 228, 116, 16);
		frameMateria.getContentPane().add(lblCargaHoraria);

		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos:");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeCreditos.setBounds(23, 294, 176, 16);
		frameMateria.getContentPane().add(lblCantidadDeCreditos);

		txtCodMateria = new JTextField();
		txtCodMateria.setBounds(132, 116, 116, 22);
		frameMateria.getContentPane().add(txtCodMateria);
		txtCodMateria.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(132, 171, 116, 22);
		frameMateria.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setBounds(132, 227, 116, 22);
		frameMateria.getContentPane().add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Materia materia = new Materia();

				try {

					materia.setIdMateria(txtCodMateria.getText());
					materia.setDescripcionMateria(txtDescripcion.getText());
					materia.setCargaHoraria(txtCargaHoraria.getText());
					materia.setCantidadCreditos(txtCantCreditos.getText());

					Facultad facultad = new Facultad();
					facultad.setIdFacultad(cboFacultad.getSelectedItem().toString());
					materia.setFacultad(facultad);

					MateriaDao matDao = new MateriaDao();

					Boolean isInserted = matDao.insertarMateria(materia);

					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Registro Correcto!", "", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro", null,
								JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (SQLException e1) {

					System.out.println(e1.getMessage());

				}
			}
		});
		btnAgregar.setBounds(80, 433, 97, 25);
		frameMateria.getContentPane().add(btnAgregar);

		JLabel lblFacultad = new JLabel("Facultad:");
		lblFacultad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFacultad.setBounds(31, 359, 89, 16);
		frameMateria.getContentPane().add(lblFacultad);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Materia materia = new Materia();

				materia.setIdMateria(txtCodMateria.getText());

				materia.setDescripcionMateria(txtDescripcion.getText());
				materia.setCargaHoraria(txtCargaHoraria.getText());
				materia.setCantidadCreditos(txtCantCreditos.getText());

				Facultad facultad = new Facultad();
				facultad.setIdFacultad(cboFacultad.getSelectedItem().toString());
				materia.setFacultad(facultad);

				MateriaDao matDao = new MateriaDao();

				Boolean isDeleted = matDao.eliminarDMateria(materia);

				if (isDeleted) {
					JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnEliminar.setBounds(236, 433, 97, 25);
		frameMateria.getContentPane().add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(172, 511, 97, 25);
		frameMateria.getContentPane().add(btnCancelar);

		JButton btnFacultad = new JButton("Agregar Facultad");
		btnFacultad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FacultadView visible = new FacultadView();
				visible.frameFacultad.setVisible(true);
			}
		});
		btnFacultad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFacultad.setBounds(276, 357, 97, 25);
		frameMateria.getContentPane().add(btnFacultad);

		txtCantCreditos = new JTextField();
		txtCantCreditos.setBounds(202, 293, 67, 22);
		frameMateria.getContentPane().add(txtCantCreditos);
		txtCantCreditos.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\materia.png"));
		lblNewLabel.setBounds(276, 101, 150, 153);
		frameMateria.getContentPane().add(lblNewLabel);

		JLabel labelAyuda = new JLabel("");
		labelAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MateriaF1View visible = new MateriaF1View();
				visible.frameAyudaMateria.setVisible(true);

			}
		});
		labelAyuda.setIcon(new ImageIcon("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\ayuda.png"));
		labelAyuda.setBounds(358, 13, 57, 63);
		frameMateria.getContentPane().add(labelAyuda);
	}
}
