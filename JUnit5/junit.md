# JUnit

* JUnit4 is not modular and consists of a single JAR.
* JUnit5 is created from scratch using Java 8 - allows you to take advantage of features such as lambdas.
* JUnit5 has multiple dependencies.

![Nutshell](./nutshell.PNG)

* Platform is for launching tests on the JVM (e.g. Provides an API for other libraries like Cucumber to use it)
* Jupiter - new API for writing tests
* Vintage - backward compatability for the old JUnit API 3 & 4

![architecture](./architecture.PNG)


![architecture2](./architecture2.PNG)


![architecture3](./architecture3.PNG)

# Extensions

![ext](./ext2.PNG)

![ext](./ext3.PNG)

![ext](./ext4.PNG)

![ext](./ext5.PNG)

![ext](./ext6.PNG)

![ext](./ext7.PNG)

![ext](./ext8.PNG)


# Testing

## Standard Tests

`@Test` annotation identifies a method as a test. This does not take any attributes.

![beforeaftereach](./beforeaftereach.PNG)

![beforeafterall](./beforeafterall.PNG)

![teststruct](./teststruct.PNG)

![beforeafterall](./displayname.PNG)

## Assertions

![assert](./assert.PNG)

An assertion consists of 3 parts:

1. The expected value
2. The real outcome
3. The comparison of expected to real

![assert2](./assert2.PNG)

![assert3](./assert3.PNG)

![assertAll](./assertAll.PNG)

![assertthrows](./assertthrows.PNG)

![assert4](./assert4.PNG)

![assert5](./assert5.PNG)

## Tagging and Filtering

![tag](./tag.PNG)

![tag2](./tag2.PNG)

![tag3](./tag3.PNG)

![tag4](./tag4.PNG)

## Conditional Test Execution

![disabled](./disabled.PNG)

![disabled2](./disabled2.PNG)

![assumptions](./assumptions.PNG)

![assume](./assume.PNG)

## Nested and Repeated Tests

![nested](./nested.PNG)

![nested2](./nested2.PNG)

![nested3](./nested3.PNG)

![repeat](./repeat.PNG)

![repeat2](./repeat2.PNG)

![repeat3](./repeat3.PNG)

## Dynamic  Tests

![dynamic](./dynamic.PNG)

![dynamic2](./dynamic2.PNG)

![dynamic3](./dynamic3.PNG)

![dynamic4](./dynamic4.PNG)

![dynamic5](./dynamic5.PNG)

![dynamic6](./dynamic6.PNG)
