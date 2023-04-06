import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Dialog5 extends JFrame {
    JTextField fld = new JTextField(20);
    JButton btnCopy = new JButton("Копіювати");
    JButton btnPrint = new JButton("Друкувати");
    JLabel lbl = new JLabel(" ");
    ArrayList<String> textList = new ArrayList<String>();

    Dialog5() {
        super("Копіювання тексту");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {}
        setSize(400, 200);
        Container c = getContentPane();

        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        middlePanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());

        topPanel.add(lbl, BorderLayout.NORTH);
        topPanel.add(fld, BorderLayout.CENTER);
        middlePanel.add(btnCopy, BorderLayout.CENTER);
        bottomPanel.add(btnPrint, BorderLayout.CENTER);

        c.add(topPanel, BorderLayout.NORTH);
        c.add(middlePanel, BorderLayout.CENTER);
        c.add(bottomPanel, BorderLayout.SOUTH);

        btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = fld.getText();
                lbl.setText("Скопійовано: " + text);
                textList.add(text); // Додати текст у список
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Збережений текст:");
                for (String text : textList) {
                    System.out.println(text);
                }
            }
        });


        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog5();
    }
}