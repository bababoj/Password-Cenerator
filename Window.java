import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    JTextArea passwordOutput;
    JScrollPane passwordOutputPane;
    JPanel mainPanel;
    JPanel subPanel;
    JLabel label;
    JSlider slider;

    JCheckBox upper, lower, numbers, symbols;


    JButton button;

    int length;

    PasswordGenerator passwordGenerator;



    public Window(){

        new JFrame("Password Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);

        gui();
        setVisible(true);

    }

    public void gui(){

        mainPanel = new JPanel();

        passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Arial", Font.BOLD, 34));

        passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordOutputPane.setPreferredSize(new Dimension(300, 60));
        mainPanel.add(passwordOutputPane, BorderLayout.NORTH);


        subPanel = new JPanel(new GridLayout(3, 2));

        label = new JLabel("Length:");
        subPanel.add(label);
        length = 8;

        slider = new JSlider(JSlider.HORIZONTAL, 6, 14, 8);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> length = slider.getValue());
        subPanel.add(slider);

        upper = new JCheckBox("UpperCase");
        lower = new JCheckBox("LowerCase");
        numbers = new JCheckBox("Numbers");
        symbols = new JCheckBox("Symbols");
        subPanel.add(upper);
        subPanel.add(lower);
        subPanel.add(numbers);
        subPanel.add(symbols);

        subPanel.setPreferredSize(new Dimension(300, 300));
        subPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        mainPanel.add(subPanel, BorderLayout.CENTER);
        passwordGenerator = new PasswordGenerator();

        button = new JButton("Generate");
        button.setPreferredSize(new Dimension(150, 50));
        button.setFocusable(false);
        button.setBackground(Color.PINK);
        button.addActionListener(e -> {
            if(length <= 0) return;
            boolean anySelected = lower.isSelected() ||
                    upper.isSelected() ||
                    numbers.isSelected() ||
                    symbols.isSelected();

            if(anySelected){
                String generatedPassword = passwordGenerator.generatePassword(length,
                        upper.isSelected(),
                        lower.isSelected(),
                        numbers.isSelected(),
                        symbols.isSelected());

                passwordOutput.setText(generatedPassword);
            }
        });


        mainPanel.add(button, BorderLayout.SOUTH);

        add(mainPanel);


    }


}
