import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings("unused")
public class Photo {
	
	public static BufferedImage menuImage;
	public static BufferedImage bulletImage;
	public static BufferedImage nameImage;
	public static BufferedImage typeImage;
	public static BufferedImage scoreImage;
	public static BufferedImage instImage;
	public static BufferedImage vicImage;
	public static BufferedImage defImage;
	public static BufferedImage shotImage;
	public static BufferedImage gameImage;
	public static BufferedImage playerImage;
	public static BufferedImage shooter1Image;
	public static BufferedImage shooter2Image;
	public static BufferedImage shooter3Image;
	public static BufferedImage bomb1Image;
	public static BufferedImage bomb2Image;
	public static BufferedImage bomb3Image;
	public static BufferedImage bomb4Image;
	public static BufferedImage bomb5Image;
	public static BufferedImage bomb6Image;
	public static BufferedImage bomb7Image;
	
	public void loadAll() {
		try {
			// Storing images in variables
			vicImage = ImageIO.read(getClass().getResourceAsStream("vicImage.png"));
			defImage = ImageIO.read(getClass().getResourceAsStream("defImage.png"));
			typeImage = ImageIO.read(getClass().getResourceAsStream("typeImage.png"));
			nameImage = ImageIO.read(getClass().getResourceAsStream("nameImage.png"));
			menuImage = ImageIO.read(getClass().getResourceAsStream("menuImage.png"));
			gameImage = ImageIO.read(getClass().getResourceAsStream("gameImage.png"));
			shooter1Image = ImageIO.read(getClass().getResourceAsStream("shooter1Image.png"));
			shooter2Image = ImageIO.read(getClass().getResourceAsStream("shooter2Image.png"));
			shooter3Image = ImageIO.read(getClass().getResourceAsStream("shooter3Image.png"));
			bulletImage = ImageIO.read(getClass().getResourceAsStream("bulletImage.png"));
			bomb1Image = ImageIO.read(getClass().getResourceAsStream("bomb1Image.png"));
			bomb2Image = ImageIO.read(getClass().getResourceAsStream("bomb2Image.png"));
			bomb3Image = ImageIO.read(getClass().getResourceAsStream("bomb3Image.png"));
			bomb4Image = ImageIO.read(getClass().getResourceAsStream("bomb4Image.png"));
			bomb5Image = ImageIO.read(getClass().getResourceAsStream("bomb5Image.png"));
			bomb6Image = ImageIO.read(getClass().getResourceAsStream("bomb6Image.png"));
			bomb7Image = ImageIO.read(getClass().getResourceAsStream("bomb7Image.png"));
			shotImage = ImageIO.read(getClass().getResourceAsStream("shotImage.png"));
			playerImage = ImageIO.read(getClass().getResourceAsStream("playerImage.png"));
			scoreImage = ImageIO.read(getClass().getResourceAsStream("scoreImage.png"));
			instImage = ImageIO.read(getClass().getResourceAsStream("instImage.png"));

		} catch (IOException e) {
		} // end of catch exception

	}// end of loadAll
}// end of class Test1Photo
