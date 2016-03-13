package Jonas.View;

import Jonas.Controller.IController;
import Jonas.Model.Book;
import Jonas.Model.DVD;
import collections.ArrayList;
import Jonas.Model.Media;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author Jonatan Fridsten, Johnatan Sona, Gustaf Bohlin
 *         This is the class containing all Graphical components
 */
public class Gui extends JFrame implements ActionListener, IGUI {

    private String currentUser;
    private IController ctrl;
    private JPanel mainPanelBasic = new JPanel();
    private JTextArea textArea = new JTextArea();
    private JButton changeUser = new JButton("Byta användare"), borrow = new JButton("Låna media"), returnBook = new JButton("Lämna tillbaka");
    private JTextField textFieldUser = new JTextField(50), textFieldBorrow = new JTextField(50), textFieldReturn = new JTextField(50);

    /**
     * Constructor.
     * Initializes all graphical components.
     */
    public Gui() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setLayout(new BorderLayout());
        mainPanelBasic.setLayout(new GridLayout(3, 0, 0, 10));
        textFieldUser.setEditable(false);
	    textFieldUser.setBorder(new EmptyBorder(0, 10, 10, 0));
        textArea.setEditable(false);

        changeUser.addActionListener(this);
        borrow.addActionListener(this);
        returnBook.addActionListener(this);

        mainPanelBasic.add(basicJPanel("Namn", textFieldUser, changeUser, "Användare"));
        mainPanelBasic.add(basicJPanel("Media ID", textFieldBorrow, borrow, "Låna"));
        mainPanelBasic.add(basicJPanel("Media ID", textFieldReturn, returnBook, "Lämna tillbaka"));
        mainPanelBasic.setBorder(new EmptyBorder(0,0,10,0));

        add(panelList("Media", textArea, "Lista av media objekt"), BorderLayout.CENTER);
        add(mainPanelBasic, BorderLayout.NORTH);

	    this.setResizable(false);
        pack();
    }

    /**
     * Creates a basic JPanel
     *
     * @param labelInfo    text on the label
     * @param textField    what textfield to put in panel
     * @param button       what button to put in panel
     * @param borderString text on the border
     * @return the actual panel
     */
    private JPanel basicJPanel(String labelInfo, JTextField textField, JButton button, String borderString) {
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
     * A JPanel containing the list with mediaobjects
     *
     * @param label        text on the label
     * @param txtList      the text area
     * @param borderString text on the border
     * @return the actual panel
     */
    public JPanel panelList(String label, JTextArea txtList, String borderString) {
        JPanel panel = new JPanel();
        JLabel lblText = new JLabel(label);
	    JScrollPane spText = new JScrollPane(txtList);

	    panel.setPreferredSize(new Dimension(200, 100));

        spText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new BorderLayout());
        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.black), borderString);
        panel.setBorder(border);
        panel.add(spText, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(250, 100));
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeUser) {
            clearAllText();
            ctrl.logout();
        } else if (e.getSource() == borrow) {
            String input = textFieldBorrow.getText();
            clearInputText();
            ctrl.borrow(input);
        } else if (e.getSource() == returnBook) {
            String input = textFieldReturn.getText();
            clearInputText();
            ctrl.returnMedia(input);
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
	        Media media = loan.get(i);
	        if (media instanceof Book) {
		        builder.append("Bok" +": "+
				        loan.get(i).getMediaID() + " , " +
				        loan.get(i).getTitle()+ " , " +
				        loan.get(i).getYear()+ " , " +
				        ((Book) media).getAuthor() + "\n");
	        }
	        if (media instanceof DVD) {
		        String actors = Arrays.toString(((DVD) media).getActors());
		        builder.append("Dvd" + ": " +
				        loan.get(i).getMediaID() + " , " +
				        loan.get(i).getTitle() + " , " +
				        loan.get(i).getYear() + " , "
				        + "Skådespelare:"+actors + "\n");
	        }


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
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void clearAllText() {
        clearInputText();
        textArea.setText("");
    }

    private void clearInputText() {
        textFieldBorrow.setText("");
        textFieldReturn.setText("");
    }


}
