package main.java;

/* Подключаем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
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

/* Создаем главный класс программы, реализующий интерфейс ActionListener,
который отвечает за обработку события нажатия на кнопку.*/
public class Calculator implements ActionListener{
	/* Создаем переменную id типа boolean, в которой хранится состояние авторизации
	(если авторизация не пройдена, то значение переменной равно false,
	в противном случае true).*/
	private boolean id = false;
	
	/* Создаем метод, который изменяет значение
    переменной id на значение, которое было
	передано в параметрах метода.*/	
	public void setStateId(boolean id) {
		this.id = id;
	}
	
	/* Создаем метод, который возвращает значение
	переменной id при вызове.*/
	public boolean getStateId() {
		return id;
	}
	
	/* Создаем объект главного окна с помощью ключевого слова new */
    JFrame frame = new JFrame("Расчет количества символов в тексте");
	/* Создаем объект панели с метками */
    JPanel panelLeft = new JPanel();
	/* Создаем объект панели с текстовыми полями */
    JPanel panelRight = new JPanel();
	/* Создаем объект панели с кнопками */
    JPanel panelBottom = new JPanel();
	/* Создаем массив текстовых полей */
    public JTextField[] fields = new JTextField[2];

    /* Добавляем конструктор класса */
    public Calculator() {
    	/* Для того, чтобы изменить цвет фона.
    	panelLeft.setBackground(Color.red);
    	panelRight.setBackground(Color.red);
    	panelBottom.setBackground(Color.red);
    	*/
        /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с метками 250 на 300 пикселей */
        panelLeft.setPreferredSize(new Dimension(250, 300));
        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с текстовыми полями 370 на 300 пикселей */
        panelRight.setPreferredSize(new Dimension(370,300));
        /* Добавляем метки к текстовым полям через метод addLabel */
        addLabel(panelLeft, "Текст:", Color.BLACK);
        addLabel(panelLeft, "Количество символов в тексте:", Color.BLACK);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fields.length; i++){
            if(fields.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fields[i] = addTextField(panelRight);}
        }

        /* Добавляем кнопку расчета количества символов */
        JButton calc = addButton(panelBottom, "Расчет символов");
        /* Добавляем слушатель на событие нажатия кнопки расчета символов */
        calc.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton reset = addButton(panelBottom, "Сброс");
        /* Добавляем слушатель на событие нажатия кнопки сброса */
        reset.addActionListener(this);
		/* Добавляем кнопку авторизации */
        JButton authorization = addButton(panelBottom, "Авторизация");
        /* Добавляем слушатель на событие нажатия кнопки авторизации*/
        authorization.addActionListener(this);
        /* Добавляем кнопку расчета количества точек и запятых */
        JButton punMarks = addButton(panelBottom, "Расчет точек и запятых");
        /* Добавляем слушатель на событие нажатия кнопки расчета количества точек и запятых */
        punMarks.addActionListener(this);
        /* Делаем главное окно видимым */
        frame.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Устанавливаем начальное положение главного окна относительно центра экрана (по центру) */
        frame.setLocationRelativeTo(null);
        /* Устанавливаем размер главного окна(600 на 200) */
        frame.setSize(600,200);
        /* Добавляем панель с метками на главное окно */
        frame.add(panelLeft, BorderLayout.WEST);
		/* Добавляем панель с текстовыми полями на главное окно */
        frame.add(panelRight, BorderLayout.EAST);
		/* Добавляем панель с кнопками на главное окно */
        frame.add(panelBottom, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров главного окна */
        frame.setResizable(false);
    }

    /* Метод добавления текстовых меток */
    public void addLabel(JComponent container, String name, Color color){
        /* Создаем объект текстовой метки */
        JLabel label = new JLabel(name);
        /* Устанавливаем максимально допустимый размер метки */
        label.setMaximumSize(new Dimension(200,20));
        /* Устанавливаем цвета текста метки */
        label.setForeground(color);
        /* Для того, чтобы изменить цвет рамки текстового поля
        if (name == "") {label.setBackground(Color.red);}
		*/
        /* Устанавливаем выравнивание метки по правому краю */
        label.setHorizontalAlignment(JLabel.RIGHT);
        /* Добавляем рамку вокруг метки */
        label.setBorder(new EtchedBorder());
        /* Добавляем метку на панель */
        container.add(label);
    }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* Метод обработки события нажатия на кнопку */
    public void actionPerformed(ActionEvent e) {
        /* С помощью оператора if выполняем действие,
		назначенное на ту кнопку, чье имя совпадаем со
		строкой, которая передается в качестве параметра
		встроенному методу equals.*/
        if (e.getActionCommand().equals("Расчет символов")) {
			/* Обработка исключения на случай возникновения ошибок
			в процессе выполнения кода, записанного в боке try.*/
            try {
                /* Запускаем метод расчета количества символов */
                calculate();
			/* Код, выполняемый при возникновении ошибок
			в процессе выполнения кода из блока try. */
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Авторизация")) {
        	try {
                /* Создаем объект класса CalcAuthorization */
                CalcAuthorization calcAut = new CalcAuthorization();
				/* Запускаем процесс авторизации */
                calcAut.runAut();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Расчет точек и запятых")) {
        	try {
				/* Если авторизация не пройдена - выводим предупреждающее
				сообщение, в противном случае - запускаем метод расчета количества
				точек и запятых. */
                if(getStateId() == false) {
                	JOptionPane.showMessageDialog(null, "Авторизируйтесь, чтобы получить доступ к этой функции");
                } else {
                	calculatePunMarks();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Сброс")) {
            /* Очищаем все поля через цикл */
            for(int i=0; i<fields.length; i++){
                fields[i].setText("");
            }
        }
    }
    
    /* Главный метод класса, запускающий калькулятор */
    public static void main(String[] args) {
		/* С помощью метода invokeLater запускаем асинхронную операцию,
		которая сохраняет действие (Runnable), и запускает его на одной
		из следующих итераций цикла сообщений.*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			/* Создаем метод, который запускает калькулятор
			через конструктор главного класса.*/
            public void run() {
                new Calculator();
            }
        });
    }
}
