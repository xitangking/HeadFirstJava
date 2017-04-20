package Chapter14;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizCardPlayer
{
	
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex = 0;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer = false;

	public static void main(String[] args)
	{
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}
	
	public void go()
	{
		//创建并显式gui
		frame = new JFrame("QuizCardPlayer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel(); 
		
		Font bigFont = new Font(Font.MONOSPACED, Font.BOLD, 16);
		
		display = new JTextArea(10,50);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane displayScroolPane = new JScrollPane(display);
		displayScroolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		displayScroolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		answer = new JTextArea(10,50);
		answer.setFont(bigFont);
		answer.setLineWrap(true);
		answer.setEditable(false);
		
		JScrollPane answerScroolPane = new JScrollPane(answer);
		answerScroolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		answerScroolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		nextButton = new JButton("answer");
		nextButton.addActionListener(new NextCradListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuOpenItem = new JMenuItem("Open");
		menuOpenItem.addActionListener(new OpenMenuListener());
		menu.add(menuOpenItem);
		menuBar.add(menu);
		
		mainPanel.add(displayScroolPane);
		mainPanel.add(answerScroolPane);
		
		frame.setJMenuBar(menuBar);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, nextButton);
		
		frame.setSize(500, 600);
		frame.setVisible(true);
	}
	
	class NextCradListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// 如果是个问题、显式答案，否则显式下一个问题
			if(isShowAnswer)
			{
				nextCard();
			}
			else
			{
				answer.setText(currentCard.answer);
				nextButton.setText("next");
				isShowAnswer = true;
			}
			// 改一个标识表明已浏览问题或答案
			
		}
		
	}
	
	class OpenMenuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// 生成一个文件对话框
			// 让用户把一个卡片设置打开
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
		
	}
	
	private void loadFile(File file)    
	{
		try
		{
			// 创建卡片的ArrayList,并从文本文件中提取他们
			cardList = new ArrayList<QuizCard>();
			// 调用OpenMenuListener事件处理器，每次从文件中读取一行
			BufferedReader reader = new BufferedReader(new FileReader(file));
			// 告诉makeCard()方法创建一个新卡片
			String line;
			while((line = reader.readLine()) != null)
				makeCard(line);
			currentCardIndex =  0;
			currentCard = cardList.get(currentCardIndex);
			display.setText(currentCard.question);
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		// （one line in file holds both the question and answer by a "/")
	}
	
	private void makeCard(String lineToParse)
	{
		// 调用LoadFile()方法，从文本文件中读取一行
		// 创建一个新的QuizCard，通过调用CardList把它加入ArrayList中
		for(int i = 0;i < lineToParse.length();++i)
		{
			if('/' == lineToParse.charAt(i))
			{
				cardList.add(new QuizCard(lineToParse.substring(0, i), lineToParse.substring(i + 1))) ;
				break;
			}
		}
	}
	
	private void nextCard()
	{
		if(currentCardIndex < cardList.size())
		{
			answer.setText("");
			currentCard = cardList.get(++currentCardIndex);
			display.setText(currentCard.question);
			nextButton.setText("answer");
			isShowAnswer = false;
		}
		else
		{
			display.setText("已经是最后一题了！");
		}
		
	}

}


