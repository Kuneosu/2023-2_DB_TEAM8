import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class mainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainFrame( ) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel companyName = new JLabel("JDK 법률회사");
		companyName.setFont(new Font("배달의민족 도현", Font.BOLD, 56));
		companyName.setBounds(35, 32, 479, 123);
		contentPane.add(companyName);
		
		JLabel lawyerCount = new JLabel("상담 가능 변호사 : XX");
		lawyerCount.setFont(new Font("배달의민족 도현", Font.PLAIN, 28));
		lawyerCount.setBounds(35, 165, 446, 38);
		contentPane.add(lawyerCount);
		
		JLabel caseCount = new JLabel("진행중인 사건 : XX");
		caseCount.setFont(new Font("배달의민족 도현", Font.PLAIN, 28));
		caseCount.setBounds(35, 213, 446, 38);
		contentPane.add(caseCount);
		
		JLabel entireWinrate = new JLabel("사건 전체  승률 : XX");
		entireWinrate.setFont(new Font("배달의민족 도현", Font.PLAIN, 28));
		entireWinrate.setBounds(35, 261, 446, 38);
		contentPane.add(entireWinrate);
		
		JLabel whoText = new JLabel("Who are you ?");
		whoText.setFont(new Font("배달의민족 도현", Font.PLAIN, 32));
		whoText.setBounds(35, 359, 446, 38);
		contentPane.add(whoText);
		
		JLabel companyLogo = new JLabel("");
		companyLogo.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\law-book (2).png"));
		companyLogo.setBounds(485, 42, 256, 279);
		contentPane.add(companyLogo);
		
		JButton btnLawyer = new JButton("변호사");
		btnLawyer.setFont(new Font("배달의민족 도현", Font.PLAIN, 32));
		btnLawyer.setBounds(35, 407, 325, 123);
		btnLawyer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lawyerFrame lawyer = new lawyerFrame();
				lawyer.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(btnLawyer);
		
		JButton btnCustomer = new JButton("고객");
		btnCustomer.setFont(new Font("배달의민족 도현", Font.PLAIN, 32));
		btnCustomer.setBounds(416, 407, 325, 123);
		btnCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customerFrame lawyer = new customerFrame();
				lawyer.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(btnCustomer);
		
	}
}
