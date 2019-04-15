# Viagogo-Intern-Test
This project was part of the interview process for undergraduate placement schemes at Viagogo. 

The scenario provided for this project by Viagogo:
- Your program should randomly generate seed data
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10 to +10 (X axis)
- Your program should assume that each co-ordinate can hold a maximum of one event
- Each event has a unique numeric identifier (e.g. 1, 2, 3)
- Each event has zero or more tickets
- Each ticket has a non-zero price, expressed in US Dollars
- The distance between two points should be computed as the Manhattan distance

The instructions provided by Viagogo:
- You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event

*Example Program Run*
```cmd
Please Input Coordinates:

> 4,2
Closest Events to (4,2):
Event 003 - $30.29, Distance 3
Event 001 - $35.20, Distance 5
Event 006 - $01.40, Distance 12
```

## Getting Started

### Prerequisites
1. The project uses [Gradle](https://gradle.org) so this must be installed on your machine.
2. Java 8 or higher

### Installing
1. Run `gradle build` in the Viagogo-Intern-Testdirectory to download dependencies and build the project.

The project should now be ready and setup. You can run the project using the `gradle run` command.

## Contributing
We are happy to have contributions whether it is for small bug fixes or new pieces of major functionality. To contribute changes, you should first fork the upstream repository to your own GitHub account. You can then add a new remove for upstream and rebase any changes to
make keep up to date with upstream.

`git remote add upstream https://github.com/skdev/Viagogo-Intern-Test.git`

The style guides the project uses is based on the [Google style guide](https://google.github.io/styleguide/javaguide.html)

## Authors
**Suraj Kumar**

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
