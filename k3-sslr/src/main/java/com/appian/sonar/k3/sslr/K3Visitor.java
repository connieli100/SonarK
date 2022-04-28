package com.appian.sonar.k3.sslr;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;
import com.sonar.sslr.api.Token;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class K3Visitor {

  private K3VisitorContext context;

  private Set<AstNodeType> subscribedKinds = null;

  public abstract List<AstNodeType> subscribedTo();

  private Set<AstNodeType> subscribedKinds() {
    if (subscribedKinds == null) {

      subscribedKinds = Collections.unmodifiableSet(new HashSet<>(subscribedTo()));
    }
    return subscribedKinds;
  }

  public void visitFile(@Nullable AstNode node) {
  }

  public void leaveFile(@Nullable AstNode node) {
  }

  public void visitNode(AstNode node) {
  }

  public void leaveNode(AstNode node) {
  }

  public void visitToken(Token token) {
  }

  public K3VisitorContext getContext() {
    return context;
  }

  public void scanFile(K3VisitorContext context) {
    this.context = context;
    AstNode tree = context.rootTree();
    visitFile(tree);
    if (tree != null) {
      scanNode(tree);
    }
    leaveFile(tree);
  }

  public void scanNode(AstNode node) {
    boolean isSubscribedType = subscribedKinds().contains(node.getType());

    if (isSubscribedType) {
      visitNode(node);
    }

    List<AstNode> children = node.getChildren();
    if (children.isEmpty()) {
      node.getTokens().forEach(this::visitToken);
    } else {
      children.forEach(this::scanNode);
    }

    if (isSubscribedType) {
      leaveNode(node);
    }
  }

}
