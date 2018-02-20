

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements Runnable, KeyListener, ActionListener {
	// initiatiing variables
	static int[][] varList = new int[96][4];
	static int[][] bulList = new int[10][3];
	static String[] scores = new String[10];
	int[] avaliUnits = new int[96];
	static int playerHP, playerMove = 0, playerx = 0, playery = 0, shootDir = 0, colorTime = 0, menu, TxtActive;
	static long gameTimer, spawnTimer, spawnDelay, score;
	static boolean shooting = false;
	JButton btnGame = new JButton("Play");
	JButton btnStand = new JButton("Standard");
	JButton btnCheat = new JButton("Cheat");
	JButton btnInst = new JButton("Instructions");
	JButton btnScore = new JButton("Score");
	JButton btnBack = new JButton("Back");
	JButton btnEnter = new JButton("Enter");
	JLabel lblScore1 = new JLabel("");
	JLabel lblScore2 = new JLabel("");
	JLabel lblScore3 = new JLabel("");
	JLabel lblScore4 = new JLabel("");
	JLabel lblScore5 = new JLabel("");
	JLabel lblScore6 = new JLabel("");
	JLabel lblScore7 = new JLabel("");
	JLabel lblScore8 = new JLabel("");
	JLabel lblScore9 = new JLabel("");
	JLabel lblScore10 = new JLabel("");
	JLabel lblScoreCur = new JLabel("");
	JLabel lblHealth = new JLabel("");
	JLabel lblTime = new JLabel("");
	JTextField txtPlayer = new JTextField("");
	BufferedReader reader = null;
	BufferedWriter writer = null;
	String s = "", playername;
	public static final String filePath = new File("").getAbsolutePath() + "/src/";

	// start game
	public Game() {
		// Removing focus from buttons
		btnGame.setFocusable(false);
		btnInst.setFocusable(false);
		btnScore.setFocusable(false);
		btnStand.setFocusable(false);
		btnCheat.setFocusable(false);
		btnBack.setFocusable(false);
		btnEnter.setFocusable(false);
		// initiate and starting thread
		Thread t = new Thread(this);
		t.start();
	}// end Test1Game

	// part of actionListner
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	// What happens when keys are pressed
	public void keyPressed(KeyEvent e) {
		// only works if game is on
		if (menu == 3 || menu == 4) {
			// movement and firedirection changes based on keypressed
			if (e.getKeyCode() == KeyEvent.VK_W)
				playerMove = 1;
			if (e.getKeyCode() == KeyEvent.VK_S)
				playerMove = 2;
			if (e.getKeyCode() == KeyEvent.VK_A)
				playerMove = 3;
			if (e.getKeyCode() == KeyEvent.VK_D)
				playerMove = 4;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				shooting = true;
				shootDir = 1;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				shooting = true;
				shootDir = 2;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				shooting = true;
				shootDir = 3;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				shooting = true;
				shootDir = 4;
			}
		} // end if menu == 3 || menu == 4

	}// end of keyPessed

	// What happens when buttons are pressed
	public void button() {
		// initiating button listeners to change menus when button pressed
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playername = txtPlayer.getText();
				// only accept name entered if between 1-14 characters
				if (playername.length() > 0 && playername.length() < 15) {
					menu = 2;
					TxtActive = 0;
				}
			}
		});
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 3;
			}
		});
		btnCheat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 4;
			}
		});
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 1;
			}
		});
		btnInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 5;
			}
		});
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 6;
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu = 0;
				TxtActive = 0;
			}
		});

	}// end of button

	@Override
	// part of keyListener
	public void keyTyped(KeyEvent e) {
	}

	@Override
	// What happens when keys are released
	public void keyReleased(KeyEvent e) {
		if (menu == 3 || menu == 4) {
			// only works if game is running
			// stops player when keys are released
			if (playerMove == 1 && e.getKeyCode() == KeyEvent.VK_W)
				playerMove = 0;
			if (playerMove == 2 && e.getKeyCode() == KeyEvent.VK_S)
				playerMove = 0;
			if (playerMove == 3 && e.getKeyCode() == KeyEvent.VK_A)
				playerMove = 0;
			if (playerMove == 4 && e.getKeyCode() == KeyEvent.VK_D)
				playerMove = 0;
		}
	}// end keyReleased

	// Writes scores to txtfile scores.txt
	public void writeTo() throws IOException {
		writer = new BufferedWriter(new FileWriter(filePath + "scores.txt"));
		// Writes each element in the list scores[] to the txt file
		for (int i = 0; i < 10; i++) {
			writer.write(scores[i]);
			writer.newLine();
			writer.flush();
		}

	}// end writeTo

	@Override
	// What happens when re is called
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// What is painted when game is on
		if (menu == 4 || menu == 3) {
			// drawing background
			g.drawImage(Photo.gameImage, 0, 0, 1100, 700, null);
			// drawing enetities
			for (int i = 95; i > 0; i--) {
				// enemy shooter
				if (i <= 10) {
					// no damage
					if (varList[i][2] == 3)
						g.drawImage(Photo.shooter1Image, varList[i][0], varList[i][1], 50, 50, null);
					// 1 damage
					else if (varList[i][2] == 2)
						g.drawImage(Photo.shooter2Image, varList[i][0], varList[i][1], 50, 50, null);
					// 2 damage
					else if (varList[i][2] == 1)
						g.drawImage(Photo.shooter3Image, varList[i][0], varList[i][1], 50, 50, null);
					// enemy follower
				} else if (i <= 15) {
					// no damage
					if (varList[i][2] == 7)
						g.drawImage(Photo.bomb1Image, varList[i][0], varList[i][1], 50, 50, null);
					// 1 damage
					else if (varList[i][2] == 6)
						g.drawImage(Photo.bomb2Image, varList[i][0], varList[i][1], 50, 50, null);
					// 2 damage
					else if (varList[i][2] == 5)
						g.drawImage(Photo.bomb3Image, varList[i][0], varList[i][1], 50, 50, null);
					// 3 damage
					else if (varList[i][2] == 4)
						g.drawImage(Photo.bomb4Image, varList[i][0], varList[i][1], 50, 50, null);
					// 4 damage
					else if (varList[i][2] == 3)
						g.drawImage(Photo.bomb5Image, varList[i][0], varList[i][1], 50, 50, null);
					// 5 damage
					else if (varList[i][2] == 2)
						g.drawImage(Photo.bomb6Image, varList[i][0], varList[i][1], 50, 50, null);
					// 6 damage
					else if (varList[i][2] == 1)
						g.drawImage(Photo.bomb7Image, varList[i][0], varList[i][1], 50, 50, null);
					// enemy bullet
				} else {
					g.drawImage(Photo.bulletImage, varList[i][0], varList[i][1], 10, 10, null);
				}

			}
			// bullets
			for (int i = 0; i < 10; i++) {
				if (bulList[i][0] >= 0) {
					g.drawImage(Photo.shotImage, bulList[i][0], bulList[i][1], 10, 10, null);
				}
			}
			// player hp bar and colors
			if (playerHP > 66)
				g.setColor(Color.GREEN);
			else if (playerHP > 33)
				g.setColor(Color.YELLOW);
			else if (playerHP >= 0)
				g.setColor(Color.RED);
			g.fillRect(736, 53, playerHP * 3, 40);
			// timer bar and colors
			g.setColor(Color.GREEN);
			if (colorTime == 1)
				g.setColor(Color.RED);
			g.fillRect(736, 131, (int) (120000 + gameTimer - System.currentTimeMillis()) / 400, 40);
			g.drawImage(Photo.playerImage, playerx, playery, 50, 50, null);
			// player health label
			if (playerHP == 100)
				lblHealth.setText("" + playerHP + "%");
			else if (playerHP >= 10)
				lblHealth.setText(" " + playerHP + "%");
			else
				lblHealth.setText("  " + playerHP + "%");
			// time remaining label
			lblTime.setText("" + ((120000 + gameTimer - System.currentTimeMillis()) / 1000));
			lblHealth.setBounds(886, 57, 200, 30);
			lblTime.setBounds(886, 137, 200, 30);
			lblScoreCur.setBounds(736, 201, 200, 30);
			// adding player score, health, time counters
			this.add(lblScoreCur);
			this.add(lblHealth);
			this.add(lblTime);
			// main menu
		} else if (menu == 0) {
			// adding main menu background
			g.drawImage(Photo.menuImage, 0, 0, 1100, 700, null);
			// removing everything not on main menu
			this.remove(lblScore1);
			this.remove(lblScore2);
			this.remove(lblScore3);
			this.remove(lblScore4);
			this.remove(lblScore5);
			this.remove(lblScore6);
			this.remove(lblScore7);
			this.remove(lblScore8);
			this.remove(lblScore9);
			this.remove(lblScore10);
			this.remove(btnStand);
			this.remove(btnCheat);
			this.remove(btnEnter);
			this.remove(txtPlayer);
			this.remove(btnBack);
			this.remove(lblScoreCur);
			// adding play, socre, and instruction buttons
			btnGame.setBounds(450, 280, 200, 40);
			btnInst.setBounds(450, 340, 200, 40);
			btnScore.setBounds(450, 400, 200, 40);
			this.add(btnGame);
			this.add(btnInst);
			this.add(btnScore);
			// enter name menu
		} else if (menu == 1) {
			// adding background
			g.drawImage(Photo.nameImage, 0, 0, 1100, 700, null);
			// removing everything not on name menu
			this.remove(btnInst);
			this.remove(btnScore);
			this.remove(btnGame);
			// adding back, enter, and textfeild
			btnBack.setBounds(950, 630, 100, 20);
			txtPlayer.setBounds(500, 300, 100, 20);
			btnEnter.setBounds(500, 350, 100, 20);
			this.add(btnBack);
			this.add(btnEnter);
			// making sure textfeild is only added once
			if (TxtActive != 1)
				this.add(txtPlayer);
			TxtActive = 1;
			// choosing game type menu
		} else if (menu == 2) {
			// adding background
			g.drawImage(Photo.typeImage, 0, 0, 1100, 700, null);
			// removing stuff that are not on menu
			this.remove(btnEnter);
			this.remove(txtPlayer);
			// adding cheat and standard button
			btnCheat.setBounds(500, 400, 100, 20);
			btnStand.setBounds(500, 350, 100, 20);
			btnBack.setBounds(950, 630, 100, 20);
			this.add(btnStand);
			this.add(btnCheat);
			this.add(btnBack);
			// instruction menu
		} else if (menu == 5) {
			// drawing background
			g.drawImage(Photo.instImage, 0, 0, 1100, 700, null);
			// removing stuff not on instruction menu
			this.remove(btnInst);
			this.remove(btnScore);
			this.remove(btnGame);
			// adding back button
			btnBack.setBounds(950, 630, 100, 20);
			this.add(btnBack);
			// score menu
		} else if (menu == 6) {
			// removing stuff not on score menu
			this.remove(btnGame);
			this.remove(btnInst);
			this.remove(btnScore);
			// adding background
			g.drawImage(Photo.scoreImage, 0, 0, 1100, 700, null);
			// adding scores and back button
			lblScore1.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore2.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore3.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore4.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore5.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore6.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore7.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore8.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore9.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore10.setFont(new Font("Courier New", Font.PLAIN, 12));
			lblScore1.setForeground(Color.white);
			lblScore2.setForeground(Color.white);
			lblScore3.setForeground(Color.white);
			lblScore4.setForeground(Color.white);
			lblScore5.setForeground(Color.white);
			lblScore6.setForeground(Color.white);
			lblScore7.setForeground(Color.white);
			lblScore8.setForeground(Color.white);
			lblScore9.setForeground(Color.white);
			lblScore10.setForeground(Color.white);
			lblScore1.setBounds(385, 156, 500, 30);
			lblScore1.setText(scores[0]);
			lblScore2.setBounds(385, 196, 500, 30);
			lblScore2.setText(scores[1]);
			lblScore3.setBounds(385, 236, 500, 30);
			lblScore3.setText(scores[2]);
			lblScore4.setBounds(385, 276, 500, 30);
			lblScore4.setText(scores[3]);
			lblScore5.setBounds(385, 316, 500, 30);
			lblScore5.setText(scores[4]);
			lblScore6.setBounds(385, 356, 500, 30);
			lblScore6.setText(scores[5]);
			lblScore7.setBounds(385, 396, 500, 30);
			lblScore7.setText(scores[6]);
			lblScore8.setBounds(385, 436, 500, 30);
			lblScore8.setText(scores[7]);
			lblScore9.setBounds(385, 476, 500, 30);
			lblScore9.setText(scores[8]);
			lblScore10.setBounds(385, 516, 500, 30);
			lblScore10.setText(scores[9]);
			btnBack.setBounds(950, 630, 100, 20);
			this.add(lblScore1);
			this.add(lblScore2);
			this.add(lblScore3);
			this.add(lblScore4);
			this.add(lblScore5);
			this.add(lblScore6);
			this.add(lblScore7);
			this.add(lblScore8);
			this.add(lblScore9);
			this.add(lblScore10);
			this.add(btnBack);
			// Victory screen
		} else if (menu == 7) {
			// drawing background
			g.drawImage(Photo.vicImage, 0, 0, 1100, 700, null);
			// removing health and time label
			this.remove(lblHealth);
			this.remove(lblTime);
			// adding score and back button
			lblScoreCur.setText("" + score);
			lblScoreCur.setBounds(548, 350, 500, 30);
			this.add(lblScoreCur);
			btnBack.setBounds(500, 400, 100, 20);
			this.add(btnBack);
			lblScoreCur.setText("" + score);
			// Defeat screen
		} else if (menu == 8) {
			// drawing background
			g.drawImage(Photo.defImage, 0, 0, 1100, 700, null);
			// removing health and time label
			this.remove(lblHealth);
			this.remove(lblTime);
			// adding score and back button
			lblScoreCur.setText("" + score);
			lblScoreCur.setBounds(548, 350, 500, 30);
			this.add(lblScoreCur);
			btnBack.setBounds(500, 400, 100, 20);
			this.add(btnBack);
		}
	}// end paintComponent

	@Override
	// Main game thread
	public void run() {
		// initiating methods
		this.scoreinit();
		this.button();
		// game goes on
		boolean isOpen = true;
		// menu starting at 0
		menu = 0;
		while (isOpen) {
			// main menu
			if (menu == 0) {
				this.repaint();
			}
			// instruction menu
			else if (menu == 5) {
				this.repaint();
			}
			// score menu
			else if (menu == 6) {
				this.repaint();
			}
			// game type choosing menu
			else if (menu == 2) {
				this.repaint();
			}
			// name entering menu
			else if (menu == 1) {
				this.repaint();
			}
			// cheat game
			else if (menu == 4) {
				// removing unnecessary buttons
				this.remove(btnBack);
				this.remove(btnStand);
				this.remove(btnCheat);
				// game setup
				this.gameSetup();
				// game loop win condition stops loop
				while (System.currentTimeMillis() - 120000 <= gameTimer) {
					// 60 seconds + easy mode
					if (System.currentTimeMillis() - 60000 >= gameTimer) {
						spawnDelay = 2000;
						colorTime = 1;
					}
					// hard mode
					else {
						spawnDelay = 4000;
						colorTime = 0;
					}
					// setting text on score label
					lblScoreCur.setText(score + "");
					// running game methods
					this.hitdetect();
					this.shoot();
					this.entitySpawn();
					this.entityupdate();
					this.bulletupdate();
					this.playerupdate();
					// keeping score above 0
					if (score < 0)
						score = 0;
					this.repaint();
					// delay
					try {

						Thread.sleep(9L);
					} catch (InterruptedException e) {
						System.err.println(e.toString());
					}
				}
				// making score comparable
				s = playername;
				for (int j = 0; j < 40 - playername.length(); j++)
					s += " ";
				s += " " + score;
				// adding score to scoreboard if in top 10
				for (int i = 0; i < 10; i++) {
					if (s.length() > scores[i].length()) {
						for (int j = 8; j >= i; j--)
							scores[j + 1] = scores[j];
						scores[i] = s;
						break;
					} else if (s.length() == scores[i].length()) {
						if (s.substring(19).compareTo(scores[i].substring(19)) > 0) {
							for (int j = 8; j >= i; j--)
								scores[j + 1] = scores[j];
							scores[i] = s;
							break;
						}
					}
				}
				try {
					this.writeTo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// if win
				if (playerHP > 0) {
					menu = 7;

				}
				// if lose
				else if (playerHP <= 0) {
					menu = 8;

				}
			}
			// normal game mode, same as cheat except while loop has second
			// break condition
			else if (menu == 3) {
				this.remove(btnBack);
				this.remove(btnStand);
				this.remove(btnCheat);
				this.remove(btnGame);
				this.remove(btnInst);
				this.remove(btnScore);
				this.gameSetup();
				// same as cheat except it ends if player hp goes below 0
				while (playerHP > 0 && System.currentTimeMillis() - 120000 <= gameTimer) {
					if (System.currentTimeMillis() - 60000 >= gameTimer) {
						spawnDelay = 2000;
						colorTime = 1;
					} else {
						spawnDelay = 4000;
						colorTime = 0;
					}
					lblScoreCur.setText(score + "");

					this.shoot();
					this.entitySpawn();
					this.entityupdate();
					this.bulletupdate();
					this.playerupdate();
					this.hitdetect();
					if (score < 0)
						score = 0;
					this.repaint();
					try {

						Thread.sleep(9L);
					} catch (InterruptedException e) {
						System.err.println(e.toString());
					}
				}
				s = playername;
				for (int j = 0; j < 40 - playername.length(); j++)
					s += " ";
				s += " " + score;
				for (int i = 0; i < 10; i++) {
					if (s.length() > scores[i].length()) {
						for (int j = 8; j >= i; j--)
							scores[j + 1] = scores[j];
						scores[i] = s;
						break;
					} else if (s.length() == scores[i].length()) {
						if (s.substring(19).compareTo(scores[i].substring(19)) > 0) {
							for (int j = 8; j >= i; j--)
								scores[j + 1] = scores[j];
							scores[i] = s;
							break;
						}
					}
				}
				try {
					this.writeTo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (playerHP > 0) {
					menu = 7;

				} else if (playerHP <= 0) {
					menu = 8;

				}

			}
			// victory menu
			else if (menu == 8) {
				this.repaint();
			}
			// defeat menu
			else if (menu == 7) {
				this.repaint();
			}
		}
	}

	// sets up variables before game starts
	public void gameSetup() {
		score = 0;
		playerMove = 0;
		spawnDelay = 5000;
		gameTimer = System.currentTimeMillis();
		playerx = 325;
		playery = 325;
		for (int i = 0; i < 96; i++)
			avaliUnits[i] = 0;
		playerHP = 100;
		for (int i = 0; i < 96; i++) {
			for (int j = 0; j != 3; j++) {
				varList[i][j] = -50;
			}
		}
		for (int i = 0; i < 10; i++) {
			bulList[i][0] = bulList[i][1] = bulList[i][2] = -50;
		}
	}

	// Controls when entities spawn
	public void entitySpawn() {
		// timer for spawn delay
		if (spawnTimer == 0 || System.currentTimeMillis() - spawnDelay >= spawnTimer) {
			spawnTimer = System.currentTimeMillis();
			// generating random enemy type
			int a = (int) (Math.random() * 3);
			int num = 0;
			if (a == 0) {
				// finding available units for one direction shooter type
				for (int i = 1; i < 6; i++) {
					num = -2;
					if (avaliUnits[i] == 0) {
						avaliUnits[i] = 1;
						num = i;
						break;
					}
				}
			}
			// finding available units for other direction shooter type
			if (a == 1) {
				num = -2;
				for (int i = 6; i < 11; i++) {
					if (avaliUnits[i] == 0) {
						avaliUnits[i] = 1;
						num = i;
						break;
					}
				}
			}
			// finding available units for following type
			if (a == 2) {
				num = -2;
				for (int i = 11; i < 16; i++)
					if (avaliUnits[i] == 0) {
						avaliUnits[i] = 1;
						num = i;
						break;
					}
			}
			// generating where entity spawns
			int side = (int) (Math.random() * 650), length = (int) (Math.random() * 2) * 650;
			if (num < 6 && num != -2) {
				varList[num][0] = length;
				varList[num][1] = side;
				if (length == 650)
					varList[num][3] = 1;
				else
					varList[num][3] = -1;
			} else if (num < 11 && num != -2) {
				varList[num][0] = side;
				varList[num][1] = length;
				if (length == 650)
					varList[num][3] = 1;
				else
					varList[num][3] = -1;
			} else if (num < 16 && num != -2) {
				varList[num][0] = side;
				varList[num][1] = length;
			}
			// how much hp enties have
			if (num != -2 && num < 10) {
				varList[num][2] = 3;
			} else if (num != -2 && num < 15) {
				varList[num][2] = 7;
			}
		}
	}

	// Checking if 2 things hit each other
	public void hitdetect() {
		// enemy hit detection
		for (int i = 1; i < 96; i++) {
			if (i <= 15 && varList[i][2] > 0) {
				if (Math.pow(varList[i][0] - playerx,2) + Math.pow(varList[i][1]-playery,2) <= 2500) {
					// health and score lost to colliding
					varList[i][2] = -2;
					if (i <= 10) {
						score -= 250;
						playerHP -= 20;
					} else if (i <= 15) {
						score -= 500;
						playerHP -= 25;
					}
				}
			}
			else if (varList[i][2] > 0){
				if (Math.pow((varList[i][0] + 5) - (playerx + 25),2) + Math.pow((varList[i][1]+5) - (playery + 25),2) <= 900) {
					// health and score lost to colliding
					varList[i][2] = -2;
					score -= 100;
					playerHP -= 4;
				}
			}
			// bullet hit detection
			for (int j = 0; j < 9; j++) {
				if (i<=15 && varList[i][2] > 0) {
					if (Math.pow((varList[i][0]+25) - (bulList[j][0]+5),2) + Math.pow((varList[i][1]+25) - (bulList[j][1]+5),2) <= 900){
						// score gain and enemy despawn
						bulList[j][0] = bulList[j][1] = -50;
						bulList[j][2] = 0;
						varList[i][2] -= 1;
						score += 50;
					}
				}
			}
			// moving away entities that died
			if (varList[i][2] <= 0) {
				varList[i][2] = -2;
				varList[i][0] = -80;
				varList[i][1] = -80;
				avaliUnits[i] = 0;

			}

		}
	}

	// generating bullets shot from player
	public void shoot() {
		if (shooting == true) {
			for (int i = 0; i < 10; i++) {
				if (bulList[i][0] < 0) {
					bulList[i][0] = playerx + 20;
					bulList[i][1] = playery + 20;
					bulList[i][2] = shootDir;
					shooting = false;
					break;
				}
			}
		}
	}

	// enemy bullets firing
	public void bulletupdate() {
		boolean bullet;
		//checking if each bullet from the shooter exists
		for (int i = 1; i < 11; i++) {
			if (varList[i][2] >= 0) {
				bullet = false;
				for (int j = 1; j != 9; j++) {

					if (varList[15 + (i - 1) * 8 + j][2] > 0) {
						bullet = true;
					}

				}
				// generating new enemy bullets
				if (bullet == false) {
					for (int j = 1; j < 9; j++) {
						varList[15 + (i - 1) * 8 + j][2] = 1;
						varList[15 + (i - 1) * 8 + j][0] = varList[i][0] + 20;
						varList[15 + (i - 1) * 8 + j][1] = varList[i][1] + 20;
						varList[15 + (i - 1) * 8 + j][3] = j;
					}
				}
			}
		}
	}

	//updating player position based on player keys
	public void playerupdate() {
		if (playerMove == 1 && playery >= 0)
			playery -= 3;
		else if (playerMove == 2 && playery <= 650)
			playery += 3;
		else if (playerMove == 3 && playerx >= 0)
			playerx -= 3;
		else if (playerMove == 4 && playerx <= 650)
			playerx += 3;
		for (int i = 0; i < 10; i++) {
			if (bulList[i][0] >= 0) {
				if (bulList[i][2] != 0) {
				}
				if (bulList[i][2] == 1)
					bulList[i][0] -= 5;
				else if (bulList[i][2] == 2)
					bulList[i][1] -= 5;
				else if (bulList[i][2] == 3)
					bulList[i][0] += 5;
				else if (bulList[i][2] == 4)
					bulList[i][1] += 5;

			}
			//updating bullets position based on direction
			if (bulList[i][0] < 0 || bulList[i][0] > 700 || bulList[i][1] < 0 || bulList[i][1] > 700
					|| bulList[i][2] == 0) {
				bulList[i][2] = 0;
				bulList[i][0] = -80;
				bulList[i][1] = -80;
			}
		}
	}
	// Hi yc0lt
	//reading scores from file 
	public void scoreinit() {
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(filePath + "scores.txt"));
			int i = 0;
			while (i < 10) {
				//storing each score of the top 10 in an element of scores[]
				line = reader.readLine();
				scores[i] = line;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//updating entities
	public void entityupdate() {

		//checking all enemy entities
		for (int i = 0; i != 96; i++) {
			if (varList[i][2] > 0) {
				//shooting
				if (i < 6) {
					if (varList[i][0] == 650 || varList[i][0] == 0)
						varList[i][3] *= -1;
					varList[i][0] += varList[i][3];
				} 
				//shooting
				else if (i < 11) {
					if (varList[i][1] == 650 || varList[i][1] == 0)
						varList[i][3] *= -1;
					varList[i][1] += varList[i][3];
				} 
				//following
				else if (i < 16) {
					if (playerx > varList[i][0]) {
						varList[i][0] += 1;
					}
					if (playerx < varList[i][0]) {
						varList[i][0] -= 1;
					}
					if (playery > varList[i][1]) {
						varList[i][1] += 1;
					}
					if (playery < varList[i][1]) {
						varList[i][1] -= 1;
					}
				} 
				//bullets
				else if (i < 96) {
					if (varList[i][3] == 1) {
						varList[i][0] -= 3;
					} else if (varList[i][3] == 2) {
						varList[i][0] -= 3;
						varList[i][1] -= 3;
					} else if (varList[i][3] == 3) {
						varList[i][1] -= 3;
					} else if (varList[i][3] == 4) {
						varList[i][0] += 3;
						varList[i][1] -= 3;
					} else if (varList[i][3] == 5) {
						varList[i][0] += 3;
					} else if (varList[i][3] == 6) {
						varList[i][0] += 3;
						varList[i][1] += 3;
					} else if (varList[i][3] == 7) {
						varList[i][1] += 3;
					} else if (varList[i][3] == 8) {
						varList[i][0] -= 3;
						varList[i][1] += 3;
					}
					// if bullets go over the boundaries, they disapear
					if (varList[i][0] < 0 || varList[i][0] > 700 || varList[i][1] < 0 || varList[i][1] > 700) {
						varList[i][2] = -2;
						varList[i][0] = -80;
						varList[i][1] = -80;
					}

				}
			}
		}

	}
}
