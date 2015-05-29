package com.libraries.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.libraries.db.LibraryDao;

public class PanelBook extends JFrame {
	
	public PanelBook() {
		addNewBook();
	}

	public static void addNewBook() {
		JFrame addingBook = new JFrame("Add New Book");
		addingBook.setSize(500, 400);
		addingBook.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		addingBook.add(panel);

		final JTextArea title = new JTextArea("Title: ", 3, 20);
		final JTextArea volumeSheets = new JTextArea("Volume Shteets: ", 3, 20);
		final JTextArea releaseYear = new JTextArea("Release Year: ", 3, 20);
		final JTextArea type = new JTextArea("Type: ", 3, 20);
		JButton submitButton = new JButton("Add new book");
		
		
		submitButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					LibraryDao.insertBook(title.getText(), Integer.parseInt(volumeSheets.getText()), Integer.parseInt(releaseYear.getText()), type.getText());
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		panel.add(title);
		panel.add(volumeSheets);
		panel.add(releaseYear);
		panel.add(type);
		panel.add(submitButton);
	}
}
