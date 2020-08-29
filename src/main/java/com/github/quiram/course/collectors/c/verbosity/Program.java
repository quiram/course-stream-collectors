package com.github.quiram.course.collectors.c.verbosity;

import com.github.quiram.course.collectors.a.safer.commands.Command;
import com.github.quiram.course.collectors.a.safer.commands.PingCommand;
import com.github.quiram.course.collectors.a.safer.commands.RepeatCommand;
import com.github.quiram.course.collectors.a.safer.commands.ReverseCommand;

import java.util.List;
import java.util.Scanner;

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
                        .collect(toSingleton());

                System.out.println(command.apply(input));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
