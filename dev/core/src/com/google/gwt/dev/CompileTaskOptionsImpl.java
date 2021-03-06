/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.dev;

import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.dev.cfg.Properties;
import com.google.gwt.dev.util.arg.OptionJsInteropMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class to implement compile task options.
 */
class CompileTaskOptionsImpl implements CompileTaskOptions {

  private Properties finalProperties;
  private Type logLevel;
  private final List<String> moduleNames = new ArrayList<String>();
  private File workDir;
  private Mode jsInteropMode;

  public CompileTaskOptionsImpl() {
  }

  @Override
  public void addModuleName(String moduleName) {
    moduleNames.add(moduleName);
  }

  public void copyFrom(CompileTaskOptions other) {
    setLogLevel(other.getLogLevel());
    setModuleNames(other.getModuleNames());
    setWorkDir(other.getWorkDir());
    setFinalProperties(other.getFinalProperties());
  }

  public File getCompilerWorkDir(String moduleName) {
    return new File(new File(getWorkDir(), moduleName), "compiler");
  }

  @Override
  public Properties getFinalProperties() {
    return finalProperties;
  }

  @Override public OptionJsInteropMode.Mode getJsInteropMode() {
    return jsInteropMode;
  }

  @Override
  public Type getLogLevel() {
    return logLevel;
  }

  @Override
  public List<String> getModuleNames() {
    return new ArrayList<String>(moduleNames);
  }

  @Override
  public File getWorkDir() {
    return workDir;
  }

  @Override
  public void setFinalProperties(Properties finalProperties) {
    this.finalProperties = finalProperties;
  }

  @Override public void setJsInteropMode(OptionJsInteropMode.Mode mode) {
    jsInteropMode = mode;
  }

  @Override
  public void setLogLevel(Type logLevel) {
    this.logLevel = logLevel;
  }

  @Override
  public void setModuleNames(List<String> moduleNames) {
    this.moduleNames.clear();
    this.moduleNames.addAll(moduleNames);
  }

  @Override
  public void setWorkDir(File workDir) {
    this.workDir = workDir;
  }
}
