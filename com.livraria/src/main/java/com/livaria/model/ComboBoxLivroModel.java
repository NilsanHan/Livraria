package com.livaria.model;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ComboBoxLivroModel extends DefaultComboBoxModel {

	private ArrayList<Livro> names = null;

	public ComboBoxLivroModel(ArrayList<Livro> names) {
		this.names = names;
	}

	@Override
	public void addElement(Object anObject) {
		this.names.add((Livro) anObject);
		// notifica o combo que o modelo foi alterado.
		this.fireIntervalAdded(this, 0, 0);
	}

	@Override
	public Object getElementAt(int index) {
		return this.names.get(index);
	}

	@Override
	public Object getSelectedItem() {
		return super.getSelectedItem();
	}

	@Override
	public int getSize() {
		return this.names.size();
	}
}