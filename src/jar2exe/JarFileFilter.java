package jar2exe;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public  class JarFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		return file.getAbsolutePath().endsWith(".jar") || file.isDirectory();
	}

	@Override
	public String getDescription() {
		return "Java Archives (*.jar)";
	}

}
