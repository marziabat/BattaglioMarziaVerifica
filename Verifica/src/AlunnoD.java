import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AlunnoD extends JDialog implements ActionListener{
	
	private JLabel lcognome, lnome, lcodice, ldata, lclasse, lsezione;
	private JTextField tcognome, tnome, tcodice, tdata, tclasse, tsezione;
	private JButton salva;
	private Alunno a;
	
	public AlunnoD(JFrame j, boolean modale) {
		super(j, true);
		setSize(800,600);
		setLayout(new GridLayout(7,2));
		initComp();
	}
	
	public void initComp() {
		lcognome = new JLabel("cognome");
		add(lcognome);
		tcognome = new JTextField(10);
		add(tcognome);
		lnome = new JLabel("nome");
		add(lnome);
		tnome = new JTextField(10);
		add(tnome);
		lcodice = new JLabel("codice");
		add(lcodice);
		tcodice = new JTextField(10);
		add(tcodice);
		ldata = new JLabel("data");
		add(ldata);
		tdata = new JTextField(10);
		add(tdata);
		lclasse = new JLabel("classe");
		add(lclasse);
		tclasse = new JTextField(10);
		add(tclasse);
		lsezione = new JLabel("sezione");
		add(lsezione);
		tsezione = new JTextField(10);
		add(tsezione);
		
		salva = new JButton("salva");
		add(salva);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == salva) {
				if(a == null) {
					a = new Alunno(tcognome.getText(), tnome.getText(), tcodice.getText(), tdata.getText(), tclasse.getText(), tsezione.getText());
					dispose();
				}
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Alunno getRisultato() {
		return a;
	}
	
	public JLabel getLcognome() {
		return lcognome;
	}

	public void setLcognome(JLabel lcognome) {
		this.lcognome = lcognome;
	}

	public JLabel getLnome() {
		return lnome;
	}

	public void setLnome(JLabel lnome) {
		this.lnome = lnome;
	}

	public JLabel getLcodice() {
		return lcodice;
	}

	public void setLcodice(JLabel lcodice) {
		this.lcodice = lcodice;
	}

	public JLabel getLdata() {
		return ldata;
	}

	public void setLdata(JLabel ldata) {
		this.ldata = ldata;
	}

	public JLabel getLclasse() {
		return lclasse;
	}

	public void setLclasse(JLabel lclasse) {
		this.lclasse = lclasse;
	}

	public JLabel getLsezione() {
		return lsezione;
	}

	public void setLsezione(JLabel lsezione) {
		this.lsezione = lsezione;
	}

	public JTextField getTcognome() {
		return tcognome;
	}

	public void setTcognome(JTextField tcognome) {
		this.tcognome = tcognome;
	}

	public JTextField getTnome() {
		return tnome;
	}

	public void setTnome(JTextField tnome) {
		this.tnome = tnome;
	}

	public JTextField getTcodice() {
		return tcodice;
	}

	public void setTcodice(JTextField tcodice) {
		this.tcodice = tcodice;
	}

	public JTextField getTdata() {
		return tdata;
	}

	public void setTdata(JTextField tdata) {
		this.tdata = tdata;
	}

	public JTextField getTclasse() {
		return tclasse;
	}

	public void setTclasse(JTextField tclasse) {
		this.tclasse = tclasse;
	}

	public JTextField getTsezione() {
		return tsezione;
	}

	public void setTsezione(JTextField tsezione) {
		this.tsezione = tsezione;
	}

	public JButton getSalva() {
		return salva;
	}

	public void setSalva(JButton salva) {
		this.salva = salva;
	}	
}
