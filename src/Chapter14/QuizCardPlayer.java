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
		//��������ʽgui
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
			// ����Ǹ����⡢��ʽ�𰸣�������ʽ��һ������
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
			// ��һ����ʶ���������������
			
		}
		
	}
	
	class OpenMenuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// ����һ���ļ��Ի���
			// ���û���һ����Ƭ���ô�
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
		
	}
	
	private void loadFile(File file)    
	{
		try
		{
			// ������Ƭ��ArrayList,�����ı��ļ�����ȡ����
			cardList = new ArrayList<QuizCard>();
			// ����OpenMenuListener�¼���������ÿ�δ��ļ��ж�ȡһ��
			BufferedReader reader = new BufferedReader(new FileReader(file));
			// ����makeCard()��������һ���¿�Ƭ
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
		
		// ��one line in file holds both the question and answer by a "/")
	}
	
	private void makeCard(String lineToParse)
	{
		// ����LoadFile()���������ı��ļ��ж�ȡһ��
		// ����һ���µ�QuizCard��ͨ������CardList��������ArrayList��
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
			display.setText("�Ѿ������һ���ˣ�");
		}
		
	}

}


