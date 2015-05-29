package com.libraries.swing;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.libraries.db.LibraryDao;
import com.libraries.service.MagazinesService;

public class PanelAuthor extends JFrame {

	public PanelAuthor() {
		addNewAuthor();
	}

	public static void addNewAuthor() {
		JFrame addingAuthor = new JFrame("Add New Author");
		addingAuthor.setSize(300, 250);
		addingAuthor.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		addingAuthor.add(panel);

		final JTextArea name = new JTextArea("Author name: ", 3, 20);
		final JTextArea secondName = new JTextArea("Author second name: ", 3,
				20);
		JButton submitButton = new JButton("Add new author");

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
					LibraryDao.insertAuthor(name.getText(),
							secondName.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		panel.add(name);
		panel.add(secondName);
		panel.add(submitButton);
	}
}
