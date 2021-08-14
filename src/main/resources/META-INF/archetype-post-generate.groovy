/* groovylint-disable CompileStatic */
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.PosixFilePermissions
import java.util.stream.Collectors


String operatingSystem = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Path mvnWrapper = Paths.get(projectPath.toString(), "mvnw.cmd")

if (!operatingSystem.contains("windows")) {
  mvnWrapper = Paths.get(projectPath.toString(), "mvnw")

  Files.setPosixFilePermissions(mvnWrapper, PosixFilePermissions.fromString("rwxrwxrwx"))
}

def err = new StringBuilder()
def out = new StringBuilder()

def env = System.getenv().keySet().stream().map({key -> return "${key}=${System.getenv().get(key)}" }).collect(Collectors.toList())

def proc = "${mvnWrapper.toAbsolutePath()} generate-sources".execute(env, projectPath.toAbsolutePath().toFile())

proc.consumeProcessOutput(out, err)
proc.waitFor()
println("${out}\n${err}\n")

def openApiGenIgnore = Paths.get(request.outputDirectory, request.artifactId, ".openapi-generator-ignore").toFile()

openApiGenIgnore.append("\n**/*Impl.java")