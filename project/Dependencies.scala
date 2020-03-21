import sbt._

object Dependencies {

  val collectionCompatVersion = "2.1.2"
  val shapelessVersion        = "2.3.3"
  val catsVersion             = "2.1.1"
  val zioVersion              = "1.0.0-RC18"
  val scalaTestVersion        = "3.1.1"
  val scalaCheckVersion       = "1.14.3"
  val magnoliaVersion         = "0.12.8"
  val contextualVersion       = "1.2.1"

  val collectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % collectionCompatVersion
  val shapeless        = "com.chuusai"            %% "shapeless"               % shapelessVersion
  val catsCore         = "org.typelevel"          %% "cats-core"               % catsVersion
  val catsEffect       = "org.typelevel"          %% "cats-effect"             % catsVersion
  val zio              = "dev.zio"                %% "zio"                     % zioVersion
  val zioStreams       = "dev.zio"                %% "zio-streams"             % zioVersion
  val zioTest          = "dev.zio"                %% "zio-test"                % zioVersion
  val zioTestSbt       = "dev.zio"                %% "zio-test-sbt"            % zioVersion
  val magnolia         = "com.propensive"         %% "magnolia"                % magnoliaVersion
  val contextual       = "com.propensive"         %% "contextual"              % contextualVersion
  val scalaTest        = "org.scalatest"          %% "scalatest"               % scalaTestVersion
  val scalaCheck       = "org.scalacheck"         %% "scalacheck"              % scalaCheckVersion
}
