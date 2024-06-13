import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListApp {
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField itemField;
    private JButton addButton;
    private JButton removeButton;

    public ShoppingListApp() {
        frame = new JFrame("Shopping List");
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        itemField = new JTextField(20);
        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Item");

        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set up the panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add components to the panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(itemField);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(removeButton, BorderLayout.SOUTH);

        // Add ActionListeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText().trim();
                if (!item.isEmpty()) {
                    listModel.addElement(item);
                    itemField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingListApp();
            }
        });
    }
}

