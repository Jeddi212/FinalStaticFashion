package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static view.MainMenus.mindfullyFont;

public class ProductMenu {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelProduct = new JPanel();

    BoxLayout boxLayout = new BoxLayout(panelProduct, BoxLayout.Y_AXIS);

    JLabel lblTitle = new JLabel("Products");

    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public ProductMenu() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelProduct.setLayout(boxLayout);

        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));

        // Loop through product list
        for (int i = 0; i < 10; i++) {
            // Panel Declaration
            JPanel productContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelImg = new JPanel();
            JPanel panelDesc = new JPanel(new GridLayout(3, 1));
            JPanel panelDescRight = new JPanel(new GridLayout(3, 1));

            // Border Separator
            productContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension
            productContainer.setPreferredSize(new Dimension(1200, 200));
            panelImg.setPreferredSize(new Dimension(200, 200));
            panelDesc.setPreferredSize(new Dimension(590, 120));
            panelDescRight.setPreferredSize(new Dimension(500, 120));

            // Product Image
            JLabel labelImg = new JLabel(new ImageIcon("media/productIcon.png"));

            // Product Data
            // --> Name
            JLabel labelProductName = new JLabel("T-Shirt 3Second New Variant Red Mariant");
            labelProductName.setFont(new Font("Arial", Font.BOLD, 25));
            labelProductName.setForeground(Color.WHITE);

            // --> Brand
            JLabel labelProductBrand = new JLabel("Brand : 3Second");
            labelProductBrand.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductBrand.setForeground(Color.WHITE);

            // --> Category
            JLabel labelProductCategory = new JLabel("( T-Shirt )");
            labelProductCategory.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductCategory.setForeground(Color.WHITE);

            // --> Price
            JLabel labelProductPrice = new JLabel("Price : 120000");
            labelProductPrice.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductPrice.setForeground(Color.WHITE);

            // --> Size
            JLabel labelProductSize = new JLabel("Size : L");
            labelProductSize.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductSize.setForeground(Color.WHITE);

            // --> Store Name
            JLabel labelStoreName = new JLabel("Store Name : 3Second Official");
            labelStoreName.setFont(new Font("Arial", Font.PLAIN, 20));
            labelStoreName.setForeground(Color.WHITE);

            // Transparent background
            productContainer.setBackground(new Color(0,0,0, 0));
            panelImg.setBackground(new Color(0, 0, 0, 0));
            panelDesc.setBackground(new Color(0, 0, 0, 0));
            panelDescRight.setBackground(new Color(0,0,0, 0));

            // Add to main panel
            panelImg.add(labelImg);

            panelDesc.add(labelProductName);
            panelDesc.add(labelProductBrand);
            panelDesc.add(labelStoreName);

            panelDescRight.add(labelProductCategory);
            panelDescRight.add(labelProductSize);
            panelDescRight.add(labelProductPrice);

            productContainer.add(panelImg);
            productContainer.add(panelDesc);
            productContainer.add(panelDescRight);

            panelProduct.add(productContainer);
        }

        panelTitle.add(lblTitle);

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelProduct.setBackground(new Color(0,0,0,0));

        panel.setBackground(Color.BLACK);
        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(panelProduct, BorderLayout.CENTER);
        frame.add(scrollPane);

        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
