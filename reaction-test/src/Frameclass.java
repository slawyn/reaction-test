import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Frameclass extends JFrame implements ItemListener, ActionListener {
	public JLabel[] output = new JLabel[5];
	public JLabel Label;
	public JLabel dot;
	public static StopWatch watch = new StopWatch();
	public static boolean started;
	public int limit;
	public static int counter;
	public JButton startbutton;
	public Font font;
	public Font font1;
	public Numbers object = new Numbers();
	public JLabel reactiontimes;
	public JRadioButton[] button = new JRadioButton[3];

	public ButtonGroup group;

	public JComboBox box;
	public JButton ggtbutton;
	public Color[] colors = new Color[] { Color.WHITE, Color.BLACK };
	public String[] backgrounds = new String[] { "WHITE", "BLACK" };
	Presser mouser = new Presser();

	public static boolean pressable;

	public static final int MIN_WIDTH = 400;

	public static final int MIN_HEIGHT = 300;

	public void printMethod() {
		/* 48 */ System.out.println(String.valueOf(getWidth()) + " " + getHeight());
	}

	public void actionPerformed(ActionEvent event) {
		this.setVisible(false);
		this.getContentPane().addMouseListener(this.mouser);
		this.removeMouseListener(this.mouser);
		this.setEnabled(false);
	}

	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == 1) {
			this.getContentPane().setBackground(this.colors[this.box.getSelectedIndex()]);

			int i;
			for (i = 0; i < output.length; i++) {
				output[i].setBackground(this.colors[this.box.getSelectedIndex()]);
				output[i].setForeground(this.colors[1 - this.box.getSelectedIndex()]);
			}

			for (i = 0; i < this.button.length; i++) {
				this.button[i].setBackground(this.colors[this.box.getSelectedIndex()]);
				this.button[i].setForeground(this.colors[1 - this.box.getSelectedIndex()]);
			}
			if (1 - this.box.getSelectedIndex() == 0) {
				startbutton.setIcon(new ImageIcon(getClass().getResource("1black.png")));
				startbutton.setForeground(Color.WHITE);
			} else {
				startbutton.setIcon(new ImageIcon(getClass().getResource("1.png")));
				startbutton.setForeground(Color.BLACK);
			}
		}
	}

	public String endingMatcher(int number) {
		/* 53 */ String ending = "";
		/* 54 */ int tester = number;
		/* 55 */ if (tester == 1) {
			/* 56 */ ending = "  I ";
			/* 57 */ } else if (tester == 2) {
			/* 58 */ ending = " II ";
			/* 59 */ } else if (tester == 3) {
			/* 60 */ ending = "III ";
			/* 61 */ } else if (tester == 4) {
			/* 62 */ ending = "IV ";
		} else {
			/* 64 */ ending = " V ";
		}
		/* 66 */ return ending;
	}

	public void changeback() {
		/* 72 */ if (1 - this.box.getSelectedIndex() != 0) {
			/* 73 */ this.dot.setIcon(new ImageIcon(getClass().getResource("1.png")));
		} else {
			/* 75 */ this.dot.setIcon(new ImageIcon(getClass().getResource("1black.png")));
			/* 76 */ }
		counter = 0;
	}

	public long randomtime() {
		/* 84 */ Random random = new Random();
		/* 85 */ int min = 1000;
		/* 86 */ int max = 4000;
		/* 87 */ long result = random.nextInt(3500) + min;
		/* 88 */ return result;
	}

	public Frameclass() {
		/* 94 */ setLayout(new BorderLayout());

		/* 96 */ getContentPane().setBackground(Color.WHITE);
		/* 97 */ this.startbutton = new JButton("Start");
		/* 98 */ this.startbutton.setForeground(Color.orange);
		/* 99 */ this.startbutton.setBackground(Color.DARK_GRAY);
		/* 100 */ add(this.startbutton);
		/* 101 */ this.startbutton.setEnabled(false);
		/* 102 */ this.startbutton.setBounds(0, 0, 80, 45);

		/* 104 */ this.ggtbutton = new JButton("ggT Berechner!");
		/* 105 */ this.ggtbutton.setBackground(Color.YELLOW);
		/* 106 */ this.ggtbutton.setBounds(120, 0, 150, 25);
		/* 107 */ this.ggtbutton.setForeground(Color.BLUE);
		/* 108 */ add(this.ggtbutton);

		/* 110 */ this.object.setDefaultCloseOperation(2);
		/* 111 */ this.object.setSize(500, 180);
		/* 112 */ this.object.setTitle("Ggt Berechner");

		/* 116 */ this.button[0] = new JRadioButton("3", false);
		/* 117 */ this.button[0].setBounds(50, 75, 35, 25);
		/* 118 */ this.button[0].setBackground(Color.WHITE);
		/* 119 */ add(this.button[0]);
		/* 120 */ this.button[1] = new JRadioButton("5", false);
		/* 121 */ this.button[1].setBounds(85, 75, 35, 25);
		/* 122 */ this.button[1].setBackground(Color.WHITE);
		/* 123 */ add(this.button[1]);
		/* 124 */ this.button[2] = new JRadioButton("1", false);
		/* 125 */ this.button[2].setBounds(15, 75, 35, 25);
		/* 126 */ this.button[2].setBackground(Color.WHITE);
		/* 127 */ add(this.button[2]);
		/* 128 */ this.group = new ButtonGroup();
		/* 129 */ this.group.add(this.button[0]);
		/* 130 */ this.group.add(this.button[1]);
		/* 131 */ this.group.add(this.button[2]);

		/* 134 */ this.Label = new JLabel();
		/* 135 */ this.font = new Font("Impact", 0, 18);
		/* 136 */ this.Label.setFont(this.font);
		/* 137 */ this.Label.setForeground(Color.BLACK);
		/* 138 */ add(this.Label);
		/* 139 */ this.reactiontimes = new JLabel("Reaction times");
		/* 140 */ this.font1 = new Font("Impact", 0, 18);
		/* 141 */ this.reactiontimes.setFont(this.font1);
		/* 142 */ this.reactiontimes.setForeground(Color.MAGENTA);
		/* 143 */ this.reactiontimes.setBounds(2, 100, 125, 25);
		/* 144 */ add(this.reactiontimes);
		/* 145 */ this.output[0] = new JLabel();
		/* 146 */ this.output[0].setBounds(0, 140, 100, 15);
		/* 147 */ add(this.output[0]);
		/* 148 */ this.output[1] = new JLabel();
		/* 149 */ this.output[1].setBounds(0, 160, 100, 15);
		/* 150 */ add(this.output[1]);
		/* 151 */ this.output[2] = new JLabel();
		/* 152 */ this.output[2].setBounds(0, 180, 1000, 15);
		/* 153 */ add(this.output[2]);
		/* 154 */ this.output[3] = new JLabel();
		/* 155 */ this.output[3].setBounds(0, 200, 100, 15);
		/* 156 */ add(this.output[3]);
		/* 157 */ this.output[4] = new JLabel();
		/* 158 */ this.output[4].setBounds(0, 220, 100, 15);
		/* 159 */ add(this.output[4]);

		/* 162 */ this.dot = new JLabel(new ImageIcon(getClass().getResource("1.png")));
		/* 163 */ add(this.dot);
		/* 164 */ this.box = new JComboBox<String>(this.backgrounds);
		/* 165 */ add(this.box, "After");
		/* 166 */ this.box.setBounds(0, 25, 10, 10);
		/* 167 */ this.box.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				/* 171 */ if (event.getStateChange() == 1) {
					/* 172 */ Frameclass.this.getContentPane()
							.setBackground(/* 173 */ Frameclass.this.colors[Frameclass.this.box.getSelectedIndex()]);
					int i;
					/* 174 */ for (i = 0; i < Frameclass.this.output.length; i++) {
						/* 175 */ Frameclass.this.output[i]
								.setBackground(Frameclass.this.colors[Frameclass.this.box.getSelectedIndex()]);
						/* 176 */ Frameclass.this.output[i].setForeground(
								Frameclass.this.colors[1 - Frameclass.this.box/* 177 */ .getSelectedIndex()]);
					}

					/* 180 */ for (i = 0; i < Frameclass.this.button.length; i++) {
						/* 181 */ Frameclass.this.button[i]
								.setBackground(Frameclass.this.colors[Frameclass.this.box.getSelectedIndex()]);
						/* 182 */ Frameclass.this.button[i].setForeground(
								Frameclass.this.colors[1 - Frameclass.this.box/* 183 */ .getSelectedIndex()]);
					}
					/* 185 */ if (1 - Frameclass.this.box.getSelectedIndex() == 0) {
						/* 186 */ Frameclass.this.dot
								.setIcon(new ImageIcon(getClass().getResource(/* 187 */ "1black.png")));
						/* 188 */ Frameclass.this.Label.setForeground(Color.WHITE);
					} else {
						/* 190 */ Frameclass.this.dot.setIcon(new ImageIcon(getClass().getResource(/* 191 */ "1.png")));
						/* 192 */ Frameclass.this.Label.setForeground(Color.BLACK);
					}
				}
			}
		});

		/* 201 */ addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				/* 203 */ int width = Frameclass.this.getWidth();
				/* 204 */ int height = Frameclass.this.getHeight();
				/* 205 */ boolean resize = false;
				/* 206 */ if (width < 400) {
					/* 207 */ resize = true;
					/* 208 */ width = 400;
				}
				/* 210 */ if (height < 300) {
					/* 211 */ resize = true;
					/* 212 */ height = 300;
				}
				/* 214 */ if (resize) {
					/* 215 */ Frameclass.this.setSize(width, height);
				}

				/* 219 */ double textresizerwidth = 0.25D * width;
				/* 220 */ double textresizerheight = 0.17D * height;
				/* 221 */ int widthint = (int) textresizerwidth;
				/* 222 */ int heightint = (int) textresizerheight;

				/* 224 */ Frameclass.this.Label.setBounds(Frameclass.this.getContentPane().getWidth() / 2,
						/* 225 */ Frameclass.this.getContentPane().getHeight() / 6, widthint, heightint);
				/* 226 */ double fontsize = 0.045D * width;
				/* 227 */ int fontsizeint = (int) fontsize;

				/* 229 */ Frameclass.this.font = new Font("Impact", 0, fontsizeint);
				/* 230 */ Frameclass.this.Label.setFont(Frameclass.this.font);
			}
		});

		/* 236 */ Radiolistener choice = new Radiolistener();
		/* 237 */ this.button[0].addItemListener(choice);
		/* 238 */ this.button[1].addItemListener(choice);
		/* 239 */ this.button[2].addItemListener(choice);

		/* 242 */ this.startbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				/* 247 */ Frameclass.this.startbutton.setVisible(false);
				/* 248 */ Frameclass.this.getContentPane().addMouseListener(Frameclass.this.mouser);
				/* 249 */ Frameclass.this.startbutton.removeMouseListener(Frameclass.this.mouser);
				/* 250 */ Frameclass.this.box.setEnabled(false);
			}
		});

		/* 255 */ this.startbutton.addMouseListener(this.mouser);
		/* 256 */ Ggtwindow ggtwindow = new Ggtwindow();
		/* 257 */ this.ggtbutton.addActionListener(ggtwindow);
		/* 258 */ this.object.addWindowListener(ggtwindow);
	}

	public class Presser extends MouseAdapter {
		int looped;

		/* 270 */ int sum = 0;
		/* 271 */ Timer timer = new Timer();

		public void mousePressed(MouseEvent event) {
			/* 274 */ System.out.println("Alex i am listening mouse");
			/* 275 */ if (Frameclass.pressable) {
				/* 276 */ Frameclass.this.button[0].setEnabled(false);
				/* 277 */ Frameclass.this.button[1].setEnabled(false);
				/* 278 */ Frameclass.this.button[2].setEnabled(false);
				/* 279 */ if (this.looped < Frameclass.this.limit) {
					/* 280 */ if (Frameclass.started && Frameclass.counter == 1) {
						/* 281 */ Frameclass.watch.stop();
						/* 282 */ Frameclass.this.changeback();
						/* 283 */ Frameclass.this.output[this.looped]
								.setText(String.valueOf(Frameclass.this.endingMatcher(this.looped + 1))
										+ Frameclass/* 284 */ .watch.getElapsedTime() + " ms");
						/* 285 */ this.sum = (int) (this.sum + Frameclass.watch.getElapsedTime());
						/* 286 */ this.looped++;
						/* 287 */ Frameclass.started = false;
					}

					/* 290 */ if (this.looped < Frameclass.this.limit) {
						/* 291 */ this.timer.schedule(new Randomizer(), Frameclass.this.randomtime());
						/* 292 */ Frameclass.counter = Frameclass.counter + 1;

						/* 294 */ if (Frameclass.counter > 1) {
							/* 295 */ this.timer.cancel();
							/* 296 */ Frameclass.started = false;
							/* 297 */ Frameclass.this.changeback();
							/* 298 */ for (int index = 0; index < Frameclass.this.limit; index++) {
								/* 299 */ Frameclass.this.output[index].setText("");
							}
							/* 301 */ Timer titleadder = new Timer();
							/* 302 */ titleadder.schedule(new Titleadder(), 0L);
							/* 303 */ Timer titleremover = new Timer();
							/* 304 */ titleremover.schedule(new Titleremover(), 100L);
							/* 305 */ titleadder.schedule(new Titleadder(), 200L);
							/* 306 */ titleremover.schedule(new Titleremover(), 300L);
							/* 307 */ this.looped = 0;
							/* 308 */ this.sum = 0;
							/* 309 */ this.timer = new Timer();
							/* 310 */ this.timer.schedule(new Randomizer(), Frameclass.this.randomtime());
							/* 311 */ Frameclass.counter = Frameclass.counter + 1;

						}

					}
					/* 317 */ else if (Frameclass.this.limit == this.looped) {
						/* 318 */ Frameclass.this.getContentPane().removeMouseListener(Frameclass.this.mouser);
						/* 319 */ int result = this.sum / this.looped;
						/* 320 */ String finaloutput = "";
						/* 321 */ if (result > 200 && result < 250) {
							/* 322 */ finaloutput = " ***You could do better/:\n";
							/* 323 */ } else if (result < 100) {
							/* 324 */ finaloutput = " ***Physically  impossible!!!\n";
							/* 325 */ } else if (result >= 150 && result <= 200) {
							/* 326 */ finaloutput = " ***You are fast!\n";
							/* 327 */ } else if (result <= 150 && result >= 100) {
							/* 328 */ finaloutput = " ***You are extremely fast!!\n";
						} else {
							/* 330 */ finaloutput = " ***Did you fall asleep?\n";
						}
						/* 332 */ int restartstatus = JOptionPane.showConfirmDialog(null,
								/* 333 */ "Your average is : " + (this.sum / this.looped) + " ms" +
								/* 334 */ "\n" + finaloutput +
								/* 335 */ "\n     Want to try again?", /* 336 */ "Ausgabe", 2);

						/* 339 */ if (restartstatus == 0) {
							/* 340 */ Frameclass.this.button[0].setEnabled(true);
							/* 341 */ Frameclass.this.button[1].setEnabled(true);
							/* 342 */ Frameclass.this.button[2].setEnabled(true);
							/* 343 */ Frameclass.this.startbutton.addMouseListener(this);
							/* 344 */ Frameclass.this.startbutton.setVisible(true);
							/* 345 */ Frameclass.this.box.setEnabled(true);

							/* 347 */ for (int index = 0; index < Frameclass.this.limit; index++)
								/* 348 */ Frameclass.this.output[index].setText("");
							/* 349 */ this.sum = 0;
							/* 350 */ this.looped = 0;
							/* 351 */ Frameclass.this.changeback();
						} else {

							/* 354 */ System.exit(0);
						}
					}
				}
			}
		}

		public class Randomizer extends TimerTask {
			public void run() {
				Frameclass.this.Label.setText("");
				Frameclass.watch.start();
				Frameclass.started = true;
				if (1 - Frameclass.this.box.getSelectedIndex() != 0) {
					 Frameclass.this.dot.setIcon(new ImageIcon(getClass().getResource("2.png")));
				} else {
					Frameclass.this.dot.setIcon(new ImageIcon(getClass().getResource("2black.png")));
				}
			}
		}

		public class Titleremover extends TimerTask {
			public void run() {
				Frameclass.this.Label.setText("");
			}
		}

		public class Titleadder extends TimerTask {
			public void run() {
				Frameclass.this.Label.setText("No Cheating!");
			}
		}
	}

	public class Radiolistener implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			/* 399 */ if (Frameclass.this.button[0].isSelected()) {
				/* 400 */ Frameclass.this.limit = 3;
			}
			/* 402 */ else if (Frameclass.this.button[1].isSelected()) {
				/* 403 */ Frameclass.this.limit = 5;
			} else {
				/* 405 */ Frameclass.this.limit = 1;
				/* 406 */ }
			Frameclass.this.startbutton.setEnabled(true);
			/* 407 */ Frameclass.pressable = true;
		}
	}

	private class Ggtwindow extends WindowAdapter implements ActionListener {
		boolean opened;

		private Ggtwindow() {
			/* 414 */ this.opened = false;
		}

		public void actionPerformed(ActionEvent e) {
			/* 417 */ if (this.opened) {
				/* 418 */ Frameclass.this.object.setVisible(false);
				/* 419 */ this.opened = false;
			} else {
				/* 421 */ Frameclass.this.object.setVisible(true);
				/* 422 */ this.opened = true;
			}
		}

		public void windowClosed(WindowEvent event) {
			/* 429 */ this.opened = false;
			/* 430 */ Frameclass.this.object.setVisible(false);
		}
	}

}

/*
 * Location:
 * C:\Users\Unixt\OneDrive\Desktop\Projects\Projects\java\reaction-test\Reaction
 * test\!\Frameclass.class Java compiler version: 6 (50.0) JD-Core Version:
 * 1.1.3
 */