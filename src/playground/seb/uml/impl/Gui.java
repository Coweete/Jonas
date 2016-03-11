package playground.seb.uml.impl;

import collections.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jonatan Fridsten, Johnatan Sona, Gustaf Bohlin
 * This is the class containing all Graphical components
 */
public class Gui extends JFrame implements ActionListener, IGUI {
    private String currentUser;
    private IController ctrl;
    private JTextArea textArea = new JTextArea();
    private JButton changeUser = new JButton("Byta användare"), borrow = new JButton("Låna bok"), returnBook = new JButton("Lämna tillbaka");
    private JTextField textFieldUser = new JTextField(10), textFieldBorrow = new JTextField(10), textFieldReturn = new JTextField(10);

    public Gui(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setLayout(new GridLayout(4, 0, 0, 10));
        textFieldUser.setEditable(false);

		changeUser.addActionListener(this);
		borrow.addActionListener(this);
		returnBook.addActionListener(this);

        add(basicJPanel("PersonNr", textFieldUser, changeUser, "Användare"));
        add(basicJPanel("Media ID", textFieldBorrow, borrow, "Låna"));
        add(basicJPanel("Media ID", textFieldReturn, returnBook, "Lämna tillbaka"));
        add(panelList("Media", textArea, "Lista av media objekt"));
        pack();
    }

    /**
     * @author Gustaf Bohlin, Johnatan Sona
     * Creates a basic JPanel
     * @param labelInfo text on the label
     * @param textField what textfield to put in panel
     * @param button what button to put in panel
     * @param borderString text on the border
     * @return the actual panel
     */
    private JPanel basicJPanel(String labelInfo, JTextField textField,JButton button, String borderString) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelButton = new JPanel();
        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel(labelInfo);
        panelButton.add(button);
        panelLabel.add(label);

        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), borderString);
        panel.add(panelLabel, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(panelButton, BorderLayout.EAST);
        panel.setBorder(border);
        return panel;
    }

    /**
     * @author Jonatan Fridsten
     * A JPanel containing the list with mediaobjects
     * @param label text on the label
     * @param txtList the text area
     * @param borderString text on the border
     * @return the actual panel
     */
    public JPanel panelList(String label, JTextArea txtList, String borderString){
        JPanel panel = new JPanel();
        JLabel lblText = new JLabel(label);
        JScrollPane spText = new JScrollPane(txtList);
        spText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new BorderLayout());
        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.black), borderString);
        panel.setBorder(border);
        panel.add(lblText,BorderLayout.WEST);
        panel.add(spText,BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeUser) {
			ctrl.logout();
        }
        else if(e.getSource() == borrow) {
			ctrl.borrow(textFieldBorrow.getText());
        }
        else if(e.getSource() == returnBook) {
            ctrl.returnBook(textFieldBorrow.getText());
        }
    }

    @Override
    public void setController(IController controller) {
        ctrl = controller;
    }

    @Override
    public void updateMemberServiceFromView() {
        ctrl.getMemberService().setCurrentUserID(currentUser);
    }

    @Override
    public void updateViewFromMemberService() {
        textFieldUser.setText(ctrl.getMemberService().getCurrentUser().getName());
    }

    @Override
    public void updateViewFromMediaService() {
		StringBuilder builder = new StringBuilder();
		ArrayList<Media> loan = ctrl.getMemberService().getCurrentUser().getLoan();
		for (int i = 0; i < loan.size(); i++) {
			builder.append(loan.get(i).getMediaID() + " , " + loan.get(i).getTitle() + "\n");
		}
		textArea.setText(builder.toString());
    }

    @Override
    public void openLogin() {
        currentUser = JOptionPane.showInputDialog(null, "Enter User");
        ctrl.login();
    }

    @Override
    public void closeLogin() {
        setVisible(true);
    }

    @Override
    public void openMainView() {
        setVisible(true);
    }

    @Override
    public void closeMainView() {
        setVisible(false);
    }

    @Override
    public void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
