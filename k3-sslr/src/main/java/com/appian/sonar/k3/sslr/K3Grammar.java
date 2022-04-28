package com.appian.sonar.k3.sslr;

import org.sonar.sslr.grammar.GrammarRuleKey;
import org.sonar.sslr.grammar.LexerlessGrammarBuilder;
import org.sonar.sslr.parser.LexerlessGrammar;

public enum K3Grammar implements GrammarRuleKey {
  WHITESPACE;
  private static final String WHITESPACE_REGEXP = "\\t\\v\\f\\u0020\\u00A0\\uFEFF\\p{Zs}";
  private static final String LINE_TERMINATOR_REGEXP = "\\n\\r\\p{Zl}\\p{Zp}";

  public static LexerlessGrammar createGrammar() {
    LexerlessGrammarBuilder b = LexerlessGrammarBuilder.create();
    b.rule(WHITESPACE).is(b.regexp("[" + LINE_TERMINATOR_REGEXP + WHITESPACE_REGEXP + "]*+"));
    return b.build();
  }
}
