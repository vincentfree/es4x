package io.reactiverse.es4x.test;

import io.reactiverse.es4x.Runtime;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.reactiverse.es4x.test.JS.commonjs;
import static org.junit.Assert.assertEquals;

@RunWith(VertxUnitRunner.class)
public class ArrayBufferTest {

  private Runtime runtime;

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Before
  public void initialize() {
    runtime = commonjs(rule.vertx());
  }

  @Test
  public void testBasicConsole() {
    assertEquals(
      8,
      runtime.eval(
      "let buffer = new ArrayBuffer(8);\n" +
      "buffer.byteLength;\n").asInt());
  }
}
