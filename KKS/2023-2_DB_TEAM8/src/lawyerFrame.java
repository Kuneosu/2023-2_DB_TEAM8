import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class lawyerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lawyerFrame frame = new lawyerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lawyerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCaseQeury = new JButton("사건 조회");
		btnCaseQeury.setFont(new Font("배달의민족 도현", Font.BOLD, 32));
		btnCaseQeury.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCaseQeury.setBounds(30, 34, 220, 500);
		contentPane.add(btnCaseQeury);
		
		JButton btnPartyQuery = new JButton("당사자 조회");
		btnPartyQuery.setFont(new Font("배달의민족 도현", Font.PLAIN, 32));
		btnPartyQuery.setBounds(280, 34, 220, 500);
		contentPane.add(btnPartyQuery);
		
		JButton btnCounselQuery = new JButton("상담 기록\r\n");
		btnCounselQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCounselQuery.setFont(new Font("배달의민족 도현", Font.PLAIN, 32));
		btnCounselQuery.setBounds(530, 34, 220, 500);
		contentPane.add(btnCounselQuery);
	}

}
