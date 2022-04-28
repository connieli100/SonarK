package com.appian.sonar.k3.sslr;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class K3Check extends K3Visitor {

  private List<Issue> issues = new ArrayList<>();

  public List<Issue> scanFileForIssues(K3VisitorContext context) {
    issues = new ArrayList<>();
    scanFile(context);
    return Collections.unmodifiableList(issues);
  }

  public void addIssueAtLine(String message, int line) {
    issues.add(Issue.lineIssue(line, message));
  }

  public void addIssue(String message, AstNode node) {
    addIssueAtLine(message, node.getTokenLine());
  }

  public void addIssue(String message, Token token) {
    addIssueAtLine(message, token.getLine());
  }

  public void addFileIssue(String message) {
    issues.add(Issue.fileIssue(message));
  }

  public void addIssueWithCost(String message, AstNode node, double cost) {
    issues.add(Issue.lineIssue(node.getTokenLine(), message, cost));
  }

}

