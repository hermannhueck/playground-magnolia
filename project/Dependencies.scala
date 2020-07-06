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

  // compilerPlugins
  lazy val silencerVersion         = "1.7.0"
  lazy val kindProjectorVersion    = "0.11.0"
  lazy val betterMonadicForVersion = "0.3.1"
  lazy val macroParadiseVersion    = "2.1.1"

  // FORMAT: OFF

  // https://github.com/ghik/silencer
  lazy val silencerLib = "com.github.ghik" % "silencer-lib" % silencerVersion % Provided cross CrossVersion.full
  lazy val silencerPlugin = compilerPlugin(
    "com.github.ghik" % "silencer-plugin" % silencerVersion cross CrossVersion.full
  )
  // https://github.com/typelevel/kind-projector
  lazy val kindProjectorPlugin = compilerPlugin(
    compilerPlugin("org.typelevel" % "kind-projector" % kindProjectorVersion cross CrossVersion.full)
  )
  // https://github.com/oleg-py/better-monadic-for
  lazy val betterMonadicForPlugin = compilerPlugin(
    compilerPlugin("com.olegpy" %% "better-monadic-for" % betterMonadicForVersion)
  )
  // https://github.com/scalamacros/paradise
  // https://docs.scala-lang.org/overviews/macros/paradise.html
  lazy val macroParadise = compilerPlugin(
    compilerPlugin("org.scalamacros" %% "paradise" % macroParadiseVersion cross CrossVersion.full)
    // use in 2.11 or 2.12
    // included in the compiler since 2.13
    // enabled by -Ymacro-annotations, see: ScalacOptions.scala
  )
}
