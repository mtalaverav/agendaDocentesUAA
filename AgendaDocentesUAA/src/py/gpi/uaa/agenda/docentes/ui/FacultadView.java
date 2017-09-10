package py.gpi.uaa.agenda.docentes.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.gpi.uaa.agenda.docentes.dao.FacultadDao;
import py.gpi.uaa.agenda.docentes.model.Facultad;
import javax.swing.ImageIcon;

public class FacultadView {

	 JFrame frameFacultad;
	 private JTextField txtCodigo;
	 private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultadView window = new FacultadView();
					window.frameFacultad.setVisible(true);
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
			frameFacultad.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public FacultadView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameFacultad = new JFrame();
		frameFacultad.getContentPane().setBackground(new Color(204, 204, 255));
		frameFacultad.getContentPane().setLayout(null);
		
		JLabel lblFacultad = new JLabel("Facultad");
		lblFacultad.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblFacultad.setBounds(99, 13, 100, 50);
		frameFacultad.getContentPane().add(lblFacultad);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblCodigo.setBounds(44, 91, 100, 50);
		frameFacultad.getContentPane().add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblDescripcion.setBounds(32, 154, 100, 50);
		frameFacultad.getContentPane().add(lblDescripcion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(138, 107, 116, 22);
		frameFacultad.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(138, 170, 116, 22);
		frameFacultad.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("Agregar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Facultad facultad = new Facultad();
				try {
					
					facultad.setIdFacultad(txtCodigo.getText());
					facultad.setDescripcion(txtDescripcion.getText());
					
					FacultadDao facultadDao = new FacultadDao();
					Boolean isInserted = facultadDao.insertarFacultad(facultad);
					
					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Registro Correcto!", "", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro", null,
								JOptionPane.ERROR_MESSAGE, null);
					}
					
				}catch (SQLException e) {

					System.out.println(e.getMessage());
				}
				
				
			}
		});
		btnAceptar.setBounds(44, 279, 97, 25);
		frameFacultad.getContentPane().add(btnAceptar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Facultad facultad = new Facultad();
				facultad.setIdFacultad(txtCodigo.getText());
				facultad.setDescripcion(txtDescripcion.getText());
				
				FacultadDao facultadDao = new FacultadDao();
				Boolean isDeleted = facultadDao.eliminarFacultad(facultad);
				
				if (isDeleted) {
					JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnEliminar.setBounds(298, 279, 97, 25);
		frameFacultad.getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(165, 279, 97, 25);
		frameFacultad.getContentPane().add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(310, 350, 97, 25);
		frameFacultad.getContentPane().add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\facultad.png"));
		label.setBounds(298, 76, 163, 150);
		frameFacultad.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FacultadF1View visible = new FacultadF1View();
				visible.frameAyudaFacultad.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\Melissa\\workspace\\AgendaDocentesUAA\\ayuda.png"));
		label_1.setBounds(410, 13, 57, 50);
		frameFacultad.getContentPane().add(label_1);
		frameFacultad.setTitle("Facultad");
		frameFacultad.setBounds(100, 100, 494, 449);
		frameFacultad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
