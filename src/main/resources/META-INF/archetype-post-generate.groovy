/* groovylint-disable CompileStatic */
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.PosixFilePermissions


String operatingSystem = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)


if (!operatingSystem.contains("windows")) {
  Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

  Properties properties = request.properties

  Path mvnWrapper = Paths.get(projectPath.toString(), "mvnw")

  Files.setPosixFilePermissions(mvnWrapper, PosixFilePermissions.fromString("rwxrwxrwx"))

}