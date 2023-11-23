import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class customerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerFrame frame = new customerFrame();
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
	public customerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCaseQuery = new JButton("사건 조회");
		btnCaseQuery.setFont(new Font("배달의민족 도현", Font.BOLD, 32));
		btnCaseQuery.setBounds(39, 22, 340, 500);
		contentPane.add(btnCaseQuery);
		
		JButton btnLawyerQuery = new JButton("변호사 조회");
		btnLawyerQuery.setFont(new Font("배달의민족 도현", Font.BOLD, 32));
		btnLawyerQuery.setBounds(405, 22, 340, 500);
		contentPane.add(btnLawyerQuery);
	}

}
