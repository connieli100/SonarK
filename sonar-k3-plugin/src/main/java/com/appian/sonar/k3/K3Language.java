package com.appian.sonar.k3;

import org.sonar.api.config.Configuration;
import org.sonar.api.resources.AbstractLanguage;

public class K3Language extends AbstractLanguage {

  public static final String KEY = "k";
  static final String FILE_SUFFIXES_KEY = "sonar.k.file.suffixes";
  static final String FILE_SUFFIXES_DEFVALUE = ".k";

  private Configuration configuration;

  public K3Language(Configuration configuration) {
    super(KEY, "K3(kx)");
    this.configuration = configuration;
  }

  @Override
  public String[] getFileSuffixes() {
    return configuration.getStringArray(FILE_SUFFIXES_KEY);
  }
}
