import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewHotelGUI extends JPanel {
    private JPanel parentPanel;

    private JPanel panelTitle;
    private JButton logoButton;
    private JLabel title;

    private JPanel panelSelection;
    private JButton ViewHighLevelHotelInformation;
    private JButton ViewHotelsAvailableandBookedRooms;
    private JButton ViewInfoOfSelectedRoom;
    private JButton ViewInfoOfSelectedReservation;

    private JButton MainMenuButton;

    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);;
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static ImageIcon fullLogoImageIcon = new ImageIcon("./photos/OpulenceOasisFullLogo.png");

    public ViewHotelGUI() {
        parentPanel = new JPanel();

        Image fullLogoImage = fullLogoImageIcon.getImage();
        Image scaledfullLogoIcon = fullLogoImage.getScaledInstance(275, 275,  java.awt.Image.SCALE_SMOOTH);
        fullLogoImageIcon = new ImageIcon(scaledfullLogoIcon);
        
        parentPanel.setBorder(new EmptyBorder(0,0, 0, 0));
        parentPanel.setBackground(paleGreen1);

        panelTitle = new JPanel();
        logoButton = new JButton();
        title = new JLabel("View Hotel");
        MainMenuButton = new JButton("Main Menu");
        panelTitle.setBackground(beige);
        panelTitle.setBorder(new EmptyBorder(75, 250, 75, 250));
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
        ViewHighLevelHotelInformation = new JButton("View High Level Hotel Information");
        ViewHotelsAvailableandBookedRooms = new JButton("View Hotel's Available and Booked Rooms");
        ViewInfoOfSelectedRoom = new JButton("View Info of Selected Room");
        ViewInfoOfSelectedReservation = new JButton("View Info of Selected Reservation");
        panelSelection.setBorder(new EmptyBorder(75, 0, 0, 0));
        panelSelection.setBackground(paleGreen1);
        panelSelection.setLayout(new GridLayout(6, 1));
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(30f);
            ViewHighLevelHotelInformation.setFont(font);
            ViewHotelsAvailableandBookedRooms.setFont(font);
            ViewInfoOfSelectedRoom.setFont(font);
            ViewInfoOfSelectedReservation.setFont(font);
            MainMenuButton.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 30);
            ViewHighLevelHotelInformation.setFont(font);
            ViewHotelsAvailableandBookedRooms.setFont(font);
            ViewInfoOfSelectedRoom.setFont(font);
            ViewInfoOfSelectedReservation.setFont(font);
            MainMenuButton.setFont(font);
        }

        ViewHighLevelHotelInformation.setBackground(paleGreen1);
        ViewHighLevelHotelInformation.setBorder(null);
        ViewHighLevelHotelInformation.setForeground(beige);
        ViewHotelsAvailableandBookedRooms.setBackground(paleGreen1);
        ViewHotelsAvailableandBookedRooms.setBorder(null);
        ViewHotelsAvailableandBookedRooms.setForeground(beige);
        ViewInfoOfSelectedRoom.setBackground(paleGreen1);
        ViewInfoOfSelectedRoom.setBorder(null);
        ViewInfoOfSelectedRoom.setForeground(beige);
        ViewInfoOfSelectedReservation.setBackground(paleGreen1);
        ViewInfoOfSelectedReservation.setBorder(null);
        ViewInfoOfSelectedReservation.setForeground(beige);
        ViewHighLevelHotelInformation.setPreferredSize(new Dimension(700, 60));
        ViewHighLevelHotelInformation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ViewHotelsAvailableandBookedRooms.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ViewInfoOfSelectedRoom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ViewInfoOfSelectedReservation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        MainMenuButton.setBackground(darkBlue1);
        MainMenuButton.setBorder(null);
        MainMenuButton.setForeground(beige);
        MainMenuButton.setSize(new Dimension(300, 60));
        

        panelTitle.add(logoButton);
        panelTitle.add(title);

        panelSelection.add(ViewHighLevelHotelInformation);
        panelSelection.add(ViewHotelsAvailableandBookedRooms);
        panelSelection.add(ViewInfoOfSelectedRoom);
        panelSelection.add(ViewInfoOfSelectedReservation);
        panelSelection.add(new JLabel());
        panelSelection.add(MainMenuButton);

        parentPanel.add(panelTitle, BorderLayout.NORTH);
        parentPanel.add(panelSelection, BorderLayout.CENTER);
    }

    public JButton getlogoButton() {
        return logoButton;
    }

    public JPanel getParentPanel(){
        return parentPanel;
    }

    public JButton getBtnViewHighLevelHotelInformation() {
        return ViewHighLevelHotelInformation;
    }
    public JButton getBtnViewHotelsAvailableandBookedRooms() {
        return ViewHotelsAvailableandBookedRooms;
    }
    public JButton getBtnViewInfoOfSelectedRoom() {
        return ViewInfoOfSelectedRoom;
    }
    public JButton getBtnViewInfoOfSelectedReservation() {
        return ViewInfoOfSelectedReservation;
    }
    public JButton getMainMenuButton() {
        return MainMenuButton;
    }
}
