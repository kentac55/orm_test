
name := "orm_test"

version := "1.0"

scalaVersion := "2.12.2"

val slickVersion = "3.2.0"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "mysql" % "mysql-connector-java" % "5.1.23",
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.typesafe.slick" %% "slick-codegen" % slickVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

// change dir for IDEA
// when you don't run this program on IDEA, remove it.
sourceManaged in Compile := file((sourceDirectory in Compile).value.getAbsolutePath + "/scala")
cleanFiles += (sourceManaged in Compile).value

slick <<= slickCodeGenTask
sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use

lazy val slick = taskKey[Seq[File]]("gen-tables")
lazy val slickCodeGenTask = (sourceManaged in Compile, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
  val username = "slick"
  val password = sys.env("slick_pass")
  val outputDir = dir.getPath
  val url = "jdbc:mysql://localhost/sakila"
  val jdbcDriver = "com.mysql.jdbc.Driver"
  val slickDriver = "slick.jdbc.MySQLProfile"
  val pkg = "models"
  toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password), s.log))
  val fname = outputDir + "/" + pkg + "/Tables.scala"
  Seq(file(fname))
}