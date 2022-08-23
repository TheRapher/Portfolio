package ejer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class U7E02 {

	private JFrame frmRafaHermosilla;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblResultado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U7E02 window = new U7E02();
					window.frmRafaHermosilla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public U7E02() {
		initialize();
	}
	
	private void initialize() {
		frmRafaHermosilla = new JFrame();
		frmRafaHermosilla.setTitle("Rafa Hermosilla");
		frmRafaHermosilla.setBounds(100, 100, 450, 300);
		frmRafaHermosilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRafaHermosilla.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pulse para convertir a Euros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 113, 434, 20);
		frmRafaHermosilla.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Importe en pesetas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(0, 42, 434, 14);
		frmRafaHermosilla.getContentPane().add(lblNewLabel_1);
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(128, 82, 174, 20);
		frmRafaHermosilla.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblResultado = new JLabel(" ");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(0, 209, 434, 20);
		frmRafaHermosilla.getContentPane().add(lblResultado);
			
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pesetas = textField.getText();
				if (pesetas.length() == 0 ) {
					textField.setBackground(Color.RED);
					lblResultado.setText("Error");
					lblResultado.setForeground(Color.RED);

				}else {
					textField.setBackground(Color.WHITE);

					double euros = Double.parseDouble(pesetas);
					euros = euros * 0.0060;
					String total = Double.toString(euros);
						lblResultado.setText(total + " €");
						lblResultado.setForeground(Color.black);
				}
			}
		});
		btnNewButton.setBounds(170, 160, 89, 23);
		frmRafaHermosilla.getContentPane().add(btnNewButton);
	}
}
