dependencies {
  val vertxVersion = extra["vertxVersion"]
  val junit5Version = extra["junit5Version"]
  val logbackClassicVersion = extra["logbackClassicVersion"]
  val restAssuredVersion = extra["restAssuredVersion"]
  val assertjVersion = extra["assertjVersion"]

  implementation("io.vertx:vertx-rx-java2:$vertxVersion")
  implementation("io.vertx:vertx-web:$vertxVersion")
  implementation("io.vertx:vertx-amqp-client:$vertxVersion")
  implementation("ch.qos.logback:logback-classic:$logbackClassicVersion")

  implementation("io.vertx:vertx-kafka-client:$vertxVersion") {
    exclude("org.slf4j")
    exclude("log4j")
  }

  testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
  testImplementation("io.vertx:vertx-junit5:$vertxVersion")
  testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")
  testImplementation("org.assertj:assertj-core:$assertjVersion")

  testRuntime("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
}

application {
  mainClassName = "tenksteps.ingester.Main"
}

tasks.test {
  useJUnitPlatform()
}