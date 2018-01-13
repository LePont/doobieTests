name := "doobieTests"

version := "1.0"

scalaVersion := "2.12.4"

lazy val doobieVersion = "0.4.2"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core-cats"       % doobieVersion,
  "org.tpolecat" %% "doobie-postgres-cats"   % doobieVersion,
  "org.tpolecat" %% "doobie-specs2-cats"     % doobieVersion
)