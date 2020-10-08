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
������� �������� �� ��������� ������� ������� �� ������.*/
public class Calculator implements ActionListener{
	/* ������� ���������� id ���� boolean, � ������� �������� ��������� �����������
	(���� ����������� �� ��������, �� �������� ���������� ����� false,
	� ��������� ������ true).*/
	private boolean id = false;
	
	/* ������� �����, ������� �������� ��������
    ���������� id �� ��������, ������� ����
	�������� � ���������� ������.*/	
	public void setStateId(boolean id) {
		this.id = id;
	}
	
	/* ������� �����, ������� ���������� ��������
	���������� id ��� ������.*/
	public boolean getStateId() {
		return id;
	}
	
	/* ������� ������ �������� ���� � ������� ��������� ����� new */
    JFrame frame = new JFrame("������ ���������� �������� � ������");
	/* ������� ������ ������ � ������� */
    JPanel panelLeft = new JPanel();
	/* ������� ������ ������ � ���������� ������ */
    JPanel panelRight = new JPanel();
	/* ������� ������ ������ � �������� */
    JPanel panelBottom = new JPanel();
	/* ������� ������ ��������� ����� */
    public JTextField[] fields = new JTextField[2];

    /* ��������� ����������� ������ */
    public Calculator() {
    	/* ��� ����, ����� �������� ���� ����.
    	panelLeft.setBackground(Color.red);
    	panelRight.setBackground(Color.red);
    	panelBottom.setBackground(Color.red);
    	*/
        /* ������������� �������� ���������� ��� ������ � ������� � ������������ �� ��������� */
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        /* ������������� ������ ������ � ������� 250 �� 300 �������� */
        panelLeft.setPreferredSize(new Dimension(250, 300));
        /* ������������� �������� ���������� ��� ������ � ���������� ������ � ������������ �� ��������� */
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        /* ������������� ������ ������ � ���������� ������ 370 �� 300 �������� */
        panelRight.setPreferredSize(new Dimension(370,300));
        /* ��������� ����� � ��������� ����� ����� ����� addLabel */
        addLabel(panelLeft, "�����:", Color.BLACK);
        addLabel(panelLeft, "���������� �������� � ������:", Color.BLACK);
        /* ��������� ��������� ���� ����� ���� � ���������� �� � ������ */
        for(int i = 0; i < fields.length; i++){
            if(fields.length >= 0){
                /* ���������� ������ �� ������ � ������ ��� ���������� ������ � ��������� ����� */
                fields[i] = addTextField(panelRight);}
        }

        /* ��������� ������ ������� ���������� �������� */
        JButton calc = addButton(panelBottom, "������ ��������");
        /* ��������� ��������� �� ������� ������� ������ ������� �������� */
        calc.addActionListener(this);
		/* ��������� ������ ������ */
        JButton reset = addButton(panelBottom, "�����");
        /* ��������� ��������� �� ������� ������� ������ ������ */
        reset.addActionListener(this);
		/* ��������� ������ ����������� */
        JButton authorization = addButton(panelBottom, "�����������");
        /* ��������� ��������� �� ������� ������� ������ �����������*/
        authorization.addActionListener(this);
        /* ��������� ������ ������� ���������� ����� � ������� */
        JButton punMarks = addButton(panelBottom, "������ ����� � �������");
        /* ��������� ��������� �� ������� ������� ������ ������� ���������� ����� � ������� */
        punMarks.addActionListener(this);
        /* ������ ������� ���� ������� */
        frame.setVisible(true);
        /* ������������� �������� ��� ������� �� ������� - ���������� ���������� */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* ������������� ��������� ��������� �������� ���� ������������ ������ ������ (�� ������) */
        frame.setLocationRelativeTo(null);
        /* ������������� ������ �������� ����(600 �� 200) */
        frame.setSize(600,200);
        /* ��������� ������ � ������� �� ������� ���� */
        frame.add(panelLeft, BorderLayout.WEST);
		/* ��������� ������ � ���������� ������ �� ������� ���� */
        frame.add(panelRight, BorderLayout.EAST);
		/* ��������� ������ � �������� �� ������� ���� */
        frame.add(panelBottom, BorderLayout.SOUTH);
		/* ��������� ��������� �������� �������� ���� */
        frame.setResizable(false);
    }

