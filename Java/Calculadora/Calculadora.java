package ejer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

public class U7E03 {

	private JFrame frmRafaHermosilla;
	private JLabel lblNewLabel;
	private String tmp = "";
	private String memoria1;
	private String signo;
	private String memoria2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U7E03 window = new U7E03();
					window.frmRafaHermosilla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public U7E03() {
		initialize();
	}

	private void initialize() {
		tmp = null;
		frmRafaHermosilla = new JFrame();
		frmRafaHermosilla.setTitle("Rafa Hermosilla");
		frmRafaHermosilla.setBounds(100, 100, 364, 300);
		frmRafaHermosilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRafaHermosilla.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("8");
		frmRafaHermosilla.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
		btnNewButton.setBounds(69, 70, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.setBounds(0, 70, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_2 = new JButton("4");
		btnNewButton_2.setBounds(0, 119, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
		
		
		JButton btnNewButton_3 = new JButton("1");
		btnNewButton_3.setBounds(0, 171, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBounds(69, 119, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
		
		
		JButton btnNewButton_5 = new JButton("2");
		btnNewButton_5.setBounds(69, 171, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_5);
		btnNewButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
		
		
		JButton btnNewButton_6 = new JButton("3");
		btnNewButton_6.setBounds(138, 171, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_6);
		btnNewButton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_7 = new JButton("6");
		btnNewButton_7.setBounds(138, 119, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_7);
		btnNewButton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.setBounds(138, 70, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_8);
		btnNewButton_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_9 = new JButton("0");
		btnNewButton_9.setBounds(0, 220, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_9);
		btnNewButton_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_10 = new JButton(".");
		btnNewButton_10.setBounds(69, 220, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnNewButton_10);
		btnNewButton_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPuntoActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_11 = new JButton("=");
		btnNewButton_11.setBorderPainted(false);
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBackground(Color.BLUE);
		btnNewButton_11.setBounds(138, 220, 59, 41);
		btnNewButton_11.setToolTipText("Igual");
		frmRafaHermosilla.getContentPane().add(btnNewButton_11);
		btnNewButton_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIgualActionPerformed(evt);
            }
        });
		
		JButton btnDel = new JButton("DEL");
		btnDel.setBorderPainted(false);
		btnDel.setBackground(Color.ORANGE);
		btnDel.setBounds(207, 70, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnDel);
		btnDel.setToolTipText("Borrar el ultimo num");

		btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonDELActionPerformed(evt);
            }
        });
		JButton btnCl = new JButton("CL");
		btnCl.setBorderPainted(false);
		btnCl.setBackground(Color.ORANGE);
		btnCl.setBounds(276, 70, 59, 41);
		frmRafaHermosilla.getContentPane().add(btnCl);
		btnCl.setToolTipText("Borrar todos los nums");
		btnCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonCLActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_14 = new JButton("+");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setBorderPainted(false);
		btnNewButton_14.setBackground(Color.BLUE);
		btnNewButton_14.setBounds(207, 119, 59, 41);
		btnNewButton_14.setToolTipText("Sumar");
		frmRafaHermosilla.getContentPane().add(btnNewButton_14);
		btnNewButton_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSumaActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_15 = new JButton("-");
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setBorderPainted(false);
		btnNewButton_15.setBackground(Color.BLUE);
		btnNewButton_15.setBounds(276, 119, 59, 41);
		btnNewButton_15.setToolTipText("Restar");
		frmRafaHermosilla.getContentPane().add(btnNewButton_15);
		btnNewButton_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonRestaActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_16 = new JButton("*");
		btnNewButton_16.setForeground(Color.WHITE);
		btnNewButton_16.setBorderPainted(false);
		btnNewButton_16.setBackground(Color.BLUE);
		btnNewButton_16.setBounds(207, 171, 59, 41);
		btnNewButton_16.setToolTipText("Multiplicar");
		frmRafaHermosilla.getContentPane().add(btnNewButton_16);
		btnNewButton_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiActionPerformed(evt);
            }
        });
		
		JButton btnNewButton_17 = new JButton("/");
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.setBorderPainted(false);
		btnNewButton_17.setBackground(Color.BLUE);
		btnNewButton_17.setBounds(276, 171, 59, 41);
		btnNewButton_17.setToolTipText("Dividir");
		frmRafaHermosilla.getContentPane().add(btnNewButton_17);
		btnNewButton_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiviActionPerformed(evt);
            }
        });
		JButton btnNewButton_18 = new JButton("^");
		btnNewButton_18.setBorderPainted(false);
		btnNewButton_18.setBackground(Color.BLUE);
		btnNewButton_18.setForeground(Color.WHITE);
		btnNewButton_18.setBounds(207, 220, 59, 41);
		btnNewButton_18.setToolTipText("Cuadrado");
		frmRafaHermosilla.getContentPane().add(btnNewButton_18);
		btnNewButton_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCuadradoActionPerformed(evt);
            }
        });
		JButton btnR = new JButton("R");
		btnR.setForeground(Color.WHITE);
		btnR.setBorderPainted(false);
		btnR.setBackground(Color.BLUE);
		btnR.setBounds(276, 220, 59, 41);
		btnR.setToolTipText("Raiz Cuadrada");
		frmRafaHermosilla.getContentPane().add(btnR);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonRaizActionPerformed(evt);
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 11, 338, 41);
		frmRafaHermosilla.getContentPane().add(lblNewLabel);
	
	}
	
	
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	lblNewLabel.setText(lblNewLabel.getText()+"5");
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
      
    	lblNewLabel.setText(lblNewLabel.getText()+"8");
    }

    private void jButtonRestaActionPerformed(java.awt.event.ActionEvent evt) {
        if (!lblNewLabel.getText().equals("")) {
            memoria1=lblNewLabel.getText();
            signo="-";
            lblNewLabel.setText("");
        }
    }

    private void jButtonIgualActionPerformed(java.awt.event.ActionEvent evt) {
       
        String resultado;
        memoria2=lblNewLabel.getText();
      
        if (!memoria2.equals("")) {
            resultado=calculadora(memoria1,memoria2,signo);
            lblNewLabel.setText(resultado);
        }
    }
    public static String calculadora(String memoria1,String memoria2,String signo){
    	Double resultado=0.0;
    	String respuesta;
		
    	if (signo.equals("-")) {
    		resultado=Double.parseDouble(memoria1)-Double.parseDouble(memoria2);
        
    	}
    	if (signo.equals("+")) {
    		resultado=Double.parseDouble(memoria1)+Double.parseDouble(memoria2);
        
    	}
    	if (signo.equals("*")) {
    		resultado=Double.parseDouble(memoria1)*Double.parseDouble(memoria2);
        
    	}
    	if (signo.equals("/")) {
    		
    		resultado=Double.parseDouble(memoria1)/Double.parseDouble(memoria2);
       
        }
    	if (signo.equals("^")) {
    		resultado=Math.pow(Double.parseDouble(memoria1),Double.parseDouble(memoria2));
        
	}
    	respuesta=resultado.toString();
    	return respuesta;
    }
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	lblNewLabel.setText(lblNewLabel.getText()+"1");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       
    	lblNewLabel.setText(lblNewLabel.getText()+"2");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
     
    	lblNewLabel.setText(lblNewLabel.getText()+"3");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
       
    	lblNewLabel.setText(lblNewLabel.getText()+"4");
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
       
    	lblNewLabel.setText(lblNewLabel.getText()+"6");
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
    
    	lblNewLabel.setText(lblNewLabel.getText()+"7");
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
  
    	lblNewLabel.setText(lblNewLabel.getText()+"9");
    }

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {
       
    	lblNewLabel.setText(lblNewLabel.getText()+"0");
    }

    private void jButtonPuntoActionPerformed(java.awt.event.ActionEvent evt) {
        String cadena;
        cadena=lblNewLabel.getText();
        
        if (cadena.length()<=0) {
        	lblNewLabel.setText("0.0");
            
        }
        else{
            if (!existepunto(lblNewLabel.getText())) {
            	lblNewLabel.setText(lblNewLabel.getText()+".");
                                
            }
        }
        
    }

    private void jButtonDELActionPerformed(java.awt.event.ActionEvent evt) {
     
    	String cadena;
        cadena=lblNewLabel.getText();
        
        if (cadena.length()>0) {
            cadena=cadena.substring(0, cadena.length()-1);
            lblNewLabel.setText(cadena);
        }
    }
    private void jButtonCLActionPerformed(java.awt.event.ActionEvent evt) {
       
    	lblNewLabel.setText("");
    }

    private void jButtonRaizActionPerformed(java.awt.event.ActionEvent evt) {
      String raiz;
      double resul;
    	if (!lblNewLabel.getText().equals("")) {
            resul=Double.parseDouble(lblNewLabel.getText());
            resul =Math.sqrt(resul);
            raiz = String.valueOf(resul);
            lblNewLabel.setText(raiz);
        }
    }
    private void jButtonSumaActionPerformed(java.awt.event.ActionEvent evt) {    	
         if (!lblNewLabel.getText().equals("")) {
        	memoria1=lblNewLabel.getText();
            signo="+";
            lblNewLabel.setText("");
        }
    }

    private void jButtonMultiActionPerformed(java.awt.event.ActionEvent evt) {
        
         if (!lblNewLabel.getText().equals("")) {
            memoria1=lblNewLabel.getText();
            signo="*";
            lblNewLabel.setText("");
        }
    }

    private void jButtonDiviActionPerformed(java.awt.event.ActionEvent evt) {
        
         if (!lblNewLabel.getText().equals("")) {
            memoria1=lblNewLabel.getText();
            signo="/";
            lblNewLabel.setText("");
        }
    }
    private void jButtonCuadradoActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (!lblNewLabel.getText().equals("")) {
           memoria1=lblNewLabel.getText();
           signo="^";
           lblNewLabel.setText("");
       }
   }
    public static boolean existepunto(String cadena){
        boolean resultado;
        resultado=false;
        
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i, i+1).equals(".")) {
                resultado=true;
                break;
            }      
        }
        return resultado;
    }
}