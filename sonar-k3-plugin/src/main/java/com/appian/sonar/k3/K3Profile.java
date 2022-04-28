package com.appian.sonar.k3;

import com.appian.sonar.k3.checks.CheckList;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonarsource.analyzer.commons.BuiltInQualityProfileJsonLoader;

public class K3Profile implements BuiltInQualityProfilesDefinition {

  public static final String SONAR_WAY_PROFILE_PATH = "com/appian/sonar/k3/rules/Sonar_way_profile.json";

  @Override
  public void define(Context context) {
    NewBuiltInQualityProfile profile = context.createBuiltInQualityProfile(CheckList.SONAR_WAY_PROFILE, K3Language.KEY);
    BuiltInQualityProfileJsonLoader.load(profile, CheckList.REPOSITORY_KEY, SONAR_WAY_PROFILE_PATH);
    profile.done();
  }
}
