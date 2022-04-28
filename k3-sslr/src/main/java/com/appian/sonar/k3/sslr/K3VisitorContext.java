package com.appian.sonar.k3.sslr;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.RecognitionException;

import javax.annotation.CheckForNull;

public class K3VisitorContext {
  private final String fileContent;
  private final AstNode rootTree;
  private final RecognitionException parsingException;

  public K3VisitorContext(String fileContent, AstNode tree) {
    this(fileContent, tree, null);
  }

  public K3VisitorContext(String fileContent, RecognitionException parsingException) {
    this(fileContent, null, parsingException);
  }

  private K3VisitorContext(String fileContent, AstNode rootTree, RecognitionException parsingException) {
    this.fileContent = fileContent;
    this.rootTree = rootTree;
    this.parsingException = parsingException;
  }

  @CheckForNull
  public AstNode rootTree() {
    return rootTree;
  }

  public RecognitionException parsingException() {
    return parsingException;
  }

  public String fileContent() {
    return fileContent;
  }
}

