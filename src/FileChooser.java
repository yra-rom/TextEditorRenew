import javax.swing.*;
import java.io.File;

public class FileChooser extends JFileChooser{

    public File pick() {
        setCurrentDirectory(new File("d:/free"));
        if (this.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        } else {
            return null;
        }
    }

    public File pick(String fileName) {
        setCurrentDirectory(new File("d:/free/"));
        setSelectedFile(new File(fileName));
        if (this.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        } else {
            return null;
        }
    }
}
