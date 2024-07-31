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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ManageHotelGUI extends JPanel {
    private JPanel parentPanel;

    private JPanel panelTitle;
    private JButton logoButton;
    private JLabel title;

    private JPanel panelSelection;
    private JButton ChangeNameofHotel;
    private JButton AddRooms;
    private JButton RemoveRooms;
    private JButton UpdateBasePriceofRooms;
    private JButton RemoveReservation;
    private JButton RemoveHotel;

    private JButton MainMenuButton;

    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static ImageIcon fullLogoImageIcon = new ImageIcon("./photos/OpulenceOasisFullLogo.png");

    public ManageHotelGUI() {
        parentPanel = new JPanel();

        Image fullLogoImage = fullLogoImageIcon.getImage();
        Image scaledfullLogoIcon = fullLogoImage.getScaledInstance(275, 275,  java.awt.Image.SCALE_SMOOTH);
        fullLogoImageIcon = new ImageIcon(scaledfullLogoIcon);
        
        parentPanel.setBorder(new EmptyBorder(0,0, 0, 0));
        parentPanel.setBackground(paleGreen1);

        panelTitle = new JPanel();
        logoButton = new JButton();
        title = new JLabel("Manage Hotel");
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
        ChangeNameofHotel = new JButton("Change Name of Hotel");
        AddRooms = new JButton("Add Rooms");
        RemoveRooms = new JButton("Remove Rooms");
        UpdateBasePriceofRooms = new JButton("Update Base Price of Rooms");
        RemoveReservation = new JButton("Remove Reservation");
        RemoveHotel = new JButton("Remove Hotel");
        MainMenuButton = new JButton("Main Menu");
        panelSelection.setBorder(new EmptyBorder(25, 0, 0, 0));
        panelSelection.setBackground(paleGreen1);
        panelSelection.setLayout(new GridLayout(8, 1));
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(30f);
            ChangeNameofHotel.setFont(font);
            AddRooms.setFont(font);
            RemoveRooms.setFont(font);
            UpdateBasePriceofRooms.setFont(font);
            RemoveReservation.setFont(font);
            RemoveHotel.setFont(font);
            MainMenuButton.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 30);
            ChangeNameofHotel.setFont(font);
            AddRooms.setFont(font);
            RemoveRooms.setFont(font);
            UpdateBasePriceofRooms.setFont(font);
            RemoveReservation.setFont(font);
            RemoveHotel.setFont(font);
            MainMenuButton.setFont(font);
        }

        ChangeNameofHotel.setBackground(paleGreen1);
        ChangeNameofHotel.setBorder(null);
        ChangeNameofHotel.setForeground(beige);
        AddRooms.setBackground(paleGreen1);
        AddRooms.setBorder(null);
        AddRooms.setForeground(beige);
        RemoveRooms.setBackground(paleGreen1);
        RemoveRooms.setBorder(null);
        RemoveRooms.setForeground(beige);
        UpdateBasePriceofRooms.setBackground(paleGreen1);
        UpdateBasePriceofRooms.setBorder(null);
        UpdateBasePriceofRooms.setForeground(beige);
        RemoveReservation.setBackground(paleGreen1);
        RemoveReservation.setBorder(null);
        RemoveReservation.setForeground(beige);
        RemoveHotel.setBackground(paleGreen1);
        RemoveHotel.setBorder(null);
        RemoveHotel.setForeground(beige);
        ChangeNameofHotel.setPreferredSize(new Dimension(700, 60));

        MainMenuButton.setBackground(darkBlue1);
        MainMenuButton.setBorder(null);
        MainMenuButton.setForeground(beige);
        MainMenuButton.setPreferredSize(new Dimension(300, 60));

        panelTitle.add(logoButton);
        panelTitle.add(title);

        panelSelection.add(ChangeNameofHotel);
        panelSelection.add(AddRooms);
        panelSelection.add(RemoveRooms);
        panelSelection.add(UpdateBasePriceofRooms);
        panelSelection.add(RemoveReservation);
        panelSelection.add(RemoveHotel);
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

    public JButton getBtnChangeNameofHotel() {
        return ChangeNameofHotel;
    }
    public JButton getBtnAddRooms() {
        return AddRooms;
    }
    public JButton getBtnRemoveRooms() {
        return RemoveRooms;
    }
    public JButton getBtnUpdateBasePriceofRooms() {
        return UpdateBasePriceofRooms;
    }
    public JButton getRemoveReservation() {
        return RemoveReservation;
    }
    public JButton getRemoveHotel() {
        return RemoveHotel;
    }
    public JButton getMainMenuButton() {
        return MainMenuButton;
    }
}
