package py.gpi.uaa.agenda.docentes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import py.gpi.uaa.agenda.docentes.dao.MateriaDao;
import py.gpi.uaa.agenda.docentes.model.Facultad;
import py.gpi.uaa.agenda.docentes.model.Materia;

import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class CertificacionConsultaView {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";

	JFrame frameCertificacion;
	JTable tableConsultaCurso;
	DefaultTableModel tablaCurso;
	DefaultTableModel tablaCertif;
	JTable tableConsultaCertif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CertificacionConsultaView window = new CertificacionConsultaView();
					window.frameCertificacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CertificacionConsultaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCertificacion = new JFrame();
		frameCertificacion.getContentPane().setBackground(new Color(204, 204, 255));
		frameCertificacion.setIconImage(Toolkit.getDefaultToolkit().getImage("agenda_android.png"));
		frameCertificacion.setTitle("CONSULTAS");
		frameCertificacion.setBounds(100, 100, 867, 674);
		frameCertificacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane scrollPaneCurso = new JScrollPane();

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCertificacion.dispose();
			}
		});

		MateriaDao materiaDao = new MateriaDao();
		List<Materia> materias = materiaDao.recuperarMateria();
		ArrayList<String> stringComboMaterias = new ArrayList<>();
		for (Materia materia : materias) {
			stringComboMaterias.add(materia.getDescripcionMateria());
		}
		JComboBox<Materia> cboMateria = new JComboBox(stringComboMaterias.toArray());

		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Connection dbConnection = null;
				PreparedStatement preparedStatement = null;

				try {

					String parametroMateria = cboMateria.getSelectedItem().toString();
					// CURSOO

					String queryCurso = "Select id_curso, id_materia, id_docente, semestre from curso where id_materia = '"
							+ parametroMateria + "'";

					dbConnection = getDBConnection();

					String cabeceraCurso[] = { "CODIGO", "MATERIA", "DOCENTE", "SEMESTRE" };
					tablaCurso = new DefaultTableModel(null, cabeceraCurso);
					String fila[] = new String[4];
					ResultSet rs = dbConnection.createStatement().executeQuery(queryCurso);

					while (rs.next()) {
						fila[0] = rs.getString(1);
						fila[1] = rs.getString(2);
						fila[2] = rs.getString(3);
						fila[3] = rs.getString(4);

						tablaCurso.addRow(fila);
					}
					tableConsultaCurso.setModel(tablaCurso);

					// CERTIFICACION

					String queryCertificacion = "Select * from certificacion where id_materia = '" + parametroMateria
							+ "'";
					String cabeceraCertif[] = { "CODIGO", "MATERIA", "DOCENTE" };
					tablaCertif = new DefaultTableModel(null, cabeceraCertif);
					String filas[] = new String[3];
					ResultSet rs2 = dbConnection.createStatement().executeQuery(queryCertificacion);

					while (rs2.next()) {
						filas[0] = rs2.getString(1);
						filas[1] = rs2.getString(2);
						filas[2] = rs2.getString(3);

						tablaCertif.addRow(fila);
					}
					tableConsultaCertif.setModel(tablaCertif);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});

		JLabel lblConsultaDePostulantes = new JLabel("CONSULTA DE POSTULANTES");
		lblConsultaDePostulantes.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));

		JLabel lblCurso = new JLabel("CURSO:");
		lblCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		JLabel lblCertificacion = new JLabel("CERTIFICACION:");
		lblCertificacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		JScrollPane scrollPaneCertif = new JScrollPane();
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("postulante.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CertifConsultaF1View visible = new CertifConsultaF1View();
				visible.frameAyudaConsulta.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("ayuda.png"));
		GroupLayout groupLayout = new GroupLayout(frameCertificacion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(143)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneCurso, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneCertif, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCertificacion, Alignment.LEADING)
						.addComponent(lblCurso, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblMateria)
							.addGap(18)
							.addComponent(cboMateria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)))
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(713, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(53))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(265)
							.addComponent(lblConsultaDePostulantes)
							.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(36))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(138))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblConsultaDePostulantes)
									.addGap(11)
									.addComponent(label)
									.addGap(44)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(cboMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnBuscar))
										.addComponent(lblMateria))
									.addGap(38)
									.addComponent(lblCurso))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addComponent(lblNewLabel)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPaneCurso, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(lblCertificacion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPaneCertif, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(46))
		);

		tableConsultaCertif = new JTable();
		tableConsultaCertif.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"DOCENTE", "MATERIA", "DOCENTE"
			}
		));
		scrollPaneCertif.setViewportView(tableConsultaCertif);

		tableConsultaCurso = new JTable();
		tableConsultaCurso.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "CODIGO", "MATERIA", "DOCENTE", "SEMESTRE" }));
		scrollPaneCurso.setViewportView(tableConsultaCurso);
		frameCertificacion.getContentPane().setLayout(groupLayout);

	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}
