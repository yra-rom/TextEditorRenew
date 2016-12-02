import javax.swing.*;
import java.awt.*;
/*
 * Created by JFormDesigner on Fri Dec 02 00:55:00 CET 2016
 */



/**
 * @author Yurii Piets
 */
public class AboutInfo extends JDialog {
    public AboutInfo(Frame owner) {
        super(owner);
        setResizable(false);
        setTitle("About");
        initComponents();
    }

    public AboutInfo(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii Piets
        scrollPane1 = new JScrollPane();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== scrollPane1 ========
        {

            //---- label1 ----
            label1.setText("Created by Yurii Piets");
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setMaximumSize(new Dimension(300, 170));
            label1.setMinimumSize(new Dimension(300, 170));
            label1.setPreferredSize(new Dimension(300, 170));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            scrollPane1.setViewportView(label1);
        }
        contentPane.add(scrollPane1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii Piets
    private JScrollPane scrollPane1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
