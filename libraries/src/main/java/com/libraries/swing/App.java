package com.libraries.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.libraries.db.LibraryDao;
import com.libraries.db.TestDao;
import com.libraries.domain.Author;
import com.libraries.domain.Book;
import com.libraries.domain.MagazineContent;
import com.libraries.domain.Rating;

public class App extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public App() {
		prepareGUI();
	}

	public static void main(String[] args) throws SQLException {
		App swingControlDemo = new App();
		swingControlDemo.showComboboxDemo();
		
	}

	private void prepareGUI() {
		mainFrame = new JFrame("DBProject");
		mainFrame.setSize(900, 500);
		mainFrame.setLayout(new FlowLayout());
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(400, 200);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showComboboxDemo() throws SQLException {

		final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();
		
		Container parentAreas = new Container();
		parentAreas.setLayout(new BorderLayout());

		fruitsName.addElement("Show The Newest Five Books..");
		fruitsName.addElement("Show Highest Rating Book..");
		fruitsName.addElement("Read Top Gear Magazine..");
		fruitsName.addElement("Show books by author..");
		fruitsName.addElement("Add new Author..");
		fruitsName.addElement("Add new book..");
		
		final DefaultComboBoxModel ratingSystem = new DefaultComboBoxModel();
		ratingSystem.addElement("Rate the book/magazine..");
		ratingSystem.addElement("1");
		ratingSystem.addElement("2");
		ratingSystem.addElement("3");
		ratingSystem.addElement("4");
		ratingSystem.addElement("5");
		
		
		final JComboBox fruitCombo = new JComboBox(fruitsName);
		fruitCombo.setPreferredSize(new Dimension(150, 30));
		fruitCombo.setSelectedIndex(0);
		
		final JComboBox ratingCombo = new JComboBox(ratingSystem);
		ratingCombo.setPreferredSize(new Dimension(150, 30));
		ratingCombo.setSelectedIndex(0);
		

		final JTextArea commentTextArea = new JTextArea(
				"The information about books and magazines..", 7, 28);
		JScrollPane scrollPane = new JScrollPane(commentTextArea);
		scrollPane.setPreferredSize(new Dimension(380, 100));
		commentTextArea.setWrapStyleWord(true);
		commentTextArea.setLineWrap(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		fruitCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(fruitCombo.getSelectedIndex() == 0){
					try {
						List<Book> selectTheNewestFiveBooks = TestDao.selectTheNewestFiveBooks();
						for (int i = 0; i < selectTheNewestFiveBooks.size(); i++) {
							//commentTextArea.insert(selectTheNewestFiveBooks.get(0).toString(), 0);
							commentTextArea.insert(selectTheNewestFiveBooks.toString(), 0);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		final JTextArea readableTextArea = new JTextArea("The Content of book/magazine", 7, 35);
		JScrollPane readScrollPane = new JScrollPane(readableTextArea);
		readScrollPane.setVisible(true);
		readableTextArea.setWrapStyleWord(true);
		readableTextArea.setLineWrap(true);
		
		fruitCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fruitCombo.getSelectedIndex() == 2){
					try {
						List<MagazineContent> readMagazine = TestDao.readMagazine();
						readableTextArea.insert(readMagazine.toString(), 0);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if(fruitCombo.getSelectedIndex() == 1){
					try {
						List<Rating> getTheHighestRatingBooks = TestDao.selectHighestRatingBook(5);
						readableTextArea.insert(getTheHighestRatingBooks.toString(), 0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(fruitCombo.getSelectedIndex() == 3){
					try {
						Entry<Author, List<Book>> getBooksByAuthor = TestDao.selectBooksByAuthor(5);
						readableTextArea.insert(getBooksByAuthor.toString(), 0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(fruitCombo.getSelectedIndex() == 4){
					PanelAuthor panelAuthor = new PanelAuthor();
				}
				else if(fruitCombo.getSelectedIndex() == 5){
					PanelBook panelBook = new PanelBook();
				}
			}
		});
		
		JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);


		
		JButton button = new JButton("Submit");
		button.setLayout(new FlowLayout());
		button.addMouseListener(new MouseListener() {
			
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
				switch (ratingCombo.getSelectedIndex()) {
					case 1 :
						try {
							LibraryDao.insertRating(1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							LibraryDao.insertRating(2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
						try {
							LibraryDao.insertRating(3);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						try {
							LibraryDao.insertRating(4);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 5:
						try {
							LibraryDao.insertRating(5);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					default :
						break;
				}
			}
		});
		
		controlPanel.add(button);
		controlPanel.add(fruitListScrollPane);
		//controlPanel.add(scrollPane);
		parentAreas.add(readScrollPane, BorderLayout.SOUTH);
		parentAreas.add(scrollPane, BorderLayout.NORTH);
		parentAreas.add(button, BorderLayout.WEST);
		parentAreas.add(ratingCombo);
		controlPanel.add(parentAreas);
		//controlPanel.add(readableTextArea);
		mainFrame.setVisible(true);
	}

}
