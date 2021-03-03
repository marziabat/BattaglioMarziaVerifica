import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Finestra extends JFrame implements ActionListener, Serializable{
	
	private JMenuBar mbar;
	private JMenu file;
	private JMenuItem serializza, deserializza, csv;
	private JMenu edit;
	private JMenuItem aggiungid, aggiungiat, aggiungial, modifica;
	private JPanel p;
	private DefaultTableModel dtm;
	private JTable tab;
	private JScrollPane jsp;
	
	private AlunnoD ad;
	private DocenteD dd;
	private ATAD td;

	private ElencoPersona ep;
	
	public Finestra() {
		initComp();
		this.setSize(1200,1200);
	}
	
	public void initComp() {
		ep = new ElencoPersona();
		
		this.setLayout(new BorderLayout());
		mbar = new JMenuBar();
		file = new JMenu("file");
		serializza = new JMenuItem("serializza");
		file.add(serializza);
		serializza.addActionListener(this);
		deserializza = new JMenuItem("deserializza");
		file.add(deserializza);
		deserializza.addActionListener(this);
		csv = new JMenuItem("converte csv");
		file.add(csv);
		csv.addActionListener(this);
		edit = new JMenu("edit");
		aggiungid = new JMenuItem("aggiungi docente");
		edit.add(aggiungid);
		aggiungid.addActionListener(this);
		aggiungiat = new JMenuItem("aggiungi ATA");
		edit.add(aggiungiat);
		aggiungiat.addActionListener(this);
		aggiungial = new JMenuItem("aggiungi alunno");
		edit.add(aggiungial);
		aggiungial.addActionListener(this);
		modifica = new JMenuItem("modifica");
		edit.add(modifica);
		modifica.addActionListener(this);
		mbar.add(file);
		mbar.add(edit);
		this.setJMenuBar(mbar);
		
		p = new JPanel();
		dtm = new DefaultTableModel(new String[] {"COGNOME", "NOME"},0);
		tab = new JTable(dtm);
		jsp = new JScrollPane(tab);
		p.add(jsp, BorderLayout.WEST);
		
		this.add(p);		
	}
	
	public void convertCSV(File f, ArrayList<String> a) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			for(String line : a) {
				fw.write(line+"\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == serializza) {
			try {
				ep.serializza(this);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == csv) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("file di testo","txt");
			fc.setFileFilter(filter);
			int i = fc.showSaveDialog(this);
			if(i == fc.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				try {
					f.createNewFile();
					this.convertCSV(f, ep.elencoStringhe());
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource() == aggiungid) {
			dd = new DocenteD(this,true);
			dd.setVisible(true);
			if(dd.getRisultato() != null) {
				ep.add(ad.getRisultato());
				dtm.addRow(new String[] {dd.getRisultato().getT1(),dd.getRisultato().getT2()});
			}
		}
	}

	public static void main(String[] args) {
		Finestra finestra = new Finestra();
		finestra.setVisible(true);
	}
	
	public JMenuBar getMbar() {
		return mbar;
	}

	public void setMbar(JMenuBar mbar) {
		this.mbar = mbar;
	}

	public JMenu getFile() {
		return file;
	}

	public void setFile(JMenu file) {
		this.file = file;
	}

	public JMenuItem getSerializza() {
		return serializza;
	}

	public void setSerializza(JMenuItem serializza) {
		this.serializza = serializza;
	}

	public JMenuItem getDeserializza() {
		return deserializza;
	}

	public void setDeserializza(JMenuItem deserializza) {
		this.deserializza = deserializza;
	}

	public JMenuItem getCsv() {
		return csv;
	}

	public void setCsv(JMenuItem csv) {
		this.csv = csv;
	}

	public JMenu getEdit() {
		return edit;
	}

	public void setEdit(JMenu edit) {
		this.edit = edit;
	}

	public JMenuItem getAggiungid() {
		return aggiungid;
	}

	public void setAggiungid(JMenuItem aggiungid) {
		this.aggiungid = aggiungid;
	}

	public JMenuItem getAggiungiat() {
		return aggiungiat;
	}

	public void setAggiungiat(JMenuItem aggiungiat) {
		this.aggiungiat = aggiungiat;
	}

	public JMenuItem getAggiungial() {
		return aggiungial;
	}

	public void setAggiungial(JMenuItem aggiungial) {
		this.aggiungial = aggiungial;
	}

	public JMenuItem getModifica() {
		return modifica;
	}

	public void setModifica(JMenuItem modifica) {
		this.modifica = modifica;
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}

	public ElencoPersona getEp() {
		return ep;
	}

	public void setEp(ElencoPersona ep) {
		this.ep = ep;
	}
	
	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTab() {
		return tab;
	}

	public void setTab(JTable tab) {
		this.tab = tab;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}
}
