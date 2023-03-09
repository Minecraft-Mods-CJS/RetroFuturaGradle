/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.gtnewhorizons.retrofuturagradle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.BuildTask;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * A simple functional test for the 'retrofuturagradle.greeting' plugin.
 */
class UserDevPluginFunctionalTest {

    public static final String SIMPLE_SETTINGS = """
            plugins {
              id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
            }
            """;

    public static final String SIMPLE_BUILDSCRIPT = """
            plugins {
                id('com.gtnewhorizons.retrofuturagradle')
            }
            minecraft {
                mcVersion = '1.7.10'
            }
            """;

    @TempDir
    File projectDir;

    private File getBuildFile() {
        return new File(projectDir, "build.gradle");
    }

    private File getSettingsFile() {
        return new File(projectDir, "settings.gradle");
    }

    @Test
    void canFetchManifests() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "downloadLauncherVersionManifest", "downloadAssetManifest");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    @Test
    void canFetchData() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "downloadVanillaJars", "downloadVanillaAssets");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    @Test
    void canObtainDevPackages() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "downloadFernflower", "extractForgeUserdev", "extractMcpData");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    @Test
    void canMergeVanillaSidedJars() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "mergeVanillaSidedJars");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    @Test
    void canDecompile() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "decompressDecompiledSources");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    @Test
    void canRecompile() throws IOException {
        writeString(getSettingsFile(), SIMPLE_SETTINGS);
        writeString(getBuildFile(), SIMPLE_BUILDSCRIPT);

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("--stacktrace", "--", "packagePatchedMc");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();
        BuildResult secondResult = runner.build();
        Assertions.assertArrayEquals(
                secondResult.tasks(TaskOutcome.SUCCESS).toArray(new BuildTask[0]),
                new BuildTask[] {});
    }

    private void writeString(File file, String string) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            writer.write(string);
        }
    }
}
