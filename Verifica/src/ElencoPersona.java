import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ElencoPersona extends ArrayList<Persona> implements Serializable{
	
	public void serializza(JFrame j) throws Exception{
		ObjectOutputStream o= null;
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("generico", "dat");
			chooser.setFileFilter(filter);
			int i = chooser.showSaveDialog(j);
			if(i == chooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				f.createNewFile();
				o = new ObjectOutputStream(new FileOutputStream(f));
				o.writeObject(this);
				o.flush();
			}
		}catch(Exception e) {
			throw new Exception();
		}finally {
			try {
				if(o != null) {
					o.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void deserializza(JFrame j) {
		ObjectInputStream o = null;
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter ("generico", "dat");
			chooser.setFileFilter(filter);
			int i = chooser.showOpenDialog(j);
			if(i == chooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				if(f.exists()) {
					o = new ObjectInputStream(new FileInputStream(f));
					ElencoPersona ep = (ElencoPersona)o.readObject();
					
					for(i = 0; i<ep.size(); i++) {
						this.add(ep.get(i));
					}
				}
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "errore", JOptionPane.ERROR_MESSAGE);
		}finally {
			if(o != null) {
				try {
					o.close();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<String> elencoStringhe(){
		ArrayList<String> a = new ArrayList<String>();
		for(int i = 0; i<a.size(); i++) {
			a.add(this.get(i).toString());
		}
		return a;
	}
}