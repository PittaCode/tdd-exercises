package com.pittacode.greeter;

public class GreeterGenerator {

    private static final Greeter NO_NAME_GREETER = () -> "Hello, my friend.";

    private final NameInputProcessor nameInputProcessor;

    public GreeterGenerator(NameInputProcessor nameInputProcessor) {
        this.nameInputProcessor = nameInputProcessor;
    }

    public String buildGreeting(String[] names) {
        String[] processedNames = nameInputProcessor.splitAnyCommaSeparatedEntriesToSingleNames(names);

        var nameDifferentiator = new NameFilter(processedNames);

        var normalGreeter = new NormalGreeter(nameDifferentiator.filterNormalNames());
        var shoutingGreeter = new ShoutingGreeter(nameDifferentiator.filterShoutedNames());

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }


    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return NO_NAME_GREETER.buildGreeting();
        }

        return buildGreeting(new String[]{name});
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
