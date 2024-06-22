package io.buildfoundation.bazel.pmd;

import net.sourceforge.pmd.cli.PmdCli;
import net.sourceforge.pmd.renderers.TextColorRenderer;
import net.sourceforge.pmd.renderers.TextPadRenderer;
import net.sourceforge.pmd.renderers.TextRenderer;

import net.sourceforge.pmd.cli.commands.internal.PmdRootCommand;

import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class Main {
    public static void main(String[] args) {
        System.setProperty("picocli.disable.closures", "true");
        final CommandLine cli = new CommandLine(new PmdRootCommand())
                .setCaseInsensitiveEnumValuesAllowed(true);

        int result = cli.execute(args);

        if (result != 0) {
            printError(args);
        }

        System.exit(result);
    }

    private static void printError(String[] args) {
        List<String> arguments = Arrays.asList(args);

        String reportFormat = argument(arguments, "--format");
        String reportFilePath = argument(arguments, "--report-file");

        if (reportFormat != null && reportFilePath != null) {
            if (Arrays.asList(TextRenderer.NAME, TextColorRenderer.NAME, TextPadRenderer.NAME).contains(reportFormat)) {
                printFile(reportFilePath);
            }
        }
    }

    private static String argument(List<String> arguments, String name) {
        try {
            return arguments.get(arguments.indexOf(name) + 1);
        } catch (IndexOutOfBoundsException ignored) {
            return null;
        }
    }

    private static void printFile(String filePath) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            fileReader.lines().forEach(System.err::println);
        } catch (IOException ignored) {
        }
    }
}
