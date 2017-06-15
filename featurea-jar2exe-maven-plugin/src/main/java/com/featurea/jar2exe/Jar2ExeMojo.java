package com.featurea.jar2exe;

import featurea.tools.jar2exe.Converter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.List;

@Mojo(name = "build", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class Jar2ExeMojo extends AbstractMojo {

    @Parameter(property = "descriptorRefs", required = true)
    private List descriptorRefs;

    @Parameter(property = "project")
    private MavenProject project;

    public void execute() throws MojoExecutionException {
        if (!descriptorRefs.isEmpty()) {
            String descriptorRef = (String) descriptorRefs.get(0);
            String artifactId = project.getArtifactId();
            String version = project.getVersion();
            String buildDirectory = project.getBuild().getDirectory();
            File jarFile = new File(buildDirectory + "/" + artifactId + "-" + version + "-" + descriptorRef + ".jar");
            File exeFile = new File(buildDirectory + "/" + artifactId + "-" + version + "-" + descriptorRef + ".exe");
            Converter.convert(jarFile, exeFile);
        }
    }

}
