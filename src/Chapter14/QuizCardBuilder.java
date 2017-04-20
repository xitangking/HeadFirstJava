package Chapter14;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizCardBuilder
{
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	public static void main(String[] args)
	{
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}
	public void go()
	{
		//创建并显式gui
		
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		question = new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qScrollPane = new JScrollPane(question);
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScrollPane = new JScrollPane(answer);
		aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		
		cardList = new ArrayList<QuizCard>();
		
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScrollPane);
		mainPanel.add(aLabel);
		mainPanel.add(aScrollPane);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NewMenuListener());
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		
		JMenuItem saveMenuItem  = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		
		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
		
	}
	
	private class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//向列表中添加当前卡片并清除文本域
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	
	private class SaveMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//生成对话树
			//输入用户名并保存设置
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}
	
	private class NewMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//清除card文本和文本域
			cardList.clear();
			clearCard();
		}
	}
	
	private void clearCard()
	{
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	
	private void saveFile(File file)
	{
		//把列表输出到一个文本文件
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(QuizCard card : cardList)
			{
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}

class QuizCard
{
	String question;
	String answer;
	public QuizCard(String q,String a)
	{
		question = q;
		answer = a;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
}
