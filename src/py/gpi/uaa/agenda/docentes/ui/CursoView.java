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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JYearChooser;

import py.gpi.uaa.agenda.docentes.dao.CursoDao;
import py.gpi.uaa.agenda.docentes.dao.DocenteDao;
import py.gpi.uaa.agenda.docentes.dao.MateriaDao;
import py.gpi.uaa.agenda.docentes.model.Curso;
import py.gpi.uaa.agenda.docentes.model.Docente;
import py.gpi.uaa.agenda.docentes.model.Facultad;
import py.gpi.uaa.agenda.docentes.model.Materia;

public class CursoView {

	JFrame frameCurso;
	private JTextField txtCodigo;
	private JTextField txtSeccion;
	private JTextField txtAula;
	private JTextField txtAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoView window = new CursoView();
					window.frameCurso.setVisible(true);
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
			frameCurso.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public CursoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCurso = new JFrame();
		frameCurso.getContentPane().setBackground(new Color(204, 204, 255));
		frameCurso.getContentPane().setLayout(null);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(170, 379, 51, 22);
		frameCurso.getContentPane().add(yearChooser);
		frameCurso.setBackground(new Color(204, 204, 255));

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblCurso.setBounds(145, 13, 76, 21);
		frameCurso.getContentPane().add(lblCurso);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(60, 71, 94, 29);
		frameCurso.getContentPane().add(lblNewLabel);

		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblMateria.setBounds(60, 113, 94, 21);
		frameCurso.getContentPane().add(lblMateria);

		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblDocente.setBounds(60, 150, 94, 21);
		frameCurso.getContentPane().add(lblDocente);

		JLabel lblAuka = new JLabel("Aula");
		lblAuka.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblAuka.setBounds(60, 262, 94, 21);
		frameCurso.getContentPane().add(lblAuka);

		JLabel lblSeccion = new JLabel("Seccion");
		lblSeccion.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblSeccion.setBounds(60, 232, 94, 21);
		frameCurso.getContentPane().add(lblSeccion);

		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblSemestre.setBounds(46, 198, 94, 21);
		frameCurso.getContentPane().add(lblSemestre);

		JLabel lblAnho = new JLabel("A\u00F1o");
		lblAnho.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblAnho.setBounds(60, 343, 94, 21);
		frameCurso.getContentPane().add(lblAnho);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(138, 76, 116, 22);
		frameCurso.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		MateriaDao materiaDao = new MateriaDao();
		List<Materia> materias = materiaDao.recuperarMateria();
		ArrayList<String> stringComboMaterias = new ArrayList<>();
		for (Materia materia : materias) {
			stringComboMaterias.add(materia.getDescripcionMateria());
		}
		JComboBox<Facultad> cboMateria = new JComboBox(stringComboMaterias.toArray());
		cboMateria.setBackground(new Color(255, 204, 255));

		cboMateria.setBounds(138, 113, 116, 22);
		frameCurso.getContentPane().add(cboMateria);
		
		DocenteDao docenteDao = new DocenteDao();
		List<Docente> docentes = docenteDao.recuperarDocente();
		ArrayList<String> stringComboDocentes = new ArrayList<>();
		for (Docente docente : docentes) {
			stringComboDocentes.add(docente.getNombreDocente());
		}
		JComboBox <Docente>cmbDocente = new JComboBox(stringComboDocentes.toArray());
		cmbDocente.setBackground(new Color(255, 204, 255));
		cmbDocente.setBounds(138, 147, 116, 24);
		frameCurso.getContentPane().add(cmbDocente);

		txtSeccion = new JTextField();
		txtSeccion.setBounds(138, 233, 116, 22);
		frameCurso.getContentPane().add(txtSeccion);
		txtSeccion.setColumns(10);

		txtAula = new JTextField();
		txtAula.setBounds(138, 263, 116, 22);
		frameCurso.getContentPane().add(txtAula);
		txtAula.setColumns(10);

		JPanel panelTurno = new JPanel();
		panelTurno.setBackground(new Color(204, 204, 255));
		panelTurno.setBounds(92, 295, 227, 34);
		frameCurso.getContentPane().add(panelTurno);

		ButtonGroup grupoTurno = new ButtonGroup();
		panelTurno.setBounds(138, 184, 281, 35);

