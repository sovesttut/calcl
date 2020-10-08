package main.java;

/* ���������� ���������� ��� ������ � ���������� ������, �������, ��� �������� ������������ ���� */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

/* ������� ������� ����� ���������, ����������� ��������� ActionListener,
������� �������� �� ��������� ������� ������� �� ������.
*/
public class CalcAuthorization implements ActionListener{
	
	/* ������� ������ ���� ����������� � ������� ��������� ����� new */
    JFrame frameAut = new JFrame("�����������");
	/* ������� ������ ������ � ������� */
    JPanel panelLeftAut = new JPanel();
	/* ������� ������ ������ � ���������� ������ */
    JPanel panelRightAut = new JPanel();
	/* ������� ������ ������ � �������� */
    JPanel panelBottomAut = new JPanel();
	/* ������� ������ ��������� ����� */
    public JTextField[] fieldsAut = new JTextField[2];

     /* ��������� ����������� ������ */
    public CalcAuthorization() {
        /* ������������� �������� ���������� ��� ������ � ������� � ������������ �� ��������� */
        panelLeftAut.setLayout(new BoxLayout(panelLeftAut, BoxLayout.Y_AXIS));
        /* ������������� ������ ������ � ������� 250 �� 300 �������� */
        panelLeftAut.setPreferredSize(new Dimension(250, 300));

        /* ������������� �������� ���������� ��� ������ � ���������� ������ � ������������ �� ��������� */
        panelRightAut.setLayout(new BoxLayout(panelRightAut, BoxLayout.Y_AXIS));
        /* �������������  ������ 230 �� 300 �������� */
        panelRightAut.setPreferredSize(new Dimension(230,300));

        /* ��������� ����� � ��������� ����� ����� ����� addLabel */
        addLabel(panelLeftAut, "�����:", Color.BLACK);
        addLabel(panelLeftAut, "������:", Color.BLACK);
        /* ��������� ��������� ���� ����� ���� � ���������� �� � ������ */
        for(int i = 0; i < fieldsAut.length; i++){
            if(fieldsAut.length >= 0){
                /* ���������� ������ �� ������ � ������ ��� ���������� ������ � ��������� ����� */
                fieldsAut[i] = addTextField(panelRightAut);}
        }

        /* ��������� ������ ������������� ����������� */
        JButton signInAut = addButton(panelBottomAut, "��������������");
        /* ��������� ��������� �� ������� ������� */
        signInAut.addActionListener(this);
		/* ��������� ������ ������ */
        JButton resetAut = addButton(panelBottomAut, "�����");
        /* ��������� ��������� �� ������� ������� */
        resetAut.addActionListener(this);

        /* ������ ���� ����������� ������� */
        frameAut.setVisible(true);
        /* ������������� �������� ��� ������� �� ������� - ���������� ���������� */
        frameAut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* ������������� ��������� ��������� ���� ����������� ������������ ������ ������ (�� ������) */
        frameAut.setLocationRelativeTo(null);
        /* ������������� ������ ���� ����������� (450 �� 200) */
        frameAut.setSize(450,200);

        /* ��������� ������ � ������� �� ���� ����������� */
        frameAut.add(panelLeftAut, BorderLayout.WEST);
		/* ��������� ������ � ���������� ������ �� ���� ����������� */
        frameAut.add(panelRightAut, BorderLayout.EAST);
		/* ��������� ������ � �������� �� ���� ����������� */
        frameAut.add(panelBottomAut, BorderLayout.SOUTH);
		/* ��������� ��������� �������� ���� ����������� */
        frameAut.setResizable(false);
    }

    /* ����� ���������� ��������� ����� */
    public void addLabel(JComponent container, String name, Color color){
        /* ������� ������ ��������� ����� */
        JLabel label = new JLabel(name);
        /* ������������� ����������� ���������� ������ ����� */
        label.setMaximumSize(new Dimension(200,20));
        /* ������������� ����� ������ ����� */
        label.setForeground(color);
        /* ������������� ������������ ����� �� ������� ���� */
        label.setHorizontalAlignment(JLabel.RIGHT);
        /* ��������� ����� ������ ����� */
        label.setBorder(new EtchedBorder());
        /* ��������� ����� �� ������ */
        container.add(label);
    }

