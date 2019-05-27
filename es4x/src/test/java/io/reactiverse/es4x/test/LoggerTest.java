package io.reactiverse.es4x.test;

import io.reactiverse.es4x.Runtime;
import io.reactiverse.es4x.impl.graal.GraalEngine;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class LoggerTest {

  private final Logger log = LoggerFactory.getLogger(LoggerTest.class);

  private Runtime runtime;

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Before
  public void initialize() {
    runtime = new GraalEngine(rule.vertx()).newContext();
  }

  @Test
  public void shouldThrowAnErrorIfFileCantBeFound() {
    try {
      throw new RuntimeException();
    } catch (RuntimeException e) {
      log.error("Oops!", e);
    }
  }

  @Test
  public void shouldPrettyPrintException() {
    Object module = runtime.require("./exp.js");
    try {
      runtime.invokeMethod(module, "a");
    } catch (RuntimeException e) {
      log.error("Error from Script", e);
    }
  }
}