		JRadioButton rdbtnManana = new JRadioButton("Ma\u00F1ana");
		rdbtnManana.setBackground(new Color(204, 204, 255));

		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setBackground(new Color(204, 204, 255));

		JRadioButton rdbtnNoche = new JRadioButton("Noche");
		rdbtnNoche.setBackground(new Color(204, 204, 255));

		grupoTurno.add(rdbtnManana);
		grupoTurno.add(rdbtnTarde);
		grupoTurno.add(rdbtnNoche);
		panelTurno.add(rdbtnManana);
		panelTurno.add(rdbtnTarde);
		panelTurno.add(rdbtnNoche);

		JPanel panelSemestre = new JPanel();
		panelSemestre.setBackground(new Color(204, 204, 255));
		panelSemestre.setBounds(138, 184, 281, 35);
		frameCurso.getContentPane().add(panelSemestre);
		
		ButtonGroup grupoSemestre = new ButtonGroup();
		panelTurno.setBounds(138, 296, 281, 35);;

		JRadioButton rdbtnOtonho = new JRadioButton("Oto\u00F1o");
		rdbtnOtonho.setBackground(new Color(204, 204, 255));
		panelSemestre.add(rdbtnOtonho);

		JRadioButton rdbtnPrimavera = new JRadioButton("Primavera");
		rdbtnPrimavera.setBackground(new Color(204, 204, 255));
		panelSemestre.add(rdbtnPrimavera);

		JRadioButton rdbtnVerano = new JRadioButton("Verano");
		rdbtnVerano.setBackground(new Color(204, 204, 255));
		panelSemestre.add(rdbtnVerano);
		
		grupoSemestre.add(rdbtnOtonho);
		grupoSemestre.add(rdbtnPrimavera);
		grupoSemestre.add(rdbtnVerano);
		panelSemestre.add(rdbtnOtonho);
		panelSemestre.add(rdbtnPrimavera);
		panelSemestre.add(rdbtnVerano);
		
		txtAno = new JTextField();
		txtAno.setBounds(138, 344, 116, 22);
		frameCurso.getContentPane().add(txtAno);
		txtAno.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Curso curso = new Curso();
				try {
					

					String idCurso = txtCodigo.getText();
					curso.setIdCurso(Integer.valueOf(idCurso));

					Materia materia = new Materia();
					materia.setIdMateria(cboMateria.getSelectedItem().toString());
					curso.setMateria(materia);

					Docente doc = new Docente();
					doc.setNombreDocente(cmbDocente.getSelectedItem().toString());
					curso.setDocente(doc);

					// semestre
					String semestre = null;
					if (rdbtnManana.isSelected()) {
						semestre = "Otonho";
						curso.setSemestre(semestre);
					} else if (rdbtnTarde.isSelected()) {
						semestre = "Primavera";
						curso.setSemestre(semestre);
					} else if (rdbtnNoche.isSelected()) {
						semestre = "Verano";
						curso.setSemestre(semestre);
					}

					// turno
					String turno = null;
					if (rdbtnManana.isSelected()) {
						turno = "Manhana";
						curso.setTurno(turno);
					} else if (rdbtnTarde.isSelected()) {
						turno = "Tarde";
						curso.setTurno(turno);
					} else if (rdbtnNoche.isSelected()) {
						turno = "Noche";
						curso.setTurno(turno);
					}

					// seccion

					curso.setSeccion(txtSeccion.getText());

					// aula
					curso.setAula(txtAula.getText());

					CursoDao cursoDao = new CursoDao();
					Boolean isInserted = cursoDao.insertarCurso(curso);

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
		btnAgregar.setBounds(483, 171, 97, 25);
		frameCurso.getContentPane().add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(483, 232, 97, 25);
		frameCurso.getContentPane().add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(483, 330, 97, 25);
		frameCurso.getContentPane().add(btnCancelar);
		
		JLabel label = new JLabel("Turno");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label.setBounds(60, 309, 51, 21);
		frameCurso.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("metodologia-curso.png"));
		label_1.setBounds(334, 34, 169, 124);
		frameCurso.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CursoF1View visible = new CursoF1View();
				visible.frameAyudaCurso.setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon("ayuda.png"));
		label_2.setBounds(526, 26, 63, 50);
		frameCurso.getContentPane().add(label_2);
		
		
		frameCurso.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("metodologia-curso.png"));
		frameCurso.setBounds(100, 100, 619, 423);
		frameCurso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
