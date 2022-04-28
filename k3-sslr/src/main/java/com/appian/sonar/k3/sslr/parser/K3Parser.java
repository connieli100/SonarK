package com.appian.sonar.k3.sslr.parser;

import com.appian.sonar.k3.sslr.K3Grammar;
import com.sonar.sslr.impl.Parser;
import org.sonar.sslr.parser.LexerlessGrammar;
import org.sonar.sslr.parser.ParserAdapter;

import java.nio.charset.Charset;

public final class K3Parser {
  private K3Parser() {
  }

  public static Parser<LexerlessGrammar> create(Charset charset) {
    return new ParserAdapter<>(charset, K3Grammar.createGrammar());
  }
}
