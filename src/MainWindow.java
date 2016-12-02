import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder")
public class MainWindow extends JPanel {
    private ArrayList<File> files = new ArrayList<>();
    private  static int counterOfNewFiles = 0;
    private static JFrame frame;

    public MainWindow() {
        initComponents();
    }

    private void miExitActionPerformed(ActionEvent e) {
        //TODO ask Before exit
        System.out.println("Exit");
    }

    private void miCloseActionPerformed(ActionEvent e) {
        //TODO ask Before closing
        System.out.println("Close");
    }

    private void miSaveActionPerformed(ActionEvent e) {
        //TODO way of saving file
        System.out.println("Save");
    }

    private void miSaveasActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("Save as");
    }

    private void miOpenActionPerformed(ActionEvent e) {
        openFile();
    }

    private void miNewActionPerformed(ActionEvent e) {
        JScrollPane scrollPane = createScrollPaneWithEditor();

        tabbledPane.addTab("untitled" + (counterOfNewFiles>0 ? counterOfNewFiles : "") , scrollPane);
        tabbledPane.setSelectedIndex((tabbledPane.getTabCount()-1));
        counterOfNewFiles++;
    }

    private void miAboutActionPerformed(ActionEvent e) {
        AboutInfo aboutInfo = new AboutInfo(frame);
        aboutInfo.setVisible(true);
    }

    private void openFile(){
            FileChooser chooser = new FileChooser();
            File file = chooser.pick();
            files.add(file);
            if(file == null){
                return;
            }

            new Thread(()-> {
                try {
                    JScrollPane scrollPane = createScrollPaneWithEditor();
                    tabbledPane.addTab(file.getName(), scrollPane);
                    tabbledPane.setSelectedIndex((tabbledPane.getTabCount() - 1));

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder builder = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        builder.append("\n");
                    }

                    ((JEditorPane) scrollPane.getViewport().getComponent(0)).setText(builder.toString());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii Piets
        mnMain = new JMenuBar();
        mFile = new JMenu();
        miNew = new JMenuItem();
        miOpen = new JMenuItem();
        miSave = new JMenuItem();
        miSaveas = new JMenuItem();
        miClose = new JMenuItem();
        miExit = new JMenuItem();
        mHelp = new JMenu();
        miAbout = new JMenuItem();
        tabbledPane = new JTabbedPane();

        //======== this ========
        setMinimumSize(new Dimension(600, 500));
        setPreferredSize(new Dimension(600, 500));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new TableLayout(new double[][] {
            {TableLayout.FILL},
            {TableLayout.PREFERRED, TableLayout.FILL}}));

        //======== mnMain ========
        {
            mnMain.setMinimumSize(new Dimension(15, 15));
            mnMain.setPreferredSize(new Dimension(25, 25));

            //======== mFile ========
            {
                mFile.setText("File");

                //---- miNew ----
                miNew.setText("New");
                miNew.addActionListener(e -> miNewActionPerformed(e));
                mFile.add(miNew);

                //---- miOpen ----
                miOpen.setText("Open");
                miOpen.addActionListener(e -> miOpenActionPerformed(e));
                mFile.add(miOpen);
                mFile.addSeparator();

                //---- miSave ----
                miSave.setText("Save");
                miSave.addActionListener(e -> miSaveActionPerformed(e));
                mFile.add(miSave);

                //---- miSaveas ----
                miSaveas.setText("Save As");
                miSaveas.addActionListener(e -> {
			miSaveasActionPerformed(e);
		});
                mFile.add(miSaveas);
                mFile.addSeparator();

                //---- miClose ----
                miClose.setText("Close");
                miClose.addActionListener(e -> miCloseActionPerformed(e));
                mFile.add(miClose);
                mFile.addSeparator();

                //---- miExit ----
                miExit.setText("Exit");
                miExit.addActionListener(e -> miExitActionPerformed(e));
                mFile.add(miExit);
            }
            mnMain.add(mFile);

            //======== mHelp ========
            {
                mHelp.setText("Help");

                //---- miAbout ----
                miAbout.setText("About");
                miAbout.addActionListener(e -> miAboutActionPerformed(e));
                mHelp.add(miAbout);
            }
            mnMain.add(mHelp);
        }
        add(mnMain, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        add(tabbledPane, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii Piets
    private JMenuBar mnMain;
    private JMenu mFile;
    private JMenuItem miNew;
    private JMenuItem miOpen;
    private JMenuItem miSave;
    private JMenuItem miSaveas;
    private JMenuItem miClose;
    private JMenuItem miExit;
    private JMenu mHelp;
    private JMenuItem miAbout;
    private JTabbedPane tabbledPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JScrollPane createScrollPaneWithEditor() {
        JEditorPane editorPane = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setViewportView(editorPane);
        return scrollPane;
    }

    public static void main(String[] args) {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MainWindow());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                //ask Before exit
                System.out.println("Exit");
                e.getWindow().dispose();
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private void saveFile(){
        JScrollPane scroll = (JScrollPane) tabbledPane.getComponentAt(tabbledPane.getSelectedIndex());
        JViewport viewport = scroll.getViewport();
        JEditorPane  editor = (JEditorPane) viewport.getComponent(0);
        String text = editor.getText();// get text from text pane
    }

    private boolean noDiff(File file){
        JScrollPane scroll = (JScrollPane) tabbledPane.getComponentAt(tabbledPane.getSelectedIndex());
        JViewport viewport = scroll.getViewport();
        JEditorPane  editor = (JEditorPane) viewport.getComponent(0);
        String text = editor.getText();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file)); // Have to save info about start file
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                builder.append(line);
                builder.append("\n");
            }

            return builder.toString().equals(text); // check if file file need to be saved
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean noDiffForEach(){
        for(File file : files){
            if(!noDiff(file)) {
                return false;
            }
        }
        return true;
    }
}
