import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CreateHotelGUI extends JPanel {
    private JPanel parentPanel;

    private JPanel panelTitle;
    private JButton logoButton;
    private JLabel title;

    private JPanel panelSelection;
    private JLabel newHotelLabel;
    private JTextField newHotelTextField;
    private JButton submitButton;

    private JPanel containerForFeedbackLabel;
    private JLabel creationFeedback;

    private JPanel panelFooter;
    private JButton MainMenuButton;

    private static Color black = new Color(0, 0, 0);
    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static ImageIcon fullLogoImageIcon = new ImageIcon("./photos/OpulenceOasisFullLogo.png");

    public CreateHotelGUI() {
        parentPanel = new JPanel();

        Image fullLogoImage = fullLogoImageIcon.getImage();
        Image scaledfullLogoIcon = fullLogoImage.getScaledInstance(275, 275,  java.awt.Image.SCALE_SMOOTH);
        fullLogoImageIcon = new ImageIcon(scaledfullLogoIcon);
        
        parentPanel.setBorder(new EmptyBorder(0,0, 0, 0));
        parentPanel.setBackground(paleGreen1);

        panelTitle = new JPanel();
        logoButton = new JButton();
        title = new JLabel("Create Hotel");

        panelTitle.setBackground(beige);
        panelTitle.setBorder(new EmptyBorder(75, 0, 75, 0));
        panelTitle.setBackground(beige);
        // panelTitle.setLayout(new GridLayout(1, 2));
        logoButton.setIcon(fullLogoImageIcon);
        logoButton.setBorderPainted(false);
        logoButton.setBackground(null);
        logoButton.setBorder(null);
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(90f);
			title.setFont(font);
            title.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 90);
            title.setFont(font);
            title.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        
        panelSelection = new JPanel();
        newHotelLabel = new JLabel("Enter Name of Hotel:");
        newHotelTextField = new JTextField();
        submitButton = new JButton("Submit");
        creationFeedback = new JLabel("<html>Success! <b>Hotel [hotel_name]</b> created!</html>");

        panelFooter = new JPanel();
        MainMenuButton = new JButton("Main Menu");

        newHotelTextField.setForeground(darkBlue1);
        
        panelSelection.setBackground(paleGreen1);
        panelSelection.setLayout(new GridLayout(4, 1));
        panelFooter.setBackground(paleGreen1);
        panelFooter.setLayout(new GridLayout(4, 1));
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(25f);
            newHotelLabel.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 25);
            newHotelLabel.setFont(font);
        } try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(30f);
            submitButton.setFont(font);
            creationFeedback.setFont(font);
            MainMenuButton.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 30);
            submitButton.setFont(font);
            creationFeedback.setFont(font);
            MainMenuButton.setFont(font);
        } try {
			File fontStyle = new File("./fonts/NotoSerif-ThinItalic.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(30f);
            newHotelTextField.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 30);
            newHotelTextField.setFont(font);
        }

        newHotelLabel.setForeground(beige);
        newHotelTextField.setBackground(beige);
        newHotelTextField.setForeground(darkBlue1);
        submitButton.setBackground(darkBlue1);
        submitButton.setBorder(null);
        submitButton.setForeground(beige);
        submitButton.setPreferredSize(new Dimension(200, 60));
        MainMenuButton.setBackground(darkBlue1);
        MainMenuButton.setBorder(null);
        MainMenuButton.setForeground(beige);
        MainMenuButton.setPreferredSize(new Dimension(300, 60));

        containerForFeedbackLabel = new JPanel();
        containerForFeedbackLabel.add(creationFeedback);
        containerForFeedbackLabel.setBorder(new EmptyBorder(5, 5, 5, 250));
        containerForFeedbackLabel.setBackground(beige);
        containerForFeedbackLabel.setVisible(false);
        creationFeedback.setForeground(black);

        panelTitle.add(logoButton);
        panelTitle.add(title);

        panelSelection.add(newHotelLabel);
        panelSelection.add(newHotelTextField);
        panelSelection.add(submitButton);

        panelFooter.add(containerForFeedbackLabel);
        panelFooter.add(MainMenuButton);

        parentPanel.setLayout(new GridLayout(2,1));
        panelSelection.setBorder(new EmptyBorder(75, 100, 0, 100));
        panelFooter.setBorder(new EmptyBorder(0, 700, 0, 30));
        
        JPanel idk = new JPanel();

        idk.setLayout(new GridLayout(2,1));
        idk.setBorder(new EmptyBorder(0, 0, 0, 0));
        idk.add(panelSelection, BorderLayout.NORTH);
        idk.add(panelFooter, BorderLayout.SOUTH);

        parentPanel.add(panelTitle, BorderLayout.NORTH);
        parentPanel.add(idk, BorderLayout.SOUTH);

    }


    public JButton getlogoButton() {
        return logoButton;
    }

    public JPanel getParentPanel(){
        return parentPanel;
    }

    public JLabel getnewHotelLabel() {
        return newHotelLabel;
    }
    public JTextField getnewHotelTextField() {
        return newHotelTextField;
    }
    public JButton getsubmitButton() {
        return submitButton;
    }
    public JLabel getcreationFeedback() {
        return creationFeedback;
    }
    public JPanel getpanelFooter() {
        return panelFooter;
    }
    public JButton getMainMenuButton() {
        return MainMenuButton;
    }
    public JPanel getcontainerForFeedbackLabel() {
        return containerForFeedbackLabel;
    }
}
