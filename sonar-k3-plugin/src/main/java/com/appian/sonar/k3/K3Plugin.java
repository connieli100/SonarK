package com.appian.sonar.k3;

import org.sonar.api.Plugin;

public class K3Plugin implements Plugin {
  @Override
  public void define(Context context) {
    context.addExtensions(
            K3Language.class,
            K3Profile.class,
            K3DummySensor.class
    );
  }
}