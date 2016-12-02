import javax.swing.*;
import java.io.File;

public class FileChooser extends JFileChooser{

    public File pick() {
        setCurrentDirectory(new File("d:/"));
        if (this.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        } else {
            return null;
        }
    }
}
