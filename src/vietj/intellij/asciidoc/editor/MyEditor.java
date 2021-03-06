/*
 * Copyright 2013 Julien Viet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vietj.intellij.asciidoc.editor;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

/** @author Julien Viet */
public class MyEditor extends UserDataHolderBase implements FileEditor {


//  /** The {@link Document} previewed in this editor. */
//  protected final Document document;

   private final VirtualFile myFile;
    private final MyGUI myEditor;
  /** . */
//  private FutureTask<Asciidoc> asciidoc = new FutureTask<Asciidoc>(new Callable<Asciidoc>() {
//    public Asciidoc call() throws Exception {
//      return new Asciidoc();
//    }
//  });

  public MyEditor(Project project, VirtualFile file) {

    final VirtualFile vf = file instanceof LightVirtualFile ? ((LightVirtualFile)file).getOriginalFile() : file;
    final Module module = ModuleUtil.findModuleForFile(vf, project);
    if (module == null) {
      throw new IllegalArgumentException("No module for file " + file + " in project " + project);
    }
    myFile = file;
    myEditor = new MyGUI();
  }

  /**
   * Get the {@link java.awt.Component} to display as this editor's UI.
   *
   */
  @NotNull
  public JComponent getComponent() {
    return myEditor;
  }

  /**
   * Get the component to be focused when the editor is opened.
   *
   */
  @Nullable
  public JComponent getPreferredFocusedComponent() {
    return myEditor;
  }

  /**
   * Get the editor displayable name.
   *
   * @return <code>Asciidoc</code>
   */
  @NotNull
  @NonNls
  public String getName() {
    return "Asciidoc";
  }

  /**
   * Get the state of the editor.
   * <p/>
   * Just returns {@link FileEditorState#INSTANCE} as {@link MyEditor} is stateless.
   *
   * @param level the level.
   * @return {@link FileEditorState#INSTANCE}
   * @see #setState(com.intellij.openapi.fileEditor.FileEditorState)
   */
  @NotNull
  public FileEditorState getState(@NotNull FileEditorStateLevel level) {
    return FileEditorState.INSTANCE;
  }

  /**
   * Set the state of the editor.
   * <p/>
   * Does not do anything as {@link MyEditor} is stateless.
   *
   * @param state the new state.
   * @see #getState(com.intellij.openapi.fileEditor.FileEditorStateLevel)
   */
  public void setState(@NotNull FileEditorState state) {
  }

  /**
   * Indicates whether the document content is modified compared to its file.
   *
   * @return {@code false} as {@link MyEditor} is read-only.
   */
  public boolean isModified() {
    return false;
  }

  /**
   * Indicates whether the editor is valid.
   *
   */
  public boolean isValid() {
    return true;
  }

  /**
   * Invoked when the editor is selected.
   * <p/>
   * Update the HTML content if obsolete.
   */
  public void selectNotify() {
//    if (previewIsObsolete) {
//      try {
//        Asciidoc doc = this.asciidoc.get();
//        String markup = doc.render(document.getText());
//       // jEditorPane.setText(markup);
//        previewIsObsolete = false;
//      }
//      catch (InterruptedException e) {
//        Thread.currentThread().interrupt();
//      }
//      catch (ExecutionException e) {
//        throw new RuntimeException(e.getCause());
//      }
//    }
  }

  /**
   * Invoked when the editor is deselected.
   * <p/>
   * Does nothing.
   */
  public void deselectNotify() {
  }

  /**
   * Add specified listener.
   * <p/>
   * Does nothing.
   *
   * @param listener the listener.
   */
  public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
  }

  /**
   * Remove specified listener.
   * <p/>
   * Does nothing.
   *
   * @param listener the listener.
   */
  public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
  }

  /**
   * Get the background editor highlighter.
   *
   * @return {@code null} as {@link MyEditor} does not require highlighting.
   */
  @Nullable
  public BackgroundEditorHighlighter getBackgroundHighlighter() {
    return null;
  }

  /**
   * Get the current location.
   *
   * @return {@code null} as {@link MyEditor} is not navigable.
   */
  @Nullable
  public FileEditorLocation getCurrentLocation() {
    return null;
  }

  /**
   * Get the structure view builder.
   *
   * @return TODO {@code null} as parsing/PSI is not implemented.
   */
  @Nullable
  public StructureViewBuilder getStructureViewBuilder() {
    return null;
  }

  /** Dispose the editor. */
  public void dispose() {
    Disposer.dispose(this);
  }
}
