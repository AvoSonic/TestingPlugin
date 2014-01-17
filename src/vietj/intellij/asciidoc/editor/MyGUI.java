package vietj.intellij.asciidoc.editor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by izha002 on 17/01/14.
 */
public class MyGUI extends JPanel {

  public MyGUI(){
    setLayout(new BorderLayout());
    this.add(new JButton("left"), BorderLayout.CENTER);
    this.add(new JButton("right"), BorderLayout.EAST);
  }

}
