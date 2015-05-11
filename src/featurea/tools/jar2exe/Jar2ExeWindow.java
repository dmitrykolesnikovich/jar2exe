/**
 * @author Sri Harsha Chilakapati
 *
 * The exe's created are SFX archives. The data in the JAR file
 * is prepended to the module "module.mod" or "module2.mod".
 * The modules are developed in NSIS by me
 */

package featurea.tools.jar2exe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Jar2ExeWindow extends JFrame implements ActionListener {

  private JFileChooser jarFileChooser = new JFileChooser();
  private JFileChooser exeFileChooser = new JFileChooser();
  private JButton openButton = new JButton("Choose JAR");
  private JButton saveButton = new JButton("Choose EXE");
  private JButton convertButton = new JButton("Convert");
  private File jarFile;
  private File exeFile;

  public Jar2ExeWindow(){
    super("JAR to EXE converter (by Sri Harsha Chilakapati)");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initComponents();
    Dimension size = new Dimension(380, 64);
    setMinimumSize(size);
    setSize(size);
    setLayout(new FlowLayout());
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void initComponents(){
    openButton.addActionListener(this);
    add(openButton);
    saveButton.addActionListener(this);
    add(saveButton);
    convertButton.addActionListener(this);
    add(convertButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source==openButton){
      chooseJarFile();
    }else if (source==saveButton){
      chooseExeFile();
    }else if (source==convertButton){
      convert();
    }
  }

  public void convert() {
    Converter.convert(jarFile, exeFile);
  }

  public void chooseExeFile() {
    exeFileChooser.setAcceptAllFileFilterUsed(false);
    exeFileChooser.addChoosableFileFilter(new ExeFileFilter());
    if (exeFileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
      if(exeFileChooser.getSelectedFile().getAbsolutePath().endsWith(".exe")){
        exeFile = exeFileChooser.getSelectedFile();
      }else{
        exeFile = new File(exeFileChooser.getSelectedFile().getAbsolutePath() + ".exe");
      }
    }else{
      exeFile = null;
    }
  }

  public void chooseJarFile() {
    jarFileChooser.setAcceptAllFileFilterUsed(false);
    jarFileChooser.addChoosableFileFilter(new JarFileFilter());
    if(jarFileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
      if(jarFileChooser.getSelectedFile().getAbsolutePath().endsWith(".jar")){
        jarFile = jarFileChooser.getSelectedFile();
      }else{
        jarFile = new File(jarFileChooser.getSelectedFile().getAbsolutePath() + ".jar");
      }
    }else{
      jarFile = null;
    }
  }

}

