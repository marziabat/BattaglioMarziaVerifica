import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ATAD extends JDialog implements ActionListener{

	private JLabel l1, l2, l3, l4, l5;
	private JTextField t1, t2, t3, t4, t5;
	private JButton salva;
	private ATA a;
	
	public ATAD(JFrame j, boolean modale) {
		super(j, true);
		setSize(800,600);
		setLayout(new GridLayout(7,2));
		initComp();
	}
	
	public void initComp() {
		l1 = new JLabel("cognome");
		add(l1);
		t1 = new JTextField(10);
		add(t1);
		l2 = new JLabel("nome");
		add(l2);
		t2 = new JTextField(10);
		add(t2);
		l3 = new JLabel("codice");
		add(l3);
		t3 = new JTextField(10);
		add(t3);
		l4 = new JLabel("data");
		add(l4);
		t4 = new JTextField(10);
		add(t4);
		l5 = new JLabel("inquadramento");
		add(l5);
		t5 = new JTextField(10);
		add(t5);
		
		salva = new JButton("salva");
		add(salva);
		salva.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == salva) {
				if(a == null) {
					a = new ATA(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText());
					dispose();
				}
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "errore", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ATA getRisultato() {
		return a;
	}
	
	public JLabel getL1() {
		return l1;
	}


	public void setL1(JLabel l1) {
		this.l1 = l1;
	}


	public JLabel getL2() {
		return l2;
	}


	public void setL2(JLabel l2) {
		this.l2 = l2;
	}


	public JLabel getL3() {
		return l3;
	}


	public void setL3(JLabel l3) {
		this.l3 = l3;
	}


	public JLabel getL4() {
		return l4;
	}


	public void setL4(JLabel l4) {
		this.l4 = l4;
	}


	public JLabel getL5() {
		return l5;
	}


	public void setL5(JLabel l5) {
		this.l5 = l5;
	}


	public JTextField getT1() {
		return t1;
	}


	public void setT1(JTextField t1) {
		this.t1 = t1;
	}


	public JTextField getT2() {
		return t2;
	}


	public void setT2(JTextField t2) {
		this.t2 = t2;
	}


	public JTextField getT3() {
		return t3;
	}


	public void setT3(JTextField t3) {
		this.t3 = t3;
	}


	public JTextField getT4() {
		return t4;
	}


	public void setT4(JTextField t4) {
		this.t4 = t4;
	}


	public JTextField getT5() {
		return t5;
	}


	public void setT5(JTextField t5) {
		this.t5 = t5;
	}


	public JButton getSalva() {
		return salva;
	}


	public void setSalva(JButton salva) {
		this.salva = salva;
	}


	public ATA getA() {
		return a;
	}


	public void setA(ATA a) {
		this.a = a;
	}
	
	

}