    /* ����� ���������� ��������� ����� */
    public void addLabel(JComponent container, String name, Color color){
        /* ������� ������ ��������� ����� */
        JLabel label = new JLabel(name);
        /* ������������� ����������� ���������� ������ ����� */
        label.setMaximumSize(new Dimension(200,20));
        /* ������������� ����� ������ ����� */
        label.setForeground(color);
        /* ��� ����, ����� �������� ���� ����� ���������� ����
        if (name == "") {label.setBackground(Color.red);}
		*/
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
        /* ��� ����, ����� �������� ���� ������
        if (name == "") {button.setBackground(Color.red);}
        */
        /* ������������� ����������� ���������� ������ ������ */
        button.setMaximumSize(new Dimension(100,20));
        /* ������������� ������������ �� ����������� (�� ������) */
        button.setHorizontalAlignment(JButton.CENTER);
        /* ��������� ������ �� ������ */
        container.add(button);
        /* ���������� ������ �� ������ */
        return button;
    }
    
    /* ����� ������� ���������� �������� */
    public void calculate() throws Exception {
		/* ���������� ��������� ����� �� ���� ����� � ���������� */
    	String getText = fields[0].getText();
		/* ������������ ����� ���������� ������ */
        String valueOf = String.valueOf(getText.length());
		/* ���������� ��������� ������� � ���� ������ */
        fields[1].setText(valueOf);
    }
    
    /* ����� ������� ���������� ������ ���������� */
    public void calculatePunMarks() throws Exception {
		/* ������� ����������, � ������� ��������
		����� ���� ����� � �������.*/	
    	int valueOf = 0;
		/* ���������� ��������� ����� �� ���� ����� � ���������� */
    	String getText = fields[0].getText();
		/* ������������ ���������� ����� � ������� � ������� ����� for */
    	for (int i = 0; i < getText.length(); i++) {
			/* ���������� �������� �������� if
			��� ���������� �������� ���������� valueOf
			������ ���, ����� �� ��������� ������ ��������
			����������� ����� ��� �������.*/
    		if ((getText.charAt(i) == ',') || (getText.charAt(i) == '.')) {
    			valueOf += 1;
    		}
    	}
		/* ��������������� ��� ���������� valueOf
		�� �������������� ���� int � ��������� ��� String
        � ���������� ���������� �������� � ���������� result.*/		
    	String result = String.valueOf(valueOf);
		/* ���������� ��������� ������� � ���� ������ */
        fields[1].setText(result);
    }

    /* � ������� ��������� @Override ���������, ���
	�����, ��������� �� ����������, ����� �������������.*/
@Override

/* ����� ��������� ������� ������� �� ������ */
    public void actionPerformed(ActionEvent e) {
        /* � ������� ��������� if ��������� ��������,
		����������� �� �� ������, ��� ��� ��������� ��
		�������, ������� ���������� � �������� ���������
		����������� ������ equals.*/
        if (e.getActionCommand().equals("������ ��������")) {
			/* ��������� ���������� �� ������ ������������� ������
			� �������� ���������� ����, ����������� � ���� try.*/
            try {
                /* ��������� ����� ������� ���������� �������� */
                calculate();
			/* ���, ����������� ��� ������������� ������
			� �������� ���������� ���� �� ����� try. */
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }
        } else if (e.getActionCommand().equals("�����������")) {
        	try {
                /* ������� ������ ������ CalcAuthorization */
                CalcAuthorization calcAut = new CalcAuthorization();
				/* ��������� ������� ����������� */
                calcAut.runAut();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }
        } else if (e.getActionCommand().equals("������ ����� � �������")) {
        	try {
				/* ���� ����������� �� �������� - ������� ���������������
				���������, � ��������� ������ - ��������� ����� ������� ����������
				����� � �������. */
                if(getStateId() == false) {
                	JOptionPane.showMessageDialog(null, "���������������, ����� �������� ������ � ���� �������");
                } else {
                	calculatePunMarks();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }
        } else if (e.getActionCommand().equals("�����")) {
            /* ������� ��� ���� ����� ���� */
            for(int i=0; i<fields.length; i++){
                fields[i].setText("");
            }
        }
    }
    
    /* ������� ����� ������, ����������� ����������� */
    public static void main(String[] args) {
		/* � ������� ������ invokeLater ��������� ����������� ��������,
		������� ��������� �������� (Runnable), � ��������� ��� �� �����
		�� ��������� �������� ����� ���������.*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			/* ������� �����, ������� ��������� �����������
			����� ����������� �������� ������.*/
            public void run() {
                new Calculator();
            }
        });
    }
}


