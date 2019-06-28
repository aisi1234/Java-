package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1_jButton2_actionAdapter implements ActionListener {
	private Main adaptee;

	Frame1_jButton2_actionAdapter(Main adaptee) {
		 this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}
