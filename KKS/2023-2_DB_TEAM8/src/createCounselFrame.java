import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/* 상담 기록을 생성하는 프레임 입니다.
 * 사용자로부터 변호사 번호와 고객 번호를 입력받은 후 데이터베이스 존재하는 번호인지 조회합니다.
 * 상담종류를 선택하고 상담내용을 입력한 후 저장을 누르면 
 * 데이터베이스의 '상담' 테이블에 해당 내용이 저장됩니다.
 */



public class createCounselFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_lawyer_name;
	private JTextField text_lawyer_number;
	private JTextField text_customer_name;
	private JTextField text_customer_number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createCounselFrame frame = new createCounselFrame();
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
	public createCounselFrame() {
		setTitle("상담 기록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text_lawyer_name = new JTextField();
		text_lawyer_name.setBounds(37, 39, 341, 33);
		contentPane.add(text_lawyer_name);
		text_lawyer_name.setColumns(10);
		
		text_lawyer_number = new JTextField();
		text_lawyer_number.setEditable(false);
		text_lawyer_number.setColumns(10);
		text_lawyer_number.setBounds(420, 39, 143, 33);
		contentPane.add(text_lawyer_number);
		
		text_customer_name = new JTextField();
		text_customer_name.setColumns(10);
		text_customer_name.setBounds(37, 108, 341, 33);
		contentPane.add(text_customer_name);
		
		text_customer_number = new JTextField();
		text_customer_number.setEditable(false);
		text_customer_number.setColumns(10);
		text_customer_number.setBounds(420, 108, 143, 33);
		contentPane.add(text_customer_number);
		
		JLabel label_lawyer_name = new JLabel("변호사 이름");
		label_lawyer_name.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_lawyer_name.setBounds(37, 14, 112, 23);
		contentPane.add(label_lawyer_name);
		
		JLabel label_customer_name = new JLabel("고객 이름");
		label_customer_name.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_customer_name.setBounds(37, 86, 112, 23);
		contentPane.add(label_customer_name);
		
		JButton btn_lawyer_check = new JButton("변호사 확인");
		btn_lawyer_check.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		btn_lawyer_check.setBounds(604, 39, 131, 33);
		contentPane.add(btn_lawyer_check);
		
		
		JButton btn_customer_check = new JButton("고객 확인");
		btn_customer_check.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		btn_customer_check.setBounds(604, 108, 131, 33);
		contentPane.add(btn_customer_check);
		
		JLabel label_lawyer_number = new JLabel("변호사 번호");
		label_lawyer_number.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_lawyer_number.setBounds(420, 14, 103, 23);
		contentPane.add(label_lawyer_number);
		
		JLabel label_customer_number = new JLabel("고객 번호");
		label_customer_number.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_customer_number.setBounds(420, 86, 103, 23);
		contentPane.add(label_customer_number);
		
		JComboBox<String> combo_counsel_genre = new JComboBox<>();
		// 기본 선택 항목 추가
        combo_counsel_genre.addItem("사건 종류를 선택하세요");
        combo_counsel_genre.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
        // 나머지 아이템 추가
        String[] items = {"이혼/가정", "채권채무", "행정사건", "세무", "상속/유언", "의료", "부동산", 
                          "지적재산권", "형사/범죄", "교통사고", "국제/외국인", "민사/기타", "노무", 
                          "기업법무", "재판/분쟁"};

        for (String item : items) {
            combo_counsel_genre.addItem(item);
        }

        // JComboBox의 기본 선택 항목 설정
        combo_counsel_genre.setSelectedItem("사건 종류를 선택하세요");
        // JComboBox의 기본 선택 항목 설정 (선택되도록 함)
        combo_counsel_genre.setSelectedItem("사건 종류를 선택하세요");

		combo_counsel_genre.setBounds(37, 199, 225, 40);
		contentPane.add(combo_counsel_genre);
		
		JLabel label_counsel_genre = new JLabel("상담 종류 선택");
		label_counsel_genre.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_counsel_genre.setBounds(37, 175, 143, 23);
		contentPane.add(label_counsel_genre);
		
		JTextArea textArea_counsel_body = new JTextArea();
		textArea_counsel_body.setBackground(new Color(223, 234, 224));
		textArea_counsel_body.setBounds(37, 276, 698, 257);
		contentPane.add(textArea_counsel_body);
		
		JLabel label_counsel_body = new JLabel("상담 내용 기록");
		label_counsel_body.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		label_counsel_body.setBounds(37, 249, 160, 33);
		contentPane.add(label_counsel_body);
		
		JButton btn_counsel_save = new JButton("저장");
		btn_counsel_save.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		btn_counsel_save.setBounds(604, 233, 131, 33);
		contentPane.add(btn_counsel_save);
		
		btn_lawyer_check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String lawyer_name = text_lawyer_name.getText();
				String lawyer_number;
				try{
					DB_LAW law = new DB_LAW();
					lawyer_number = law.checkLawyer(lawyer_name);
					text_lawyer_number.setText(lawyer_number);
				}catch(SQLException sqlError) {
					sqlError.printStackTrace();
				}
			}
			
		});
		
		btn_customer_check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String customer_name = text_customer_name.getText();
				String customer_number;
				try{
					DB_LAW law = new DB_LAW();
					customer_number = law.checkCustomer(customer_name);
					text_customer_number.setText(customer_number);
				}catch(SQLException sqlError) {
					sqlError.printStackTrace();
				}
			}
			
		});
		
		btn_counsel_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String customer_number = text_customer_number.getText();
				String lawyer_number = text_lawyer_number.getText();
				String counsel_genre = (String) combo_counsel_genre.getSelectedItem();
				String counsel_body = textArea_counsel_body.getText();
				DB_LAW law = new DB_LAW();
				law.createCounsel(lawyer_number, customer_number, counsel_genre,counsel_body);
				mainFrame main = new mainFrame();
				main.setVisible(true);
				dispose();
			}
			
		});
	}
}
