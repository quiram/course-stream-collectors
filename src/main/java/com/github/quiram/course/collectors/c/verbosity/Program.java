package com.github.quiram.course.collectors.c.verbosity;

import com.github.quiram.course.collectors.a.safer.commands.Command;
import com.github.quiram.course.collectors.a.safer.commands.PingCommand;
import com.github.quiram.course.collectors.a.safer.commands.RepeatCommand;
import com.github.quiram.course.collectors.a.safer.commands.ReverseCommand;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

import static com.github.quiram.course.collectors.c.verbosity.collector.Collectors.toSingleton;
import static java.util.Arrays.asList;

public class Program {
    private static final List<Command> commands = asList(new PingCommand(), new RepeatCommand(), new ReverseCommand());

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();

            try {
                final Command command = commands.stream()
                        .filter(cmd -> cmd.supports(input))
                        .collect(toOneCommand(input));

                System.out.println(command.apply(input));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static Collector<Command, ?, Command> toOneCommand(String input) {
        return toSingleton("No command supports input " + input,
                "Your input is valid for the following commands: ");
    }

}
