package py.gpi.uaa.agenda.docentes.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

import py.gpi.uaa.agenda.docentes.dao.DocenteDao;
import py.gpi.uaa.agenda.docentes.dao.NacionalidadDao;
import py.gpi.uaa.agenda.docentes.model.Docente;
import py.gpi.uaa.agenda.docentes.model.Nacionalidad;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class DocenteView {

	JFrame docenteView;
	private JTextField txtCodigo;
	private JTextField txtCI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCelular;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocenteView window = new DocenteView();
					window.docenteView.setVisible(true);
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
			//System.exit(0);
			docenteView.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public DocenteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		docenteView = new JFrame();
		docenteView.setIconImage(
				Toolkit.getDefaultToolkit().getImage("icon.png"));
		docenteView.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		docenteView.getContentPane().setBackground(new Color(204, 204, 255));
		docenteView.setTitle("Docente ");
		docenteView.setBounds(100, 100, 572, 548);
		docenteView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		docenteView.getContentPane().setLayout(null);

		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblDocente.setBounds(235, 13, 138, 33);
		docenteView.getContentPane().add(lblDocente);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(32, 79, 69, 23);
		docenteView.getContentPane().add(lblCodigo);

		JLabel lblNumeroCi = new JLabel("Numero C.I.:");
		lblNumeroCi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroCi.setBounds(35, 219, 102, 16);
		docenteView.getContentPane().add(lblNumeroCi);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(35, 128, 102, 16);
		docenteView.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(32, 177, 83, 16);
		docenteView.getContentPane().add(lblApellido);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNacionalidad.setBounds(32, 268, 105, 16);
		docenteView.getContentPane().add(lblNacionalidad);

		JLabel lblCelula = new JLabel("Celular:");
		lblCelula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelula.setBounds(32, 313, 69, 16);
		docenteView.getContentPane().add(lblCelula);

		JLabel lblCorreoElectronico = new JLabel("Correo Electronico: ");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCorreoElectronico.setBounds(32, 360, 155, 16);
		docenteView.getContentPane().add(lblCorreoElectronico);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(149, 81, 116, 22);
		docenteView.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtCI = new JTextField();
		txtCI.setBounds(149, 218, 116, 22);
		docenteView.getContentPane().add(txtCI);
		txtCI.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(149, 127, 184, 22);
		docenteView.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(149, 176, 184, 22);
		docenteView.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		NacionalidadDao nacionalidadDao = new NacionalidadDao();

		// NACIONALIDADES
		List<Nacionalidad> nacionalidades = nacionalidadDao.recuperarNacionalidades();
		ArrayList<String> stringComboNacionalidades = new ArrayList<>();
		for (Nacionalidad nacionalidad : nacionalidades) {
			stringComboNacionalidades.add(nacionalidad.getDescripcionNacionalidad());
		}
		JComboBox<Nacionalidad> cboNacionalidad = new JComboBox(stringComboNacionalidades.toArray());
		cboNacionalidad.setBounds(149, 267, 116, 22);
		docenteView.getContentPane().add(cboNacionalidad);

		txtCelular = new JTextField();
		txtCelular.setBounds(149, 312, 116, 22);
		docenteView.getContentPane().add(txtCelular);
		txtCelular.setColumns(10);

		txtMail = new JTextField();
		txtMail.setBounds(198, 359, 161, 17);
		docenteView.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Docente docente = new Docente();

				// campos
				try {

					String codigoID = txtCodigo.getText();
					docente.setIdDocente(Integer.valueOf(codigoID));
					//
					// String numeroCI = txtCI.getText();
					// docente.setNumeroCedula(Integer.valueOf(numeroCI));

					docente.setNumeroCedula(txtCI.getText());
					docente.setNombreDocente(txtNombre.getText());

					docente.setApellidoDocente(txtApellido.getText());

					Nacionalidad nac = new Nacionalidad();
					nac.setIdNacionalidad(cboNacionalidad.getSelectedItem().toString());
					docente.setNacionalidad(nac);

					docente.setNumeroCelular(txtCelular.getText());

					docente.setCorreoElectronico(txtMail.getText());

					DocenteDao docenteDao = new DocenteDao();
					Boolean isInserted = docenteDao.insertarDocente(docente);

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
		btnAgregar.setBounds(32, 440, 97, 25);
		docenteView.getContentPane().add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Docente docente = new Docente();

				String codigoID = txtCodigo.getText();
				docente.setIdDocente(Integer.valueOf(codigoID));

				// String numeroCI = txtCI.getText();
				// docente.setNumeroCedula(Integer.valueOf(numeroCI));

				docente.setNumeroCedula(txtCI.getText());

				docente.setNombreDocente(txtNombre.getText());

				docente.setApellidoDocente(txtApellido.getText());

				Nacionalidad nac = new Nacionalidad();
				nac.setIdNacionalidad(cboNacionalidad.getSelectedItem().toString());
				docente.setNacionalidad(nac);

				docente.setNumeroCelular(txtCelular.getText());

				docente.setCorreoElectronico(txtMail.getText());

				DocenteDao docenteDao = new DocenteDao();
				Boolean isDeleted = docenteDao.eliminarDocente(docente);

				if (isDeleted) {
					JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnEliminar.setBounds(300, 440, 97, 25);
		docenteView.getContentPane().add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				confirmar();
			}
		});
		btnCancelar.setBounds(439, 440, 97, 25);
		docenteView.getContentPane().add(btnCancelar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Docente docente = new Docente();

				String codigoID = txtCodigo.getText();
				docente.setIdDocente(Integer.valueOf(codigoID));
				//
				// String numeroCI = txtCI.getText();
				// docente.setNumeroCedula(Integer.valueOf(numeroCI));

				docente.setNumeroCedula(txtCI.getText());
				docente.setNombreDocente(txtNombre.getText());

				docente.setApellidoDocente(txtApellido.getText());

				Nacionalidad nac = new Nacionalidad();
				nac.setIdNacionalidad(cboNacionalidad.getSelectedItem().toString());
				docente.setNacionalidad(nac);

				docente.setNumeroCelular(txtCelular.getText());

				docente.setCorreoElectronico(txtMail.getText());

				DocenteDao docenteDao = new DocenteDao();
				Boolean isUpdated = docenteDao.actualizarDocente(docente);

				if (isUpdated) {
					JOptionPane.showMessageDialog(null, "Actualizado Correctamente.", "",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(168, 440, 97, 25);
		docenteView.getContentPane().add(btnActualizar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Teachers_35749.png"));
		label.setBounds(375, 126, 179, 158);
		docenteView.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DocenteF1View bvisible = new DocenteF1View();
				bvisible.AyudaDocente.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon("ayuda.png"));
		label_1.setBounds(459, 24, 69, 50);
		docenteView.getContentPane().add(label_1);
	}
}
