package com.appian.sonar.k3.checks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckList {
  public static final String REPOSITORY_KEY = "k3";

  public static final String SONAR_WAY_PROFILE = "Sonar way";

  private CheckList() {
  }

  public static List<Class<?>> getChecks() {
    return Collections.unmodifiableList(Arrays.asList(
            // all the check list class

    ));
  }
}
