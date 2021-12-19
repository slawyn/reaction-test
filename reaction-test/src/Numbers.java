
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Numbers extends JFrame implements ActionListener {
	private JLabel label1;
	private JTextField number1;
	private JTextField number2;
	private static Ggt ggt;
	private JButton button;
	private Font font;
	private JLabel resultation;
	private static boolean status = true;

	public static long method(long number1, long number2) {
		/* 24 */ if (number1 == 0L || number2 == 0L) {
			/* 25 */ return 0L;
		}

		/* 28 */ return Ggt.Berechnung(number1, number2);
	}

	public Numbers() {
		/* 33 */ setResizable(false);
		/* 34 */ this.label1 = new JLabel("ggT ist :");
		/* 35 */ this.resultation = new JLabel();
		/* 36 */ this.number1 = new JTextField("0", 10);
		/* 37 */ this.number2 = new JTextField("0", 10);
		/* 38 */ this.button = new JButton("Result");
		/* 39 */ Container c = getContentPane();
		/* 40 */ c.setLayout((LayoutManager) null);
		/* 41 */ c.add(this.number1);
		/* 42 */ c.add(this.number2);
		/* 43 */ c.add(this.label1);
		/* 44 */ c.add(this.button);
		/* 45 */ c.add(this.resultation);
		/* 46 */ this.label1.setBounds(200, 5, 100, 100);
		/* 47 */ this.button.setBounds(200, 100, 100, 50);
		/* 48 */ this.number1.setBounds(50, 100, 100, 20);
		/* 49 */ this.number2.setBounds(50, 50, 100, 20);
		/* 50 */ this.resultation.setBounds(250, 5, 200, 100);
		/* 51 */ this.font = new Font("Serif", 1, 25);

		/* 53 */ this.resultation.setFont(this.font);

		/* 55 */ ActionHandler handler = new ActionHandler();
		/* 56 */ this.button.addActionListener(handler);
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			/* 73 */ Numbers.status = true;

			/* 75 */ for (int i = 0; i < Numbers.this.number1.getText().length(); i++) {

				/* 77 */ if (Numbers.this.number1.getText().charAt(i) < '0' ||
				/* 78 */ Numbers.this.number1.getText().charAt(i) > '9') {
					/* 79 */ if (Numbers.this.number1.getText().charAt(i) == '-') {
						/* 80 */ Numbers.status = true;
					} else {
						/* 82 */ Numbers.this.resultation.setForeground(Color.CYAN);
						/* 83 */ Numbers.this.resultation.setText("ERROR!");
						/* 84 */ Numbers.status = false;

						break;
					}
				}
			}

			/* 92 */ for (int y = 0; y < Numbers.this.number2.getText().length(); y++) {

				/* 94 */ if (Numbers.this.number2.getText().charAt(y) < '0' ||
				/* 95 */ Numbers.this.number2.getText().charAt(y) > '9') {
					/* 96 */ if (Numbers.this.number2.getText().charAt(y) == '-') {
						/* 97 */ Numbers.status = true;
					} else {
						/* 99 */ Numbers.this.resultation.setForeground(Color.CYAN);
						/* 100 */ Numbers.this.resultation.setText("ERROR!");
						/* 101 */ Numbers.status = false;

						break;
					}
				}
			}

			/* 108 */ if (Numbers.status)

				try {

					/* 112 */ long temp1 = Long.valueOf(Numbers.this.number1.getText()).longValue();
					/* 113 */ long temp2 = Long.valueOf(Numbers.this.number2.getText()).longValue();
					/* 114 */ long result = Numbers.method(temp1, temp2);

					/* 116 */ if (result == 1L) {
						/* 117 */ Numbers.this.resultation.setForeground(Color.BLACK);
						/* 118 */ } else if (result <= 3L) {
						/* 119 */ Numbers.this.resultation.setForeground(Color.RED);
					} else {
						/* 121 */ Numbers.this.resultation.setForeground(Color.GREEN);
					}
					/* 123 */ Numbers.this.resultation.setText(String.valueOf(result));
					/* 124 */ } catch (NumberFormatException e) {
					/* 125 */ Numbers.this.resultation.setText("LIMIT!!!");
				}
		}
	}

	public void actionPerformed(ActionEvent event) {

		for (int i = 0; i < number1.getText().length(); i++) {

			if (number1.getText().charAt(i) < '0' || number1.getText().charAt(i) > '9') {
				if (number1.getText().charAt(i) == '-') {
					status = true;
				} else {
					resultation.setForeground(Color.CYAN);
					resultation.setText("ERROR!");
					status = false;

					break;
				}
			}
		}

		for (int y = 0; y <number2.getText().length(); y++) {

			if (number2.getText().charAt(y) < '0'
					|| number2.getText().charAt(y) > '9') {
				if (number2.getText().charAt(y) == '-') {
					status = true;
				} else {
					resultation.setForeground(Color.CYAN);
					resultation.setText("ERROR!");
					status = false;

					break;
				}
			}
		}

		if (status)

			try {

				long temp1 = Long.valueOf(number1.getText()).longValue();
				long temp2 = Long.valueOf(number2.getText()).longValue();
				long result = Numbers.method(temp1, temp2);

				if (result == 1L) {
					resultation.setForeground(Color.BLACK);
				} else if (result <= 3L) {
					resultation.setForeground(Color.RED);
				} else {
					resultation.setForeground(Color.GREEN);
				}
				resultation.setText(String.valueOf(result));
			} catch (NumberFormatException e) {
				resultation.setText("LIMIT!!!");
			}
	}

}

/*
 * Location:
 * C:\Users\Unixt\OneDrive\Desktop\Projects\Projects\java\reaction-test\Reaction
 * test\!\Numbers.class Java compiler version: 6 (50.0) JD-Core Version: 1.1.3
 */