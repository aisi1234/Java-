package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1_jButton1_actionAdapter implements ActionListener {
	private Main adaptee;

	Frame1_jButton1_actionAdapter(Main adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}
