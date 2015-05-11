package jar2exe;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ExeFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		return file.getAbsolutePath().endsWith(".exe") || file.isDirectory();
	}

	@Override
	public String getDescription() {
		return "Executable files (*.exe)";
	}

}