    /* ����� ���������� ��������� ����� */
    public JTextField addTextField(JComponent container){
        /* ������� ������ ���������� ���� */
        JTextField field = new JTextField();
        /* ������������� ����������� ���������� ������ ���� */
        field.setMaximumSize(new Dimension(350,20));
        /* ��������� ���� �� ������ */
        container.add(field);
        /* ���������� ������ �� ��������� ���� */
        return field;
    }

    /* ����� ���������� ������ */
    public JButton addButton(JComponent container, String name){
        /* ������� ������ ������ */
        JButton button = new JButton(name);
        /* ������������� ����������� ���������� ������ ������ */
        button.setMaximumSize(new Dimension(100,20));
        /* ������������� ������������ �� ����������� (�� ������) */
        button.setHorizontalAlignment(JButton.CENTER);
        /* ��������� ������ �� ������ */
        container.add(button);
        /* ���������� ������ �� ������ */
        return button;
    }
    
    /* ����� ����������� ����������� */
    public void signIn() throws Exception {
		/* ���������� ��������� ����� �� ���� ����� ������ � ���������� */
    	String login = fieldsAut[0].getText();
		/* ���������� ��������� ����� �� ���� ����� ������ � ���������� */
    	String password = fieldsAut[1].getText();
		/* ������� ������, ������� �������� ���������� �������� ������ */
    	String[] loginArray = {"Ard", "Bay", "Shay", "Step"};
		/* ������� ������, ������� �������� ���������� �������� ������ */
    	String[] passwordArray = {"17130470", "17130175", "17130180", "17130705"};
    	
		/* ��������� �������� ��������� ������ � ������ ����� ���� for.
		���� ��������� �������� ��������� �� ���������� � ��������,
		�������� �������� ������� � ����������� ���������.
		*/
    	for (int i = 0; i < loginArray.length; i++) {
    		if ((login.equals(loginArray[i])) && (password.equals(passwordArray[i]))) {
				/* ������� ������ �������� ������ Calculator */
        		Calculator calc = new Calculator();
				/* �������� �������� ���������� id � ������� ������ */
        		calc.setStateId(true);
				/* ������� ��������� �� �������� ����������� �������� ����������� */
        		JOptionPane.showMessageDialog(null, "����������� �������� �������");
				/* �������� ���� ����������� */
        		frameAut.setVisible(false);
        	}
    	}
    }
    
    /* � ������� ��������� @Override ���������, ���
	�����, ��������� �� ����������, ����� �������������.
	*/	
    @Override
	/* ����� ��������� ������� ������� �� ������ */
    public void actionPerformed(ActionEvent e) {
        /* � ������� ��������� if ��������� ��������,
		����������� �� �� ������, ��� ��� ��������� ��
		�������, ������� ���������� � �������� ���������
		����������� ������ equals.
		*/
        if (e.getActionCommand().equals("��������������")) {
			/* ��������� ���������� �� ������ ������������� ������
			� �������� ���������� ����, ����������� � ���� try.
			*/
            try {
                /* ��������� ����� ����������� */
            	signIn();
			/* ���, ����������� ��� ������������� ������
			� �������� ���������� ���� �� ����� try.
			*/
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }
        } else if (e.getActionCommand().equals("�����")) {
            /* ������� ��� ���� ����� ���� */
            for(int i=0; i<fieldsAut.length; i++){
                fieldsAut[i].setText("");
            }
        }
    }
    
    /* ������� ����� ������, ����������� ������� ����������� */
    public void runAut() {
		/* � ������� ������ invokeLater ��������� ����������� ��������,
		������� ��������� �������� (Runnable), � ��������� ��� �� �����
		�� ��������� �������� ����� ���������.
		*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			/* ������� �����, ������� ��������� ������� �����������
			����� ����������� ������.
			*/
            public void run() {
                new CalcAuthorization();
            }
        });
    }
}

